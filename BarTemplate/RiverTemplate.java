package BarTemplate;

import Resources.River;
import Resources.Boat;
import java.util.HashMap;
import java.util.Map;

public class RiverTemplate {

    private Map<Integer,BoatLabel> boatMap;

    private static RiverTemplate instance;


    public RiverTemplate(){
        this.boatMap = new HashMap<>();
        int id = 0 ;
        for(Map.Entry<Integer,Boat> entry: River.getInstance().getBoatMap().entrySet()){
            id = entry.getKey();
            if(id>0&&id<=6){
                boatMap.put(id,new BoatLabel(id*20+20,20,entry.getValue().getDishId()));
            }
            if(id>6&&id<=12){
                boatMap.put(id,new BoatLabel(7*20+20,20*(id-5),entry.getValue().getDishId()));
            }
            if(id>12&&id<=18){
                boatMap.put(id,new BoatLabel((7*20)-(id-12)*20+20,20*8,entry.getValue().getDishId()));
            }
            if(id>18&&id<=24){
                boatMap.put(id,new BoatLabel(20,(7*20)-(id-18)*20+20,entry.getValue().getDishId()));
            }


        }

    }

    public static RiverTemplate getInstance(){
        if(instance == null){
            instance = new RiverTemplate();
        }
        return instance;

    }

    public Map<Integer,BoatLabel> getBoatMapTemplate(){
        return boatMap;
    }

    public void refreshBoatDishId(){
        for(Map.Entry<Integer,Boat> entry:River.getInstance().getBoatMap().entrySet()){
            boatMap.get(entry.getKey()).setBoatDishId(entry.getValue().getDishId());
        }
    }

}
