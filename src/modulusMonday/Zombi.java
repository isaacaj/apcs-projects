package modulusMonday;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by 90304755 on 5/8/17.
 *
 * Fight Zombies with Coconuts and Spoons in this eccentric text-based
 * adventure! Content has not been rated by the ESRB.
 */
public class Zombi
{

    static boolean hardmode;
    static int zombiHealth;
    static int spoonDamage;
    static int playerHealth = 100;
    static int playerStrength = 0;

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    // Self-explanatory.
    public static void main(String[] args)
    {
        introduction();
        gameLoop();
    }

    // Prints the introduction
    public static void introduction()
    {
        System.out.println("Welcome to Zombi!");
        System.out.println("Prepare for everything to stop making sense!");
        System.out.println();
        wait(2000);
    }

    // The game loop. This is called repeatedly until the player looses the game.
    public static void gameLoop()
    {
        generateZombie();
        zombiFight();
    }

    // Generates the zombie. Strong zombies have more health.
    public static void generateZombie()
    {
        double chooseEncounter = Math.random() + (playerStrength/100);

        if (chooseEncounter > 0.8) { hardmode = true; }
        else { hardmode = false; }

        System.out.println("You are walking down a beach... ");
        System.out.println();
        System.out.println("Suddenly, a Zombi appears!");
        System.out.println();

//        if(playerStrength > 100)
//        {
//            System.out.println("DANGER. DANGER. DANGER. ZOM-BOSS AHEAD.");
//            System.out.println();
//            zombiHealth = 2000;
//            System.out.println("Your spoon emits a mystical glow...");
//            System.out.println();
//            System.out.println("Your spoon grows hot in your hands, morphing into a SPORK!");
//            System.out.println();
//            System.out.println("The spork will heal you for every point of damage it deals.");
//        }

        if (!hardmode)
        {
            System.out.println("It is a weak Zombi! This one is decaying.");
            zombiHealth = 20 + random.nextInt(20);
        }

        else if (hardmode)
        {
            System.out.println("It is a strong Zombi! This one is recently risen.");
            zombiHealth = 40 + random.nextInt(40);
        }
    }

    // The fight sequence. Gives player decisions.
    public static void zombiFight()
    {
        while(zombiHealth > 0 && playerHealth > 0)
        {
            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("Enter a (1) for 'Throw coconut' or a (2) for 'Wield spoon'");

            if(scanner.nextInt() == 1)
            {
                System.out.println("You throw a coconut, dealing 10 damage!");
                zombiHealth -= 10;
                System.out.println();
                System.out.println("Zombi health: " + zombiHealth);
//                wait(1000);
            }

            else
            {
                spoonDamage = random.nextInt(20 + playerStrength);
                System.out.println("You charge forwards with your spoon, dealing " + spoonDamage + " damage!");
                zombiHealth -= spoonDamage;
                System.out.println();
                System.out.println("Zombi health: " + zombiHealth);
//                wait(1000);

            }

            if(zombiHealth > 0)
            {
                System.out.println();
                System.out.println("The zombi attacks, dealing " + zombiHealth + " damage to you.");
                playerHealth -= zombiHealth;
                System.out.println();
                System.out.println("Your health: " + playerHealth);
            }
        }

        if(playerHealth <= 0)
        {
            System.out.println("You succumb to your wounds, the zombies win this time...");
            wait(3000);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.print("G ");
            wait(600);
            System.out.print("A ");
            wait(600);
            System.out.print("M ");
            wait(600);
            System.out.print("E ");
            wait(600);
            System.out.print("  ");
            wait(600);
            System.out.print("O ");
            wait(600);
            System.out.print("V ");
            wait(600);
            System.out.print("E ");
            wait(600);
            System.out.print("R ");
            wait(600);
        }

        else
        {
            System.out.println("Congratulations, you have fended off the zombi!");
            System.out.println();
            System.out.println("You rest a while, restoring your health.");
            playerHealth = 100;
            System.out.println();
            System.out.println("Your health: " + playerHealth);
            System.out.println();
            System.out.println("Victory empowers you. Your spoon will be more effective.");
            playerStrength += random.nextInt(7);
            System.out.println();
            System.out.println();
            System.out.println();

            gameLoop();
        }
    }

    // Used to pause certain sections of script, allowing reader time to read.
    public static void wait(int millis)
    {
        try { Thread.sleep(millis); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
