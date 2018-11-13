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

   public void convertInputToArrays(String Input){
      //String[][] Result = null;
      char[] ch = Input.toCharArray();
      int StartNumber = 0;

      //0-25 <- first line
      //26-53 <- second line
      //54-81 < third line
      for(int i = 0; i < 4; i++){
         System.out.print(ch[i]);
      }
      //System.out.print("\n");
      for(int i = 26; i < 30; i++){
         System.out.print(ch[i]);
      }
      //System.out.print("\n");
      for(int i = 54; i < 58; i++){
         System.out.print(ch[i]);
      }
      System.out.print("\n");
      System.out.print("\n");

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



