import javafx.scene.Node;
import java.util.*;
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private Square[][] board = new Square[9][9];
    private BoardGraphics graphics;
    
    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        for(int r = 0; r < 9; r++)
        {
            for(int c = 0; c < 9; c++)
            {
                board[r][c] = new Square();
            }
        }
        
        graphics = new BoardGraphics(this);
    }
    
    public Square getSquare(int row, int col)
    {
        return board[row][col];
    }
    
    public Node getGraphics()
    {
        return graphics;
    }
}

