package pl.ironaltar.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by szzc on 11.03.17.
 */
public class getHtmlArticle {

    public String getArticle(){
        String pageHtmlAdress = "https://en.wikipedia.org/wiki/Main_Page";
        Document doc = null;
        try {
            doc = Jsoup.connect(pageHtmlAdress).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements newsHeadlines = doc.select("p");
        String news = newsHeadlines.text().toString();

        return news;
    }

}
