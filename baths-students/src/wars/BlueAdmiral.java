/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package wars;

import java.io.*;
import java.util.HashMap;

/**
 *
 * @author Nathan-McEvoy
 * @version 02/04/25
 */
public class BlueAdmiral implements Serializable
{
    private double warChest;
    private String name;
    private HashMap<String, Ship> squadron;
    
    public BlueAdmiral(String name, double warChestAmount)
    {
        this.name = name;
        this.warChest = warChestAmount;
        this.squadron = new HashMap<>();
    }
    
    /** returns name of BlueAdmiral as String
     * @returns name of BlueAdmiral as String
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * returns amount in warChest as Double
     * @return amount in warChest as Double
     */
    public double getWarChest()
    {
        return warChest;
    }
    
    /**
     * returns the squadron as HashMap<String, Ship>
     * @return the squadron as HashMap<String, Ship>
     */
    public HashMap<String, Ship> getSquadron()
    {
        return squadron;
    }
    
    /**
     * modifies the amount in the warChest
     * @param amount is the amount to change (+/-)
     */
    public void changeWarChestAmount(double amount)
    {
        warChest += amount;
    }
    
    /**
     * adds a Ship to the squadron
     * @param shipName is the name of the ship
     * @param ship is the Ship to add
     */
    public void addToSquadron(String shipName, Ship ship)
    {
        squadron.put(shipName, ship);
    }
    
    /**
     * modifies the State of the specified Ship
     * @param shipName is the name of the ship to change State of
     * @param state is the State to change the Ship to
     */
    public void changeShipState(String shipName, ShipState state)
    {
        if (squadron.containsKey(shipName))
        {
            Ship ship = squadron.get(shipName);
            ship.setState(state);
        }
    }
    
    /**
     * returns Boolean on the condition of unsunk ships.
     * @return if have decommissionable ships as Boolean
     */
    public boolean hasDecommissionableShips() {
        if (!squadron.isEmpty()) {
            for (Ship ship : squadron.values()) {
                if (ship.getState() != ShipState.SUNK) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * returns a string containing the Admiral's name, warChest, status and squadron
     * @return a string containing the Admiral's name, warChest, status and squadron
     */
    public String toString()
    {
        String ships = String.join(", ", squadron.keySet());
        return "####ADMIRAL####\n" 
                + "Name: " + name + "\n"
                + "War Chest: " + warChest + "\n"
                + "Status: " + (!hasDecommissionableShips() && warChest <= 0 ? "You lost your job" : "Is OK") + "\n"
                + "Squadron: " + (squadron.isEmpty() ? "[No Ships]" : ships) + "\n";
    }
    
}
