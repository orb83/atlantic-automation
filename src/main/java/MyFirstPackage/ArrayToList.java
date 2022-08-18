package MyFirstPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {

    public static void main(String[] args){

       // int [] array1 = new int[] {11,12,23,22,33};
        int[] array1 = {11,12,23,22,33};
        System.out.println("Printing array1 : ");
        System.out.println(Arrays.toString(array1));

        //Converting array to list
               // List newlists = Arrays.asList(array1); // this method for string type data only
              //  System.out.println(newlists);
        List<Integer> newlist = new ArrayList<Integer>();

        for (int lists:array1) {
            newlist.add(lists);
            //System.out.println(newlist);
        }
        System.out.println("Printing New List : " +newlist);
    }
}
