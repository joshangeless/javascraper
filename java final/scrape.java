import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
// import org.jsoup.select.Elements;

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

    public static void slowPrint(String output) {
        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(4);
            } catch (Exception e) {

            }
        }
    }
}
