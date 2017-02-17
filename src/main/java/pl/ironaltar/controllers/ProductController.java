package pl.ironaltar.controllers;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.ironaltar.domain.Product;
import pl.ironaltar.services.ProductService;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.UUID;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @RequestMapping(value = "/products/{category}", method = RequestMethod.GET)
    public String list(@PathVariable String category, Model model){
        model.addAttribute("products", productService.findByCategoryOrderByBrandAsc(category));
        return "products";
    }

    @RequestMapping(value = "/products/below/{price}", method = RequestMethod.GET)
    public String list(@PathVariable BigDecimal price, Model model){
        model.addAttribute("products", productService.findByPriceLessThanOrderByPriceAsc(price));
        return "products";
    }


    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }

    // JSON/XML
    @RequestMapping(
            value = "/productjson/{id}",
            produces = { "application/json","application/xml" },
            method = RequestMethod.GET)
    public @ResponseBody Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    //Administracja produktami po logowaniu role Admin

    @RequestMapping(value = "/admin/products", method = RequestMethod.GET)
    public String listAdmin(Model model){
        model.addAttribute("products", productService.listAllProducts());
        return "productsadmin";
    }

    @RequestMapping("admin/products/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    @RequestMapping("admin/products/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product,@RequestParam("file") MultipartFile file,
                              RedirectAttributes redirectAttributes) throws IOException {

            if (file.isEmpty()) {
                redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
                return "redirect:productform";
            }

            UUID uniqueKey = UUID.randomUUID();
            try {
                FTPClient ftpClient = new FTPClient();
                ftpClient.connect("ftp.etronik.pl", 21);
                ftpClient.login("szzc@etronik.pl", "jMo3X92YegbQ");
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                String fileName = uniqueKey+".jpg";
                InputStream inp = file.getInputStream();
                ftpClient.storeFile(fileName,inp);
            } catch (IOException e) {
                e.printStackTrace();
            }

            product.setImageName(uniqueKey+".jpg");
            product.setImageUrl("http://etronik.pl/szczepanczyk/");
            product.setProductId(uniqueKey+"");
            productService.saveProduct(product);
        return "redirect:/admin/products";
    }

    @RequestMapping("admin/products/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/productsadmin";
    }



}