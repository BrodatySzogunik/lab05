package Threads;

import BarTemplate.CustomerLabel;
import Resources.River;

import java.util.ArrayList;

public class Guest implements Runnable{

    private int guestPosition;
    private ArrayList<Integer> preferences = new ArrayList<>();
    private boolean end = false;
    private int takenDish;
    private boolean preferencesSet = false;
    CustomerLabel label;


    public Guest(int guestPosition,CustomerLabel label){
        this.guestPosition = guestPosition;
        this.label = label;
    }

    private void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
    }

    synchronized public void setPreferences(Integer[] preferences){
        for(Integer item: preferences ){
            this.preferences.add(item);
        }
        this.preferencesSet = true;
    }

    synchronized public void end(){
        this.end = true;
        this.label.freeSeat();
    }

    @Override
    public void run(){
        while (!end){

            if(this.preferencesSet && preferences.size()<1)this.end();
            if(preferences.contains(River.getInstance().checkDishOnBoat(guestPosition))){
                takenDish =River.getInstance().getDishFromBoat(guestPosition);
                System.out.println("Guest : "+guestPosition+" took dish : "+takenDish);
                sleep((int)(Math.random()*5000));
                preferences.remove(preferences.indexOf(takenDish));
            }
            else{
                sleep(100);
            }


        }
    }
}
