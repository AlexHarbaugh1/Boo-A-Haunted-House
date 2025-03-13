/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rooms;

/**
 *
 * @author sturk
 */
public class Rooms {
    
    private String description;
    private Rooms[] exits;
    
    public Rooms(String description){
    
    this.description=description;
    this.exits= new Rooms [4];
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
