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

    // Input: Ship Name, Captain Name, Battle Skill, Commission Fee
    public Ship(String n, String captain, int sk, int fee) {
        this.name = n;
        this.captainName = captain;
        this.commissionFee = fee;
        this.skill = sk;
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
