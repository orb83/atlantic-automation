package MyFirstPackage;

import java.util.Arrays;

public class Homeworkq1 {

    public int[] arrayFirstElement(int[] a, int[] b) {
        for (int count = 0; count < a.length - 2; count++) {

            int firstvaluea1=a[0];
            System.out.println(Arrays.toString(a));

            System.out.println("First index value of array a is : " +firstvaluea1);
        }
        for (int count1 = 0; count1 <b.length-2; count1++) {

            int firstvalueb1= b[0];
            System.out.println(Arrays.toString(b));

            System.out.println("First index value of array b is : " +firstvalueb1);
            return b;
        } return a;
    }
    public int[] arraySums(int[] a1, int[] b1) {
        int suma1=0; int sumb1=0;
        for( int i=0; i<3;i++) {
            suma1 = suma1 + a1[i];
        }
        System.out.println(Arrays.toString(a1));
        System.out.println("Sum of the array a1 is : " +suma1);
        for (int j=0;j<3;j++) {
            sumb1 = sumb1 + b1[j];
        }
        System.out.println(Arrays.toString(b1));
        System.out.println("Sum of the array b1 is : " +sumb1);
        return a1;
    }


}
