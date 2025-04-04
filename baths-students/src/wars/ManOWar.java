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
public class ManOWar extends Ship {
    //  Fields declared
    private int decks;
    private int marines;
    
    //  Constructor Input: Ship Name, Captain Name, Battle Skill, Ship State, Decks, Marines
    public ManOWar(String n, String captain, int sk, int deck, int m, ShipState state) {
        super(n, captain, sk, 500, state); // Set commission fee = 500
        this.decks = deck;
        this.marines = m;
        
        if (deck <= 2) {
            super.setCommissionFee(300); // Set commission to 300
        }
    }
    
    //  Return decks value
    public int viewDecks() {
        return decks;
    }
    
    //  Return marines value
    public int viewMarines() {
        return marines;
    }
    
    //  Return ship information
    @Override
    public String toString() {
        String s = "";
        s += "####MAN-O-WAR#####\n";
        s += super.toString();
        s += "Decks: " + decks + "\n";
        s += "Marines: " + marines + "\n";
        s += "Ship State: " + super.toStringState() + "\n";
        return s;
    }
    
}
