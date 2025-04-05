/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author T.Organ
 * @version 03/04/25
 */
public class BackendTester {
    
    public static void main(String[] args) {
        
        // Create Ships
        
        ManOWar victory = new ManOWar("Victory", "Alan Aikan", 3, 3, 20, ShipState.RESERVE);
        Frigate sophie = new Frigate("Sophie", "Ben Baggins", 8, 16, true, ShipState.RESERVE);
        Sloop arrow = new Sloop("Arrow", "Dan Dare", 150, true, ShipState.RESERVE);
        
        //  Create Encounter
        Encounter brest = new Encounter(3, EncounterType.BLOCKADE, "Brest", 3, 150);
        
        // Create Admiral
        BlueAdmiral thomas = new BlueAdmiral("Thomas", 1000);
        
        // Print Ship Information
        System.out.println(victory.toString());
        System.out.println(sophie.toString());
        System.out.println(arrow.toString());
        System.out.println(thomas.toString());
        
        thomas.addToSquadron("Victory", victory);
        thomas.addToSquadron("Sophie", sophie);
        System.out.println(thomas.toString());
        
        //  Print Encounter Information
        System.out.println(brest);
        
        // Ship State Testing 
        System.out.println("State is: " + arrow.getState());
        arrow.setState(ShipState.SUNK);
        System.out.println("State is: " + arrow.getState());
        System.out.println();
        
        // Encounter Testing
         System.out.println("Encounter Type is: " + brest.getType());
         brest.setEncounter(EncounterType.BLOCKADE);
         System.out.println("Encounter Type is: " + brest.getType());
         System.out.println();
        
        // Ship State If Statement Testing
        if (arrow.getState() == ShipState.SUNK) {
            System.out.println(arrow.viewName() + " has sunk");
        }
        
        // Encounter If Statement Testing
        if (brest.getType() == EncounterType.BLOCKADE) {
            System.out.println("Encounter: " + brest.viewLocation() + " has a blockade");
        }
        
    }
    
}
