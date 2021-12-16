package Threads;

import BarTemplate.RiverTemplate;
import Resources.Boat;
import Resources.River;

import java.util.Map;

public class Mover implements Runnable {
    private void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while (true){
//            for(Map.Entry<Integer, Boat> entry:River.getInstance().getBoatMap().entrySet()){
//                System.out.println(entry.getKey()+" -> "+entry.getValue().getDishId());
//            }
            RiverTemplate.getInstance().refreshBoatDishId();
            River.getInstance().moveBoats();
            sleep(1000);


        }
    }
}

