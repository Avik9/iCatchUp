/**
 * 
 * @author Avik Kadakia
 * email:avik.kadakia@stonybrook.edu
 * Stony Brook ID: 111304945
 * 
 * Class: CSE 214.02
 * Recitation: CSE 214 - R.14
 * 
 * Holds all the Exceptions in the project.
 * 
 **/
public class Exceptions 
{
    
}

/**
 * 
 * An Exception class that is thrown when trying to push a Command that is not 
 * valid for the given CommandStack.
 */
class InvalidCommandException extends Exception
{

}

/**
 * 
 * An Exception class that is thrown when trying to pop from a stack with no 
 * elements.
 */
class EmptyStackException extends Exception
{

}