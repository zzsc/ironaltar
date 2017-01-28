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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /*bez logowania*/
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("products", productService.listAllProducts());
        return "products";
    }

    @RequestMapping(value = "/products/{category}", method = RequestMethod.GET)
    public String list(@PathVariable String category, Model model){
        model.addAttribute("products", productService.findByCategory(category));
        return "products";
    }

    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }
    /*logowanie*/

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "login";
    }

    /*po logowaniu logowania*/
    @RequestMapping(value = "/productsadmin", method = RequestMethod.GET)
    public String listAdmin(Model model){
        model.addAttribute("products", productService.listAllProducts());
        return "productsadmin";
    }

    @RequestMapping("productsadmin/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    @RequestMapping("productsadmin/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    String workingDir = System.getProperty("user.dir");
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product,@RequestParam("file") MultipartFile file,
                              RedirectAttributes redirectAttributes) throws IOException {

            if (file.isEmpty()) {
                redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
                return "redirect:productform";
            }
/*
           try {
                UUID uniqueKey = UUID.randomUUID();
                byte[] bytes = file.getBytes();
                Path path = Paths.get(workingDir+"/src/main/resources/static/images/" + uniqueKey +".jpg");
                product.setImageName(uniqueKey+".jpg");
                product.setImageUrl("/images/");
                product.setProductId(uniqueKey+"");
                Files.write(path, bytes);

            } catch (IOException e) {
                e.printStackTrace();
            }

        */

        String server = "ftp.etronik.pl";
        int port = 21;
        String user = "szzc@etronik.pl";
        String pass = "jMo3X92YegbQ";
        UUID uniqueKey = UUID.randomUUID();

        try {

        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(server, port);
        ftpClient.login(user, pass);
        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        String fileNamee = uniqueKey+".jpg";
        File fileName = new File(uniqueKey+".jpg");
        InputStream inp = file.getInputStream();
        ftpClient.storeFile(fileNamee,inp);


            } catch (IOException e) {
                e.printStackTrace();
            }


        product.setImageName(uniqueKey+".jpg");
        product.setImageUrl("http://etronik.pl/szczepanczyk/");
        product.setProductId(uniqueKey+"");
        productService.saveProduct(product);
        return "redirect:/productsadmin";
    }

    @RequestMapping("productsadmin/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/productsadmin";
    }

    @RequestMapping(
            value = "/productjson/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public @ResponseBody Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

}