package Java_SecondWeek_8;

public class Constructor_Parameter {
    int id; String name;

    // creating a parameterized constructor
    Constructor_Parameter(int i , String n){ // two argument constructor

        id=i; name=n;
    }
    void display(){
        System.out.println(id+ " " +name);
    }
}
