import org.checkerframework.checker.units.qual.A;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Admin extends User{
    private final String account = "admin";
    private final String password = "123";
    private static final DecimalFormat df = new DecimalFormat("0.000");
    public Admin(List<Rate> rateList) {
        super(rateList);
    }

    public void addRate(Rate rate) {
        rateList.add(rate);
    }

    public int deleteRate(Rate rate) {
        if (rateList.size() == 4) {
            System.out.println("Cannot delete.");
            return 1;
        }
        super.rateList.remove(rate);
        delete(rate);
        update(App.rateList);
        return 0;
    }



    public void setRate(Rate rate, Rate rate2, double newRate, String target, String from) {
        for(int i = 0; i < App.rateList.size(); i++){
            Rate each = App.rateList.get(i);
            for(int j = 0; j < each.getMap().size(); j++){
                each.getMap().replace(j,0);
            }
        }
        for (Rate value : rateList) {
            if (value.getCountry().equals(rate.getCountry())) {
                value.setRate(Double.parseDouble(df.format(1/newRate)),target);
                History history = new History("src/main/java/history");
                history.changeFile(rate.getCountry(), rate2.getCountry(), newRate);
                value.increasePopularity();
            }
        }
        for (Rate value : rateList) {
            if (value.getCountry().equals(rate2.getCountry())) {
                value.setRate(newRate,from);
                value.increasePopularity();
            }
        }
        update(this.rateList);
    }

    public void update(List<Rate> rateList) {
        File file = new File("src/main/java/currency");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < rateList.size(); i++) {
                if (i < rateList.size() - 1) {
                    bw.write(rateList.get(i).getCountry());
                    bw.write(",");
                } else {
                    bw.write(rateList.get(i).getCountry());
                    bw.write("\n");
                }
            }
            for (Rate rate : rateList) {
                bw.write(rate.getCountry());
                bw.write(" ");
                for (int j = 0; j < rate.getRate().length; j++) {
                    if (j < rate.getRate().length - 1) {
                        bw.write(rate.getRate()[j]);
                        bw.write(",");
                    } else {
                        bw.write(rate.getRate()[j]);
                        bw.write("\n");
                    }
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void delete(Rate rate) {
        int index = 0;
        for (int i = 0; i < App.countryArray.length; i++) {
            if (App.countryArray[i].equals(rate.getCountry())) {
                index = i;
                for (int j = index; j < App.countryArray.length - 1; j++) {
                    App.countryArray[j] = App.countryArray[j + 1];
                }
                String[] tmp = new String[App.countryArray.length - 1];
                System.arraycopy(App.countryArray, 0, tmp, 0, App.countryArray.length - 1);
                App.countryArray = tmp;
                for (Rate value : rateList) {
                    for (int j = index; j < value.getArraySize() - 1; j++) {
                        value.getRate()[j] = value.getRate()[j + 1];
                    }
                    String[] x = new String[value.getArraySize() - 1];
                    System.arraycopy(value.getRate(), 0, x, 0, value.getArraySize() - 1);
                    value.setRates(x);
                }
                break;
            }
        }
    }

    public void resetPopularity(){
        for(Rate each: rateList){
            each.setPopularity(0);
        }
    }
    public void setPopular(ArrayList<Rate> rates){
        for(Rate each: rates){
            each.increasePopularity();
        }
    }

}
