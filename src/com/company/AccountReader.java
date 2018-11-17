package com.company;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class AccountReader {
   private Path pathFile;
   private List<String> readFile;

   public AccountReader(Path pathFile) {
      this.pathFile = pathFile;
      ReadFile();
   }

   public AccountReader ReadFile() {
      try {
         this.readFile = readAllLines(pathFile);
      } catch (Exception e) {
         System.out.println("nie udalo sie wczytać pliku");
      }
      return this;
   }

   public List<String[]> IsolateAccounts() {
      List<String[]> listAccounts = new ArrayList<>();

      for (int i = 0; i < this.readFile.size() / 4; i++) {
         listAccounts.add(
            new String[]{
               this.readFile.get(i * 4),
               this.readFile.get((i * 4) + 1),
               this.readFile.get((i * 4) + 2),
            }
         );
      }
      return listAccounts;
   }

   public List<String> GetAllAccounts() {

      List<String[]> listAccounts = IsolateAccounts();
      List<String> result = new ArrayList<>();

      for (String[] account : listAccounts) {
         String transformedAccount = new Digit().convertStringToAccountNumber(account);
         if (CheckErrorAccount(transformedAccount)) {
            //get ? place no for tests
            String Replaced = new Digit().solveAmbiguous(account, transformedAccount.indexOf('?'));
            transformedAccount = transformedAccount.replace('?', Replaced.charAt(0));
            result.add(transformedAccount + " ILL");
         } else if (!CheckAccountSumControl(transformedAccount)) {
            //get ? place no for tests


            result.add(transformedAccount + " ERR");
         } else {
            //get ? place no for tests

            result.add(transformedAccount);
         }
      }
      return result;
   }

   public boolean CheckErrorAccount(String account) {
      return account.contains("?");
   }

   public boolean CheckAccountSumControl(String account) {
      int sum = 0;

      for (int i = 1; i <= account.length(); i++) {
         sum += i * Integer.parseInt(account.substring(i - 1, i));
      }

      return sum % 11 == 0;
   }
}