package com.company;


/*
*
*  First user story to be solved
*
*
*
*/

class Digit {

    private String w0 = " _ ";
    private String w1 = "   ";
    private String w2 = "  |";
    private String w3 = "| |";
    private String w4 = "|_|";
    private String w5 = " _|";
    private String w6 = "|_ ";

   //FIXED : 14/11/2018 : 12:07 : RC
   //TODO : get output to 2D table
   public void convertInputToArrays(String Input){
      char[] ch = Input.toCharArray();
      String line0; line0 = Input.substring( 0,  27);  //0-27 <- first line
      String line1; line1 = Input.substring( 27,  55); //27-55 <- second line
      String line2; line2 = Input.substring( 55,  82); //55-82 < third line
      String[] Lines = {line0,line1,line2}; 
      // i = Number of line
      for(int i = 0; i < 3; i++){
          System.out.println(Lines[i].substring(3,6));
          //<- 0 + 3 due to array
          /* Explanation
           * i=0 [0,1,2] 
           * i=1 [0,1,2]
           * i=2 [0,1,2]
          */         
      }
      //possible solution!
      String[][] Output = {Lines[0].substring(0,3),Lines[1].substring(0,3),Lines[2].substring(0,3)};
      
      //lines output testing
      //System.out.print(line0);
      //System.out.print(line1);
      //System.out.print(line2);
   }

   public String convert(String[] digit) {
        if (digit.length != 3) {
            return "?";
        }
        if (digit[0].equals(w1)) {
            if (digit[1].equals(w2)){
                if (digit[2].equals(w2))return "1";
                else return "?";
            } else if (digit[1].equals(w4)){
                if (digit[2].equals(w2))return "4";
                else return "?";
            }
        } else {
            if (digit[1].equals(w2)) {
                if (digit[2].equals(w2)) return "7";
                else return "?";
            } else if (digit[1].equals(w3)) {
                if (digit[2].equals(w4)) return "0";
                else return "?";
            } else if (digit[1].equals(w4)) {
                if (digit[2].equals(w4)) return "8";
                else if (digit[2].equals(w5)) return "9";
                else return "?";
            } else if (digit[1].equals(w5)) {
                if (digit[2].equals(w5)) return "3";
                else if (digit[2].equals(w6)) return "2";
                else return "?";
            } else if (digit[1].equals(w6)) {
                if (digit[2].equals(w5)) return "5";
                else if (digit[2].equals(w4)) return "6";
                else return "?";
            }
        }
        return "?";
    }

}



