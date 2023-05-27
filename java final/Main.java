import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        scrape s1 = new scrape();

        boolean flag = true;
        do {
            System.out.println("Would you like to scrape information from H&M? \n[1] Yes \n[2] No");
            int user = scan.nextInt();

            switch (user) {
                case 1:
                    s1.productInfo();
                    flag = false;
                    break;
                case 2:
                    System.out.println("You have too...");
                    continue;
            }

        } while (flag);

        do {
            System.out.println("\nWould you like to look at an item? \n[1] Yes \n[2] No");
            int user = scan.nextInt();

            switch (user) {
                case 1:
                    selectItem();
                    flag = false;
                case 2:
                    System.out.println("Have a nice day!");
                    flag = false;
                    scan.close();
            }

        } while (flag);
    }

    public static void selectItem() throws IOException {
        productlist p1 = new productlist();
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        System.out.println("What would you like to look at?\n Input item number(1-36): ");
        int user = scan.nextInt();
        if (user == 0) {
            System.out.println("Please select item number between 1-36");
            selectItem();
        } else {
            System.out.println(p1.productLinks().get(user));
        }

        System.out.println("Would you like to get another item? \n[1]Yes \n[2]No");
        int user2 = scan.nextInt();

        switch (user2) {
            case 1:
                selectItem();
                break;

            case 2:
                System.out.println("Bye!");
                break;
        }
    }
}
