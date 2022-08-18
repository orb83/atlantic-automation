package MyFirstPackage;

public class FormatMethod {
    public static void main(String[] args) {
        String name ="Jonathan";
        int age = 20;
        int salary = 4000;
        String str = String.format("My name is %s and I am %d years old amd my salary is $%d yearly", name,age,salary);
        System.out.println(str);
    }
}
