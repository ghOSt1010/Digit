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

   //Convert input to account number as char array
   public char[] convertStringToAccountNumberCharArray(String Input){
      char[] Result = this.convertStringToAccountNumber(Input).toCharArray();
      return Result;
   }

   //Convert input to account Number as String
   public String convertStringToAccountNumber(String Input){
      String Result = new String();
      for(int i = 0; i < 9;i++){
         Result += this.convertStringToNumber(Input,i);
      }
      return Result;
   }

   //Convert input to number by id. ID range 0-8
   public String convertStringToNumber(String Input, int Digit_Place){
      String Result;
      //error handle digits are 0-9
      int[] Start_IDs = {0,3,6,9,12,15,18,21,24};

      StringBuilder _Input = new StringBuilder(Input);
      char emptychar = ' ';
      
      //removing problematic \n char <- no new line in char array
      _Input.setCharAt(26,emptychar);
      _Input.setCharAt(54,emptychar);

      String line0 = _Input.toString().substring( 0,  27 );  //0-27 <- first line -1 as \n
      String line1 = _Input.toString().substring( 27,  54 ); //27-55 <- second line -1 as \n
      String line2 = _Input.toString().substring( 55,  82 ); //55-82 < third line
      String[] Lines = {line0,line1,line2}; 


      String[] Output = {Lines[0].substring(Start_IDs[Digit_Place],Start_IDs[Digit_Place]+3),
                         Lines[1].substring(Start_IDs[Digit_Place],Start_IDs[Digit_Place]+3),
                         Lines[2].substring(Start_IDs[Digit_Place],Start_IDs[Digit_Place]+3)};

      Result = this.convert(Output);
      return Result;
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



