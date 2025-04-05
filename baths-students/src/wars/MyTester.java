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
        
        SeaBattles john = new SeaBattles("John");
        
//        System.out.println(john.toString());
//        System.out.println(john.getAllShips());
//        System.out.println(john.getReserveFleet());

//        System.out.println(john.getShipDetails("Sophie"));
        john.commissionShip("Victory");
        john.commissionShip("Beast");
//        System.out.println(john.getShipDetails("Sophie"));
//        System.out.println(john.toString());
        john.fightEncounter(7);
        System.out.println(john.fightEncounter(7));

       

    }
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest1();
    }
    
}
