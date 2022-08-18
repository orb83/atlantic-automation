package Java_SecondWeek_8;

public class WrapperClasses {
    public static void main(String[] args) {

        int number = 100;

            // convert primitive data types into objects/wrapper (int --->> Integer)

        Integer wrapperclassobject = Integer.valueOf(number); // Creating a wrapper class object by Integer and valueOf()

        System.out.println("Display \"int value\" as \" Wrapper Integer\" : " +wrapperclassobject);

        System.out.println();

       // Integer wcobj = new Integer(10); // Creating Wrapper class object
        Integer wcobj = Integer.valueOf(10);// Another way to Creating Wrapper class object
         int num=wcobj.intValue(); // Converting the wrapper object to primitive datatype by intValue()
            // System.out.println(num + " " + wcobj);

        System.out.println("The Wrapper Integer is : " +wcobj );
        System.out.println("The primitive int is : " +num);
    }
}
