/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author thomasorgan
 */
public class Sloop extends Ship {
    // Fields declared
    private Boolean hasDoctor;
    
    // Input: Ship Name, Captain Name, Commission Fee, Has Doctor
    public Sloop(String n, String captain, int fee, Boolean doctor) {
        super(n, captain, 5, fee); // Set battle skill = 5
        this.hasDoctor = doctor;
    }
    
    // Return doctor boolean
    public Boolean checkDoctor() {
        return hasDoctor;
    }
    
    @Override
    public String toString() {
        String s = "";
        s = s + "####SLOOP#####\n";
        s = s + super.toString();
        s = s + "Has Doctor: " + hasDoctor + "\n";
        return s;
    }
}
