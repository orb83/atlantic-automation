package Java_SecondWeek_8;

public class CallMethod_Overloading {
    public static void main(String[] args) {

        Method_Overloading obj = new Method_Overloading();
        System.out.println(obj.sum(10,20));
        System.out.println(obj.sum(10,20,30));
        System.out.println(obj.sum(10.23d,20.82d));
    }
}
