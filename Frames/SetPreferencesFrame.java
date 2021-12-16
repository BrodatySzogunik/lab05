package Frames;

import BarTemplate.GuestTemplate;
import Resources.River;
import Threads.Guest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class SetPreferencesFrame extends JFrame implements ActionListener {
    private JTextField preferencesInput;
    private JLabel preferencesLabel,errorLabel;
    private JButton addPreferences;
    private int guestId;

    public SetPreferencesFrame(int guestId){
        this.guestId = guestId;
        setSize(400,200);
        setLayout(null);
        setTitle("Set preferences for: "+guestId);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        preferencesInput = new JTextField();
        preferencesInput.setBounds(170,20,150,20);
        preferencesInput.setVisible(true);
        add(preferencesInput);

        errorLabel = new JLabel("try format: 1,2,3");
        errorLabel.setBounds(20,40,300,20);
        errorLabel.setVisible(false);
        add(errorLabel);

        preferencesLabel = new JLabel("prefrences");
        preferencesLabel.setBounds(20,20,150,20);
        preferencesLabel.setVisible(true);
        add(preferencesLabel);

        addPreferences = new JButton("add");
        addPreferences.setVisible(true);
        addPreferences.setBounds(20,60,150,20);
        addPreferences.addActionListener(this);
        add(addPreferences);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String inputRegex ="([0-9],){1,30}[0-9]|[0-9]";


        if(Pattern.compile(inputRegex).matcher(preferencesInput.getText()).matches()){
            ArrayList<Integer> tempList = new ArrayList<>();
            for (String item: preferencesInput.getText().split(",")){
                tempList.add(Integer.parseInt(item));
            }

            GuestTemplate.getInstance().getGuestMapTemplate().get(guestId).setPreferences(tempList);
            dispose();
        }else{
            errorLabel.setVisible(true);
            errorLabel.setBackground(Color.RED);
        }


    }




}
