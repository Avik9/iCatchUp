/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14 
 *  
 * The class creates a <code>GoToBookmark</code> command to go to a bookmark/link.
 *
 **/

import java.util.*;
        
public class GoToBookmark implements Command
{
    public String bookmark;
    
    /**
     * 
     * @param scanner 
     *      Takes in a scanner to add a bookmark in the command.
     */
    public GoToBookmark(Scanner scanner)
    {
        System.out.print("\nPlease enter bookmark name: ");
        bookmark = scanner.nextLine();
    }
    
    /**
     * 
     * @param stack
     *      Checks if the command belongs in the stack 
     * 
     * @return 
     *      Would always return true because the GoToBookmark always belongs in 
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
     *      Returns the String representation of the bookmark in long form 
     * (for current screen display)
     */
    @Override
    public String toString()
    {
        return bookmark;
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of the bookmark in short form 
     * (for stack display)
     */
    @Override
    public String toShortString()
    {
        return "->F:" + bookmark;
    }
}