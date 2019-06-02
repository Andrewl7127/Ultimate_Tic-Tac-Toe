import javafx.scene.layout.GridPane;

/**
 * Creates the graphic for the whole big board
 *
 * @author (Birla, Chang, Chung ,Liu)
 * @version (1.0)
 */
//gridpane is used so the visuals look like a grid
public class BoardGraphics extends GridPane
{
    /**
     * Constructor for objects of class BoardGraphics
     */
    public BoardGraphics(MasterArray board) 
    {
        //creates gap between each mini tic tac toe board
        setVgap(5);
        setHgap(5);
        //creates the big boy board out of all the mini tic tac toe boards
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                add(((MiniArray)board.getSquare(row, col)).getGraphics(), row, col);
            }
        }      
    }
}
