package MyFirstPackage;

import java.util.*;

public class ArrayList_q3 {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("List of five random numbers are : ");
        int listofrandomnumber = 0;
        int largest = 0;


        for (int count = 0; count < 5; count++) {
            listofrandomnumber = random.nextInt(10); // Creating random list of five numbers between 10
            System.out.println(listofrandomnumber);
        }
           int[] ab = new int[]{listofrandomnumber};

            System.out.println(Arrays.toString(ab));

       /* for (int i =0;i<ab.length;i++) {
            System.out.println(ab[i]);
           // System.out.println(Arrays.toString(ab[i]));
        }*/



    }
}
