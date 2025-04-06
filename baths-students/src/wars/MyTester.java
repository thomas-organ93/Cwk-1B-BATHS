/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author thomasorgan
 */
public class MyTester {
    
    private void doTest1() {
        // Create Admiral 
        SeaBattles john = new SeaBattles("John");
        // Show Admiral and Ship details
        
        // Test ManOWar fighting a Skirmish
        john.commissionShip("Victory");
        System.out.println(john.toString());
        System.out.println(john.fightEncounter(2));
        System.out.println(john.toString());
        
        // Test Sloop fighting a Blockade
        john.commissionShip("Arrow");
        System.out.println(john.toString());
        System.out.println(john.fightEncounter(3));
        System.out.println(john.toString());
        
        // Test Frigate (no pinnace) fighting a Blockade
        john.commissionShip("Jupiter");
        System.out.println(john.toString());
        System.out.println(john.fightEncounter(3));
        System.out.println(john.toString());
        
        // Test Frigate (pinnace) fighting a Blockade
        john.commissionShip("Sophie");
        System.out.println(john.toString());
        System.out.println(john.fightEncounter(3));
        System.out.println(john.toString());
        
        // Decommission a resting ship
        john.decommissionShip("Sophie");
        System.out.println(john.toString());
        
        // Test Losing the game 
        System.out.println(john.fightEncounter(4));
        System.out.println(john.fightEncounter(4));
        john.restoreShip("Victory");
        System.out.println(john.fightEncounter(4));
       

    }
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest1();
    }
    
}
