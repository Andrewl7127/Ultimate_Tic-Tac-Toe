import javafx.scene.layout.GridPane;
/**
 * Write a description of class BigSquareGraphics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MiniGraphics extends GridPane
{
    /**
     * Constructor for objects of class BigSquareGraphics
     */
    public MiniGraphics(MiniArray master)
    {
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                add(((Square)master.getSquare(row, col)).getGraphics(), row, col);
            }
        }
    }
}
