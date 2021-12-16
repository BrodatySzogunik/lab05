package BarTemplate;

import javax.swing.*;

public class BoatLabel extends JLabel {
    int posX,posY;
    final int height,width;
    int dishId;


    public BoatLabel(int posX,int posY,int dishId){
        this.posX = posX;
        this.posY = posY;

        height = 20;
        width = 20;

        this.dishId = dishId ;

        setBounds(posX,posY,width,height);
        setVisible(true);
        setLayout(null);
        setText("| "+dishId+" |");
    }
    public void setBoatDishId(int dishId){
        setText("| "+dishId+" |");
    }


}
