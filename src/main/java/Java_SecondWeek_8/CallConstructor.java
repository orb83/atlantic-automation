package Java_SecondWeek_8;

public class CallConstructor {
    public static void main(String[] args) {

        Constructors_practice obj = new Constructors_practice();

        int y = obj.x; // this x = 0; then y=0
       System.out.println(y);
       // System.out.println(obj); // this obj contain Constructors_practice() ,i.e x=4
    }
}
