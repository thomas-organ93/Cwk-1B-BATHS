package wars;

import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from the BATHS
 system as required for 5COM2007 Cwk1B BATHS - Feb 2025
 * 
 * @author A.A.Marczyk, Nathan-McEvoy, Jordan Anyanwu
 * @version 02/04/25
 */

public class SeaBattles implements BATHS 
{
    // may have one HashMap and select on stat

    private BlueAdmiral admiral;
    private HashMap<String, Ship> reserveFleet;
    private HashSet<Encounter> encounters;

//**************** BATHS ************************** 
    /** Constructor requires the name of the admiral
     * @param admiral the name of the admiral
     */  
    public SeaBattles(String adm)
    {
      this.admiral = new BlueAdmiral(adm, 1000.0);
      this.reserveFleet = new HashMap<>();
      this.encounters = new HashSet<>();
        
       setupShips();
       setupEncounters();
    }
    
    /** Constructor requires the name of the admiral and the
     * name of the file storing encounters
     * @param admiral the name of the admiral
     * @param filename name of file storing encounters
     */  
    public SeaBattles(String admir, String filename)  //Task 3
    {
      this.admiral = new BlueAdmiral(admir, 1000.0);
      this.reserveFleet = new HashMap<>();
      this.encounters = new HashSet<>();
        
       setupShips();
       // setupEncounters();
       // uncomment for testing Task 
       readEncounters(filename);
    }
    
    
    /**Returns a String representation of the state of the game,including the name of the 
     * admiral, state of the warChest,whether defeated or not, and the ships currently in 
     * the squadron,(or, "No ships" if squadron is empty), ships in the reserve fleet
     * @return a String representation of the state of the game,including the name of the 
     * admiral, state of the warChest,whether defeated or not, and the ships currently in 
     * the squadron,(or, "No ships" if squadron is empty), ships in the reserve fleet
     **/
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Admiral: ").append(admiral).append("\n");
        s.append("War Chest: ").append((int) admiral.getWarChest()).append("\n");
        s.append("Defeated: ").append(isDefeated() ? "Yes" : "No").append("\n\n");
        s.append("Squadron: ");

        HashMap<String, Ship> squadron = admiral.getSquadron();
        if (squadron.isEmpty()) {
            s.append("No ships\n");
        } else {
            for (Ship ship : squadron.values()) {
                s.append(ship.toString()).append("\n");
            }
        }

        s.append("\nReserve Fleet: ").append(getReserveFleet()).append("\n\n");
        s.append("Sunk ships:\n").append(getSunkShips());

        return s.toString().trim();
    }
    
    
    /** returns true if War Chest <=0 and the admiral's squadron has no ships which 
     * can be retired. 
     * @returns true if War Chest <=0 and the admiral's fleet has no ships 
     * which can be retired. 
     */
    public boolean isDefeated()
    {
        if (admiral.getWarChest() > 0) return false;
        
        HashMap<String, Ship> squadron = admiral.getSquadron();
        for (String i: squadron.keySet())
        {
            ShipState stateOfShip = squadron.get(i).getState();
            if (stateOfShip == ShipState.ACTIVE || stateOfShip == ShipState.RESTING)
            {
                return false;
            }
        }
        
        return true;
    }
    
    /** returns the amount of money in the War Chest
     * @returns the amount of money in the War Chest
     */
    public double getWarChest()
    {
        return admiral.getWarChest();
    }
    
    
    /**Returns a String representation of all ships in the reserve fleet
     * @return a String representation of all ships in the reserve fleet
     **/
    public String getReserveFleet()
    {   //assumes reserves is a Hashmap
        String s = "";
        s += "All Reserve Ships:\n";
        if (reserveFleet.isEmpty()) {
            s += "[No Ships Available]\n"; // For testing. Should be impossible.
        } else {
            for (Ship ship : reserveFleet.values()) {
                s += ship.toString();
            }
        }
        return s;
    }
    
    /**Returns a String representation of the ships in the admiral's squadron
     * or the message "No ships commissioned"
     * @return a String representation of the ships in the admiral's fleet
     **/
    public String getSquadron()
    {
        if (!admiral.getSquadron().isEmpty())
        {
            StringBuilder s = new StringBuilder();
            HashMap<String, Ship> squadron = admiral.getSquadron();

            for (String i: squadron.keySet())
            {
                s.append(squadron.get(i).toString()).append("\n");
                
            }
            return s.toString().trim();
        }
        
        return "No ships commissioned";
        
    }
    
    /**Returns a String representation of the ships sunk (or "no ships sunk yet")
     * @return a String representation of the ships sunk
     **/
    public String getSunkShips()
    {
        StringBuilder result = new StringBuilder();
        HashMap<String, Ship> squadron = admiral.getSquadron();

        for (Ship ship : squadron.values()) {
            if (ship.getState() == ShipState.SUNK) {
                result.append(ship.toString()).append("\n");
            }
        }

        if (result.length() > 0) {
            return result.toString().trim();
        } else {
            return "no ships sunk yet";
        }
    }
    
    /**Returns a String representation of the all ships in the game
     * including their status
     * @return a String representation of the ships in the game
     **/
    public String getAllShips()
    {
       String s = "";
       s += getReserveFleet(); // To avoid duplication..
       
       s += "All Owned Ships:\n";
       if (admiral.getSquadron().isEmpty()) {
           s += "[No Ships Available]\n";
       } else {
           for (Ship ship : admiral.getSquadron().values()) {
               s += ship.toString();
           }
       }
       return s;
    }
    
    
    /** Returns details of any ship with the given name
     * @return details of any ship with the given name
     **/
    public String getShipDetails(String nme)
    {
        HashMap<String, Ship> squadron = admiral.getSquadron();

        if (squadron.containsKey(nme)) {
            Ship ship = squadron.get(nme);
            return ship.toString();
        }   else {
            return "No such ship";
        }
    }

    // ***************** Fleet Ships ************************   
    /** Allows a ship to be comissioned to the admiral's squadron, if there 
     * is enough money in the War Chest for the commission fee.The ship's 
     * state is set to "active"
     * @param nme represents the name of the ship
     * @return "Ship commissioned" if ship is commissioned, "Not found" if 
     * ship not found, "Not available" if ship is not in the fleet, "Not 
     * enough money" if not enough money in the warChest
     **/        
    public String commissionShip(String nme)
    {
        Ship ship = reserveFleet.get(nme);

        if (ship == null) {
            return "Not found";
        } else if (!ship.getState().equals("available")) {
            return "Not available";
        } else if (admiral.getWarChest() < ship.getCommissionFee()) {
            return "Not enough money";
        } else {
            Shipstate.setState(" ACTIVE ");
            admiral.getSquadron().put(nme, ship);
            admiral.setWarChest(admiral.getWarChest() - ship.getCommissionFee());
            return "Ship commissioned";
        }
    }
        
    /** Returns true if the ship with the name is in the admiral's squadron, false otherwise.
     * @param nme is the name of the ship
     * @return returns true if the ship with the name is in the admiral's squadron, false otherwise.
     **/
    public boolean isInSquadron(String nme)
    {
        HashMap<String, Ship> squadron = admiral.getSquadron();
        if (squadron.containsKey(nme)) return true;
        return false;
    }
    
    /** Decommissions a ship from the squadron to the reserve fleet (if they are in the squadron)
     * pre-condition: isInSquadron(nme)
     * @param nme is the name of the ship
     * @return true if ship decommissioned, else false
     **/
    public boolean decommissionShip(String nme)
    {
        return false;
    }
    
  
    /**Restores a ship to the squadron by setting their state to ACTIVE 
     * @param the name of the ship to be restored
     */
    public void restoreShip(String ref)
    {
  
        
    }
    
