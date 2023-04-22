package Threads;

import Resources.River;

public class Cook implements Runnable{

    private int cookPosition;

    public Cook(int cookPosition){
        this.cookPosition = cookPosition;
    }
    private void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        int dishId;
        int riceNeeded = 1;
        int riceCollected = 0;
        while(true){

            dishId = River.getInstance().getDishWithHighestPriorityToPrepare();
            if(dishId != 0){
            sleep((int)(Math.random()*1000));


            String dishIdString = Integer.toString(dishId);
            if(dishIdString.length() != 1){
                riceNeeded += Integer.parseInt(dishIdString.substring(0, 1));
            }

            River.getInstance().standInRiceQueue(cookPosition, riceNeeded);
            riceNeeded = 0;

            System.out.println("Cooker: "+cookPosition+" prepared dish: "+dishId);

            while(!River.getInstance().putDishOnBoat(dishId,cookPosition)){
                sleep(500);
            }
            System.out.println("Cooker: "+cookPosition+" put dish: "+dishId);
            }


        }

    }
}
