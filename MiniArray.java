
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
        if(miniTicTac[x][y].compareTo("X")>0)
            throw new IllegalArgumentException();
        miniTicTac[x][y] = player;
    }
    
    /**
     * Checks if the array has been won
     * @return integer           returns 0 or 3 if the square has been won by "X" or "0" respectively
     *                           returns -1 if the square has not been won
     *                           returns 2 if the square has been drawn
     */
    public boolean checkWon()
    {
      return (checkRow() || checkCol() || checkDraw());
        
    }
    
    private boolean checkRow()
        {
        int x = 0;
        for(int i =0; i<3; i++)
        {
             if(miniTicTac[i][0].equals("X") && 
                miniTicTac[i][1].equals("X") &&
                miniTicTac[i][2].equals ("X")){
                   finishedSquare = "X"; 
                   return true;
                }
             
             if(miniTicTac[i][0].equals("Y") && 
                miniTicTac[i][1].equals("Y") &&
                miniTicTac[i][2].equals ("Y")){
                   finishedSquare = "Y";  
                   return true;
                }
                 
        }
        return false;
    }
    
    
    private boolean  checkCol()
    {
        int x = 0;
        for(int i =0; i<3; i++)
        {
            if(miniTicTac[0][i].equals("X") && 
                miniTicTac[1][i].equals("X") &&
                miniTicTac[2][i].equals ("X")){
                   finishedSquare = "X"; 
                   return true;
                }
             
             if(miniTicTac[0][i].equals("Y") && 
                miniTicTac[1][i].equals("Y") &&
                miniTicTac[2][i].equals ("Y")){
                   finishedSquare = "Y";  
                   return true;
                }
        }
        
        return false;  

    }
    
    private boolean checkDiagonal()
    {
        
        if (miniTicTac[0][2].equals("X") &&
            miniTicTac[1][1].equals("X") && 
            miniTicTac[2][0].equals("X")){
            finishedSquare = "X";
            return true;
         }
         else {
             if (miniTicTac[0][2].equals("Y") &&
                 miniTicTac[1][1].equals("Y") && 
                 miniTicTac[2][0].equals("Y")){
                finishedSquare = "Y";
                return true;
         }
       }
       
        if(miniTicTac[2][2].equals("X") && 
           miniTicTac[1][1].equals("X") &&
           miniTicTac[0][0].equals("X")) {
              finishedSquare = "X";
              return true;
               
            }
           else{
               if(miniTicTac[2][2].equals("Y") && 
                  miniTicTac[1][1].equals("Y") &&
                  miniTicTac[0][0].equals("Y")) {
                  finishedSquare = "Y";
                  return true;
                       
                }
        }
       return false;
        
    }
    
    private boolean checkDraw()
    {
      
      for (int row = 0; row < miniTicTac.length; row++)
        for(int col = 0; col < miniTicTac[0].length; col++)
            if(!(miniTicTac[row][col].equals("X") ||
               miniTicTac[row][col].equals("Y")))
                return false;
      
      finishedSquare = "D";          
      return true;

    }
    
    public String getFinishedSquare()
    {
        return finishedSquare;
        
    }
}
