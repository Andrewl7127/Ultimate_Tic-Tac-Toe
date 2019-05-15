
/**
 * Write a description of class MasterArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MasterArray
{
    private MiniArray [][] bigTicTac; 
    
    public MasterArray()
    {
      bigTicTac = new MiniArray [3][3];
      
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
    public String checkWon()
    {
      String check = checkRow();
      if(check.equals("X"))
        return "X";
      if(check.equals("O"))
         return "O";   
        
      check = checkCol();
      if(check.equals("X"))
        return "X";
      if(check.equals("O"))
         return "O";   
      
      check = checkDiagonal();
      if(check.equals("X"))
        return "X";
      if(check.equals("O"))
         return "O";   
      
      if(checkDraw())
        return "D";
    
      return " ";
        
    }
    
    private String checkRow()
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
    
    private String checkDiagonal()
    {
        int x = bigTicTac[0][2].getFinishedSquare() + bigTicTac[1][1].getFinishedSquare() + bigTicTac[2][0].getFinishedSquare();
        
        if(x == "XXX")
            return "X";
        if(x == "OOO")
            return "O";
        
        x = bigTicTac[2][2].getFinishedSquare() + bigTicTac[1][1].getFinishedSquare() + bigTicTac[0][0].getFinishedSquare();
        
        if(x == "XXX")
            return "X";
        if(x == "OOO")
            return "O";
        
       return " ";
    }
    
    private boolean checkDraw()
    {
      boolean flag = true;
      
      for (int row = 0; row < bigTicTac.length; row++)
        for(int col = 0; col < bigTicTac[0].length; col++)
            if(!(bigTicTac[row][col].getFinishedSquare().equals("D")))
                return false;
                
      return flag;

    }
}
