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
public class Frigate extends Ship {
    //  Fields declared
    private int cannons;
    private Boolean hasPinnace;
    
    //  Constructor Input: Ship Name, Captain Name, Battle Skill, Ship State, Cannons, Has Pinnace
    public Frigate(String n, String captain, int sk, int cannon, Boolean pin, ShipState state) {
        super(n, captain, sk, 0, state); // Set commission fee to zero
        this.cannons = cannon;
        this.hasPinnace = pin;
        super.setCommissionFee(10 * cannons); // Set commission fee 10 * cannons. 
    }
    
    //  Return cannon value
    public int viewCannons() {
        return cannons;
    }
    
    //  Return pinnace boolean
    public Boolean checkPinnace() {
        return hasPinnace;
    }
    
    //  Return ship information
    @Override
    public String toString() {
        String s = "";
        s += "####FRIGATE#####\n";
        s += super.toString();
        s += "Cannons: " + cannons + "\n";
        s += "Pinnace: " + hasPinnace + "\n";
        s += "Ship State: " + super.toStringState() + "\n";
        return s;
    }
    
}
