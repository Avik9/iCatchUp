/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class creates a <code>GoogleSomething</code> command to Google something.
 * 
 **/

import java.util.*;

public class GoogleSomething implements Command
{
    public String query;
    
    /**
     * 
     * @param scanner 
     *      Takes in a scanner to add a query in the command.
     */
    public GoogleSomething(Scanner scanner)
    {
        System.out.print("\nPlease enter a query: ");
        query = scanner.nextLine();
    }
    
    /**
     * 
     * @param stack
     *      Checks if the command belongs in the stack.
     * 
     * @return 
     *      Would always return true because the GoogleSomething always belongs in 
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
     *      Returns the String representation of the query in long form 
     * (for current screen display)
     */
    public String toString()
    {
        return "Google: " + query;
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of the query in short form 
     * (for stack display)
     */
    public String toShortString()
    {
        return "->G:" + query;
    }
}