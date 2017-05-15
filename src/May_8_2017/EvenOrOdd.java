package May_8_2017;

import java.util.Scanner;

/**
 * Created by 90304755 on 5/8/17.
 */
public class EvenOrOdd
{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Put in a number to evaluate even or odd.");

        evenOdd(scanner.nextInt());
        countdown();

        scanner.close();
    }

    public static void evenOdd(int num)
    {
        if(num % 2 == 0) { System.out.println("Even"); }
        else { System.out.println("Odd"); }
    }

    /*
        Exponentially growing wait between each printed line.
     */
    public static void countdown()
    {
        int time = 1000;

        for(int i = 10; i > 0; --i)
        {
            System.out.println(i);

            try { Thread.sleep(time); }
            catch (InterruptedException e) { e.printStackTrace(); }

            time *= 2;
        }

        System.out.println("Lift off!");
    }
}
