/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class creates a <code>FollowLink</code> command to go to a link.
 * 
 **/

import java.util.*;

public class FollowLink implements Command 
{
    private String link;
    
    /**
     * 
     * @param scanner 
     *      Takes in a scanner to add a link to follow in the command.
     */
    public FollowLink (Scanner scanner)
    {
        System.out.print("\nPlease enter an link: ");
        link = scanner.nextLine();
    }
    
    /**
     * 
     * @param stack
     *      Checks if the command belongs in the stack 
     * 
     * @return 
     *      Would always return true because the FollowLink always belongs in 
     * the stack.
     */
    @Override
    public boolean validCommand(CommandStack stack) throws EmptyStackException
    {
        if(stack.isEmpty())
        {
            throw new EmptyStackException();
        }
        
        boolean bookmark = (stack.peek() instanceof GoToBookmark);
        
        boolean google = (stack.peek() instanceof GoogleSomething);
        
        return (bookmark || google);
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of the bookmark in long form 
     * (for current screen display)
     */
    @Override
    public String toShortString()
    {
        return "->L:" + link;
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of the bookmark in short form 
     * (for stack display)
     */
    @Override
    public String toString()
    {
        return link;
    }
}