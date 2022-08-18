package MyFirstPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {

    public static void main(String[] args){
        List<Integer> listname = new ArrayList<>();

        listname.add(11);
        listname.add(12);
        listname.add(13);
        listname.add(14);

        System.out.println("This is the integer list : "+listname);

        // converting this list to an array
        System.out.println("The array from list : ");
        int[] newarray = new int[listname.size()];
            for (int i=0; i<newarray.length;i++){
                newarray[i] = listname.get(i);
                System.out.print( +newarray[i] + "\t" );
            }
        
    }
}
