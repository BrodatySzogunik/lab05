package BarTemplate;

import Frames.SetPreferencesFrame;
import Resources.River;
import Threads.Guest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerLabel extends JButton implements ActionListener {
    int posX,posY;
    final int height,width;
    int guestPosition;
    boolean taken = false;

    Thread thread;
    Guest guest;


    public CustomerLabel(int posX,int posY,int guestPosition){


        this.guestPosition  =  guestPosition;
        this.posX = posX;
        this.posY = posY;

        height = 20;
        width = 20;



        setBounds(posX,posY,width,height);
        setVisible(true);
        setLayout(null);
        setBackground(Color.GREEN);
        addActionListener(this);
    }

    public void takeSeat(){
        setBackground(Color.RED);
        this.taken = true;
    }



    public void freeSeat(){
        setBackground(Color.GREEN);
        this.taken = false;
    }
    public void setPreferences(ArrayList<Integer> preferences){

        guest.setPreferences(preferences.toArray(new Integer[0]));
        River.getInstance().addNewPreferences(preferences.toArray(new Integer[0]));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(taken ==false){
            takeSeat();
            SetPreferencesFrame frame = new SetPreferencesFrame(guestPosition);
            frame.setVisible(true);

            guest = new Guest(this.guestPosition);

            thread = new Thread (guest);
            thread.start();
        }else{
            freeSeat();
            guest.end();

        }
    }
}
