package BarTemplate;

import javax.swing.*;

public class CookLabel extends JLabel {

    int posX,posY;
    final int height,width;



    public CookLabel(int posX, int posY){
        this.posX = posX;
        this.posY = posY;

        height = 20;
        width = 20;



        setBounds(posX,posY,width,height);
        setVisible(true);
        setLayout(null);
        setText("  /  ");
    }



}
