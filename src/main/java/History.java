import java.io.*;
import java.util.*;
import java.time.*;

public class History {
    public File file;

    public History(String filename) {
        this.file = new File(filename);
    }

    public void changeFile(String from, String to, double rate) {
        FileWriter fw = null;
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);

        try {
            fw = new FileWriter(this.file, true);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        PrintWriter pw = new PrintWriter(fw);
        String write = String.format("change rate %.2f from %s to %s on %d/%d/%d", rate, from, to, date, month, year);
        pw.println(write);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }


    public String readFile() {
        StringBuilder log = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(this.file));
            String line = null;
            while ((line = bf.readLine()) != null) {
                log.append("\n").append(line);

            }
            bf.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return log.toString();

    }

}