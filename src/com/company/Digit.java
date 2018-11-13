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

    //FIXME
   public void convertInputToArrays(String Input){
      //String[][] Result = null;
      char[] ch = Input.toCharArray();
      int StartNumber = 0;
      //0-25 <- first line : length 27
      //28-56 <- second line : length 28 ?!
      //57-82 < third line : length 27
      int CurrentDigitPosLine0 = 0;
      int CurrentDigitPosLine1 = 26;
      int CurrentDigitPosLine2 = 54;

      for(int move = 0; move < 9; move++){

         for(int i = CurrentDigitPosLine0; i < CurrentDigitPosLine0+4; i++){
            if(i<27) System.out.print(ch[i]);
         }

         for(int i = CurrentDigitPosLine1; i < CurrentDigitPosLine1+4; i++){
            if(i<53) System.out.print(ch[i]);

         }

         for(int i = CurrentDigitPosLine2; i < CurrentDigitPosLine2+4; i++){
            if(i<81) System.out.print(ch[i]);
         }
         System.out.println("\n");
         CurrentDigitPosLine0+=3;
         CurrentDigitPosLine1+=3;
         CurrentDigitPosLine2+=3;
         //System.out.print("\n");
         System.out.println("============");
      }


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



