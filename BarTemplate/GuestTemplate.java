package BarTemplate;



import Threads.Guest;

import java.util.HashMap;
import java.util.Map;

public class GuestTemplate {
    private Map<Integer,CustomerLabel> guestMap;

    private static GuestTemplate instance;


    public GuestTemplate() {

        this.guestMap = new HashMap<>();
        for (int id = 1; id <= 24; id++) {

            if (id > 1 && id <= 6) {
                guestMap.put(id, new CustomerLabel(id * 20 + 20, 0,id));
            }
            if (id > 7 && id <= 12) {
                guestMap.put(id, new CustomerLabel(7 * 20 + 40, 20 * (id - 5),id));
            }
            if (id > 13 && id <= 18) {
                guestMap.put(id, new CustomerLabel((7 * 20) - (id - 12) * 20 + 20, 20 * 9,id));
            }
            if (id > 19 && id <= 24) {
                guestMap.put(id, new CustomerLabel(0, (7 * 20) - (id - 18) * 20 + 20,id));
            }


        }
    }



    public static GuestTemplate getInstance(){
        if(instance == null){
            instance = new GuestTemplate();
        }
        return instance;


    }

    public Map<Integer,CustomerLabel> getGuestMapTemplate(){
        return guestMap;
    }


}
