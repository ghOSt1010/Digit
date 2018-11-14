package com.company;


/*
*
*  First user story to be solved
*
*
*
*/

import sun.text.resources.in.FormatData_in;

class Digit {

    private String w0 = " _ ";
    private String w1 = "   ";
    private String w2 = "  |";
    private String w3 = "| |";
    private String w4 = "|_|";
    private String w5 = " _|";
    private String w6 = "|_ ";

   //FIXME - if needed
   //TODO : get output to 2D table => to be tested
   public void convertInputToArrays(String Input, int Digit_Place){
      //error handle digits are 0-9
      int[] Start_IDs = {0,3,6,9,12,15,18,21,24};

      StringBuilder _Input = new StringBuilder(Input);
      char emptychar = ' ';
      _Input.setCharAt(26,emptychar);
      _Input.setCharAt(54,emptychar);
      char[] ch = _Input.toString().toCharArray();

      String line0 = _Input.toString().substring( 0,  27 );  //0-27 <- first line -1 as \n
      String line1 = _Input.toString().substring( 27,  54 ); //27-55 <- second line -1 as \n
      String line2 = _Input.toString().substring( 55,  82 ); //55-82 < third line
      String[] Lines = {line0,line1,line2}; 

      String[] Output = {Lines[0].substring(Start_IDs[Digit_Place],Start_IDs[Digit_Place]+3),
                         Lines[1].substring(Start_IDs[Digit_Place],Start_IDs[Digit_Place]+3),
                         Lines[2].substring(Start_IDs[Digit_Place],Start_IDs[Digit_Place]+3)};
      System.out.println(this.convert(Output));
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



