/**
*@param args
*@author Mirghani
*@course CPSC 220
*@section 1
*@description This program is a game in which the user must select
*the correct order and color of the pegs 
*/

import java.util.*;

class SecretPattern {

// Data members
   char peg1, peg2, peg3, peg4;

// Consructors
   public SecretPattern() {
      peg1 = 'R';
      peg2 = 'R';
      peg3 = 'R';
      peg4 = 'R';
   }

// Convert an interger to its corresponding colour letter
   public char intToColour(int i) {
      char c = ' ';
   
      switch (i) {
         case 0: c = 'R';
            break; // red
         case 1: c = 'G';
            break; // green
         case 2: c = 'B';
            break; // blue
         case 3: c = 'C';
            break; // cyan
         case 4: c = 'Y';
            break; // yellow
         case 5: c = 'M';
            break; // magenta
      
         default: System.err.println("Error: no such colour!");
            System.exit(1);
      }
      return c;
   }
// Generate four pegs for the secret code
   public void generateSecretCode() {
   
      Random random = new Random();
   
      int num = random.nextInt(6);
      char c = intToColour(num);
      setColorPeg1(c);
   
      num = random.nextInt(6);
      c = intToColour(num);
      setColorPeg2(c);  
   
      num = random.nextInt(6);
      c = intToColour(num);
      setColorPeg3(c);
   
      num = random.nextInt(6);
      c = intToColour(num);
      setColorPeg4(c);
   
   }

   public char getColorPeg1()
   {
      return peg1;
   }
   public char getColorPeg2()
   {
      return peg2;
   }
   public char getColorPeg3()
   {
      return peg3;
   }
   public char getColorPeg4()
   {
      return peg4;
   }
   public void setColorPeg1(char c)
   {
      peg1 = c;
   }
   public void setColorPeg2(char c)
   {
      peg2 = c;
   }
   public void setColorPeg3(char c)
   {
      peg3 = c;
   }
   public void setColorPeg4(char c)
   {
      peg4 = c;
   }

//Returns string representation of a SecretPattern object 
   public String toString() {
      return peg1+ "  " +
          peg2+ "  " +
          peg3+ "  " +
          peg4;
   }

//Returns the number of patternCorrect between object and guessPegs
   public int countPattern(SecretPattern guessPegs) {
      int patternCorrect = 0;
   
   
      if(peg1 == guessPegs.getColorPeg1())
      {
         patternCorrect += 1;
      
      }
   
      if(peg2 == guessPegs.getColorPeg2())
      {
         patternCorrect += 1;
      
      }
   
      if(peg3 == guessPegs.getColorPeg3())
      {
         patternCorrect += 1;
      
      }
   
      if(peg4 == guessPegs.getColorPeg4())
      {
         patternCorrect += 1;
      
      }
   
   
      return patternCorrect;
   }

   public int countColors(SecretPattern guessPegs) {
      int hits = 0;
      char guessPeg;
      guessPeg = guessPegs.getColorPeg1();
   
   
      if(peg1 == guessPeg)
      {
      //this is pattern correct not color correct
      //Don't count this toward color correct! 
      }
      else if(peg2 == guessPeg)
      {
         hits += 1;
      }
      else if(peg3 == guessPeg)
      {
         hits += 1;
      }
      else if(peg4 == guessPeg)
      {
         hits += 1;
      }
   
      guessPeg = guessPegs.getColorPeg2();
   
      if(peg2 == guessPeg)
      {
      //Don't count this toward color correct!
      }   
      else if(peg1 == guessPeg)
      {
         hits += 1;
      }
      else if(peg3 == guessPeg)
      {
         hits += 1;
      }
      else if(peg4 == guessPeg)
      {
         hits += 1;
      }
   
      guessPeg = guessPegs.getColorPeg3();
   
      if(peg3 == guessPeg)
      {
      //Don't count count this toward color correct!
      }   
      else if(peg1 == guessPeg)
      {
         hits += 1;
      }
      else if(peg2 == guessPeg)
      {
         hits += 1;
      }
      else if(peg4 == guessPeg)
      {
         hits += 1;
      }
   
      guessPeg = guessPegs.getColorPeg4();
   
      if(peg4 == guessPeg)
      {
      //Don't count this toward color correct!
      }   
      else if(peg1 == guessPeg)
      {
         hits += 1;
      }
      else if(peg2 == guessPeg)
      {
         hits += 1;
      }
      else if(peg3 == guessPeg)
      {
         hits += 1;
      }
   
      return hits;
   }
}

   
