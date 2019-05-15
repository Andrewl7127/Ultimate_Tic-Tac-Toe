
/**
 * Write a description of class MiniArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MiniArray
{
    private String [][] miniTicTac; 
    private String finishedSquare;
    
    public MiniArray()
    {
      miniTicTac = new String [3][3];
      finishedSquare = null;
      
      for (int row = 0; row < miniTicTac.length; row++)
        for(int col = 0; col < miniTicTac[0].length; col++)
            miniTicTac[row][col] = " ";
    }
    
    /**
     * does the move specified 
     * @param x        index of x location that move needs to be played
     * @param y        index of y location that move needs to be played
     * @param player   what player makes the move
     *                 should be "X" or "O"
     */
    public void doMove(int x, int y, String player)
    {
        if(miniTicTac[x][y].equals(" "))
            throw new IllegalArgumentException();
        miniTicTac[x][y] = player;
    }
    
    /**
     * Checks if the array has been won
     * @return integer           returns 0 or 3 if the square has been won by "X" or "0" respectively
     *                           returns -1 if the square has not been won
     *                           returns 2 if the square has been drawn
     */
    public int checkWon()
    {
      int check = checkRow();
      if(check >= 0)
        return check;
        
      check = checkCol();
      if(check >= 0)
         return check;   
      
      check = checkDiagonal();
      if(check >= 0)
        return check;
      
      if(checkDraw())
        return 2;
    
      return -1;
        
    }
    
    private int checkRow()
        {
        int x = 0;
        for(int i =0; i<3; i++)
        {
             x = miniTicTac[i][0] + miniTicTac[i][1] + miniTicTac[i][2];
             if(x == 0 || x == 3)
             {
                finishedSquare = true;
                return x;
            }
        }
        return -1;
    }
    
    
    private int checkCol()
    {
        int x = 0;
        for(int i =0; i<3; i++)
        {
             x = miniTicTac[0][i] + miniTicTac[1][i] + miniTicTac[2][i];
             if(x == 0 || x == 3){
                finishedSquare = true;
                return x;
            }
        }
        
        return -1;  
        
        
    }
    
    private int checkDiagonal()
    {
        int x = miniTicTac[0][2] + miniTicTac[1][1] + miniTicTac[2][0];
        
        if(x == 0 || x==3){
            finishedSquare = true;
            return x;
        }
        
        x = miniTicTac[2][2] + miniTicTac[1][1] + miniTicTac[0][0];
        if(x == 0 || x==3){
            finishedSquare = true;
            return x;
        }
       return -1;
        
    }
    
    private boolean checkDraw()
    {
      
      for (int row = 0; row < miniTicTac.length; row++)
        for(int col = 0; col < miniTicTac[0].length; col++)
            if(!(miniTicTac[row][col] >=0))
                return false;
      
      finishedSquare = true;          
      return true;

    }
    
    public boolean getFinishedSquare()
    {
        return finishedSquare;
        
    }
}
