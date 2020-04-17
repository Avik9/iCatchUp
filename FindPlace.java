/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class creates a <code>FindPlace</code> command to look for a specific place.
 * 
 **/

import java.util.*;

public class FindPlace implements Command 
{
    private String destination;
    
    /**
     * 
     * @param scanner 
     *      Constructs this FindPlace instance accordingly using the Scanner.
     */
    public FindPlace(Scanner scanner)
    {
        System.out.print("\nPlease enter the place to find: ");
        this.destination = scanner.nextLine();
    }
    
    /**
     * 
     * @return 
     *      Returns the destination within the Command.
     */
    public String getDestination()
    {
        return this.destination;
    }
    
    /**
     * 
     * @param stack
     *      Checks if the command belongs in the stack 
     * 
     * @return 
     *      Returns whether or not pushing this FindPlace command will be valid 
     * for the given stack.
     */
    @Override
    public boolean validCommand(CommandStack stack)
    {
        return true;
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of this Command in long form 
     * (for current screen display)
     */
    public String toString()
    {
        return "Showing results for " + destination;
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of the Command in short form 
     * (for stack display)
     */
    public String toShortString()
    {
        return "->F:" + destination;
    }
}