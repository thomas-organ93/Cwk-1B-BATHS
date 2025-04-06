package wars; 


/**
 * Details of your team
 * 
 * @author Jordan Anyanwu 
 * @version 04/04/25
 */
public class Teamwork
{
    private String[] details = new String[13];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "CWK1B CS56";
        
        details[1] = "Ali";
        details[2] = "Awab";
        details[3] = "20049220";
        
        details[4] = "Anyanwu";
        details[5] = "Jordan";
        details[6] = "21037141";
        
        details[7] = "McEvoy";
        details[8] = "Nathan";
        details[9] = "20052541";
        
        details[10] = "Organ";
        details[11] = "Thomas";
        details[12] = "22017656";

       

	
	   // only if applicable
//        details[13] = "surname of member5";
//        details[14] = "first name of member5";
//        details[15] = "SRN of member5";


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
        
