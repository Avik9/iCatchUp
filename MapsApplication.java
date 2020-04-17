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

public class MapsApplication extends Application 
{
    private CommandStack mapsStack = new CommandStack();
    
    public MapsApplication() throws InvalidCommandException, EmptyStackException
    {
        Command h = new HomeCommand("->MapsHome");

        mapsStack.push(h);
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
            case ('F'): 
            {
                c = new FindPlace(scanner);
                
                if(c.validCommand(mapsStack))
                {
                    mapsStack.push(c);
                }

                else
                {
                    if(mapsStack.peek() == null)
                    {
                        throw new EmptyStackException();
                    }

                    else
                    {
                        mapsStack.pop();
                    }
                }
            }
            break;
            
            case ('P'): 
            {
                c = new PlanRoute(scanner);
                
                if(c.validCommand(mapsStack))
                {
                    mapsStack.push(c);
                }

                else
                {
                    if(mapsStack.peek() == null)
                    {
                        throw new EmptyStackException();
                    }

                    else
                    {
                        mapsStack.pop();
                    }
                }
            }
            break;
            
            case ('N'):
            {
                c = new StartNavigation(mapsStack);
                
                if(c.validCommand(mapsStack))
                {
                    mapsStack.push(c);
                }

                else
                {
                    if(mapsStack.peek() == null)
                    {
                        throw new EmptyStackException();
                    }

                    else
                    {
                        mapsStack.pop();
                    }
                }
            }
            break;
            
            case ('B'):
                if(mapsStack.peek() == null)
                {
                    throw new EmptyStackException();
                }

                else
                {
                    mapsStack.pop();
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
    @Override
    public void goBack() throws EmptyStackException
    {
        if(mapsStack.peek() == null)
        {
            throw new EmptyStackException();
        }
        
        else
        {
            mapsStack.pop();
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
        return mapsStack.toString();
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of this Application in short form 
     * (for stack display)
     */
    public String getScreenCommand()
    {
        if(mapsStack.isEmpty())
        {
            return mapsStack.getScreenCommand() + "Maps Home"; 
        }
        else
        {
            return mapsStack.getScreenCommand();
        }
    }
}