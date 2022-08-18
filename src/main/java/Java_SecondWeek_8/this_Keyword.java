package Java_SecondWeek_8;

public class this_Keyword {
    int rollno; String name; float fee;

    this_Keyword(int rollno,String name,float fee){

      /*  rollno=rollno; // parameters (formal arguments) and instance variables are same
        name=name;  // it will display 0 null 0.0
                                       0 null 0.0
        fee=fee; */

        //So, we are using this keyword to distinguish local variable and instance variable.
            this.rollno=rollno;
            this.name=name;
            this.fee=fee;
    }
    void display(){

        System.out.println(rollno+" "+name+" "+fee);
    }
}

