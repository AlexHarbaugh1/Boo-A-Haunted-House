/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hyatt.branch;

import hyatt.branch.Player;

/**
 *
 * @author hyattkamel
 */
public class Enemy {
    private static final double zombiepower = 10^2;
    private static final double ghostpower = 10^3;
    private static final double vampirepower = 10^4;
    private static final double skeletonpower = 10^5;
    private static final double bosspower = 10^6;
     
    // Enemies 
    public static final Enemy zombie = new Enemy("Zombie",zombiepower);
    public static final Enemy ghost = new Enemy("Ghost",ghostpower);
    public static final Enemy vampire = new Enemy("Vampire",vampirepower);
    public static final Enemy skeleton = new Enemy("Skeleton",skeletonpower);
    public static final Enemy boss = new Enemy("Boss",bosspower);

    private double power;
    private String name;

    // Constructor to set power for each enemy
    private Enemy(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public double getPower() {
        return power;
    }
    public String getName(){
        return name;
    }
    
}
