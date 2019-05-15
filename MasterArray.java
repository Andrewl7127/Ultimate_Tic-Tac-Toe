
/**
 * Write a description of class MasterArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MasterArray
{
    private MiniArray [][] bigTicTac; 
    private boolean finishedSquare;
    
    public MasterArray()
    {
      bigTicTac = new MiniArray [3][3];
      finishedSquare = false;
      
      for (int row = 0; row < bigTicTac.length; row++)
        for(int col = 0; col < bigTicTac[0].length; col++)
            bigTicTac[row][col] = new MiniArray();
    }
    
    /**
     * does the move specified 
     * @param x        index of x location that move needs to be played
     * @param y        index of y location that move needs to be played
     * @param player   what player makes the move
     *                 should be either "1" for "X" or "0" for "Y"
     */
    public void doMove(int x1, int y1, int x, int y, int player)
    {
        if(bigTicTac[x1][y1].getFinishedSquare())
            throw new IllegalArgumentException();
        bigTicTac[x1][y1].doMove(x, y, player);
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
    
    private boolean checkRow()
        {
             for(int i =0; i<3; i++)
        {
             if (bigTicTac[i][0].getFinishedSquare() + bigTicTac[i][1].getFinishedSquare() 
             + bigTicTac[i][2].getFinishedSquare() == "OOO")
                return "O";
                
             if (bigTicTac[i][0].getFinishedSquare() + bigTicTac[i][1].getFinishedSquare() 
             + bigTicTac[i][2].getFinishedSquare() == "XXX")
                return "X";
        }
        
        return " ";
    }
    
    
    private String checkCol()
    {
        for(int i =0; i<3; i++)
        {
             if (bigTicTac[0][i].getFinishedSquare() + bigTicTac[1][i].getFinishedSquare() 
             + bigTicTac[2][i].getFinishedSquare() == "OOO")
                return "O";
                
             if (bigTicTac[0][i].getFinishedSquare() + bigTicTac[1][i].getFinishedSquare() 
             + bigTicTac[2][i].getFinishedSquare() == "XXX")
                return "X";
        }
        
        return " ";
    }
    
    private int checkDiagonal()
    {
        int x = bigTicTac[0][2] + bigTicTac[1][1] + bigTicTac[2][0];
        
        if(x == 0 || x==3){
            finishedSquare = true;
            return x;
        }
        
        x = bigTicTac[2][2] + bigTicTac[1][1] + bigTicTac[0][0];
        if(x == 0 || x==3){
            finishedSquare = true;
            return x;
        }
       return -1;
        
    }
    
    private boolean checkDraw()
    {
      
      for (int row = 0; row < bigTicTac.length; row++)
        for(int col = 0; col < bigTicTac[0].length; col++)
            if(!(bigTicTac[row][col] >=0))
                return false;
      
      finishedSquare = true;          
      return true;

    }
    
    public boolean getFinishedSquare()
    {
        return finishedSquare;
        
    }
}
