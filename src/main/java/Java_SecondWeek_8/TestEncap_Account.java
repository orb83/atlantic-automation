package Java_SecondWeek_8;

public class TestEncap_Account {
    public static void main(String[] args) {

        //creating instance of Account class
        Encap_Account acc=new Encap_Account();

        //setting values through setter methods
        acc.setAcc_no(7560504000L);
        acc.setName("David Alba");
        acc.setEmail("alabadavid@.com");
        acc.setAmount(500000f);
        //getting values through getter methods
        System.out.println("Customer A/C No: "+acc.getAcc_no()+" \n" +"Customer Name : "+acc.getName()+" \n"
                +"Customer Email : "+acc.getEmail()+" \n" +"A/C Balance : "+acc.getAmount());
    }
}

