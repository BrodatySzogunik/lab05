package Threads;

import Resources.River;

import java.util.ArrayList;

public class Guest implements Runnable{

    private int guestPosition;
    private ArrayList<Integer> preferences = new ArrayList<>();
    private boolean end = false;


    public Guest(int guestPosition){
        this.guestPosition = guestPosition;
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
    }

    synchronized public void end(){
        this.end = true;
    }

    @Override
    public void run(){
        while (!end){

            if(preferences.contains(River.getInstance().checkDishOnBoat(guestPosition))){
                System.out.println("Guest : "+guestPosition+" took dish : "+River.getInstance().getDishFromBoat(guestPosition));
                sleep((int)(Math.random()*5000));
            }
            else{
                sleep(100);
            }


        }
    }
}
