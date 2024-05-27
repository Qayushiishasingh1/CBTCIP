package Task1;
import java.util.Random;
import java.util.Scanner;
public class Task1 
{
  public static void main(String[] args) 
  {
    Random number = new Random();
    int guess_right=number.nextInt(100);
    int turns=0;
    Scanner scan=new Scanner(System.in);
    System.out.println("Guess a number between 1 to 100" );
    System.out.println("GOOD LUCK");
    
    int guess;
    int i=0;
    boolean win=false;
    while(win==false) 
    {
      guess=scan.nextInt();
      turns++;
    
    if(guess==guess_right) 
    {
      win=true;
    }
    else if(i>8)
    {
      System.out.println("You loose! the right answer was: "+guess_right);
      return;
    }
    else if(guess<guess_right)
         {
                    i++;
      System.out.println("Yor Guess is lower:"+(10-i));  
    }
    else if(guess>guess_right) {
      i++;
      System.out.println("Your Guess Is Higher: "+(10-i)); 
    }
  }
    System.out.println("YOU WON");
    System.out.println("The number was "+guess_right);
    System.out.println("You used "+turns+" turns to guess the right number");
    System.out.println("Your score: "+((11-turns)*10)+" out of 100");
} 
}