//**********************Encounters************************* 
    /** returns true if the number represents a encounter
     * @param num is the reference number of the encounter
     * @returns true if the reference number represents a encounter, else false
     **/
     public boolean isEncounter(int num)
     {
         for (Encounter encounter : encounters) {
             if (encounter.viewId() == num) {
                 return true;
             }
         }
         return false;
     }



    /** Retrieves the encounter represented by the encounter 
      * number.Finds a ship from the fleet which can fight the 
      * encounter. The results of fighting an encounter will be 
      * one of the following: Encounter won by...(ship reference and name) 
      *  add prize money to War Chest and ship's state is set to RESTING,  Encounter 
      * lost as no ship available  deduct prize money from the War Chest,Encounter 
      * lost on battle skill level and (ship name) sunk/lost" - deduct prize money from 
      * War Chest and ship state set to sunk. If an encounter is lost and admiral 
      * is completely defeated, add �You have been defeated  to the output.
      * Ensure that the state of the war chest is also included in the return message.
      * @param encNo is the number of the encounter
      * @return a String showing the result of fighting the encounter
      */ 
    public String fightEncounter(int encNo)
    {
       
            
        return "Not done";
    }

    /** Provides a String representation of an encounter given by 
     * the encounter number
     * @param num the number of the encounter
     * @return returns a String representation of a encounter given by 
     * the encounter number
     **/
    public String getEncounter(int num)
    {
        
        return "\nNo such encounter";
    }
    
    /** Provides a String representation of all encounters 
     * @return returns a String representation of all encounters
     **/
    public String getAllEncounters()
    {
        if (encounters.isEmpty()) {
         return "No encounters";
        }
        String result = "";
        
        for (Encounter enc : encounters.values()) {
         result += enc.toString() + "\n";
        } 

        if (result.length() > 0) {
         result = result.substring(0, result.length() -1);
        }

        return result;
    }
    

    //****************** private methods for Task 4 functionality*******************
    //*******************************************************************************
     private void setupShips()
     {
       

     }
     
    private void setupEncounters()
    {
  
    }
        
    // Useful private methods to "get" objects from collections/maps

    //*******************************************************************************
    //*******************************************************************************
  
    /************************ Task 3 ************************************************/

    
    //******************************** Task 3.5 **********************************
    /** reads data about encounters from a text file and stores in collection of 
     * encounters.Data in the file is editable
     * @param fileName name of the file to be read
     */
    public void readEncounters(String filename)
{
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            // Assuming each line in the file represents an encounter
            // and the line format is compatible with the Encounter constructor.
            Encounter encounter = new Encounter(line);
            encounters.add(encounter);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
 
    
    // ***************   file write/read  *********************
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    public void saveGame(String fname)
    {   // uses object serialisation 
          GameFileHandler.saveGame(this, fname); 
    }
    
    /** reads all information about the game from the specified file 
     * and returns 
     * @param fname name of file storing the game
     * @return the game (as an SeaBattles object)
     */
    public SeaBattles loadGame(String fname)
    {   // uses object serialisation 
       
        return GameFileHandler.loadGame(fname);
    } 
    
 
}



