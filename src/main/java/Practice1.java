public class Practice1 {

     public void findlength(){

          String str =" Linku, Biswas ";
          int l  = str.length();
          System.out.println(" Total length of this word: " +l);
          System.out.println(str.substring(2,5));

          String[] str1 = str.split(",");// only cut ','.

          for (String st : str1) {
               System.out.println(st);
          }
     }
//     public void replace() {
//          String str = "Linku";
//          System.out.println(str.replace('L','T'));
//           char ch=str.charAt(3);
//          System.out.println("value of position 3 :" +ch);
//          boolean con =str.contains("o");
//          System.out.println(con);
//
//     }
//     public void triming(){
//          String str = "  Linku  ";
//          System.out.println("Before triming :"+str.length());
//          System.out.println(str.trim());
//          String st= str.trim();
//          System.out.println("After triming :"+st.length());
//     }
}
