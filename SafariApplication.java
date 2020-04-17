/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * This class creates an interface of the object <code>Application</code>.
 * 
 **/

import java.util.*;

public class SafariApplication extends Application 
{
    private CommandStack safariStack = new CommandStack();
    
    public SafariApplication() throws InvalidCommandException, EmptyStackException
    {
        Command h = new HomeCommand("->SafariHome");

        safariStack.push(h);
    }
    
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
    public void readCommand(Scanner scanner) throws InvalidCommandException, EmptyStackException
    {
        System.out.print("Please select what you would like to do: ");
        String option = scanner.nextLine();
        
        Command c = null;
        
        char op = option.toUpperCase().charAt(0);
        
        switch (op)
        {
            case ('G'): 
            {
                c = new GoogleSomething(scanner);
                
                if(c.validCommand(safariStack))
                {
                    safariStack.push(c);
                }

                else
                {
                    if(safariStack.peek() == null)
                    {
                        throw new EmptyStackException();
                    }

                    else
                    {
                        safariStack.pop();
                    }
                }
            }
            break;
            
            case ('L'): 
            {
                c = new FollowLink(scanner);
                
                if(c.validCommand(safariStack))
                {
                    safariStack.push(c);
                }

                else
                {
                    if(safariStack.peek() == null)
                    {
                        throw new EmptyStackException();
                    }

                    else
                    {
                        safariStack.pop();
                    }
                }
            }
            break;
            
            case ('F'): 
            {
                c = new GoToBookmark(scanner);
                
                if(c.validCommand(safariStack))
                {
                    safariStack.push(c);
                }

                else
                {
                    if(safariStack.peek() == null)
                    {
                        throw new EmptyStackException();
                    }

                    else
                    {
                        safariStack.pop();
                    }
                }
            }
            break;
            
            case ('B'): 
            {
                if(safariStack.peek() == null)
                {
                    throw new EmptyStackException();
                }

                else
                {
                    safariStack.pop();
                }
            }
            break;
                    
            case ('H'): iCatchUp.homeMenu();
            break;
            
            case('S'): iCatchUp.switchApplication(this);
            break;
            
            default: throw new InvalidCommandException();
        }
    }
    
    /**
     * Returns the application to the state it was before the most recent Command.
     * 
     * @throws EmptyStackException 
     *      Throws an exception when the stack is empty.
     */
    public void goBack() throws EmptyStackException
    {
        if(safariStack.peek() == null)
        {
            throw new EmptyStackException();
        }
        
        else
        {
            safariStack.pop();
        }
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of this Application in long form 
     * (for current screen display) 
     */
    public String toString()
    {
        return safariStack.toString();
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of this Application in short form 
     * (for stack display)
     */
    public String getScreenCommand()
    {
        if(safariStack.isEmpty())
        {
            return safariStack.getScreenCommand(); 
        }
        else
        {
            return safariStack.getScreenCommand();
        }
    }
}