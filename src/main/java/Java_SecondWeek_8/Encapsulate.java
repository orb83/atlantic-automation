package Java_SecondWeek_8;

public class Encapsulate {

    // private variable declared
        private String Name;
        private  int Roll;
        private  int Age;

        // get() for get the data

        public int getAge(){
            return Age;
        }
        public String getName(){
            return Name;
        }
        public int getRoll(){
            return Roll;
        }
        // set() for set up the data

        public void setAge(int newAge){
            Age = newAge;
        }
        public void setName(String newName){
            Name = newName;
        }
        public void setRoll(int newRoll){
            Roll = newRoll;
        }
}
