/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The <code>HomeCommand</code> class implements Command to add the home name.
 * 
 **/

public class HomeCommand implements Command
{
    public String name = "";
    
    /**
     * 
     * @param newName 
     *      Changes the name of the command to the one in newName.
     */
    public HomeCommand(String newName)
    {
        name = newName;
    }
    
    /**
     * 
     * @param stack
     *      Checks if the command belongs in the stack 
     * 
     * @return 
     *      Would always return true because the HomeCommand always belongs in 
     * the stack.
     */
    @Override
    public boolean validCommand(CommandStack stack)
    {
        return true;
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of the name in long form 
     * (for current screen display)
     */
    public String toShortString()
    {
        return name;
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of the name in short form 
     * (for stack display)
     */
    public String toString()
    {
        if(name.equals("->MapsHome"))
        {
            return "Maps Home";
        }
        
        else
        {
            return "Safari Home";
        }
    }
}
