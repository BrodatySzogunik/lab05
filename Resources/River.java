package Resources;


import java.util.HashMap;
import java.util.Map;

public class River {
    private static River instance;
    private Map<Integer,Boat> boatMap ;
    private Map<Integer,Integer> preferencesMap = new HashMap<>();


    private River(){
        this.boatMap = new HashMap<>();
        fillRiverWthBoats();
    }

     synchronized public static River getInstance(){
        if(instance == null){
            instance = new River();
        }
        return instance;
    }

    private void fillRiverWthBoats(){
        for(int i = 1 ; i<=24; i++){
            this.boatMap.put(i,new Boat(0));
        }
    }

    public Map<Integer, Boat> getBoatMap() {
        return boatMap;
    }

    synchronized public int getDishFromBoat(int position) {
        int dishId = getBoatMap().get(position).getDishId();
        if(dishId!=0){
            getBoatMap().get(position).takeDish();
        }
        return dishId;
    }


    synchronized public boolean putDishOnBoat(int dishId,int position) {
        if(getBoatMap().get(position).getDishId()==0){
            getBoatMap().get(position).putDish(dishId);
            return true;
        }else{
            return false;
        }
    }

    synchronized public int checkDishOnBoat(int position) {
        return getBoatMap().get(position).getDishId();
    }

    synchronized public void addNewPreferences(Integer[] preferences){
        for(Integer item: preferences){
            if(preferencesMap.get(item)==null||preferencesMap.get(item)==0){
                preferencesMap.put(item,1);
            }else{
                preferencesMap.put(item,preferencesMap.get(item)+1);
            }
        }
    }



    synchronized public int getDishWithHighestPriorityToPrepare(){
        int max = -1;
        int maxId = 0 ;
        for(Map.Entry<Integer,Integer> entry: preferencesMap.entrySet() ){
            if(entry.getValue()>max){
                max=entry.getValue();
                maxId = entry.getKey();
            }
        }
        if(maxId != 0 && max>0) {
            if(preferencesMap.get(maxId)==1){
                preferencesMap.put(maxId,0);
            }else{
                preferencesMap.put(maxId,preferencesMap.get(maxId)-1);
            }
            return maxId;
        }
        return 0;
    }

    synchronized public void moveBoats(){
        Boat tempBoat1 = null,tempBoat2;
        for(int i = 1 ; i<=24; i++) {
            this.boatMap.get(i).incrementTick();
            if(i==1) {
                tempBoat1 = this.boatMap.get(i);
                this.boatMap.put(i,this.boatMap.get(24));
            }else{
                tempBoat2 = this.boatMap.get(i);
                this.boatMap.put(i,tempBoat1);
                tempBoat1 = tempBoat2;
            }
        }
    }



}
