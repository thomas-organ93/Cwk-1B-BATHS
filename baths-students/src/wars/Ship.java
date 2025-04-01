/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author thomasorgan
 */
public class Ship {
    // Fields declared
    private String name;
    private String captainName;
    private int commissionFee;
    private int skill;
    private ShipState state; // ShipState Class

    // Input: Ship Name, Captain Name, Battle Skill, Commission Fee, Ship State
    public Ship(String name, String captain, int skill, int fee, ShipState state) {
        this.name = name;
        this.captainName = captain;
        this.commissionFee = fee;
        this.skill = skill;
        this.state = state;
    }

    // Return ship name
    public String viewName() {
        return name;
    }

    // Return captain name
    public String viewCaptain() {
        return captainName;
    }
    
    // Return commission fee
    public int getCommissionFee() {
        return commissionFee;
    }
    
    // Set commission fee
    public void setCommissionFee(int fee) {
        commissionFee = fee;
    }
    
    // Return ship state
    public ShipState getState() {
        return state;
    }
    
    // Return ship state string
    public String toStringState() {
        return state.toString();
    }
    
    // Set ship state
    public void setState(ShipState state) {
        this.state = state;
    }

    public String toString() {
        String s = "";
        s = s + "####SHIP####\n";
        s = s + "Ship Name: " + name + "\n";
        s = s + "Captain: " + captainName + "\n";
        s = s + "Battle Skill: " + skill + "\n";
        s = s + "Commission Fee: " + commissionFee + "\n";
        return s;
    }
}
