package MyFirstPackage;

public class MyFirstClass {

    public static void main(String[] args){

        int a[][] = {{10,20,30},{40,50,60},{70,80,90}};

       /*int[][] a = new int[3][3];
        a[0][0] = 11;
        a[0][1] = 12;
        a[0][2] = 13;

        a[1][0] = 14;
        a[1][1] = 15;
        a[1][2] = 16;

        a[2][0] = 17;
        a[2][1] = 18;
        a[2][2] = 19;*/
       /* for (int i=0; i<3;i++) {
            for (int j=0;j<3;j++) {
                System.out.print(a[i][j] + "");
            }
            System.out.println();

        }*/
        for (int [] i:a) {
            for(int j:i){
                System.out.print(j+ "  ");
            }
            System.out.println();
        }


    }
}
