package Java_SecondWeek_8;

public class CallStaticEx2 {
    public static void main(String[] args) {
        StaticMethodEx2 obj = new StaticMethodEx2();
        obj.showData();
        StaticMethodEx2 obj1 = new StaticMethodEx2();
        obj1.showData();

        StaticMethodEx2.b++; // b is static , this why not need object . directly can call by class
        obj1.showData();
    }
}
