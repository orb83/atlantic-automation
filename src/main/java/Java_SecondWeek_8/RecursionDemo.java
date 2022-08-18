package Java_SecondWeek_8;

public class RecursionDemo {

    static int factorial(int n){
        if (n == 1)
            return 1;
        else
            return(n * factorial(n-1));
    }

}
