package Frames;

import BarTemplate.*;
import Threads.Cook;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainFrame extends JFrame {

    public MainFrame(){
        setSize(300,300);
        setMinimumSize(new Dimension(200,200));
        setTitle("Sushi Bar");
        setLayout(null);
        setVisible(true);

        for(Map.Entry<Integer, BoatLabel> entry:RiverTemplate.getInstance().getBoatMapTemplate().entrySet()){
            add(entry.getValue());
        }

        CookLabel cookLabel1= new CookLabel(20,20);
        CookLabel cookLabel2= new CookLabel(20,160);
        CookLabel cookLabel3= new CookLabel(160,20);
        CookLabel cookLabel4= new CookLabel(160,160);
        cookLabel1.setText("  /  ");
        cookLabel2.setText("  \\  ");
        cookLabel3.setText("  \\  ");
        cookLabel4.setText("  /  ");

        add(cookLabel1);
        add(cookLabel2);
        add(cookLabel3);
        add(cookLabel4);


        for(Map.Entry<Integer, CustomerLabel> entry: GuestTemplate.getInstance().getGuestMapTemplate().entrySet()){
            add(entry.getValue());
        }
    }



}
