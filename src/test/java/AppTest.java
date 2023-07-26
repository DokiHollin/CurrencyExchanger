
import org.junit.jupiter.api.Test;
import javax.swing.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void TestMaxIn(){
        ArrayList<Double> array = new ArrayList<>();
        array.add(1.00);
        array.add(3.00);
        array.add(2.00);
        Double actual = UI.maxIn(array);
        assertEquals(3.00,actual);
    }
    @Test
    public void TestMinIn(){
        ArrayList<Double> array = new ArrayList<>();
        array.add(1.00);
        array.add(3.00);
        array.add(2.00);
        Double actual = UI.minIn(array);
        assertEquals(1.00,actual);
    }
    @Test
    public void TestMean(){
        ArrayList<Double> array = new ArrayList<>();
        array.add(1.00);
        array.add(3.00);
        array.add(2.00);
        Double actual = UI.mean(array);
        assertEquals(2.00,actual);
    }
    @Test
    public void TestMedian(){
        ArrayList<Double> array = new ArrayList<>();
        array.add(1.00);
        array.add(2.00);
        array.add(3.00);

        Double actual = UI.median(array);
        assertEquals(2.00,actual);


    }

    @Test
    public void TestMedianEdge(){
        ArrayList<Double> array1 = new ArrayList<>();
        array1.add(1.00);
        array1.add(2.00);
        array1.add(3.00);
        array1.add(4.00);
        Double actual1 = UI.median(array1);
        assertEquals(2.50,actual1);
    }

    @Test
    public void TestCalculateSD(){
        ArrayList<Double> array = new ArrayList<>();
        array.add(1.00);
        array.add(3.00);
        array.add(2.00);
        Double actual = UI.calculateSD(array);
        assertEquals(0.82,actual);
    }

    @Test
    public void TestGetPopularCurrencies(){

        ArrayList<Rate> ls = UI.getPopularCurrencies(App.rateList);
        assertEquals("USA",ls.get(0).getCountry());
        assertEquals("CN",ls.get(1).getCountry());
        assertEquals("AU",ls.get(2).getCountry());
        assertEquals("JPY",ls.get(3).getCountry());

    }
    @Test
    public void TestIncreasePopularity(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        r.increasePopularity();
        assertEquals(1, r.getPopularity());
    }
    @Test
    public void TestGetPopularity(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        assertEquals(0, r.getPopularity());
    }
    @Test
    public void TestGetRate(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        String[] ExpectRate = {"-","0.25","0.685","0.007","0.78","0.86"};
        assertArrayEquals(ExpectRate,r.getRate());
    }
    @Test
    public void TestGetMap(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        List<Integer> keyList = new ArrayList<Integer>();
        List<Integer> valueList = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> map : r.getMap().entrySet()){
            keyList.add(map.getKey());
            valueList.add(map.getValue());
        }
        String KeyListStr = keyList.toString();
        String ValueListStr = valueList.toString();
        assertEquals("[0, 1, 2, 3, 4, 5]", KeyListStr);
        assertEquals("[0, 0, 0, 0, 0, 0]", ValueListStr);

    }
    @Test
    public void TestSetRate(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        r.setRate(3.00,"CN");
        List<Integer> keyList = new ArrayList<Integer>();
        List<Integer> valueList = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> map : r.getMap().entrySet()){
            keyList.add(map.getKey());
            valueList.add(map.getValue());
        }
        String KeyListStr = keyList.toString();
        String ValueListStr = valueList.toString();
        assertEquals("[0, 1, 2, 3, 4, 5]", KeyListStr);
        assertEquals("[0, 1, 0, 0, 0, 0]", ValueListStr);

        r.setRate(0.06,"AU");
        List<Integer> keyList1 = new ArrayList<Integer>();
        List<Integer> valueList1 = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> map : r.getMap().entrySet()){
            keyList1.add(map.getKey());
            valueList1.add(map.getValue());
        }
        String KeyList1Str = keyList1.toString();
        String ValueList1Str = valueList1.toString();
        assertEquals("[0, 1, 2, 3, 4, 5]", KeyList1Str);
        assertEquals("[0, 1, -1, 0, 0, 0]", ValueList1Str);


    }
    @Test
    public void TestSetCountry(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        r.setCountry("USA");
        assertEquals("USA", r.getCountry());
    }
    @Test
    public void TestGetCountry(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        assertEquals("USA", r.getCountry());
    }
    @Test
    public void TestToString(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        assertEquals("USA", r.toString());
    }

    @Test
    //优化，加edge case
    public void TestArraySize(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        assertEquals(6,r.getArraySize());
    }
    @Test
    public void TestReNewRate(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        String[] New_rate = new String[]{"-","0.26","0.685","0.007","0.78","0.86"};
        r.reNewRate(New_rate);
        assertEquals("0.26", r.getRate()[1]);
    }
    @Test
    public void TestGetIcon() {
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        ImageIcon actual = r.getIcon();
        assertEquals(20,actual.getIconWidth());
        assertEquals(20,actual.getIconHeight());
    }
    public void init(){
        App.rateList = new ArrayList<>();
        NormalUser n = new NormalUser(App.rateList);
        Admin ad = new Admin(App.rateList);
        App.setup(ad);
    }
    @Test
    public void TestGetRateList(){
        //admin
        App.rateList = new ArrayList<>();
        NormalUser n = new NormalUser(App.rateList);
        Admin ad = new Admin(App.rateList);
        App.setup(ad);
        String actual = n.getRateList().toString();
        assertEquals(App.rateList.toString(), actual);
        //normal User

        String actual1 = ad.getRateList().toString();
        assertEquals(App.rateList.toString(), actual1);
    }
    @Test
    public void TestSetRate1(){
        App.rateList = new ArrayList<>();
        NormalUser n = new NormalUser(App.rateList);
        Admin ad = new Admin(App.rateList);
        App.setup(ad);
        ad.setRate(ad.getRateList().get(2),
                ad.getRateList().get(0), 6.85, "USA", "AU" );
        for (Rate value : App.rateList) {
            if (value.getCountry().equals("USA")) {
                assertEquals(String.valueOf(6.85), ad.getRateList().get(0).getRate()[2]);
            }
        }

        for (Rate value : App.rateList) {
            if (value.getCountry().equals("AU")) {
                assertEquals(String.valueOf(0.146), ad.getRateList().get(2).getRate()[0]);
            }
        }
    }
    @Test
    public void TestSetRates() {
        this.init();
        String[] newRates = new String[]{"-","0.25","0.685","0.008","0.78","0.86"};
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        r.setRates(newRates);
        String[] expect = new String[]{"-","0.25","0.685","0.008","0.78","0.86"};
        assertArrayEquals(expect, r.getRate());
    }
    // test rate
    @Test

    public void TestReadFile(){
        History H = new History("src/test/java/TestFile");
        String actual = H.readFile();
        assertEquals("\nchange rate 6.70 from USA to CN on 3/8/2022",actual);

    }
    @Test
    public void TestDeleteSizeSmaller(){
        ArrayList<Rate> rateList = new ArrayList<>();
        rateList.add(new Rate("USA" ,"-,0.143,6.85,0.007,0.78,0.86)"));
        rateList.add(new Rate("CN" ,"7.0,-,4.69,0.049,5.35,7.94"));
        rateList.add(new Rate("AU", "0.146,0.213,-,0.01,1.12,0.59)"));
        rateList.add(new Rate("JPY" ,"140.0,20.32,100.0,-,107,0.0061)"));
        Admin testAd = new Admin(rateList);
        int actual = testAd.deleteRate(new Rate("USA" ,"-,0.143,6.85,0.007,0.78,0.86)"));
        assertEquals(1,actual);

    }
    @Test
    public void TestDeleteNormal(){
        ArrayList<Rate> rateList = new ArrayList<>();
        rateList.add(new Rate("USA" ,"-,0.143,6.85,0.007,0.78,0.86"));
        rateList.add(new Rate("CN" ,"7.0,-,4.69,0.049,5.35,7.94"));
        rateList.add(new Rate("AU", "0.146,0.213,-,0.01,1.12,0.59"));
        rateList.add(new Rate("JPY" ,"140.0,20.32,100.0,-,107,0.0061"));
        rateList.add(new Rate("CAD" ,"1.29,0.19,0.89,0.01,-,0.66"));
        Admin testAd = new Admin(rateList);
        int actual = testAd.deleteRate(new Rate("USA" ,"-,0.143,6.85,0.007,0.78,0.86)"));
        assertEquals(0,actual);
    }


    @Test
    public void TestSetPopularity(){
        this.init();
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        r.setPopularity(2);
        int actual = r.getPopularity();
        assertEquals(2, actual);

    }

    @Test
    public void TestSetPopular(){
        App.rateList = new ArrayList<>();
        NormalUser n = new NormalUser(App.rateList);
        Admin ad = new Admin(App.rateList);
        App.setup(ad);
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        Rate r2 = new Rate("CN", "0.25,-,0.685,0.007,0.78,0.86");
        ArrayList<Rate> ls = new ArrayList<>();
        ls.add(r);
        ls.add(r2);
        ad.setPopular(ls);
        for(Rate each : ls){
            assertEquals(1, each.getPopularity());
        }

    }

    @Test
    public void TestResetPopular(){
        App.rateList = new ArrayList<>();
        NormalUser n = new NormalUser(App.rateList);
        Admin ad = new Admin(App.rateList);
        App.setup(ad);
        Rate r = new Rate("USA", "-,0.25,0.685,0.007,0.78,0.86");
        Rate r2 = new Rate("CN", "0.25,-,0.685,0.007,0.78,0.86");
        ArrayList<Rate> ls = new ArrayList<>();
        ls.add(r);
        ls.add(r2);
        ad.setPopular(ls);
        for(Rate each : ls){
            assertEquals(1, each.getPopularity());
        }

        ad.resetPopularity();
        for(Rate each : ad.rateList){
            assertEquals(0, each.getPopularity());
        }
    }

}
