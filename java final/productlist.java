import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class productlist {
    final String url = "https://www2.hm.com/en_us/men/new-arrivals/view-all.html";
    ArrayList<String> products = new ArrayList<String>();

    public ArrayList<String> productLinks() throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("div.image-container a"); // Finding all the links on the page and boiling it down to the product links.
        for (Element link : links) { // For loop to add them all to an array.
            String absUrl = link.absUrl("href");
            products.add(absUrl + "\n");
        }
        products.add(0, null); // Adding a null value to the zero index to shift the array up by one.
        return products;
    }

    // just another method to return products.
    public ArrayList<String> getStringList() {
        return products;
    }
}
