package Java_SecondWeek_8;

abstract class Abstraction_Animal { //abstract class can contain both abstract and non-abstract method


    public abstract void animalSound(); // Abstract method does not have a body {}

    public abstract void animalactivitiy();

    public void sleep(){ // regular method
        System.out.println("Zzz");
    }

}
