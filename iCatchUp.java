/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * This is the main driver class for the project.
 * 
 **/

import java.util.*;

public class iCatchUp
{
    private static Application mapsApplication;

    private static Application safariApplication;
    
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * The main method runs a menu driven application which allows the user to 
     * create two instances of the Application class and then prompts the user 
     * for input based on which screen it is currently in (Home, Maps, or 
     * Safari). The required information for each command is then requested 
     * from the user based on the selected operation.
     * 
     * @param args 
     */
    public static void main(String [] args)
    { 
            System.out.println("Welcome to the iPhony pocket telegraph simulator. "
                    + "You are on the home screen.");

            homeMenu();
    }
    
    /**
     * 
     * Lets the user choose the different options in the home menu.
     * 
     */
    public static void homeMenu()
    {
        try
        {
            mapsApplication = new MapsApplication();

            safariApplication = new SafariApplication();
        
            System.out.print("\nHome Options:\n\n"
                    + "\tS) Safari\n"
                    + "\tM) Maps\n"
                    + "\tQ) Quit\n\n"
                    + "Please select an option: ");

            String ans = sc.nextLine();

            char an = ans.toUpperCase().charAt(0);

            switch (an)
            {
                case ('S'): safariMenu(safariApplication);
                break;

                case ('M'): mapsMenu(mapsApplication);
                break;

                case ('Q'): System.out.println("Sorry to see you go, tell the iPod "
                        + "I said hi!");
                            System.exit(0);
                break;

                default: throw new InvalidCommandException();
            }
        }
        
        catch (InvalidCommandException e)
        {
            System.out.println("The option you chose is incorrect. Please start again");
            
            homeMenu();
        }
        
        catch (EmptyStackException x)
        {
            System.out.println("The stack is empty.");
            
            homeMenu();
        }
    }
    
    /**
     * 
     * Lets the user choose the different options in the Safari menu.
     * 
     */
    public static void safariMenu(Application sApp) throws InvalidCommandException, EmptyStackException
    {
        System.out.println(sApp.toString() + "\n");
        
        System.out.println(sApp.getScreenCommand());
        
        System.out.println("\nSafari Options:\n"
                + "\tG - Google Something\n"
                + "\tF - Go to a favorite/bookmark\n"
                + "\tL - Follow a link\n"
                + "\tB - Back\n" 
                + "\tS - Switch\n" 
                + "\tH - Home");
        
        sApp.readCommand(sc);
        
        safariMenu(sApp);
    }
    
    /**
     * 
     * Lets the user choose the different options in the Maps menu.
     * 
     */
    public static void mapsMenu(Application mApp) throws InvalidCommandException, EmptyStackException
    {
        System.out.println(mApp.toString() + "\n");
        
        System.out.println(mApp.getScreenCommand());
        
        System.out.println("\nMap Options:\n"
                + "\tF - Find a place\n"
                + "\tP - Plan a route\n"
                + "\tN - Start Navigation\n"
                + "\tB - Back\n" 
                + "\tS - Switch\n" 
                + "\tH - Home");
        
        mApp.readCommand(sc);
        
        mapsMenu(mApp);
    } 
    
    /**
     * 
     * Lets the user switch between the different applications.
     * 
     */
    public static void switchApplication(Application switchThis) throws InvalidCommandException, EmptyStackException
    {
        if(switchThis instanceof MapsApplication)
        {
            safariMenu(safariApplication);
        }
        
        else
        {
            mapsMenu(mapsApplication);
        }
    }
}