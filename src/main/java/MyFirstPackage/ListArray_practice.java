package MyFirstPackage;

import java.util.ArrayList;
import java.util.List;

public class ListArray_practice {
    // Creating an ArrayList and adding new elements to it
    public void createarraylist(){
    List<Integer> integerlist = new ArrayList<Integer>();
    List<String> stringlist = new ArrayList<String>();

    integerlist.add(10);
    integerlist.add(20);
    integerlist.add(30);
    integerlist.add(40);
    System.out.println(integerlist);

    stringlist.add("New York");
    stringlist.add("Pennsylvania");
    stringlist.add("Florida");
    stringlist.add("Delaware");
    System.out.println(stringlist);

      /*  for (Integer intvalue:integerlist) {
            System.out.println("Print value using for loop : " +intvalue);
        }
        for (String strvalue:stringlist) {
            System.out.println("Print value using for loop : " +strvalue);
         }*/
        // Adding an element at a particular index in an ArrayList
        System.out.println();

        System.out.println("After adding the new value 50 : ");
        integerlist.add(4,50);
        System.out.println(integerlist);

        System.out.println();

        System.out.println("After adding the new value Maryland : ");
        stringlist.add(4,"Maryland");
        System.out.println(stringlist);
    }

}
