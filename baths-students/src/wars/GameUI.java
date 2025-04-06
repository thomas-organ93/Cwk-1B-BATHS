package wars;

import java.io.*;
import java.util.*;
/**
 * Task 2 - provide command line interface
 * 
 * @author A.A.Marczyk, Thomas Organ, Jordan Anyanwu, Nathan McEvoy
 * @version 06/04/25
 */
public class GameUI
{
    private BATHS myBattles ;
    private Scanner myIn = new Scanner(System.in);

    public void doMain()
    {
        int choice;
        System.out.println("Enter admiral's name");
        String name = myIn.nextLine().trim();
        
        // Choice of start
        System.out.println("How would you like to start the game?");
        System.out.println("1. New game with default encounters");
        System.out.println("2. New game with encounters from encountersAM.txt");
        int startChoice = -1;
        while (startChoice < 1 || startChoice > 2)
        {
            System.out.println("Enter 1 or 2:");
            startChoice = myIn.nextInt();
            myIn.nextLine();
        }
        if (startChoice == 1)
        {
            myBattles = new SeaBattles(name);
            System.out.println("Starting new game with default encounters");
        }
        else
        {
            myBattles = new SeaBattles(name, "encountersAM.txt");
            System.out.println("Starting new game with encounters from encountersAM.txt");
        }
        
        String defaultFileName = name + ".dat";
        
        choice = 100;
        while (choice != 0 )
        {
            choice = getMenuItem();
            if (choice == 1)
            {
                System.out.println(myBattles.getReserveFleet());
            }
            else if (choice == 2)
            {
                System.out.println(myBattles.getSquadron());
            }
            else if (choice == 3)
            {
                System.out.println("Enter Ship name");
                myIn.nextLine();
                String ref = (myIn.nextLine()).trim();
                System.out.println(myBattles.getShipDetails(ref));
            } 
            else if (choice == 4)
            {
                //Commission a Ship
                System.out.println("Enter Ship Name");
                myIn.nextLine();
                String ref4 = (myIn.nextLine()).trim();
                System.out.println(myBattles.commissionShip(ref4));
            }
            else if (choice == 5)
            {
               //Fight an encounter
                System.out.println(myBattles.getAllEncounters() + "\n");
                System.out.println("Select from Encounter No:");
                int ref5 = (myIn.nextInt());
                myIn.nextLine();
                System.out.println(myBattles.fightEncounter(ref5));
            }
            else if (choice ==6)
            {
                //Restore a Ship
                System.out.println("Enter Ship name");
                myIn.nextLine();
                String ref6 = (myIn.nextLine()).trim();
                myBattles.restoreShip(ref6);
            }
            else if (choice == 7)
            {
                //Decommission a Ship
                System.out.println("Enter Ship name");
                myIn.nextLine();
                String ref7 = (myIn.nextLine()).trim();
                if (myBattles.decommissionShip(ref7)) {
                    System.out.println(ref7 + " has been decommissioned\n");
                } else {
                    System.out.println("Cannot be decommissioned\n");
                }
            }
            else if (choice==8)
            {
                System.out.println(myBattles.toString());
            }
            else if (choice == 9)
            {
                // Save the game
                System.out.println("Save game: Enter filename or press [Enter] for default:");
                myIn.nextLine();
                String saveName = myIn.nextLine().trim();
                if (saveName.isEmpty())
                {
                    myBattles.saveGame(defaultFileName);
                }
                else 
                {
                    if (!saveName.endsWith(".dat"))
                    {
                        saveName += ".dat";
                    }
                    myBattles.saveGame(saveName);
                }
           }
           else if (choice == 10) // Load the game
           {
               // Load the game
               System.out.println("Load game: Enter filename or press [Enter] for default:");
               myIn.nextLine();
               String loadName = myIn.nextLine().trim();
               if (loadName.isEmpty())
               {
                   SeaBattles loaded = myBattles.loadGame(defaultFileName);
                   if (loaded != null)
                   {
                       myBattles = loaded;
                       System.out.println("Loaded game state:\n" + myBattles.toString());
                   }
                   else
                   {
                       System.out.println("Failed to load game from " + defaultFileName);
                   }
               }
               else
               {
                   if (!loadName.endsWith(".dat"))
                   {
                       loadName += ".dat";
                   }
                   SeaBattles loaded = myBattles.loadGame(loadName);
                   if (loaded != null)
                   {
                       myBattles = loaded;
                       System.out.println("Loaded game state:\n" + myBattles.toString());
                   }
                   else
                   {
                       System.out.println("Failed to load game from " + defaultFileName);
                   }
               }
            }
        }
        System.out.println("Thank-you");
    }
    
    private int getMenuItem()
    {   int choice = 100;  
        System.out.println("Main Menu");
        System.out.println("0. Quit");
        System.out.println("1. List ships in the reserve fleet");
        System.out.println("2. List ships in admirals squadron"); 
        System.out.println("3. View a ship");
        System.out.println("4. Commission a ship into admiral's squadron");
        System.out.println("5. Fight an encounter");
        System.out.println("6. Restore a ship");
        System.out.println("7. Decommission a ship");
        System.out.println("8. View admiral's state");
        System.out.println("9. Save this game");
        System.out.println("10. Restore a game");
       
        
        while (choice < 0 || choice  > 10)
        {
            System.out.println("Enter the number of your choice");
            choice =  myIn.nextInt();
        }
        return choice;        
    } 
    
    public static void main(String[] args)
    {
        GameUI xxx = new GameUI();
        xxx.doMain();
    }
}
