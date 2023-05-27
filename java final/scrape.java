// Java imports
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

// Importing Jsoup library for webscrapping
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

// Class for getting the product info (product name and price).
public class scrape {
    final String url = "https://www2.hm.com/en_us/men/new-arrivals/view-all.html"; // URL varible for the H&M mens new arrival section.
    ArrayList<String> products = new ArrayList<String>();

    void productInfo() throws IOException {
        Document doc = Jsoup.connect(url).get(); // Connecting to the H&M website with Jsoup using the url varible. 
        slowPrint("Scrapping H&M...");
        for (Element row : doc.select("div.item-details")) { // Using a For loop to find all the prodcuts on the page with the specific HTML.
            slowPrint("\n" + row.select("h3.item-heading").text() + " " + row.select("strong.item-price").text()); // Selecting and printing the elements in the HTML for the product details
        }
    }

    // Slow print method for the text.
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
