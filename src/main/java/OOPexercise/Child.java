package OOPexercise;

public class Child extends Parent{
    int a= 40;
    String s = "I love Coding";

    public void display(){

        int i =super.a; // use super keyword for instance variable of immediate parent class
        String st = super.s;
        System.out.println("Number from parent class is :"+i);
        System.out.println("String from parent class is : "+st);
                System.out.println();
        System.out.println("Number from child class is :"+a);
        System.out.println("String from child class is : "+s);


    }
}
