package modulusMonday;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by 90304755 on 5/8/17.
 * <p>
 * Fight Zombies with Coconuts and Spoons in this eccentric text-based
 * adventure! Content has not been rated by the ESRB.
 */
public class Zombi {

    static boolean hardmode;
    static boolean bossmode;
    static int zombiHealth;
    static int spoonDamage;
    static int playerHealth = 100;
    static int playerStrength = 0;
    static int bossDamage;

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    // Self-explanatory.
    public static void main(String[] args) {
        introduction();
        gameLoop();
    }

    // Prints the introduction
    public static void introduction() {
        System.out.println("Welcome to Zombi!");
        System.out.println("Prepare for everything to stop making sense! \n");
        wait(2000);
    }

    // The game loop. This is called repeatedly until the player looses the game.
    public static void gameLoop() {
        generateZombie();
        zombiFight();
    }

    // Generates the zombie. Strong zombies have more health.
    public static void generateZombie() {
        double chooseEncounter = Math.random() + (playerStrength / 100);

        if (chooseEncounter > 0.9) {
            hardmode = true;
        } else {
            hardmode = false;
        }

        System.out.println("You are walking down a beach...  \n");
        System.out.println("Suddenly, a Zombi appears! \n");

        if (playerStrength > 100) {
            bossmode = true;
            System.out.println("DANGER. DANGER. DANGER. ZOM-BOSS AHEAD.\n");
            zombiHealth = 2000;
            System.out.println("Your spoon emits a mystical glow... \n");
            System.out.println("Your spoon grows hot in your hands, morphing into a SPORK! \n");
            System.out.println("The spork will heal you for every point of damage it deals. \n");
        } else if (!hardmode) {
            System.out.println("It is a weak Zombi! This one is decaying.");
            zombiHealth = 20 + random.nextInt(20);
        } else if (hardmode) {
            System.out.println("It is a strong Zombi! This one is recently risen.");
            zombiHealth = 40 + random.nextInt(40);
        }
    }

    // The fight sequence. Gives player decisions.
    public static void zombiFight() {
        while (zombiHealth > 0 && playerHealth > 0) {
            if (!bossmode) {
                System.out.println("What would you like to do?");
                System.out.println();
                System.out.println("Enter a (1) for 'Throw coconut' or a (2) for 'Wield spoon'");

                if (scanner.nextInt() == 1) {
                    System.out.println("You throw a coconut, dealing 10 damage!");
                    zombiHealth -= 10;
                    System.out.println();
                    System.out.println("Zombi health: " + zombiHealth);
                    //                wait(1000);
                } else {
                    spoonDamage = random.nextInt(20 + playerStrength + 5);
                    System.out.println("You charge forwards with your spoon, dealing " + spoonDamage + " damage!");
                    zombiHealth -= spoonDamage;
                    System.out.println();
                    System.out.println("Zombi health: " + zombiHealth);
                    //                wait(1000);

                }

                if (zombiHealth > 0) {
                    System.out.println();
                    System.out.println("The zombi attacks, dealing " + zombiHealth + " damage to you. \n");
                    playerHealth -= zombiHealth;
                    System.out.println("Your health: " + playerHealth);
                }
            } else if (bossmode) {
                System.out.println("What would you like to do?");
                System.out.println();
                System.out.println("Enter a (1) for 'Throw coconut' or a (2) for 'Wield Spork'");

                if (scanner.nextInt() == 1) {
                    System.out.println("You throw a coconut, dealing 10 damage!");
                    zombiHealth -= 10;
                    System.out.println();
                    System.out.println("Zombi health: " + zombiHealth);
                } else {
                    spoonDamage = (random.nextInt(50) + playerStrength / 2);
                    System.out.println("You charge forwards with your Spork, dealing " + 2 * spoonDamage + " damage! \n");
                    zombiHealth -= 2 * spoonDamage;
                    playerHealth += 2 * spoonDamage;
                    System.out.println("Zom-boss health: " + zombiHealth);
                }
                if (zombiHealth > 0) {
                    System.out.println();
                    bossDamage = random.nextInt(250) + 50;
                    System.out.println("The zombi attacks, dealing " + bossDamage + " damage to you. \n");
                    playerHealth -= bossDamage;
                    System.out.println("Your health: " + playerHealth);
                }
            } else {
                break;
            }
        }

        if (playerHealth <= 0) {
            System.out.println("You succumb to your wounds, the zombies win this time... \n \n \n");
            wait(3000);
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
        } else {
            playerStrength += random.nextInt(10);
            System.out.println("Congratulations, you have fended off the zombi!\n");
            System.out.println("You rest a while, restoring your health.\n");
            playerHealth = 100 + playerStrength / 2;
            System.out.println("Your health: " + playerHealth);
            System.out.println();
            System.out.println("Victory empowers you. \nYour spoon will be more effective. \nYou have gained some health.\n \n \n");

            if (bossmode) {
                System.out.println("The dust settles... \n \n");
                wait(3000);
                System.out.println("You have defeated the Zombies! Congratulations! Have fun on the beach!");
                System.out.print("W ");
                wait(600);
                System.out.print("I ");
                wait(600);
                System.out.print("N ");
                wait(600);
                System.out.print("N ");
                wait(600);
                System.out.print("E ");
                wait(600);
                System.out.print("R ");
            }
            if (!bossmode) {
                gameLoop();
            }
        }
    }

    // Used to pause certain sections of script, allowing reader time to read.
    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
