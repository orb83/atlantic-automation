package Java_SecondWeek_8;

import java.util.HashMap;
import java.util.Map;

public class Hashmap_Practice {
    //Creating a HashMap of int keys and String values
    HashMap<Integer,String> hmap = new HashMap<>();


    public void addhashmapvalue(){
        // Adding Key and Value pairs to HashMap
        hmap.put(1,"New York");
        hmap.put(2,"Pennsylvania");
        hmap.put(3,"Maryland");
        hmap.put(4,"Connecticut");

        System.out.println("State Name : " + hmap.get(2));
            // checking key exixtence
        boolean state = hmap.containsKey(4);
        System.out.println("Key 4 exists in HashMap? : " + state);

        System.out.println();
        for (Map.Entry newmap : hmap.entrySet() ){
            System.out.println(newmap.getKey() + "  =  " + newmap.getValue());
        }
            // Use containsKey() for check if particular key exist
        if(hmap.containsKey(2)){
            String keyvalue =hmap.get(2);
            System.out.println("Key = 2 and value = "+ keyvalue);
        }
    }
    public void removekeyvalue(){
        hmap.remove(3);
        System.out.println("After remove one entry : ");
        for(Map.Entry rmap : hmap.entrySet()){
            System.out.println(rmap.getKey() + " = " +rmap.getValue());
        }
    }
        public void addagainkeyvalue(){
        hmap.put(5,"Florida");
        hmap.put(6,"Mane");
        hmap.put(7,"Virginia");

            System.out.println("After adding some key and value : ");
        for (Map.Entry againnewmap : hmap.entrySet()){
            System.out.println(againnewmap.getKey() + " = " +againnewmap.getValue());
        }
            System.out.println("The size of final hmap is : "+hmap.size());
            System.out.println("Check HashMap is empty or not,i.e Y/N or T/F : "+hmap.isEmpty() );
        }
}
