import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


class UI {

    public static void startWindow(Admin admin,NormalUser user) {
        beautiful_ui();


        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        addImage(frame,admin,user);

        JLabel label = new JLabel("Currency Converter");
        label.setBounds(150, 70, 200, 30);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(label);

        JButton button = new JButton("Start Conversion");
        mouseOnButton(button);
        button.setBounds(150, 150, 200, 50);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));




        frame.add(button);
        button.addActionListener(e -> {
            frame.dispose();
            displayWindow(admin,user);
        });
        exit_button(frame);

        frame.setVisible(true);

    }



    public static void exit_button(JFrame frame){
        JButton exit = new JButton("Exit");
        exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(exit);
        exit.setBounds(400, 10, 80, 30);
        frame.add(exit);
        exit.addActionListener(e -> System.exit(0));
    }

    public static void addImage(JFrame frame, Admin admin, NormalUser user) {
        ImageIcon icon = new ImageIcon("src/images/ICON.png");


        JLabel image = new JLabel(icon);
        image.resize(80, 80);
        image.setLocation(0, 0);
        // 鼠标在图片上变成手指
        image.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // add hyperlink to image
        image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startWindow(admin, user);
            }
        });
        frame.add(image);
    }

    // begin window
    public static void displayWindow(Admin admin_user,NormalUser normal_User) {
        beautiful_ui();
        JFrame frame = new JFrame("Rate Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JButton admin = new JButton("Admin");
        admin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(admin);
        JButton user = new JButton("User");
        user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(user);
        admin.setBounds(100, 140, 100, 50);
        user.setBounds(300, 140, 100, 50);
        frame.add(admin);
        frame.add(user);

        JLabel label = new JLabel("Please choose whether you are admin or normal user");
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setBounds(80, 90, 400, 30);
        frame.add(label);

        addImage(frame,admin_user,normal_User);

        frame.setVisible(true);
        admin.addActionListener(e -> {
            App.admin1 = true;
            frame.dispose();
            admin_login_frame(admin_user,normal_User);
        });

        user.addActionListener(e -> {
            App.normalUser1 = true;

            normal_frame(admin_user,normal_User);
            frame.dispose();

        });
        exit_button(frame);

    }

    // admins' window
    public static void admin_frame(Admin admin_user,NormalUser normal_User) {
        JFrame admin_frame = new JFrame("Admin");
        admin_frame.setSize(500, 300);
        admin_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admin_frame.setLocationRelativeTo(null);
        admin_frame.setLayout(null);

        addImage(admin_frame,admin_user,normal_User);
        exit_button(admin_frame);

        // add a label to show the Frame name
        JLabel label = new JLabel("Admin");
        label.setBounds(200, 10, 100, 30);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        admin_frame.add(label);

        JButton checkRate = new JButton("checkRate");
        checkRate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(checkRate);
        checkRate.setBounds(50, 80, 100, 40);
        admin_frame.add(checkRate);

        JButton setRate = new JButton("setRate");
        setRate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(setRate);
        setRate.setBounds(200, 80, 100, 40);
        admin_frame.add(setRate);

        // addRate button
        JButton addRate = new JButton("addRate");
        addRate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(addRate);
        addRate.setBounds(50, 130, 100, 40);
        admin_frame.add(addRate);

        // deleteRate button
        JButton deleteRate = new JButton("deleteRate");
        deleteRate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(deleteRate);
        deleteRate.setBounds(200, 130, 100, 40);
        admin_frame.add(deleteRate);


        // backward button
        JButton back = new JButton("back");
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(back);
        back.setBounds(200, 200, 100, 40);
        admin_frame.add(back);

        // history button
        JButton checkHistory = new JButton("History");
        checkHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(checkHistory);
        checkHistory.setBounds(350, 80, 100, 40);
        admin_frame.add(checkHistory);

        // set popularity button
        JButton setPopularity = new JButton("Popularity");
        setPopularity.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(setPopularity);
        setPopularity.setBounds(350, 130, 100, 40);
        admin_frame.add(setPopularity);


        // when press checkRate button, show the rate
        checkRate.addActionListener(e -> rateTable( admin_user.rateList));
        deleteRate.addActionListener(e -> {
            admin_frame.dispose();
            deleteRate(admin_frame,admin_user,normal_User);
        });


        addRate.addActionListener(e -> {
            admin_frame.dispose();
            addRate(admin_frame, admin_user, normal_User);
        });

        back.addActionListener(e -> {

            displayWindow(admin_user,normal_User);
            admin_frame.dispose();
        });

        setRate.addActionListener(e -> {
            admin_frame.dispose();
            setRate(admin_frame, admin_user,normal_User);
        });

        checkHistory.addActionListener(e ->{
            HistoryFrame(admin_frame, new History("src/main/java/history"),admin_user,normal_User);
        });

        setPopularity.addActionListener(e ->{
            admin_frame.dispose();
            setPopularity(admin_frame,admin_user,normal_User);
        });


        admin_frame.setVisible(true);
    }

    public static void setPopularity(JFrame frame, Admin admin_user, NormalUser normal_User){
        JFrame setPopularity = new JFrame("Set Popularity");
        setPopularity.setSize(500, 300);
        setPopularity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPopularity.setLocationRelativeTo(null);
        setPopularity.setLayout(null);
        admin_user.resetPopularity();
        addImage(setPopularity,admin_user,normal_User);
        exit_button(setPopularity);

        JLabel label = new JLabel("Set Popularity");
        label.setBounds(200, 50, 100, 30);
        setPopularity.add(label);

        JComboBox comboBox1 = new JComboBox<>(admin_user.rateList.toArray());
        comboBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBox1.setBounds(40, 100, 100, 30);
        add_icon(comboBox1);
        setPopularity.add(comboBox1);

        JComboBox comboBox2 = new JComboBox<>(admin_user.rateList.toArray());
        comboBox2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBox2.setBounds(140, 100, 100, 30);
        add_icon(comboBox2);
        setPopularity.add(comboBox2);

        JComboBox comboBox3 = new JComboBox<>(admin_user.rateList.toArray());
        comboBox3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBox3.setBounds(240, 100, 100, 30);
        add_icon(comboBox3);
        setPopularity.add(comboBox3);

        JComboBox comboBox4 = new JComboBox<>(admin_user.rateList.toArray());
        comboBox4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBox4.setBounds(340, 100, 100, 30);
        add_icon(comboBox4);
        setPopularity.add(comboBox4);

        JButton confirm = new JButton("confirm");
        confirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(confirm);
        confirm.setBounds(200, 150, 100, 40);
        setPopularity.add(confirm);


        confirm.addActionListener(e1 -> {
            int success = 0;
            ArrayList<JComboBox> comboLs = new ArrayList<>();
            comboLs.add(comboBox1);
            comboLs.add(comboBox2);
            comboLs.add(comboBox3);
            comboLs.add(comboBox4);
            ArrayList<String> check_same = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                if (check_same.contains(Objects.requireNonNull(comboLs.get(i).getSelectedItem()).toString())) {
                    JOptionPane.showMessageDialog(null, "Can not choose the same country!");
                    break;
                }
                if(i == 3)
                    success = 1;
                check_same.add(Objects.requireNonNull(comboBox1.getSelectedItem()).toString());

            }
            if(success == 1) {
                JOptionPane.showMessageDialog(null, "Setup Successfully!");
                ArrayList<Rate> result = new ArrayList<>();
                for(int i = 0; i < comboLs.size(); i++) {
                    for(Rate each: admin_user.rateList){
                        if(each.getCountry().equals(Objects.requireNonNull(comboLs.get(i).getSelectedItem()).toString())){
                            result.add(each);
                        }
                    }
                }
                admin_user.setPopular(result);
                setPopularity.dispose();
                admin_frame(admin_user,normal_User);

            }
        });


//        //add a button to confirm the amount
//        JButton confirm3 = new JButton("confirm");
//        confirm3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        mouseOnButton(confirm3);
//        confirm3.setBounds(250, 150, 80, 30);
//        jFrame.add(confirm3);
//        //create a variable to store the amount
//
//        confirm3.addActionListener(e1 ->{
//            String newName = textField.getText();
//            System.out.println(newName);
//
//            ArrayList<Double> arr = new ArrayList<>();
//            for(int i = 0; i < admin.rateList.size(); i++){
//                jFrame.dispose();
//                getEachNewRate(jFrame,admin,normalUser,i,newName,arr);
//            }
//        });
//        admin_frame(admin,normalUser);
//        jFrame.setVisible(true);

        JButton back = new JButton("back");
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(back);
        back.setBounds(200, 200, 100, 40);
        setPopularity.add(back);

        back.addActionListener(e -> {
            admin_frame(admin_user,normal_User);
            setPopularity.dispose();
        });



        setPopularity.setVisible(true);
    }

    public static void HistoryFrame(JFrame frame, History history,Admin admin,NormalUser normalUser) {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setLayout(null);
        exit_button(frame);


        JTextArea textArea = new JTextArea(history.readFile());


        String[] hist1 = history.readFile().split("\n");
        int counterq = 0;
        ArrayList<String> history_list = new ArrayList<>();
        for(String each: hist1){
            String[] temp1 = each.split(" ");
            ArrayList<String> t1 = new ArrayList<>();
            if(t1.size() == 1){
                counterq++;
                continue;
            }else{
                history_list.add(List.of(temp1).toString());
            }
        }



        ArrayList<String> final_list = new ArrayList<>();
        for(int i = 1; i < history_list.size();i ++){
            String line = history_list.get(i);
            String temp = line.substring(0, line.length() - 1);
            String[] temp1 = temp.split(" ");
            String string = temp1[8];

            if(!final_list.contains(string)){
                // add the 8th element of temp
                final_list.add(string);
            }


        }

        // add the final_list to the combobox
        JComboBox<String> time_from = new JComboBox<>();
        time_from.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        for(String each: final_list){
            time_from.addItem(each);
        }
        time_from.setBounds(120, 80, 100, 30);
        frame.add(time_from);

        JComboBox<String> time_to = new JComboBox<>();
        time_to.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        for(String each: final_list){
            time_to.addItem(each);
        }

        time_to.setBounds(120, 140, 100, 30);
        frame.add(time_to);


        JLabel label1 = new JLabel("What currency do you have?");
        label1.setBounds(50, 50, 200, 30);
        frame.add(label1);

        JLabel label2 = new JLabel("Time from :");
        label2.setBounds(50, 80, 200, 30);
        frame.add(label2);

        JLabel label5 = new JLabel("Time to :");
        label5.setBounds(50, 140, 200, 30);
        frame.add(label5);

        JLabel label3 = new JLabel("From");
        label3.setBounds(260, 80, 200, 30);
        frame.add(label3);

        JComboBox comboBox1 = new JComboBox<>(admin.rateList.toArray());
        comboBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBox1.setBounds(300, 80, 100, 30);
        add_icon(comboBox1);
        frame.add(comboBox1);

        JComboBox comboBox2 = new JComboBox<>(admin.rateList.toArray());
        comboBox2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBox2.setBounds(300, 140, 100, 30);
        add_icon(comboBox2);
        frame.add(comboBox2);

        JLabel label4 = new JLabel("To");
        label4.setBounds(260, 140, 200, 30);
        frame.add(label4);







        //add a button to confirm the amount
        JButton confirm3 = new JButton("confirm");
        confirm3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(confirm3);
        confirm3.setBounds(200, 200, 100, 40);
        frame.add(confirm3);

        //create a variable to store the amount
        confirm3.addActionListener(e1 -> {
            if(comboBox1.getSelectedItem().equals(comboBox2.getSelectedItem())) {
                JOptionPane.showMessageDialog(null, "Please choose different currencies");
            }else {


                String timeFrom = ((String) time_from.getSelectedItem()).split("/")[0];
                String timeTo = (time_to.getSelectedItem().toString()).split("/")[0];

                ArrayList<String> time = new ArrayList<>();
                ArrayList<String> from = new ArrayList<>();
                ArrayList<String> to = new ArrayList<>();
                ArrayList<Integer> indexes = new ArrayList<>();
//            double[] rates = new double[500];
                ArrayList<Double> rates = new ArrayList<>();
//        JLabel label = new JLabel(history.readFile());
                String[] hist = history.readFile().split("\n");
                int counter = 0;
                int counter2 = 0;
                for (String each : hist) {
                    String[] temp = each.split(" ");
                    ArrayList<String> t = new ArrayList<>();

                    t.addAll(List.of(temp));
                    if (t.size() == 1) {
                        counter++;
                        continue;
                    }

                    for (int i = Integer.parseInt(timeFrom); i <= Integer.parseInt(timeTo); i++) {
                        if ((((t.get(8).split("/")[0])).equals(String.valueOf(i))) && t.get(4).equals(Objects.requireNonNull(comboBox1.getSelectedItem()).toString()) && t.get(6).equals(Objects.requireNonNull(comboBox2.getSelectedItem()).toString())|| (((t.get(8).split("/")[0])).equals(String.valueOf(i))) && t.get(4).equals(Objects.requireNonNull(comboBox2.getSelectedItem()).toString()) && t.get(6).equals(Objects.requireNonNull(comboBox1.getSelectedItem()).toString())) {

                            time.add(t.get(8));
                            from.add(t.get(4));
                            to.add(t.get(6));
                            indexes.add(counter);
                            rates.add(Double.parseDouble(t.get(2)));
                            counter2++;
                        }
                    }
                    counter++;

                }
                StringBuilder sb = new StringBuilder();
                for (Integer index : indexes) {
                    sb.append(hist[index]);
                    sb.append('\n');
                }

                //clear the frame
                frame.getContentPane().removeAll();
                frame.repaint();

                JTextArea textArea2 = new JTextArea(String.valueOf(sb));
                JScrollPane scrollPane = new JScrollPane(textArea2);
                scrollPane.setBounds(0, 0, 500, 180);
                frame.add(scrollPane);

                JLabel std = new JLabel("std is: " + calculateSD(rates));
                std.setBounds(20, 200, 100, 30);
                frame.add(std);
                // calculate the average and round it to 2 decimal places

                JLabel mean = new JLabel("mean is: " + Math.round(((mean(rates))) * 100.0) / 100.0);
                mean.setBounds(120, 200, 100, 30);
                frame.add(mean);

                JLabel median = new JLabel("median is: " + median(rates));
                median.setBounds(220, 200, 100, 30);
                frame.add(median);


                JLabel max = new JLabel("max is: " + maxIn(rates));
                max.setBounds(320, 200, 100, 30);
                frame.add(max);

                JLabel min = new JLabel("min is: " + minIn(rates));
                min.setBounds(400, 200, 100, 30);
                frame.add(min);

                JButton back = new JButton("back");
                back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                mouseOnButton(back);
                back.setBounds(180, 240, 100, 30);
                frame.add(back);
                back.addActionListener(e -> {
                    admin_frame(admin, normalUser);
                    frame.dispose();
                });

            }
        });

        // add a back button above the scrollable area
        JButton back = new JButton("back");
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(back);
        back.setBounds(50, 200, 80, 30);
        frame.add(back);
        back.addActionListener(e -> {
            admin_frame(admin,normalUser);
            frame.dispose();
        });
    }

    public static double maxIn(ArrayList<Double> rates){
        double max = -Double.MAX_VALUE;
        for (double val : rates) {
            max = Math.max(max, val);
        }
        return max;
    }

    public static double minIn(ArrayList<Double> array) {
        double min = Double.MAX_VALUE;
        //create a max variable

        for (double val : array) {
            if(val == 0){
                continue;
            }
            min = Math.min(min, val);
        }
        if( min == Double.MAX_VALUE){
            return 0;
        }
        return min;
    }

    public static double mean(ArrayList<Double> array) {
        double sum = 0;
        for (double v : array) {
            sum += v;
        }
        return sum / array.size();
    }

    // the array double[] m MUST BE SORTED
    public static double median(ArrayList<Double> m) {
        int middle = m.size()/2;
        if (m.size()%2 == 1) {
            return m.get(middle);
        } else {
            return (m.get(middle - 1) + m.get(middle)) / 2.0;
        }

    }

    public static double calculateSD(ArrayList<Double> rates)
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = rates.size();

        for(double num : rates) {
            sum += num;
        }
        double mean = sum/length;
        for(double num: rates) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        //round the result to 2 decimal places
        return Math.round(Math.sqrt(standardDeviation/length) * 100.0) / 100.0;
