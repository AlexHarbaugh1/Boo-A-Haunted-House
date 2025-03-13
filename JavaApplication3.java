/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author olivi
 */


/*
 * Group 2: The Chessmasters
 * Project: Boo! A Haunted House
 * File: Functions for Text Output
 * Last Edit: 3/31/24
 * Editor: Olivia Tucker
 */

/*
Instances:

Directly after start:
-Weapon Roll- in progress
-Floor Selection- done 
-Room Selection- done
-Current Hitpoint (Based off Weapons Roll)- in progress

Rooms:
-Monster- in progress
-Observe?
 -Key
 -Stairs
  -Have a Key to go up/down
 -New Weapons
-Next room or Leave

Boss Level:
-Boss Hitpoint- in progress
-List of players weapons
-Players hitpoints
-Proceed or go back

End Screen- done

Death Screen-done
*/



public class JavaApplication3 {

     // After Start Functions
    
    // This May go away later once Start Screen is developed
    public static void Intro() {
        System.out.println("Welcome to BOO! A Haunted House");
    }
    
    
    // Randomly Selected Weapon
    public static String Weapons(int weapon) {
        
        switch(weapon)
        {
            // get each weapon structures
            case 1 ->
            {
           return "Your Starting Weapon is";
            }
        }
        
        return "no starting weapon";
        // weapon selection happens in main file, not here
    }
    
    // Hit Point Value based off of starting Weapon
    // Value will come from code in main file
    public static String Hitpoints(String hitpoints) {
        return "Your Starting Hit Points: " + hitpoints ;
    }
    
    
     public static String rooms() {
        return "Do you want to enter a room?" ;
        
        // this will lead to a selection which will trigger the probablilty generator for whats in rooms
    }
    
      public static String floors() {
        return "Do you want to change floors?" ;
        
        // this will lead to a selection which will trigger the probablilty generator for whats in rooms
    }
     
     
    //Room Functions
    public static String monster (int Monster)
    {
        
        //Get monster names
        switch(Monster) 
        {
         case 1 -> 
         {
         
         }
        case 2 -> 
        {
           
        }
        default -> 
        {
            return "No Monsters Present";
        }

        }
       
        return "No Monsters Present";
    }
     
    
    
    // Boss Level Functions
    
     public static String Bosshp (int boss)
    {
        
        //Get monster names
        switch(boss) 
        {
         case 1 -> 
         {
         
         }
        case 2 -> 
        {
           
        }
        default -> 
        {
            
        }

        }
       
        return "Your Boss has" + boss + " hit points";
    }
     
    
    
    
    
    
    
    
    
    //End Screen
     public static void End() {
        System.out.println("Congratulations! You have beat Boo! A Haunted House");
    }
    
    //Death Screen
    
     public static void Death() {
        System.out.println("You have Died. Do you wish to quit or restart the game?");
    }

