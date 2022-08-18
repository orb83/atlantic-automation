package MyFirstPackage;


public class IndexOfMethod {

    public static int useindexof(int[] array,int t){ // t= index value
      // indexOf() directly can use for string only. we can't use for integer
        int i=0;
        while (i<array.length){
           if ( array[i] ==t ){
               return i;
           }
           else {
               i++;
           }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array = {11,22,33,44,55};
        System.out.println("Index position of 11 is: " + useindexof(array, 11));
        System.out.println("Index position of 33 is: " + useindexof(array, 33));

    }
}