//        return Math.sqrt(standardDeviation/length);
    }

    public static void normal_frame(Admin admin_user,NormalUser normal_user){
        JFrame normal_frame = new JFrame("Normal");
        normal_frame.setSize(500, 300);
        normal_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        normal_frame.setLocationRelativeTo(null);
        normal_frame.setLayout(null);

        addImage(normal_frame,admin_user,normal_user);
        exit_button(normal_frame);

        JButton checkRate = new JButton("checkRate");
        checkRate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(checkRate);
        checkRate.setBounds(130, 100, 100, 40);
        normal_frame.add(checkRate);

        JButton exchange = new JButton("exchange");
        exchange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(exchange);
        exchange.setBounds(270, 100, 100, 40);
        normal_frame.add(exchange);

        JButton back = new JButton("back");
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(back);
        back.setBounds(200, 200, 60, 40);

        normal_frame.add(back);

        back.addActionListener(e -> {

            displayWindow(admin_user,normal_user);
            normal_frame.dispose();
        });

        checkRate.addActionListener(e -> {
            rateTable(normal_user.rateList);
        });

        exchange.addActionListener(e -> {

            exchange(admin_user,normal_user);
            normal_frame.dispose();
        });
        normal_frame.setVisible(true);
    }

    public static ArrayList<Rate> getPopularCurrencies(List<Rate> rateList){
        ArrayList<Rate> ls = new ArrayList<>(rateList);
        ArrayList<Rate> result = new ArrayList<>();

        while(result.size() < 4){
            Rate maxRate = ls.get(0);
            for (Rate l : ls) {
                if (maxRate.getPopularity() < l.getPopularity()) {
                    maxRate = l;
                }
            }
            result.add(maxRate);
            ls.remove(maxRate);
        }
        return result;
    }

    public static void rateTable(List<Rate> rateList) {
        JTable table = new JTable(5, 5);
        table.setBounds(30, 40, 200, 300);

        ArrayList<Rate> popularLs = getPopularCurrencies(rateList);

        for(int i = 0; i < popularLs.size() ; i++){

            if (popularLs.get(i) != null) {
                table.setValueAt(popularLs.get(i).getCountry(), i+1, 0);
            }
        }

        for(int i = 0; i < popularLs.size(); i++) {
            if (popularLs.get(i) != null) {
                table.setValueAt(popularLs.get(i).getCountry(), 0, i+1);
            }
        }
        for(int i = 1; i < popularLs.size() + 1; i++){
            for(int j = 1; j < popularLs.size() + 1; j++){
                String value = popularLs.get(i - 1).getRate()[rateList.indexOf(popularLs.get(j - 1))];
                if(popularLs.get(i - 1).getMap().get(rateList.indexOf(popularLs.get(j - 1))) != 0){
                    if(popularLs.get(i - 1).getMap().get(rateList.indexOf(popularLs.get(j - 1))) == 1){
                        String increased = value + "(I)";
                        increased = "<html><font color='red'>" + increased + "</font></html>";
                        table.setValueAt(increased, i, j);
                    }else{
                        String decreased = value + "(D)";
                        decreased = "<html><font color='green'>" + decreased + "</font></html>";
                        table.setValueAt(decreased, i, j);
                    }
                }else{
                    table.setValueAt(value, i, j);
                }
            }
        }
        //set the image of JOptionPane
        ImageIcon icon = new ImageIcon("src/images/ICON.png");

        JOptionPane.showMessageDialog(null, table, "Rate Table", JOptionPane.INFORMATION_MESSAGE, icon);
    }


    public static void add_icon(JComboBox<Object> comboBox){
        comboBox.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Rate) {
                    Rate rate = (Rate) value;
                    setText(rate.getCountry());
                    setIcon(rate.getIcon());
                }
                return this;
            }
        });
    }

    //allow normal user to exchange money
    public static void exchange(Admin adminUser, NormalUser user){
        JFrame exchange_frame = new JFrame("Exchange");
        exchange_frame.setSize(500, 300);
        exchange_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exchange_frame.setLocationRelativeTo(null);
        exit_button(exchange_frame);

        exchange_frame.setLayout(null);
        exchange_frame.setTitle("Exchange money");
        JLabel label1 = new JLabel("What currency do you have?");
        label1.setBounds(50, 20, 200, 30);
        exchange_frame.add(label1);

        List<Rate> rateList = user.rateList;

        JComboBox<Object> comboBox1 = new JComboBox<>(rateList.toArray());
        comboBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        comboBox1.setBounds(250, 50, 100, 30);

        add_icon(comboBox1);

        exchange_frame.add(comboBox1);


        JLabel label2 = new JLabel("What currency do you want?");
        label2.setBounds(50, 100, 200, 30);
        exchange_frame.add(label2);
        // add a drop-down list contains all the currency
        JComboBox<Object> comboBox2 = new JComboBox<>(rateList.toArray());
        comboBox2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        comboBox2.setBounds(250, 100, 100, 30);
        exchange_frame.add(comboBox2);

        add_icon(comboBox2);

        // add a button to confirm the currency
        JButton confirm2 = new JButton("confirm");
        confirm2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(confirm2);
        confirm2.setBounds(400, 100, 80, 30);
        exchange_frame.add(confirm2);
        //create a variable to store the currency
        confirm2.addActionListener(e -> {
            String currency1 = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
            String currency2 = Objects.requireNonNull(comboBox2.getSelectedItem()).toString();
            if(currency1.equals(currency2)) {
                JOptionPane.showMessageDialog(null, "You have choose the same currency!");
                exchange_frame.dispose();
                exchange(adminUser, user);
            }
            //clear the frame
            exchange_frame.getContentPane().removeAll();
            exchange_frame.repaint();
            //add a label to show the currency
            JLabel label3 = new JLabel("You want to exchange " + currency1 + " to " + currency2);
            label3.setBounds(50, 50, 300, 30);
            exchange_frame.add(label3);

            JButton back1 = new JButton("Back");
            back1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            mouseOnButton(back1);
            back1.setBounds(50, 200, 80, 30);
            exchange_frame.add(back1);
            back1.addActionListener(e1 -> {
                exchange_frame.dispose();
                exchange(adminUser, user);
            });

            //add a text field to input the amount
            JTextField textField = new JTextField();
            textField.setBounds(50, 100, 100, 30);
            exchange_frame.add(textField);
            //add a button to confirm the amount
            JButton confirm3 = new JButton("confirm");
            confirm3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            mouseOnButton(confirm3);
            confirm3.setBounds(200, 100, 80, 30);
            exchange_frame.add(confirm3);
            //create a variable to store the amount

            confirm3.addActionListener(e1 ->{
                try {
                    double amount = Double.parseDouble(textField.getText());
                    exchange_frame.getContentPane().removeAll();
                    exchange_frame.repaint();

                    JLabel label4 = new JLabel("Congratulations! \n You can get " + (Math.round(amount * Double.parseDouble(rateList.get(comboBox2.getSelectedIndex()).getRate()[comboBox1.getSelectedIndex()]))) +  " " + currency2);
                    // larger the font
                    label4.setFont(new Font("Serif", Font.PLAIN, 20));
                    label4.setBounds(50, 120, 400, 30);
                    exchange_frame.add(label4);

                    JButton back = new JButton("Back");
                    back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    mouseOnButton(back);
                    back.setBounds(200, 200, 80, 30);
                    exchange_frame.add(back);
                    back.addActionListener(e2 -> {
                        exchange_frame.dispose();
                        normal_frame(adminUser, user);
                    });
                }catch (NumberFormatException e2){
                    JOptionPane.showMessageDialog(null, "Please input a number!");
                    exchange_frame.dispose();
                    exchange(adminUser, user);
                }
                //clear the frame


            });
        });
        JButton back = new JButton("Back");
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(back);
        back.setBounds(50, 220, 80, 30);
        exchange_frame.add(back);
        back.addActionListener(e1 -> {

            normal_frame(adminUser,user);
            exchange_frame.dispose();
        });
        exchange_frame.setVisible(true);
    }

    public static void setRate(JFrame frame, Admin admin,NormalUser normalUser){


        //remove the previous components
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel label1 = new JLabel("Country from?");
        label1.setBounds(50, 50, 200, 30);
        frame.add(label1);
        exit_button(frame);
        //add a drop-down list contains all the currency
        List<Rate> rateList = admin.rateList;
        JComboBox<Object> comboBox1 = new JComboBox<>(rateList.toArray());
        comboBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add_icon(comboBox1);
        comboBox1.setBounds(250, 50, 100, 30);
        frame.add(comboBox1);

        JLabel label3 = new JLabel("Country to?");
        label3.setBounds(50, 100, 200, 30);
        frame.add(label3);
        //add a drop-down list contains all the currency
        List<Rate> rateList2 = admin.rateList;
        JComboBox<Object> comboBox2 = new JComboBox<>(rateList2.toArray());
        comboBox2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add_icon(comboBox2);
        comboBox2.setBounds(250, 100, 100, 30);
        frame.add(comboBox2);



        //add a button to confirm the currency
        JButton confirm1 = new JButton("confirm");
        confirm1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(confirm1);
        confirm1.setBounds(400, 150, 80, 30);
        frame.add(confirm1);

        JLabel label2 = new JLabel("What is the new rate?");
        label2.setBounds(50, 150, 200, 30);
        frame.add(label2);
        //add a text field to input the new rate
        JTextField textField = new JTextField();
        textField.setBounds(250, 150, 100, 30);
        frame.add(textField);

        JButton back = new JButton("Back");
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(back);
        back.setBounds(50, 220, 80, 30);
        frame.add(back);
        back.addActionListener(e1 -> {

            admin_frame( admin,normalUser);
            frame.dispose();
        });

        //create a variable to store the currency
        confirm1.addActionListener(e ->{
            if(comboBox1.getSelectedIndex() == comboBox2.getSelectedIndex()){
                JOptionPane.showMessageDialog(null,"please choose two different currency.");
            }
            try{
                double newRate = Double.parseDouble(textField.getText());
            }catch(Exception a){
                JOptionPane.showMessageDialog(null,"please fill in the number.");
            }
            double newRate = Double.parseDouble(textField.getText());
            Rate currency = (Rate) Objects.requireNonNull(comboBox1.getSelectedItem());
            for(int i = 0; i < admin.rateList.size(); i ++){
                //find the currency in the list
                if(admin.rateList.get(i).getCountry().equals(currency.getCountry())){
                    //remove the currency from the list
                    admin.setRate(rateList.get(i),rateList.get(comboBox2.getSelectedIndex()),newRate, String.valueOf(rateList.get(comboBox2.getSelectedIndex())) , String.valueOf(rateList.get(comboBox1.getSelectedIndex())));
                    JOptionPane.showMessageDialog(null, "Set successfully!");
                    System.out.println(admin.rateList.get(i).getCountry() + " " +admin.rateList.get(i).getRate());
                }
            }
            rateTable(rateList);



        });

        frame.setVisible(true);
    }

    public static void addRate(JFrame jFrame,Admin admin, NormalUser normalUser){
        ArrayList<Double> currencies = new ArrayList<>();
        jFrame.getContentPane().removeAll();
        jFrame.repaint();
        JLabel label1 = new JLabel("Enter a new type of currency");
        label1.setBounds(50, 100, 200, 30);
        jFrame.add(label1);
        exit_button(jFrame);

        // add back button
        JButton back = new JButton("Back");
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(back);
        back.setBounds(50, 220, 80, 30);
        jFrame.add(back);
        back.addActionListener(e1 -> {

            admin_frame( admin,normalUser);
            jFrame.dispose();
        });

        JTextField textField = new JTextField();
        textField.setBounds(250, 100, 100, 30);
        jFrame.add(textField);

        //add a button to confirm the amount
        JButton confirm3 = new JButton("confirm");
        confirm3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(confirm3);
        confirm3.setBounds(250, 150, 80, 30);
        jFrame.add(confirm3);
        //create a variable to store the amount

        confirm3.addActionListener(e1 ->{
            String newName = textField.getText();
            System.out.println(newName);

            ArrayList<Double> arr = new ArrayList<>();
            for(int i = 0; i < admin.rateList.size(); i++){
                jFrame.dispose();
                getEachNewRate(jFrame,admin,normalUser,i,newName,arr);
            }
        });
        admin_frame(admin,normalUser);
        jFrame.setVisible(true);
    }

    // delete a currency
    public static void deleteRate(JFrame jFrame,Admin admin, NormalUser normalUser){

        jFrame.getContentPane().removeAll();
        jFrame.repaint();
        JLabel label1 = new JLabel("Enter the currency you want to delete");
        label1.setBounds(20, 100, 230, 30);
        jFrame.add(label1);
        exit_button(jFrame);

        // add back button
        JButton back = new JButton("Back");
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(back);
        back.setBounds(50, 220, 80, 30);
        jFrame.add(back);
        back.addActionListener(e1 -> {

            admin_frame( admin,normalUser);
            jFrame.dispose();
        });


        JComboBox<Object> comboBox1 = new JComboBox<>(admin.rateList.toArray());
        comboBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add_icon(comboBox1);
        comboBox1.setBounds(250, 100, 100, 30);
        jFrame.add(comboBox1);

        //add a button to confirm the amount
        JButton confirm3 = new JButton("confirm");
        confirm3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(confirm3);
        confirm3.setBounds(250, 150, 80, 30);
        jFrame.add(confirm3);
        //create a variable to store the amount

        confirm3.addActionListener(e1 ->{
//            jFrame.dispose();
            String newName = comboBox1.getSelectedItem().toString();
            System.out.println(newName);
            for(int i = 0; i < admin.rateList.size(); i++){
                if(admin.rateList.get(i).getCountry().equals(newName)){
                    if (admin.deleteRate(admin.rateList.get(i)) == 0) {
                        JOptionPane.showMessageDialog(null, "Delete successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cannot delete!");
                    }
                    deleteRate(jFrame,admin,normalUser);
                }
            }
            rateTable(admin.rateList);
        });
//        admin_frame(admin,normalUser);
        jFrame.setVisible(true);
    }

    public static void getEachNewRate(JFrame jframe, Admin admin,NormalUser normalUser,int index,String newName,ArrayList<Double> arr){
        jframe.setVisible(false);
        JFrame fm = new JFrame("Add new currency");
        fm.setSize(500, 300);
        fm.setLocationRelativeTo(null);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.setLayout(null);
        exit_button(fm);

        JLabel label1 = new JLabel("Enter the rate for " + admin.rateList.get(index).getCountry());
        label1.setFont(new Font("Arial", Font.PLAIN, 15));
        label1.setBounds(50, 100, 200, 30);
        fm.add(label1);
        JTextField textField = new JTextField();
        textField.setBounds(250, 100, 100, 30);

        fm.add(textField);

        JButton confirm3 = new JButton("confirm");
        confirm3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(confirm3);
        confirm3.setBounds(250, 150, 80, 30);
        fm.add(confirm3);
        confirm3.addActionListener(e ->{
            fm.dispose();
            Double input = Double.parseDouble(textField.getText());
            System.out.println(input);
            fm.dispose();
            JOptionPane.showMessageDialog(null, "Set successfully for " + admin.rateList.get(index).getCountry());
            if(index != 0){
                arr.add(input);
//            Rate newRate
            }else{
                arr.add(input);
                System.out.println(arr);
                for(int i = 0; i < admin.rateList.size(); i++){
                    ArrayList<String> temp2 = new ArrayList<>(Arrays.asList(admin.rateList.get(i).getRate()));
                    temp2.add(String.valueOf(1/arr.get(i)));
                    admin.rateList.get(i).reNewRate(temp2.toArray(new String[0]));
                    admin.rateList.get(i).getMap().put(admin.rateList.size(),0);
                }

                String x = arr.toString();
                StringBuilder sb = new StringBuilder();
                sb.append(x);
                sb.delete(sb.length() - 1, sb.length());
                sb.delete(0,1);
                System.out.println(sb);
                sb = new StringBuilder(sb + ",-");
                x = sb.substring(0,sb.length());
                System.out.println(x);
                Rate newRate = new Rate(newName,x);

                admin.rateList.add(newRate);
//                newRate.increasePopularity();
                ArrayList<String> temp = new ArrayList<>(Arrays.asList(App.countryArray));
                temp.add(newName);
                App.countryArray =  temp.toArray(new String[0]);
                App.admin.update(admin.rateList);

                newRate.getMap().put(admin.rateList.size()-1,0);
                for(Rate each: admin.rateList){
                    System.out.println(each.getMap());
                }
            }
        });

        fm.setVisible(true);

    }

    public static void admin_login_frame(Admin admin,NormalUser normalUser){
        JFrame login_frame = new JFrame("Login");
        login_frame.setSize(500, 300);
        login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login_frame.setLocationRelativeTo(null);
        login_frame.setLayout(null);
        login_frame.setTitle("Login");
        exit_button(login_frame);
        JLabel label1 = new JLabel("Username:");
        label1.setBounds(50, 50, 100, 30);
        login_frame.add(label1);
        JTextField textField1 = new JTextField();
        textField1.setBounds(150, 50, 100, 30);
        login_frame.add(textField1);
        JLabel label2 = new JLabel("Password:");
        label2.setBounds(50, 100, 100, 30);
        login_frame.add(label2);

        JPasswordField textField2 = new JPasswordField();
        textField2.setBounds(150, 100, 100, 30);
        login_frame.add(textField2);




        JButton login = new JButton("Login");
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(login);
        login.setBounds(150, 150, 80, 30);
        login_frame.add(login);
        JLabel label3 = new JLabel("admin account: admin");
        label3.setBounds(300, 50, 200, 30);
        login_frame.add(label3);
        JLabel label4 = new JLabel("admin password: 123");
        label4.setBounds(300, 100, 200, 30);
        login_frame.add(label4);
        JButton back = new JButton("Back");
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mouseOnButton(back);
        back.setBounds(50, 200, 80, 30);
        login_frame.add(back);
        back.addActionListener(e1 -> {
            displayWindow(admin,normalUser);
        });
        login.addActionListener(e -> {
            String username = textField1.getText();
            String password = textField2.getText();
            if(username.equals("admin") && password.equals("123")){
                ImageIcon login_icon = new ImageIcon("src/images/login.png");
                JOptionPane.showMessageDialog(null, "Login successfully!", "Login", JOptionPane.INFORMATION_MESSAGE,login_icon);
                login_frame.dispose();
                admin_frame(admin,normalUser);
            }else{
                JOptionPane.showMessageDialog(null, "Wrong username or password!");
            }
        });
        login_frame.setVisible(true);
    }

    // when mouse on the button, larger the font
    public static void mouseOnButton(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setFont(new Font("Arial", Font.PLAIN, 15));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setFont(new Font("Arial", Font.PLAIN, 13));
            }
        });
    }

    // beautiful the UI
    public static void beautiful_ui(){
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}