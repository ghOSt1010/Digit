package com.company;

//not used as of now

public class AccountNumber {
   private Digit digit = new Digit();
   private String Number;
   private String[] OriginalNumber;
   private boolean Error;
   private String[] ErrorType = {"", " ERR", " ILL", " AMB"};
   private int ErrorNo;
   private String ErrorTypeInfo = ErrorType[ErrorNo];

   public AccountNumber(String[] input, boolean Error, int ErrorNo) {
      this.Number = digit.convertStringToAccountNumber(input);
      this.OriginalNumber = input;
      this.Error = Error;
      this.ErrorTypeInfo = ErrorType[ErrorNo];
   }


}
