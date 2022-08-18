package Java_SecondWeek_8;

public class Recursion_FibonacciSeries {
    static void displayFibonacci(int N){

        int n1=0, n2=1, fibo;
        System.out.print(n1+ " " +n2);

        for (int i=3;i<=N;i++){
            fibo = n1+n2;
            System.out.print(" "+fibo);
            n1=n2;
            n2=fibo;
        }
    }
}
