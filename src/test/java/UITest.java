import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITest {
    @Test
    public void testUIForAdmin(){
        ArrayList<Rate> rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        Admin admin = new Admin(rateList);
        App.setup((Admin) admin);

        UI.startWindow(admin, normal);

        UI.displayWindow(admin,normal);
        UI.admin_frame(admin,normal);
        assertEquals("USA",admin.rateList.get(0).getCountry());
    }

    @Test
    public void testUIForNormal(){
        ArrayList<Rate> rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        Admin admin = new Admin(rateList);
        App.setup((Admin) admin);

        UI.startWindow(admin, normal);

        UI.displayWindow(admin,normal);
        UI.normal_frame(admin,normal);
    }

    @Test
    public void testSetPopularityUI(){
        ArrayList<Rate> rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        Admin admin = new Admin(rateList);
        App.setup((Admin) admin);

        JFrame frame = new JFrame();
        UI.setPopularity(frame,admin,normal);

    }

    @Test
    public void testHistoryFrameUI(){
        ArrayList<Rate> rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        Admin admin = new Admin(rateList);
        App.setup((Admin) admin);

        JFrame frame = new JFrame();
        UI.HistoryFrame(frame, new History("src/main/java/history"),admin,normal);

    }

    @Test
    public void testExchangeFrameUI(){
        ArrayList<Rate> rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        Admin admin = new Admin(rateList);
        App.setup((Admin) admin);

        UI.exchange(admin,normal);

    }

    @Test
    public void testSetRateFrameUI(){
        ArrayList<Rate> rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        Admin admin = new Admin(rateList);
        App.setup((Admin) admin);

        JFrame frame = new JFrame();
        UI.setRate(frame,admin,normal);

    }

    @Test
    public void testLoginFrameUI(){
        ArrayList<Rate> rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        Admin admin = new Admin(rateList);
        App.setup((Admin) admin);

        UI.admin_login_frame(admin,normal);

    }

    @Test
    public void testAddRateFrameUI(){
        ArrayList<Rate> rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        Admin admin = new Admin(rateList);
        App.setup((Admin) admin);

        JFrame frame = new JFrame();
        UI.addRate(frame,admin,normal);

    }

    @Test
    public void testDeleteRateFrameUI(){
        ArrayList<Rate> rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        Admin admin = new Admin(rateList);
        App.setup((Admin) admin);

        JFrame frame = new JFrame();
        UI.deleteRate(frame,admin,normal);

    }

    @Test
    public void testGetEachRateFrameUI(){
        ArrayList<Rate> rateList = new ArrayList<>();
        NormalUser normal = new NormalUser(rateList);
        Admin admin = new Admin(rateList);
        App.setup((Admin) admin);

        String newName = "ABC";
        ArrayList<Double> arr = new ArrayList<>();
        JFrame frame = new JFrame();
        UI.getEachNewRate(frame,admin,normal,0,newName,arr);

    }
}
