/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hyatt.branch;
import hyatt.branch.Items;
/**
 *
 * @author hyattkamel
 */
public class Player { 
    private double powerLevel;
    private int roomCounter;
    private String name;

    public Player() {
        powerLevel = 0;
        roomCounter = 0; 
    }
    public Player(String name, double power) { // is this necessary?
        this.name = name;
        this.powerLevel = power;
        this.roomCounter = 0; 
    }
    private void enteredRoom()
    {
        roomCounter += 1;
    }
    public void increasePowerLevel(double PowerPnts) {
        powerLevel *= PowerPnts; // or powerLevel = powerLevel * PowerPnts;
    }
    
    public double getPowerLevel() {
        return powerLevel;
    }
    
    public String getName(){
        return name;
    }  
    
    public int getRmCount(){
        return roomCounter;
    }
}

