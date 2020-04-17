/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * This class creates an interface of the object <code>CommandStack</code>.
 * 
 **/

import java.util.*;

public class CommandStack
{
    private ArrayList<Command> commandS = new ArrayList<Command>();
    
    private int stackSize = 0;
    
    /**
     * 
     * @return 
     *      Returns the size of the stack.
     */
    public int getStackSize()
    {
        return stackSize;
    }
    
    /**
     * 
     * @param command
     *      Takes in a command to add to the stack.
     * 
     * @throws InvalidCommandException 
     *      Throws an exception when an incorrect argument is entered.
     * 
     * @throws EmptyStackException
     *      Throws it when the stack is empty
     */
    public void push(Command command) throws InvalidCommandException, EmptyStackException
    {
        if(command.validCommand(this))
        {
            commandS.add(command);
            
            stackSize++;
        }
        
        else
        {
            commandS.remove(stackSize - 1);
            
            commandS.add(command);
            
            stackSize++;
        }
    }
    
    /**
     * 
     * @return
     *      Returns the command that is being removed from the stack.
     * 
     * @throws EmptyStackException 
     *      Throws an exception when the stack is empty.
     */
    public Command pop() throws EmptyStackException
    {
     Command temp;
        
        if(this.isEmpty())
        {
            throw new EmptyStackException();
        }
        
        else
        {
            temp = (Command) commandS.get(stackSize - 1);
                    
            commandS.remove(stackSize - 1);
            
            stackSize--;
        }
        
        return temp;
    }
    
    /**
     * 
     * @return 
     *      Returns the topmost Command from the stack without removing it. 
     * The stack is unchanged as a result of this method. 
     * 
     * @throws EmptyStackException
     *      Throws an exception when the stack is empty
     */
    public Command peek() throws EmptyStackException
    {
        Command ret = null;

        if(stackSize > 0)
        {
            throw new EmptyStackException();
        }
        
        else
        {
            ret = (Command)(commandS.get(stackSize - 1));
        }
        
        return ret;
    }
    
    /**
     * 
     * @return 
     *      Returns true if the stack is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return stackSize == 0;
    }
    
    /**
     * 
     * @return 
     *      Returns a String representation of the Command that will be 
     * displayed on the screen.
     */
    public String getScreenCommand()
    {
        String ans = "Current Screen: ";
        
        if(commandS.isEmpty())
        {
            return ans;
        }
        
        else
        {
            ans += (commandS.get(stackSize - 1).toString());
        }
        
        return ans;
    }
    
    /**
     * 
     * @return 
     *      Returns a String representation of this CommandStack. 
     */
    public String toString()
    {
        String ans = "\nStack Debug:\n[Home";
        
        for(Command command: commandS)
        {
            ans += command.toShortString();
        }
        
        return ans;
    }
}