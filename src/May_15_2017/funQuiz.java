package May_15_2017;

import java.util.Scanner;

/**
 * Created by 90304755 on 5/17/17.
 */
public class funQuiz {

    static Scanner scanner = new Scanner(System.in);
    static String input = "";
    static int numCorrect = 0;

    public static void main(String[] args) {
        String[] questionArray;
        String[] answerArray;
        questionArray = new String[10];
        answerArray = new String[10];

        questionArray[0] = "January has 30 days. (true/false)";
        questionArray[1] = "Is the product of any two even numbers always even? (true/false)";
        questionArray[2] = "Apples come in many varieties. Red, yellow, and green are common colors. (true/false)";
        questionArray[3] = "The diameter of a circle is equivalent to its circumference divided by pi. (true/false)";
        questionArray[4] = "The World Wide Web is a network of computers. (true/false)";
        questionArray[5] = "The rate of acceleration of gravity on Earth is about 9.8 meters per second per second. (true/false)";
        questionArray[6] = "A cartographer builds carts to be drawn by horses. (true/false)";
        questionArray[7] = "A soccer ball has 14 pentagons and 20 hexagons. (true/false)";
        questionArray[8] = "A regular dodecahedron has 12 sides, all of which are congruent hexagons. (true/false)";
        questionArray[9] = "A haberdasher is a salesman of men's apparel.";

        answerArray[0] = "False. January has 31 days.";
        answerArray[1] = "True";
        answerArray[2] = "True";
        answerArray[3] = "True";
        answerArray[4] = "False. The WWW is more like an application that runs on the Internet, which is the network of computers.";
        answerArray[5] = "True";
        answerArray[6] = "False. Cartographers create navigational maps.";
        answerArray[7] = "False. There are 12 pentagons and 20 hexagons on a soccer ball.";
        answerArray[8] = "False. A regular dodecahedron has 12 sides, all of which are congruent pentagons.";
        answerArray[9] = "True";

        for (int item = 0; item < questionArray.length; item++) {

            System.out.println(questionArray[item]);

            input = scanner.nextLine();

            if (answerArray[item].length() == 4) {
                if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("t")) {
                    System.out.println("Congration, Ya dun a smart. \n \n \n");
                    numCorrect++;
                }
                else {
                    System.out.println("Answer: " + answerArray[item] + "\n \n \n");
                }
            }

            else if (answerArray[item].substring(0, 5).equalsIgnoreCase("false")) {
                if (input.equalsIgnoreCase("false") || input.equalsIgnoreCase("f")) {
                    System.out.println("Congration, Ya dun a smart. \n \n \n");
                    numCorrect++;
                }
                else
                {
                    System.out.println("Answer: " + answerArray[item] + "\n \n \n");
                }
            }
        }

        System.out.println("You got " + numCorrect + " out of 10 questions correct.");
    }
}
