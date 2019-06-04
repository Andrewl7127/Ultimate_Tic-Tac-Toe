import javafx.scene.Node;
import java.util.*;
/**
 * Decomposition of the square graphics class, helps interaction between
 * classes
 *
 * @author (Birla, Chang, Chung ,Liu)
 * @version (1.0)
 */
public class Square
{
    //the graphics of the square
    private SquareGraphics mySquare;
    //the number that tells us where the little square is
    private int input;
    //status of each square (x, o, " ")
    private String myStatus;
    //the game
    private Play myGame;
    
    /**
     * Constructor for objects of class Square
     */
    public Square(Play game)
    {
        mySquare = new SquareGraphics(this);
        input = 1;
        myStatus = " ";
        myGame = game;
    }
    
    /**
     * Returns the game
     * @return myGame  the game board we're using
     */
    public Play getPlay()
    {
        return myGame;
    }
    
    /**
     * Runs when mouse is clicked 
     * @param game  the game board we're using
     */
    public void clicked(Play game)
    {
        game.playGame(this);
    }
    
    /**
     * Gets the board graphics
     * @return mySquare  the square graphics
     */
    public Node getGraphics()
    {
        return mySquare;
    }
    
    /**
     * Accessor method for input private variable
     * @return input  the number associated with the little square
     */
    public int getInput()
    {
        return input;
    }
    
    /**
     * Sets the input to the desired number
     * @param n  the desired number
     */
    public void setInput(int n)
    {
        input = n;
    }
    
    /**
     * Setter method for the status variable
     * @param status  the status of the square (x, o, " ")
     */
    public void setStatus(String status)
    {  
        myStatus = status;
    }
    
    /**
     * Getter method for the status of the square
     * @return myStatus  the status of the square
     */
    public String getStatus()
    {
        return myStatus;
    }    
}
