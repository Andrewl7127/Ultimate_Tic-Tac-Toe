import javafx.scene.layout.GridPane;

/**
 * Write a description of class BoardGraphics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoardGraphics extends GridPane
{

    /**
     * Constructor for objects of class BoardGraphics
     */
    public BoardGraphics(MasterArray board) 
    {
        setVgap(5);
        setHgap(5);
        
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                add(((MiniArray)board.getSquare(row, col)).getGraphics(), row, col);
            }
        }
                
    }

}
