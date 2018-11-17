package com.company;


class Digit {

   private String w0 = " _ ";
   private String w1 = "   ";
   private String w2 = "  |";
   private String w3 = "| |";
   private String w4 = "|_|";
   private String w5 = " _|";
   private String w6 = "|_ ";
   private String w7 = " _|";


   //Convert input to account number as char array
   public char[] convertStringToAccountNumberCharArray(String[] Input) {
      char[] Result = this.convertStringToAccountNumber(Input).toCharArray();
      return Result;
   }

   //Convert input to account number as int array
   public int convertStringToAccountNumberInt(String[] Input) {
      int Result;
      String AccountNumber= this.convertStringToAccountNumber(Input);
      Result = Integer.parseInt(AccountNumber);
      return Result;
   }

   //Convert input to account Number as String
   public String convertStringToAccountNumber(String[] Input) {
      String Result = "";
      for(int i = 0; i < 9;i++){
         Result += this.convertStringToNumber(Input,i);
      }
      return Result;
   }

   //Convert input to number by id. ID range 0-8
   public String convertStringToNumber(String[] Input, int Digit_Place) {
      String Result;

      String[] Output = {Input[0].substring(Digit_Place * 3, (Digit_Place * 3) + 3),
         Input[1].substring(Digit_Place * 3, (Digit_Place * 3) + 3),
         Input[2].substring(Digit_Place * 3, (Digit_Place * 3) + 3)};

      Result = this.convert(Output);
      return Result;
   }

   public String convert(String[] digit) {
      boolean Done = false;
      String DigitErr = "?";
      String Result = DigitErr;

      if (digit.length != 3) {
         return Result;
      }

      if (digit[0].equals(w1)) {
         if (digit[1].equals(w2)) {
            if (digit[2].equals(w2)) {
               Result = "1";
            } else Result = DigitErr;
         } else if (digit[1].equals(w4)) {
            if (digit[2].equals(w2)) {
               Result = "4";
            } else Result = DigitErr;
         }
      } else {
         if (digit[1].equals(w2)) {
            if (digit[2].equals(w2)) {
               Result = "7";
            } else Result = DigitErr;
         } else if (digit[1].equals(w3)) {
            if (digit[2].equals(w4)) {
               Result = "0";
            } else Result = DigitErr;
         } else if (digit[1].equals(w4)) {
            if (digit[2].equals(w4)) {
               Result = "8";
            } else if (digit[2].equals(w5)) {
               Result = "9";
            } else Result = DigitErr;
         } else if (digit[1].equals(w5)) {
            if (digit[2].equals(w5)) {
               Result = "3";
            } else if (digit[2].equals(w6)) {
               Result = "2";
            } else Result = DigitErr;
         } else if (digit[1].equals(w6)) {
            if (digit[2].equals(w5)) {
               Result = "5";
            } else if (digit[2].equals(w4)) {
               Result = "6";
            } else Result = DigitErr;
         }
      }
      return Result;
   }

   //Convert input to number by id. ID range 0-8
   public String solveAmbiguous(String[] Input, int Digit_Place) {
      //version 0.0.1 beta :)
      String Result;
      char[] temp;
      String tempString;
      String[] Output = {Input[0].substring(Digit_Place * 3, (Digit_Place * 3) + 3),
         Input[1].substring(Digit_Place * 3, (Digit_Place * 3) + 3),
         Input[2].substring(Digit_Place * 3, (Digit_Place * 3) + 3)};

      //for(int i = 0; i < Output.length; i++){
      temp = Output[1].toCharArray();
      temp[0] = '|';
      Output[1] = String.valueOf(temp);

      Output[1].replace(' ', '|');
      //}

      Result = this.convert(Output);
      return Result;
   }


}