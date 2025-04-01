/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wars;

/**
 *
 * @author thomasorgan
 */
public class Encounter {
    private int id;
    private EncounterType type;
    private String location;
    private int skill;
    private int prize;
    
    
    public Encounter(int id, EncounterType type, String location, int skill, int prize) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.skill = skill;
        this.prize = prize;
    }
    
    //  Return Id
    public int viewId() {
        return id;
    }
    
    // Return encounter type
    public EncounterType getType() {
        return type;
    }
    
    // Return encounter type (String)
    public String getStringType() {
        return type.toString();
    }
    
    // Set enounter type
    public void setEncounter(EncounterType type) {
        this.type = type;
    }
    
    public String viewLocation() {
        return location;
    }
    
    public int viewSkill() {
        return skill;
    }
    
    public int viewPrize() {
        return prize;
    }
    
    public void setPrize(int value) {
        prize = value;
    }
    
    
    public String toString() {
        String s = "";
        s = s + "####ENCOUNTER####\n";
        s = s + "Encounter No: " + id + "\n";
        s = s + "Type: " + type.toString() + "\n";
        s = s + "Location: " + location + "\n";
        s = s + "Battle Skill: " + skill + "\n";
        s = s + "Prize Money: " + prize + "\n";
        return s;
    }
    
}
