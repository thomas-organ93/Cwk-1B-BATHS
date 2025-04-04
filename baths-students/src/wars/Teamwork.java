package wars; 


/**
 * Details of your team
 * 
 * @author (Jordan Anyanwu) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "CWK1B CS56";
        
        details[1] = "Organ";
        details[2] = "Thomas";
        details[3] = "22017656";

        details[4] = "Ali";
        details[5] = "Awab";
        details[6] = "20049220";

        details[7] = "McEvoy";
        details[8] = "Nathan";
        details[9] = "20052541";


        details[10] = "Anyanwu";
        details[11] = "Jordan";
        details[12] = "21037141";

	
	   // only if applicable
        details[13] = "surname of member5";
        details[14] = "first name of member5";
        details[15] = "SRN of member5";


    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
