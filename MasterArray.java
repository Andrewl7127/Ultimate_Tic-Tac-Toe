
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
    public void doMove(int x1, int y1, int x, int y, String player)
    {
        if(bigTicTac[x1][y1].getFinishedSquare().equals(" "))
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
             if ((bigTicTac[i][0].getFinishedSquare() + bigTicTac[i][1].getFinishedSquare() 
             + bigTicTac[i][2].getFinishedSquare()).equals("OOO"))
                return "O";
                
             if ((bigTicTac[i][0].getFinishedSquare() + bigTicTac[i][1].getFinishedSquare() 
             + bigTicTac[i][2].getFinishedSquare()).equals("XXX"))
                return "X";
        }
        
        return " ";
    }
    
    
    private String checkCol()
    {
        for(int i =0; i<3; i++)
        {
             if ((bigTicTac[0][i].getFinishedSquare() + bigTicTac[1][i].getFinishedSquare() 
             + bigTicTac[2][i].getFinishedSquare()).equals("OOO"))
                return "O";
                
             if ((bigTicTac[0][i].getFinishedSquare() + bigTicTac[1][i].getFinishedSquare() 
             + bigTicTac[2][i].getFinishedSquare()).equals("XXX"))
                return "X";
        }
        
        return " ";
    }
    
    private String checkDiagonal()
    {
        String x = bigTicTac[0][2].getFinishedSquare() + bigTicTac[1][1].getFinishedSquare() + bigTicTac[2][0].getFinishedSquare();
        
        if(x.equals("XXX"))
            return "X";
        if(x.equals("OOO"))
            return "O";
        
        x = bigTicTac[2][2].getFinishedSquare() + bigTicTac[1][1].getFinishedSquare() + bigTicTac[0][0].getFinishedSquare();
        
        if(x.equals("XXX"))
            return "X";
        if(x.equals("OOO"))
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
    
    public MiniArray getMiniArray(int x1, int y1)
    {
        return bigTicTac[x1][y1];
    }
    
    public int[] inputConvert(int input)
    {
        int[] answer = new int[4];
        
        switch(input)
        {
          case 1:
          case 2:
          case 3:
          case 4: 
          case 5: 
          case 6: 
          case 7:
          case 8:
          case 9:
            answer[0] = 0;
            answer [1]= 0;
            break;
          case 10:
          case 11:
          case 12:
          case 13:
          case 14: 
          case 15:
          case 16:
          case 17:
          case 18:
            answer[0] = 0;
            answer [1] = 1;
            break;
          case 19:
          case 20:
          case 21:
          case 22:
          case 23:
          case 24: 
          case 25:
          case 26:
          case 27:
            answer[0] = 0;
            answer[1] = 2;
            break;
          case 28:
          case 29:      
          case 30:
          case 31:
          case 32:
          case 33:
          case 34: 
          case 35:
          case 36:
            answer[0] = 1;
            answer[1] = 0;
          case 37:
          case 38:
          case 39:
          case 40:  
          case 41:
          case 42:
          case 43:
          case 44: 
          case 45:
            answer[0] = 1;
            answer[1] = 1;
          case 46: 
          case 47:
          case 48:
          case 49:  
          case 50:  
          case 51:
          case 52:
          case 53:
          case 54: 
             answer[0] = 1;
            answer[1] = 2;
          case 55: 
          case 56: 
          case 57:
          case 58:
          case 59:
          case 60:
          case 61:
          case 62:
          case 63:
             answer[0] = 2;
            answer[1] = 0;
          case 64: 
          case 65: 
          case 66: 
          case 67:
          case 68:
          case 69:
          case 70:
          case 71:
          case 72:
            answer[0] = 2;
            answer[1] = 1;
          case 73:
          case 74: 
          case 75: 
          case 76: 
          case 77:
          case 78:
          case 79:
          case 80:
          case 81:
            answer[0] = 2;
            answer[1] = 2;
          default: 
            throw new IllegalArgumentException();
        }
        
        input %=9;
        
        switch(input)
        {
           case 1:
               answer[2] = 0;
               answer[3] = 0;
               break;
           case 2:
               answer[2] = 0;
               answer[3] =1;
               break;
           case 3:
              answer[2] = 0;
              answer[3] = 2;
              break;
           case 4:
              answer[2] = 1;
              answer[3] = 0;
              break;
           case 5:
              answer[2] = 1;
              answer [3] = 1;
              break;
           case 6:
              answer[2] = 1;
              answer [3] = 2;
              break;
           case 7: 
             answer[2] = 2;
             answer [3] = 0;
             break;
           case 8:
             answer[2] = 2;
             answer [3] = 1;
             break;
           case 0:
            answer[2] = 2;
            answer [3] = 2;
            break;
           default:
            throw new IllegalArgumentException();
        }
        return answer;
    }
}
