/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * This class creates an interface of the <code>Application</code>.
 * 
 **/

import java.util.*;

public abstract class Application
{
    /**
     * 
     * @param scanner
     *      Reads in input from the scanner to construct a Command and add it 
     * to the CommandStack.
     * 
     * @throws InvalidCommandException
     *      Throws an exception if the argument entered is invalid given the 
     * current state of the stack.
     * 
     * @throws EmptyStackException 
     *      Throws an exception if the stack is empty.
     */
    public abstract void readCommand(Scanner scanner)  throws InvalidCommandException, EmptyStackException;
    
    /**
     * Returns the application to the state it was before the most recent Command.
     * 
     * @throws EmptyStackException 
     *      Throws an exception when the stack is empty.
     */
    public abstract void goBack() throws EmptyStackException;
    
    /**
     * 
     * @return 
     *      Returns the String representation of this Application in long form 
     * (for current screen display) 
     */
    public abstract String toString();
    
    /**
     * 
     * @return 
     *      Returns the String representation of this Application in short form 
     * (for stack display)
     */
    public abstract String getScreenCommand();
}