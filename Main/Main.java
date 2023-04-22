package Main;

import Frames.MainFrame;
import Resources.Boat;
import Resources.River;
import Threads.Cook;

import Threads.Guest;
import Threads.IngredientsMaker;
import Threads.Mover;

import javax.swing.*;
import java.util.Map;

public class Main {
    public static void main(String[] args){



        Mover mover = new Mover();

        Cook cook1  = new Cook(1);
        Cook cook2  = new Cook(7);
        Cook cook3  = new Cook(13);
        Cook cook4  = new Cook(19);
        IngredientsMaker riceMaker1 = new IngredientsMaker("Rice",1);
        IngredientsMaker riceMaker2 = new IngredientsMaker("Rice",2);
        Thread moverThread = new Thread(mover);
        Thread cookThread1 = new Thread(cook1);
        Thread cookThread2 = new Thread(cook2);
        Thread cookThread3 = new Thread(cook3);
        Thread cookThread4 = new Thread(cook4);
        Thread riceMakerThread1 = new Thread(riceMaker1);
        Thread riceMakerThread2 = new Thread(riceMaker2);
        riceMakerThread1.start();
        riceMakerThread2.start();
        moverThread.start();
        cookThread1.start();
        cookThread2.start();
        cookThread3.start();
        cookThread4.start();

        MainFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);







    }
}
