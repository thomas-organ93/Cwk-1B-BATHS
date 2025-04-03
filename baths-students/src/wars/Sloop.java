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
public class Sloop extends Ship {
    //  Fields declared
    private Boolean hasDoctor;
    
    //  Constructor Input: Ship Name, Captain Name, Commission Fee, Ship State, Has Doctor
    public Sloop(String n, String captain, int fee, Boolean doctor, ShipState state) {
        super(n, captain, 5, fee, state); // Set battle skill = 5
        this.hasDoctor = doctor;
    }
    
    //  Return doctor boolean
    public Boolean checkDoctor() {
        return hasDoctor;
    }
    
    //  Return ship information
    @Override
    public String toString() {
        String s = "";
        s += "####SLOOP#####\n";
        s += super.toString();
        s += "Has Doctor: " + hasDoctor + "\n";
        s += "Ship State: " + super.toStringState() + "\n";
        return s;
    }
}
