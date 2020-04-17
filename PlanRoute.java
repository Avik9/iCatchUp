/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class creates a <code>PlanRoute</code> command to create a route.
 * 
 **/

import java.util.*;

public class PlanRoute implements Command
{
    private String source;
    private String destination;
    
    /**
     * 
     * @param scanner 
     *      Constructs this PlanRoute instance accordingly after reading input from the scanner.
     */
    public PlanRoute(Scanner scanner)
    {
        System.out.print("Please enter a source: ");
        this.source = scanner.nextLine();
        
        System.out.print("Please enter a destination: ");
        this.destination = scanner.nextLine();
    }
    
     /**
     * 
     * @return 
     *      Returns the source within the Command.
     */
    public String getSource()
    {
        return this.source;
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
     *      Checks if the command belongs in the stack.
     * 
     * @return 
     *      Returns whether or not pushing this PlanRoute command will be valid
     * for the given stack.     */
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
        return "Planning route from " + this.source + " to " + this.destination;
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of this Command in short form
     * (for stack display).    
     */
    public String toShortString()
    {
        return "->P:" + this.source + "-" + this.destination;
    }
}