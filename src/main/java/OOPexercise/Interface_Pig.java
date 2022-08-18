package OOPexercise;

public class Interface_Pig implements Interface_animal {

    public void animalsound(){
        System.out.println("The pig says wee wee");
    }

    @Override
    public void run() {
        System.out.println("running.... ");

    }

    public void sleep(){
        System.out.println("Zzz");
    }
}
