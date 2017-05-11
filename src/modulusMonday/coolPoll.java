package modulusMonday;

import java.util.Scanner;

/**
 * Created by 90304755 on 5/8/17.
 */
public class coolPoll
{

    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[]  args)
    {
        System.out.println("\tSuper Poll");
        System.out.println();
        System.out.println("Please answer the following questions... ");
        System.out.println();
        System.out.println("1: What is your name?");
        System.out.println("Hello, " + keyboard.next() + ".");
        System.out.println();
        System.out.println("2: How difficult do you think the test was? (1-10, 1 being easiest)");
        System.out.println(getPoll(keyboard.nextInt()));
        System.out.println("Thank you for answering those questions!");

        keyboard.close();
    }

    public static String getPoll(int rating)
    {
        switch (rating)
        {
            case 0:  return "Nice one, smart stuff.";
            case 1:  return "Looks like somebody studied well! Excellent work.";
            case 2:  return "Wonderful! Keep up the good work!";
            case 3:  return "Excellent job!";
            case 4:  return "You did fantastic, I can tell!";
            case 5:  return "I wish you luck, hope you did well.";
            case 6:  return "You did your best!";
            case 7:  return "Did you pay attention in class?";
            case 8:  return "Did you not study at all?";
            case 9:  return "Better luck next time.";
            case 10: return "Do you not understand basic Algebra? How are you in high school?";

            default: return "Please enter a real number between 1 and 10";
        }
    }
}
