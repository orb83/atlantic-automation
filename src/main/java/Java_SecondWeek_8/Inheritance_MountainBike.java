package Java_SecondWeek_8;

public class Inheritance_MountainBike extends Inheritance_Bicycle {

    public int seatHeight;

    public Inheritance_MountainBike(int gear, int speed,int startHeight){
        super(gear,speed);
        seatHeight = startHeight;
    }
    public void setHeight(int newValue){
        seatHeight = newValue;
    }
    public String toString(){ // Applying method Overriding
        return (super.toString() + "\nseat height is "+seatHeight);
    }
}

