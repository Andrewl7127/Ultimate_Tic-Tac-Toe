import javafx.scene.layout.GridPane;
/**
 * Creates the visual for each mini tic tac toe board
 *
 * @author (Birla, Chang, Chung ,Liu)
 * @version (1.0)
 */
public class MiniGraphics extends GridPane
{
    /**
     * Constructor for objects of class MiniGraphics
     */
    public MiniGraphics(MiniArray master)
    {
        //creates 9 square visuals
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                add(((Square)master.getSquare(row, col)).getGraphics(), row, col);
            }
        }
    }
}
