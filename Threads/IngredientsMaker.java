package Threads;

import java.util.PriorityQueue;

public class IngredientsMaker implements Runnable {

    private String providedIngredient;
    private boolean isIngredientReady;
    private int makerId;
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int cookAbleToTakeIngredient = 0 ;


    public IngredientsMaker(String providedIngredient , int makerId) {
        this.providedIngredient = providedIngredient;
        this.makerId = makerId;
    }

    @Override
    public void run() {
        while(true){
            if(!this.isIngredientReady){
                System.out.println(this.makerId+": Preparing: "+ this.providedIngredient);
                sleep(1000);
                this.isIngredientReady = true;
                System.out.println(this.makerId+":" + this.providedIngredient+" is Ready");
            }
        }
    }


    synchronized public void standInQueue(int cookerPosition){
        this.queue.add(cookerPosition);
    }

    synchronized public String takeIngredient(int cookPosition){
        if(this.cookAbleToTakeIngredient == 0){
            this.cookAbleToTakeIngredient = this.queue.size() > 0 ? this.queue.poll() : 0;
        }
        if(cookPosition == this.cookAbleToTakeIngredient && this.isIngredientReady){
            this.isIngredientReady = false;
            System.out.println(this.providedIngredient+ "was taken");
            this.cookAbleToTakeIngredient = 0 ;
            return providedIngredient;
        }
        return null;
    }

    synchronized public int getQueueLength(){
        return this.queue.size();
    }


    private void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
    }
}
