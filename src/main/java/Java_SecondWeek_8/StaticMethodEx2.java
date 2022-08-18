package Java_SecondWeek_8;

public class StaticMethodEx2 {
    int a; // initialize a=0
    static int b;

    // create constructor for increment b
    StaticMethodEx2(){
        b++;
    }
    public void showData(){
        System.out.println("Value of a = "+a);
        System.out.println("Value of b = "+b);
    }
}
