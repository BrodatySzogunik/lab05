package Resources;

public class Boat {
    private Integer dishId;
    private Integer ticksAlive=0;

    public Boat(int dishId){
        this.dishId=dishId;
    }


    public int getDishId() {
        return dishId;
    }

    public void putDish(int dishId) {
        this.dishId = dishId;
        this.ticksAlive = 0;
    }

    public void incrementTick(){
        this.ticksAlive++;
        checkIfFoodIsStillGood();
    }

    private void checkIfFoodIsStillGood(){
        if(ticksAlive>48){
            dishId = 0;
        }
    }

    public void takeDish(){
        this.dishId=0;
    }

    @Override
    public String toString(){
        return  dishId.toString();
    }
}
