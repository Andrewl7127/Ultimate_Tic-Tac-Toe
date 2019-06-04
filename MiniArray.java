import javafx.scene.Parent;
/**
 * Creates each individual mini tic tac toe board
 *
 * @author (Birla, Chang, Chung ,Liu)
 * @version (1.0)
 */
public class MiniArray
{
    //array for each mini square
    private String [][] miniTicTac; 
    //holds status of each big square
    private String finishedSquare;
    //array of squares to create graphcis
    private Square[][] mini;
    //graphics of mini square (x and o)
    private MiniGraphics graphics;
    //the game
    private Play myGame;
    
    /**
     * Constructor for MiniArray class
     */
    public MiniArray(Play game)
    {
      miniTicTac = new String [3][3];
      mini = new Square[3][3];
      finishedSquare = " ";
      int n = 1;
      myGame = game;
      
      //initiliazes everything to their starting values
      for (int row = 0; row < miniTicTac.length; row++)
          for(int col = 0; col < miniTicTac[0].length; col++)
          {
              miniTicTac[row][col] = " ";
              mini[row][col] = new Square(game);
              mini[row][col].setInput(n);
              n++;
          }
      graphics = new MiniGraphics(this);
    }
    
    /**
     * Does the move
     * @param x  index of x coordinate of the move
     * @param y  index of y coordinate of the move
     * @param player  the player who's turn it is
     */
    public void doMove(int x, int y, String player)
    {
        miniTicTac[x][y] = player;
    }
    
    /**
     * Checks if the big square is won
     * @return true if the square is won/drawn, false if not
     */
    public boolean checkWon()
    {
      return (checkRow() || checkCol() || checkDraw() || checkDiagonal());
    }
    
    //used to check if the square is won by winning by the row
    private boolean checkRow()
    {
        int x = 0;
        boolean check = false;
        //checks each row if its won
        for(int i =0; i < 3; i++)
        {
             //if x won, the big square is won, so returns true
             if(miniTicTac[i][0].equals("X") && 
                miniTicTac[i][1].equals("X") &&
                miniTicTac[i][2].equals ("X"))
             {
                 finishedSquare = "X"; 
                 check = true;
             }
             //if o won, the big square is won, so returns true
             if(miniTicTac[i][0].equals("O") && 
                miniTicTac[i][1].equals("O") &&
                miniTicTac[i][2].equals ("O"))
             {
                 finishedSquare = "O";  
                 check = true;
             } 
        }
        return check;
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
      
    if(finishedSquare.equals(" "))
      {
      finishedSquare = "D";  
      return true;
    }
    else
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
    
    public void colorMini(String winner)
    {
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {
                ((SquareGraphics)mini[r][c].getGraphics()).changeColor(winner); 
            }
        }
    }
}
