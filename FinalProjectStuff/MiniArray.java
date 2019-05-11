
/**
 * Write a description of class MiniArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MiniArray
{
    private int [][] miniTicTac; 
    
    public MiniArray()
    {
      miniTicTac = new int [3][3];
      
      for (int row = 0; row < miniTicTac.length; row++)
        for(int col = 0; col < miniTicTac[0].length; col++)
            miniTicTac[row][col] = -1;
    }
    
    //x and y are the INDEXES of the cell the player has moved
    //player is 1 if "X" has moved, and 0 is "O" has moved 
    private void doMove(int x, int y, int player)
    {
        miniTicTac[x][y] = player;
    }
    
        
        
    
    
}
