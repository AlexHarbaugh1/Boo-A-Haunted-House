import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;



import java.io.*;




/**
 * A text-based adventure action game.
 * 
 * @author
 */
public class TheDungeon{
    
private static Title title;
/** The menu option for attacking. */
    public static final int ATTACK = 1;

    /** The string which contains all acceptable affirmative answers to yes or no questions. Not case-sensitive. */
    public static final String CONFIRMATION = "yesyyupoksureof course";

    /** The delay used for display messages. */
    public static final long DELAY = 2000;

    /** The menu option for exiting the game. */
    public static final int EXIT = 5;
    
    /** The random number generator of this game. */
    public static final Random RANDOM = new Random();

    /** The way of gathering input of this game. */
    public static final Scanner SCANNER = new Scanner(System.in);

    
public static void main(String[] args){
    
    /**
     * The dungeon game.
     * 
     * @param argument not used
     */
    
        title = new Title();
        //title.displayGameScreen();
        // Main character
        Player player = new Player();
        
        // Game variables
        /* The following three chance variables are percentages */
        //int swordDropChance = 10;
        boolean running = true;
        boolean alive = true;

        // Game introduction
        title.UpdateTextArea("\fWelcome to the dungeon.");
        delay();
        //first weapon
        int R = RANDOM.nextInt(1, 20);
        if (R>=19){
            player.addWeapon("GUN");//Highest level weapon/enemy
        }
        else if (R >= 17){
            //second highest level weapon/enemy
            player.addWeapon("WHIP");
        }
        else if (R >= 15){
            //second highest level weapon/enemy
            player.addWeapon("KNIFE");
        }
        else if (R >= 13){
            //second highest level weapon/enemy
            player.addWeapon("CLUB");
        }
        else if (R >= 11){
            //third highest level weapon/enemy
            player.addWeapon("STAKE");
        }
        else {
            //weakest monster
            player.addWeapon("FIST");
        }

        // Game loop
        while (running) {
            if (!alive) 
            {
                title.UpdateTextArea("\nUh oh! You have died, game over.");
                title.UpdateTextArea("Would you like to respawn? ");
                String continueGame = SCANNER.nextLine();
                if (CONFIRMATION.contains(continueGame.toLowerCase())) {
                    alive = true;
                    player.reset();
                    R = RANDOM.nextInt(1, 20);
                    if (R >= 19) {
                        player.addWeapon("GUN");
                    } else if (R >= 17) {
                        player.addWeapon("WHIP");
                    } else if (R >= 15) {
                        player.addWeapon("KNIFE");
                    } else if (R >= 13) {
                        player.addWeapon("CLUB");
                    } else if (R >= 11) {
                        player.addWeapon("STAKE");
                    } else {
                        player.addWeapon("FIST");
                    }
                 
            }
        }
            while (alive) 
            {
                // Always spawn an enemy at the start of the alive loop
                
                int choice;
                choice= ATTACK;


                Enemy villain = new Enemy();
                if (player.key) 
                {
                    villain = Enemy.boss;
                }
                title.UpdateTextArea("\f# A " + villain.current_enemy.name + " appeared #");
                delay();
                if (choice == ATTACK) {
                    System.out.print("in choice==attack");
                    // Placeholder for attack logic, needs to check result of battle to decide on 'alive'
                    if (player.hitpoints() > villain.current_enemy.hitpoints()) 
                    {
                        title.UpdateTextArea("You defeated " + villain.current_enemy.name + "!");
                        delay();
                        // Add random weapon or key chance after winning
                        R = RANDOM.nextInt(1, 20);
                        if (R >= 19) {
                            player.addWeapon("GUN");
                            System.out.print("added gun");
                        } else if (R >= 17) 
                        {
                            player.addWeapon("WHIP");
                        } else if (R >= 15) 
                        {
                            player.addWeapon("KNIFE");
                        } else if (R >= 13) 
                        {
                            player.addWeapon("CLUB");
                        } else if (R >= 11) 
                        {
                            player.addWeapon("STAKE");
                            System.out.print("added stake");
                        } else 
                        {
                            player.addWeapon("FIST");
                        }
                        if (R == 20) 
                        {
                            player.hasKey(); // Assuming this method updates the key status
                        }
//                        
                    } else 
                    {
                        alive = false;
                        title.UpdateTextArea("You were defeated by " + villain.current_enemy.name);
                        break; // Exit the while(alive) loop
                    }//end if elses
                }
        
            }
            
}
   

    
   
}  // end of main
    /**
     * The battle prompt menu of this program.
     */
    public static void startBattle()
    {
        title.UpdateTextArea("\n1. Attack.");
        title.UpdateTextArea("2. Exit Game.");

        title.UpdateTextArea("\nChoice? ");
    } // end of startBattle()

    /**
     * Puts thread to sleep to allow the user to read the display messages.
     */
    public static void delay()
    {
        try{
            Thread.sleep(DELAY);
        } 
        catch (InterruptedException exception){
            title.UpdateTextArea("\fThe game experienced an interrupted exception.");
            title.UpdateTextArea("The game state was not saved.");
            title.UpdateTextArea("Please restart the game.");

            System.exit(0);
        } // end of catch (InterruptedException)
    } // end of method delay()
    
    
} // end of class TheDungeon
