package MyFirstPackage;

import java.util.Scanner;

public class BinaryNumber_Practice {
    public static void main(String[] args) {
        int num1, num2;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the First Number : ");
        num1 = input.nextInt();
        String binarynum1 = Integer.toBinaryString(num1);
        System.out.println("The binary of given number is : " +binarynum1);
        //System.out.println("The Integer " +num1+ " have binary number: "+ Integer.toBinaryString(num1));

        System.out.print("Enter the Second Number: ");
        num2 = input.nextInt();
        String binarynum2 = Integer.toBinaryString(num2);
        System.out.println("The binary of given number is : " +binarynum2);
       // System.out.println("The Integer " +num2+ " have binary number: "+ Integer.toBinaryString(num2));

        int sum = num1+num2;
      //  String binarysum = binarynum1+binarynum2;
        //String newbinary = Integer.toBinaryString(Integer.parseInt(binarysum));
        String add= Integer.toBinaryString(sum);
       // System.out.println(binarysum);

        System.out.println("The Sum of two Binary Number is: "+add);
    }
}
