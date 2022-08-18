package MyFirstPackage;

import java.util.Arrays;
import java.util.Collections;

public class Conditionaloperator {

    public void condope() {
        int a = 10;
        int b;
        b = (a == 1) ? 20 : 30; // if equal to condition is true then b=20, if false b=30 (true value: false value)/(20:30)
        System.out.println("Value of b is : " +b);

        b = (a == 10) ? 20 : 30;
        System.out.println("Value of b is : " +b);  // expression is true, so b=20
    }
    public void LearnArray(){

        String[] str = {"Dhk","Syl","Raj","Ctg"};
        Integer [] number = {12,21,11,22};

        Arrays.sort(str);
        Arrays.sort(number);

        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(number));

        // for descending order
        System.out.println("After descending order : ");

        Arrays.sort(str, Collections.reverseOrder());
        System.out.println(Arrays.toString(str));

        Arrays.sort(number,Collections.reverseOrder());
        System.out.println(Arrays.toString(number));
    }
}
