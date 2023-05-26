import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class scrape {
    final String url = "https://www2.hm.com/en_us/men/new-arrivals/view-all.html";
    ArrayList<String> products = new ArrayList<String>();

    void productInfo() throws IOException {
        Document doc = Jsoup.connect(url).get();
        slowPrint("Scrapping H&M...");
        for (Element row : doc.select("div.item-details")) {
            slowPrint("\n" + row.select("h3.item-heading").text() + " " + row.select("strong.item-price").text());
        }
    }

    public ArrayList<String> productLinks() throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("div.image-container a");
        for (Element link : links) {
            String absUrl = link.absUrl("href");
            products.add(absUrl + "\n");
        }
        products.add(0, null);
        return products;
    }

    public ArrayList<String> getStringList() {
        return products;
    }

    public static void slowPrint(String output) {
        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (Exception e) {

            }
        }
    }
}
