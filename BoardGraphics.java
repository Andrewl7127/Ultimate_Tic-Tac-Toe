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
    public BoardGraphics(Board board) 
    {
        for(int row = 0; row < 9; row++)
        {
            for(int col = 0; col < 9; col++)
            {
                add(((Square)board.getSquare(row, col)).getGraphics(), row, col);
            }
        }
    }

}
