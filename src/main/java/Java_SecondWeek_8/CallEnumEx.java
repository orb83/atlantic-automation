package Java_SecondWeek_8;

public class CallEnumEx {
    public static void main(String[] args) {
        String str = "FRIDAY";

        EnumExample.Test t1 = new EnumExample.Test(EnumExample.Day.valueOf(str));
        t1.switchclass();

        // EnumExample.Test t1= new EnumExample.Test(EnumExample.Day.MONDAY);
      //  EnumExample.Day d= EnumExample.Day.MONDAY;
        //System.out.println(d);

    }
}
