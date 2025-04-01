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
    //  Fields declared
    private int id;
    private EncounterType type;
    private String location;
    private int skill;
    private int prize;
    
    
    //  Constructor Input: Encounter Id, Encounter Type, Location, Battle Skill, Winning Prize
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
    
    //  Return encounter type
    public EncounterType getType() {
        return type;
    }
    
    //  Return encounter type (String)
    public String getStringType() {
        return type.toString();
    }
    
    //  Set enounter type
    public void setEncounter(EncounterType type) {
        this.type = type;
    }
    
    //  Return location
    public String viewLocation() {
        return location;
    }
    
    //  Return battle skill
    public int viewSkill() {
        return skill;
    }
    
    //  Return winning prize
    public int viewPrize() {
        return prize;
    }
    
    //  Set winning prize
    public void setPrize(int value) {
        prize = value;
    }
    
    //  Return encounter information
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
