package Java_SecondWeek_8;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int i= 12/0;
        }
        catch (Exception e){ // it will show arithmetic exception
            System.out.println(e);
        }

        try {
            int a[] = new int[5];
            a[6] = 15; //ArrayIndexOutOfBoundsException
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
