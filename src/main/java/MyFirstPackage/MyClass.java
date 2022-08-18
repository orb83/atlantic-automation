package MyFirstPackage;

public class MyClass {
    public static void main(String[] args) {

        int n1 = 2, n2 = 3;
        System.out.print(n1 + " " + n2);

        for (int i = 3; i < 25; i++) {
            if (i % 2 != 0) {
                if (i % 3 != 0) {
                    System.out.print(" " + i);
                }
            }
        }
        for (int j = 25; j <= 100; j++) {
            if (j % 2 != 0) {
                if (j % 3 != 0) {
                    if (j % 5 != 0) {
                        if (j % 7 != 0) {
                            System.out.print(" " + j);
                        }
                    }
                }
            }
        }

    }
}
