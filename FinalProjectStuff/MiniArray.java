
/**
 * Write a description of class MiniArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MiniArray
{
    private int [][] miniTicTac; 
    boolean finishedSquare;
    
    public MiniArray()
    {
      miniTicTac = new int [3][3];
      finishedSquare = false;
      
      for (int row = 0; row < miniTicTac.length; row++)
        for(int col = 0; col < miniTicTac[0].length; col++)
            miniTicTac[row][col] = -1;
    }
    
    //x and y are the INDEXES of the cell the player has moved
    //player is 1 if "X" has moved, and 0 is "O" has moved 
    public void doMove(int x, int y, int player)
    {
        miniTicTac[x][y] = player;
    }
    
    /**
     * Checks if the array has been won
     */
    public int checkWon()
    {
      int check = checkRow();
      if(check > 0)
        return check;
        
      check = checkCol();
      if(check > 0)
         return check;   
      
      check = checkDiagonal();
      if(check>0)
        return check;
      
      return -1;
        
    }
    
    private int checkRow()
    {
        int x = 0;
        for(int i =0; i<3; i++)
        {
             x = miniTicTac[i][0] + miniTicTac[i][1] + miniTicTac[i][2];
             if(x == 0 || x == 3)
                return x;
            }
        
        return -1;
    }
    
    private int checkCol()
    {
        int x = 0;
        for(int i =0; i<3; i++)
        {
             x = miniTicTac[0][i] + miniTicTac[1][i] + miniTicTac[2][i];
             if(x == 0 || x == 3)
                return x;
            }
        
        return -1;  
        
        
    }
    
    private int checkDiagonal()
    {
        int x = miniTicTac[0][2] + miniTicTac[1][1] + miniTicTac[2][0];
        
        if(x == 0 || x==3)
            return x;
        
        x = miniTicTac[2][2] + miniTicTac[1][1] + miniTicTac[0][0];
        if(x == 0 || x==3)
            return x;
        
       return -1;
        
    }
    
    private boolean checkDraw()
    {
      for (int row = 0; row < miniTicTac.length; row++)
        for(int col = 0; col < miniTicTac[0].length; col++)
            if(!(miniTicTac >=0))
                return false;
      return true;
        
        
    }
}
