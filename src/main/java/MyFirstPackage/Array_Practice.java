package MyFirstPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array_Practice {

    public void LearnArray(){

        String[] stringarray = {"Florida"," California","Georgia","Texas","Pennsylvania"};
        Integer[] integerarray = {11,22,33,44,55};

                // Alternative way to create an array
               /* int[] integerarray = new int[4];
                integerarray[0]=11;
                integerarray[1]=22;
                integerarray[2]=33;
                integerarray[3]=44; */

        Arrays.sort(stringarray, Collections.reverseOrder());
        Arrays.sort(integerarray,Collections.reverseOrder());

        System.out.println(Arrays.toString(stringarray)); // array print without using loop
        System.out.println(Arrays.toString(integerarray));
            //convert Array to List :: integerarray----->>ilist
        System.out.println("New List from Array : ");
        List<Integer> ilist = new ArrayList<>();
        for (Integer templist:integerarray) {   // templist is a temporary array variable to store integerarray's element
            ilist.add(templist);
        }
        System.out.println(ilist);
            // convert List to Array :: ilist--->>arrayfromlist
        System.out.println("New Array from List : ");
        int[] arrayFromlist= new int[ilist.size()];
        for (int i=0; i<ilist.size();i++){
            arrayFromlist[i]=ilist.get(i);
            System.out.print(arrayFromlist[i] + " \t");
        }
    }
}
