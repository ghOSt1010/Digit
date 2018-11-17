package com.company;


class Digit {

   private String w0 = " _ ";
   private String w1 = "   ";
   private String w2 = "  |";
   private String w3 = "| |";
   private String w4 = "|_|";
   private String w5 = " _|";
   private String w6 = "|_ ";


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

      //if (digit.length != 3) {
      //
      //   return Result;
      //}

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
      //if (Done) return Result;
      if (Result == DigitErr) {
         Result = this.extendedConverter(digit);
      }

      return Result;
   }

   public String extendedConverter(String[] digit) {
      //only one stroke play
      if (digit.length != 3) {
         return "?";
      }

      // First line stroke - missing logic
      // missing one stroke -
      if (digit[0].equals(w1) && digit[1].equals(w3) && digit[1].equals(w4)) {
         return "0";
      } else {
         //1
         //missing one stroke | upper
         if (digit[0].equals(w1) && digit[1].equals(w2) && digit[2].equals(w1)) {
            return "1";
         }
         //missing one stroke | upper
         if (digit[0].equals(w1) && digit[1].equals(w1) && digit[2].equals(w1)) {
            return "1";
         }
         //no more missing strokes |
         if (digit[0].equals(w1) && digit[1].equals(w2) && digit[2].equals(w2)) {
            return "1";
         }
         //2
         //

      }


      return "?";
   }

}