package MyFirstPackage;

import java.util.Scanner;

public class w3resource_practice {

    public static void main(String[] args) {
      /*  int a=50; int b= 3;
        int d= a/b;
        System.out.println("50/3 = " +d);
        System.out.println("20+10 = " +(20+10));
        System.out.println("-5+8*6 = "+(-5+8*6));
        System.out.println("(55+9)%9 = "+(55+9)%9);
        System.out.println("20 + -3*5 / 8 = " +(20 + -3*5 / 8));
        System.out.println("5 + 15 / 3 * 2 - 8 % 3 = " +(5 + 15 / 3 * 2 - 8 % 3));
*/

      /*  Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number : ");
        int num1 =input.nextInt();

        System.out.print("Enter the second number : ");
        int num2 =input.nextInt();

        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
        System.out.println(num1 + " mod " + num2 + " = " + (num1 % num2));
        System.out.println("Multiplication of the given number : ");
        for(int i= 1; i<=10; i++){
           int mul= num1*i;
            System.out.println(num1 + " * "+ i + " = " +mul);
        } */
       // System.out.println("(25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5) = " +((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)));
       /* Scanner inputvalue = new Scanner(System.in);

        System.out.print("Enter width : ");
        double width =inputvalue.nextDouble();

        System.out.print("Enter height : ");
        double height = inputvalue.nextDouble();

        double area = width*height;
        double perimetre = 2*(width+height);
       // System.out.println("Area is : " +Math.round(area));
        System.out.printf("Area is %.2f \n",area); // use printf() method instead of println() , \n= new line,\t=space
        System.out.println("Perimeter is : " +perimetre);
       // System.out.printf("Area is %.1f * %.1f = %.2f \n", width, height, area);*/

        // swap two variables
        int a=5; int b=3;
        int pot =a;  // pot=5, ==> a=[]
            a=b;  //a=3 , ==>b=[]
            b=pot; //b=5
        System.out.println("a = " + a + " b = " +b  );
    }
}
