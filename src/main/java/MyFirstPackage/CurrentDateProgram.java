package MyFirstPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CurrentDateProgram {

    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy,MM,dd");
        LocalDateTime currenttime = LocalDateTime.now();
        String dt = dtf.format(currenttime);
        System.out.println(" {" +dt + "}");



    }
}
