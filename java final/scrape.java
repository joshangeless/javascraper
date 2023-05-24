import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import java.util.ArrayList; 

public class scrape {
    public static void main(String[] args) {
        final String url = "https://www2.hm.com/en_us/men/new-arrivals/view-all.html";
        ArrayList<String> productsURL = new ArrayList<String>();

        try {
            final Document doc = Jsoup.connect(url).get();

            for(Element row: doc.select("div.item-details")) {
                System.out.println(row.select("h3.item-heading").text() + " " + row.select("strong.item-price").text());
            }

            Elements links = doc.select("div.image-container a");
            for(Element link : links) {
                String absUrl = link.absUrl("href");
                System.out.println(absUrl);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}