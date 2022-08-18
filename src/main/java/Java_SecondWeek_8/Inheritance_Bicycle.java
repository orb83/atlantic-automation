package Java_SecondWeek_8;

public class Inheritance_Bicycle {
        public int gear;
        public int speed;

        public Inheritance_Bicycle(int gear, int speed){ //Constructor for Inheritance_Bicycle class
            this.gear = gear;
            this.speed = speed;
        }
            //Inheritance_bicycle has three method
        public void applyBrake(int decrement){
            speed--;
        }
        public void speedUp(int increment){
            speed++;
        }
        public String toString(){
            return("No of gears are " +gear + "\n"+ "speed of bicycle is "+speed);
        }
    }

