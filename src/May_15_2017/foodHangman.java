package May_15_2017;

import java.util.Scanner;

public class foodHangman {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = {"apple", "cheese", "banana", "rice", "milk", "strawberry", "carrot", "onion"};
        int randWord = (int) (Math.random() * words.length);
        char[] inputLetters = new char[words[randWord].length()];
        int numGuesses = 0;
        boolean wordRevealed = false;
        do {
            switch (enterLetter(words[randWord], inputLetters)) {
                case 0:
                    numGuesses++;
                    break;
                case 1:
                    numGuesses++;
                    break;
                case 2:
                    break;
                case 3:
                    wordRevealed = true;
                    break;
            }
        } while (!wordRevealed);
        System.out.println("\nThe word is... " + words[randWord] + " \nYou guessed wrong letters " + (numGuesses - findEmptyPosition(inputLetters)) + " times");
    }

    public static int enterLetter(String word, char[] enteredLetters) {
        System.out.print("Enter a letter in the word ");
        if (!printWord(word, enteredLetters))
            return 3;
        int emptyPosition = findEmptyPosition(enteredLetters);
        char userInput = input.nextLine().charAt(0);
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println(userInput + " is already in the word");
            return 2;
        } else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            return 1;
        } else {
            System.out.println(userInput + " is not in the word");
            return 0;
        }
    }

    public static boolean printWord(String word, char[] enteredLetters) {
        boolean asteriskPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (inEnteredLetters(letter, enteredLetters))
                System.out.print(letter);
            else {
                System.out.print('*');
                asteriskPrinted = true;
            }
        }
        return asteriskPrinted;
    }

    public static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }

    public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000') i++;
        return i;
    }
}
