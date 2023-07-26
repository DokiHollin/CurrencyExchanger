import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Rate {
    private String country;
    private String[] rate;
    private int popularity;

    private HashMap<Integer,Integer> varied = new HashMap<>();

    public Rate(String country, String rates) {
        this.country = country;
        this.rate = rates.split(",");
        for(int i = 0; i < App.countryArray.length; i ++){
            varied.put(i,0);
        }
        this.popularity = 0;
    }


    public int getArraySize(){
        return this.rate.length;
    }
    public void increasePopularity(){
        this.popularity++;
    }

    public int getPopularity(){
        return this.popularity;
    }

    public void setPopularity(int amount){ this.popularity = amount;}
    public String[] getRate() {
        return rate;
    }

    public void setRates(String[] rates) {
        this.rate = rates;
    }

    public HashMap<Integer,Integer> getMap(){
        return this.varied;
    }
    public void setRate(double rate,String target) {

        for(int i = 0; i < App.countryArray.length; i++){
            if(App.countryArray[i].equals(target)){
                if(Double.parseDouble(this.rate[i]) > rate){
                    varied.replace(i,-1);
                }else if((Double.parseDouble(this.rate[i]) < rate)){
                    varied.replace(i,1);
                }
                this.rate[i] = String.valueOf(rate);
            }
        }
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    //get icon for each country
    public ImageIcon getIcon() {
        ImageIcon icon = new ImageIcon("src/images/" + country + ".png");
        //resize icon
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    public void reNewRate(String[] rate){
        this.rate = rate;
    }

    public String toString() {
        return country;
    }
}
