package Java_SecondWeek_8;

public class CallEncapsulation {

    public static void main(String[] args) {
        Encapsulate obj = new Encapsulate();

        obj.setName("Ronaldo");
        obj.setAge(23);
        obj.setRoll(101);

        System.out.println("Name is : "+obj.getName());
        System.out.println("Age is : "+obj.getAge());
        System.out.println("Roll is : "+obj.getRoll());
    }
}
