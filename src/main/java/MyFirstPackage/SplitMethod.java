package MyFirstPackage;

import java.util.Arrays;

public class SplitMethod {

    public void splitarray(){
        String date = "2022-07-15";
        String[] datearray = date.split("-");
        for(String dt : datearray){
            System.out.print("\t"+dt);
        }
    }
}
