package OOPexercise;

public class Child1 extends Parent1{

    // declaring display method in Child class
    void display(){
        System.out.println("display() :: I am child method.");
    }
    void print(){

        // invoking display method from immediate parent class
        super.display();

        // display method from child class
        display();
    }
}
