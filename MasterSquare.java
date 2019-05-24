import javafx.scene.Parent;
/**
 * Write a description of class MasterSquare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MasterSquare
{
    // instance variables - replace the example below with your own
    private MasterGraphics graphics;
    private Square[][] master = new Square[3][3];
    /**
     * Constructor for objects of class MasterSquare
     */
    public MasterSquare()
    {
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {
                master[r][c] = new Square();
            }
        }
        
        graphics = new MasterGraphics(this);
    }
    
    public Square getSquare(int row, int col)
    {
        return master[row][col];
    }
    
    public Parent getGraphics()
    {
        return graphics;
    }
}
