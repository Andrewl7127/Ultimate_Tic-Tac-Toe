import javafx.scene.Node;
import java.util.*;
/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square
{
    private SquareGraphics mySquare;
    private int input;
    private String myStatus;
    private Play bruh;
    
    /**
     * Constructor for objects of class Square
     */
    public Square(Play game)
    {
        mySquare = new SquareGraphics(this);
        input = 1;
        myStatus = " ";
        bruh = game;
    }
    
    public Play getPlay()
    {
        return bruh;
    }
    
    public void clicked(Play game)
    {
        game.playGame(input);
        
    }
    
    public Node getGraphics()
    {
        return mySquare;
    }
    
    public int getInput()
    {
        return input;
    }
    
    public void setInput(int n)
    {
        input = n;
    }
    
    public void setStatus(String status)
    {  
        myStatus = status;
    }
    
    public String getStatus()
    {
        return myStatus;
    }
}
