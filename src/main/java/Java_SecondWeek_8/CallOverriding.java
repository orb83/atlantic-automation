package Java_SecondWeek_8;

public class CallOverriding {
    public static void main(String[] args) {

        Method_Overriding_TDBank td= new Method_Overriding_TDBank();
        Method_Overriding_CapitalOne c1 = new Method_Overriding_CapitalOne();
        Method_Overriding_ChaseBank ch = new Method_Overriding_ChaseBank();

        System.out.println("TDBank Rate of Interest: "+td.getRateOfInterest());
        System.out.println("CapitalOne Rate of Interest: "+c1.getRateOfInterest());
        System.out.println("Chase Rate of Interest: "+ch.getRateOfInterest());
    }
}
