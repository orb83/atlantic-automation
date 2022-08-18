package Java_SecondWeek_8;

public class CallStaticmethodex1 {
    public static void main(String[] args) {
        // for non-static method need to create an object.
        StaticMethodEx1 obj = new StaticMethodEx1();
        obj.display();
        //obj.display1();
        // for static method do not need to create an object. can call by class
        StaticMethodEx1.display1();
    }
}
