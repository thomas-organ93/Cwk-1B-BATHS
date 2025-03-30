/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author thomasorgan
 */
public class ShipTester {
    
    public static void main(String[] args) {
        
        ManOWar victory = new ManOWar("Victory", "Alan Aikan", 3, 3, 20);
        Frigate sophie = new Frigate("Sophie", "Ben Baggins", 8, 16, true);
        Sloop arrow = new Sloop("Arrow", "Dan Dare", 150, true);
        
        System.out.println(victory.toString());
        System.out.println(sophie.toString());
        System.out.println(arrow.toString());
        
    }
    
}
