/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * The class creates a <code>StartNavigation</code> command to look for a 
 * specific place.
 * 
 **/

public class StartNavigation implements Command
{
    private String source;
    private String destination;
    
    /**
     * 
     * @param commandStack 
     *      Checks if the command before could be used to start a navigation
     */
    public StartNavigation(CommandStack commandStack) throws EmptyStackException
    {
        if(commandStack.peek() instanceof FindPlace)
        {
            destination = ((FindPlace)(commandStack.peek())).getDestination();
        }
        
        else if(commandStack.peek() instanceof PlanRoute)
        {
            source = ((PlanRoute)(commandStack.peek())).getSource();
            
            destination = ((PlanRoute)(commandStack.peek())).getDestination();
        }
        
        else if(commandStack.peek() == null)
        {
            System.out.println("\nNo route or destination!");
        }
        
        else
        {
            System.out.println("\nNo route or destination!");
        }
    }
    
    /**
     * 
     * @param stack
     *      Checks if the command belongs in the stack 
     * 
     * @return 
     *      Would return true or false based on whether the command before it is
     * an instance of PlanRoute or FindPlace and StartNavigation.
     * 
     * @Exception
     *      Throws an EmptyStackException if the stack is empty.
     */
    @Override
    public boolean validCommand(CommandStack stack) throws EmptyStackException
    {
        if(stack.isEmpty())
        {
            throw new EmptyStackException();
        }
        
        boolean checkNav = (!(stack.peek() instanceof StartNavigation));
        
        boolean planRoute = (stack.peek() instanceof PlanRoute);
        
        boolean findPlace = (stack.peek() instanceof FindPlace);
        
        return  checkNav && (planRoute || findPlace);
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of the destination or the 
     * destination and the source in long form (for current screen display)
     */
    public String toString()
    {
        if(source == null && destination != null)
        {
            return "Navigating to " + destination;
        }
        
        else
        {
            return "Navigating from " + source + " to " + destination;
        }
    }
    
    /**
     * 
     * @return 
     *      Returns the String representation of the destination or destination 
     * and source in short form (for stack display)
     */
    public String toShortString()
    {
        if(source == null)
        {
            return "->N:" + destination;
        }
        
        else
        {
            return "->N:" + source + "-" + destination;
        }
    }
}