package main;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author sturk
 */
import javaapplication5.*;
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
import javaapplication5.Player;
import javaapplication5.Enemy;
import javaapplication5.Weapons;


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
        title.displayGameScreen();
        
        // Main character
        Player player = new Player();

        // Game variables
        /* The following three chance variables are percentages */
        //int swordDropChance = 10;
        boolean running = true;
        boolean alive = true;

        // Game introduction
        UpdateTextArea("\fWelcome to the dungeon.");
        
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
        while (running) 
        {
            if (alive == false) {
                UpdateTextArea("\nUh oh! You have died, game over.");
                UpdateTextArea("Would you like to respawn? ");
                String continueGame = SCANNER.nextLine();
                if (CONFIRMATION.contains(continueGame)) 
                {
                    alive = true;
                    player.reset();
                    R = RANDOM.nextInt(1, 20);
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
                } 
                else 
                {
                    UpdateTextArea("\nProgram terminated.");
                    running = false;
                    return;
                }
            }
            
            while(alive)
            {
                 startBattle();

                int choice;

                try 
                {
                    choice = Integer.parseInt(SCANNER.nextLine());
                }
                catch (NumberFormatException exception)
                {
                    choice = EXIT;
                } // end of catch (NumberFormatException exception)

                switch (choice)
                {
                    case ATTACK:
//                        ranAway = false;
                 
                        Enemy villain = new Enemy();
                        //printStatistics(player, villain);
                        if (player.key == true) {
                            villain = Enemy.boss;
                            UpdateTextArea("\f# A " + villain.current_enemy.name + " appeared #");
                            if (player.hitpoints() == villain.current_enemy.hitpoints()) {
                                R = RANDOM.nextInt(1, 20);
                                if (R>=11) {
                                    alive = false;
                                    break;
                                }
                                else {
                                    UpdateTextArea("beat boss");
                                    //add win screen
                                    break;
                                }
                            }
                            else if (player.hitpoints() > villain.current_enemy.hitpoints()) {
                                UpdateTextArea("beat boss");
                                //add win screen
                                break;
                            }   
                            else {
                                alive = false;
                                break;
                            }

                        }
                        else{
                            villain = new Enemy();
                        }

                        UpdateTextArea("\f# A " + villain.current_enemy.name + " appeared #");
                        if (player.hitpoints() == villain.current_enemy.hitpoints()) {
                            if (R>=11) {
                                alive=false;
                                break;
                            }
                            else {
                                UpdateTextArea("1 print everything like stats here also loot and such");
                            }
                        }
                        else if (player.hitpoints() >= villain.current_enemy.hitpoints()) {
                            UpdateTextArea("1 print everything like stats here also loot and such");
                        }   
                        else {
                            alive=false;
                            break;
                        }
                         R = RANDOM.nextInt(1, 20);
                        if (R>=11) {
                            R = RANDOM.nextInt(1, 20);
                            if (R == 20){
                                player.hasKey();    
                                UpdateTextArea("20");
                            }
                            else if (R >= 19){
                                player.addWeapon("GUN");//Highest level weapon/enemy
                                UpdateTextArea(">=19");
                            }
                            else if (R >= 17){
                                //second highest level weapon/enemy
                                player.addWeapon("WHIP");
                                UpdateTextArea(">=17");
                            }
                            else if (R >= 15){
                                //second highest level weapon/enemy
                                player.addWeapon("KNIFE");
                                UpdateTextArea(">=15");
                            }
                            else if (R >= 13){
                                //second highest level weapon/enemy
                                player.addWeapon("CLUB");
                                UpdateTextArea(">=13");
                            }
                            else if (R >= 11){
                                //third highest level weapon/enemy
                                player.addWeapon("STAKE");
                                UpdateTextArea(">=11");
                            }
                            else {
                                //weakest monster
                                player.addWeapon("FIST");
                                UpdateTextArea("lol");
                            }
                        }

                        delay();
                        break;
                        
    
                    case EXIT:
                        UpdateTextArea("\fExiting game...");
                        running = false;
                        return;
                } // end of switch (choice)
            } // end of while(alive)
        } // end of while(running))   
}  // end of main
    /**
     * The battle prompt menu of this program.
     */
    public static void startBattle()
    {
        UpdateTextArea("\n1. Attack.");
        UpdateTextArea("2. Exit Game.");

        UpdateTextArea("\nChoice? ");
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
            UpdateTextArea("\fThe game experienced an interrupted exception.");
            UpdateTextArea("The game state was not saved.");
            UpdateTextArea("Please restart the game.");

            System.exit(0);
        } // end of catch (InterruptedException)
    } // end of method delay()
    
    public static void UpdateTextArea(String text)
    {
        title.UpdateTextArea(text);
    }
} // end of class TheDungeon
