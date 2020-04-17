/**
 *
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 *  
 * This class creates an interface of the object <Code>Command</code>.
 * 
 **/

public interface Command 
{   
    /**
     * 
     * @param stack
     *      Returns whether this Command is valid and can be added to the given 
     * CommandStack.
     * 
     * @return 
     *      Returns whether the command belongs in there or not.
     * 
     * @throws EmptyStackException
     *      Throws an exception if the the stack is empty.
     */
    public boolean validCommand(CommandStack stack) throws EmptyStackException;
    
    /**
     * 
     * @return 
     *      Returns the String representation of this Command in long form 
     * (for current screen display) 
     */
    @Override
    public String toString();
    
    /**
     * 
     * @return 
     *      Returns the String representation of this Command in short form 
     * (for stack display)
     */
    public String toShortString();
}