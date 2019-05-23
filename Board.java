import javafx.scene.Parent;
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private MasterSquare[][] board = new MasterSquare[3][3];
    private BoardGraphics graphics;
    
    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {
                board[r][c] = new MasterSquare();
            }
        }
        
        graphics = new BoardGraphics(this);
    }
    
    public MasterSquare getSquare(int row, int col)
    {
        return board[row][col];
    }
    
    public Parent getGraphics()
    {
        return graphics;
    }
}

