import chn.util.*;
/**
 * Write a description of class Play here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Play
{
    private String playerTurn;
    private int count;
    private int previousX;
    private int previousY;
    MasterArray game1;
    public Play()
    {
      count = 1;
      playerTurn = "";
      game1 = new MasterArray(this);
      previousX = 5;
      previousY = 5;
    }
    
    public MasterArray getMA()
    {
     return game1;   
    }
    
    public void playGame(Square square)
    {
   
        int[] answer;
        
        if(game1.checkWon().equals(" "))
        {
            answer = game1.inputConvert(square.getInput());
            
            if (count % 2 != 0)
                playerTurn = "X";
            else
                playerTurn = "O";
                
            if (count != 1)
            {
                if (!game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals(" "))
                {
                    //reprompt
                }
                else
                {
                     if (answer[0] != previousX || answer[1] != previousY)
                    {
                        //reprompt
                    }
                    else
                    {
                     makeTurn(answer, playerTurn, square);
                    previousX = answer[2];
                    previousY = answer[3];
                    count++; 
                    }
                }
            }
            else
            {
                makeTurn(answer, playerTurn, square);
                previousX = answer[2];
                previousY = answer[3];
                count++;  
            } 
              
        }
            
        }
         
        private void makeTurn(int [] temp, String player, Square current)
        {
              game1.doMove(temp[0], temp[1], temp[2], temp[3], player);
              current.setStatus(playerTurn);
              game1.getMiniArray(temp[0], temp[1]).checkWon();
    
        }
 }
    
