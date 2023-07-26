import java.io.*;
import java.util.*;
import java.util.List;

public class App {
    // let user choose whether they are admin or normal user and then call the appropriate function
    public static boolean admin1;
    public static boolean normalUser1;

    public static Admin admin;

    public static String[] countryArray;
    public static List<Rate> rateList;

    public static void main(String[] args) {
        rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        admin = new Admin(rateList);
        setup(admin);
        UI.startWindow(admin, normal);
    }

    public static void setup(Admin ad) {
        File f = new File("src/main/java/currency");
        Scanner scan;
        int counter = 0;
        try {
            scan = new Scanner(f);
            while (scan.hasNextLine()) {
                String contents = scan.nextLine();
                String[] content = contents.split(" ");
                if (counter >= 1) {
                    Rate rate = new Rate(content[0], content[1]);
                    ad.addRate(rate);
                } else {
                    countryArray = contents.split(",");
                    counter++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file exist.");
            System.out.println("hello");
        }
    }

}


