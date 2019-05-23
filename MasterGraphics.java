import javafx.scene.layout.GridPane;
/**
 * Write a description of class BigSquareGraphics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MasterGraphics extends GridPane
{
    /**
     * Constructor for objects of class BigSquareGraphics
     */
    public MasterGraphics(MasterSquare master)
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
