import javafx.scene.Parent;
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
    private Square[][] mini = new Square[3][3];
    private MiniGraphics graphics;
    private int n;
    public MiniArray()
    {
      miniTicTac = new String [3][3];
      finishedSquare = " ";
      n = 1;
      
      for (int row = 0; row < miniTicTac.length; row++)
        for(int col = 0; col < miniTicTac[0].length; col++)
            miniTicTac[row][col] = " ";
            
      for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {
                mini[r][c] = new Square();
                mini[r][c].setInput(n);
                n++;
            }
        }
        
      
      graphics = new MiniGraphics(this);
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
             
             if(miniTicTac[i][0].equals("O") && 
                miniTicTac[i][1].equals("O") &&
                miniTicTac[i][2].equals ("O")){
                   finishedSquare = "O";  
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
             
             if(miniTicTac[0][i].equals("O") && 
                miniTicTac[1][i].equals("O") &&
                miniTicTac[2][i].equals ("O")){
                   finishedSquare = "O";  
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
             if (miniTicTac[0][2].equals("O") &&
                 miniTicTac[1][1].equals("O") && 
                 miniTicTac[2][0].equals("O")){
                finishedSquare = "O";
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
               if(miniTicTac[2][2].equals("O") && 
                  miniTicTac[1][1].equals("O") &&
                  miniTicTac[0][0].equals("O")) {
                  finishedSquare = "O";
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
               miniTicTac[row][col].equals("O")))
                return false;
      
      finishedSquare = "D";          
      return true;

    }
    
    public String getFinishedSquare()
    {
        return finishedSquare;
        
    }
    
    public Square getSquare(int row, int col)
    {
        return mini[row][col];
    }
    
    public Parent getGraphics()
    {
        return graphics;
    }

}
