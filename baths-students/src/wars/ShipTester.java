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
        
        ManOWar victory = new ManOWar("Victory", "Alan Aikan", 3, 3, 20, ShipState.RESERVE);
        Frigate sophie = new Frigate("Sophie", "Ben Baggins", 8, 16, true, ShipState.RESERVE);
        Sloop arrow = new Sloop("Arrow", "Dan Dare", 150, true, ShipState.RESERVE);
        
        System.out.println(victory.toString());
        System.out.println(sophie.toString());
        System.out.println(arrow.toString());
        
        System.out.println("State is: " + arrow.getState());
        arrow.setState(ShipState.SUNK);
        System.out.println("State is: " + arrow.getState());
        
        if (arrow.getState() == ShipState.SUNK) {
            System.out.println(arrow.viewName() + " has sunk");
        }
        
    }
    
}
