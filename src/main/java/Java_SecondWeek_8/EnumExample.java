package Java_SecondWeek_8;

public class EnumExample {
    enum Day
                { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    public static class Test{
        Day day;

        public Test( Day day){
            this.day=day;
        }

        public void switchclass(){

            switch (day){
                case MONDAY:
                    System.out.println("Why come Monday ");
                    break;
                case FRIDAY:
                    System.out.println("I like Friday ");
                    break;
                case SATURDAY:
                    break;
                case SUNDAY:
                    System.out.println("Sunday is Funday");
                    break;
                default:
                    System.out.println("Other day");
                    break;
             }
        }
    }
}

