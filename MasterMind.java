/**
*@param args
*@author Mirghani
*@course CPSC 220
*@section 1
*@description This programis a game in which the user must select
*the correct order and color of the pegs
*/

import java.util.Scanner;

class MasterMind {
   public static void main (String [] args) {
   
   final int MAX_ATTEMPTS = 10;
   Scanner scanner = new Scanner(System.in);
   SecretPattern secretPegs, secretPegsCopy, guessPegs;
   String guess;
   int   attempt = 0;
   int   patternCorrect = 0, colorCorrect = 0;
   
   
   System.out.println("Welcome to MasterMind!");
   System.out.println("Enter a string consisting of 4 letters, which can be");
   System.out.println("R (Red), B (Blue), G  (Green), Y (Yellow), C (Cyan) or M (Magenta).");
   System.out.println("Enjoy!");
   
   secretPegs = new SecretPattern();
   secretPegs.generateSecretCode();
   //Uncomment next line to see the pattern!
   System.out.println(secretPegs.toString());
   
   secretPegsCopy = new SecretPattern();
   secretPegsCopy.setColorPeg1(secretPegs.getColorPeg1());
   secretPegsCopy.setColorPeg2(secretPegs.getColorPeg2());
   secretPegsCopy.setColorPeg3(secretPegs.getColorPeg3());
   secretPegsCopy.setColorPeg4(secretPegs.getColorPeg4());
   //System.out.println(secretPegsCopy.toString());
   
   do {
   
   attempt += 1;
   
   secretPegsCopy.setColorPeg1(secretPegs.getColorPeg1());
   secretPegsCopy.setColorPeg2(secretPegs.getColorPeg2());
   secretPegsCopy.setColorPeg3(secretPegs.getColorPeg3());
   secretPegsCopy.setColorPeg4(secretPegs.getColorPeg4());
   
   System.out.print("Enter your guess: ");
   guess = scanner.nextLine();
   
   while (guess.length() != 4) {
      System.out.println("Incorrect guess!");
      System.out.print("Enter your guess: ");
      guess = scanner.nextLine();
   }
   
   
   guessPegs = new SecretPattern();
   guessPegs.setColorPeg1(guess.charAt(0));
   guessPegs.setColorPeg2(guess.charAt(1));
   guessPegs.setColorPeg3(guess.charAt(2));
   guessPegs.setColorPeg4(guess.charAt(3));
   
   patternCorrect = secretPegs.countPattern(guessPegs);
   
   colorCorrect = secretPegs.countColors(guessPegs);
   
   System.out.print("Colors correct: " + colorCorrect + "; ");
   System.out.print("Pattern correct: " + patternCorrect);
   System.out.println(" ");
   System.out.println(" ");
   
   } while (attempt < MAX_ATTEMPTS && patternCorrect < 4);
   
   if(patternCorrect == 4)
   {
   System.out.print("You Won! Congratulations");
   }
   else
   {
   System.out.print("You Lost! Try Again!");
   }
   
   
   }
   }
   