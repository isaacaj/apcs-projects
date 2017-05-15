package May_8_2017;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by 90304755 on 5/10/17.
 */
public class Guess
{
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args)
    {
        int targetNum = random.nextInt(100);
        int guessedNum;

        System.out.println("Guess the number that I'm thinking of." /* + targetNum */);

        while(true)
        {
            guessedNum = scanner.nextInt();

            if(guessedNum > targetNum)  { System.out.println("Your number is too high."); }
            if(guessedNum < targetNum)  { System.out.println("Your number is too low"); }
            if(guessedNum == targetNum) { System.out.println("Congrats! You got it!"); break; }
        }

        scanner.close();
    }
}
