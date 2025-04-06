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
        System.out.println(john.toString());
        // Show all ships
        System.out.println(john.getAllShips());
        

       

    }
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest1();
    }
    
}
