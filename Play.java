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
    MasterArray game1;
    public Play()
    {
      count = 1;
      playerTurn = "";
      game1 = new MasterArray(this);
    }
    
    public MasterArray getMA()
    {
     return game1;   
    }
    
    public void playGame(int input)
    {
        int previousX = 5, previousY = 5;
        int[] answer;
        
        if(game1.checkWon().equals(" "))
        {
            answer = game1.inputConvert(input);
            
            if (count % 2 != 0)
                playerTurn = "X";
            else
                playerTurn = "O";
                
            if (count != 1)
            {
                if (game1.getMiniArray(answer[0], answer[1]).getFinishedSquare() != null)
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
                         game1.doMove(answer[0], answer[1], answer[2], answer[3], playerTurn);
                        MiniArray temp = game1.getMiniArray(answer[0], answer[1]);
                        Square temp2 = temp.getSquare(answer[3], answer[4]);
                        temp2.setStatus(playerTurn);
                        temp.checkWon();
                        
                        
                        previousX = answer[3];
                        previousY = answer[4];
                        count++;  
                    }
                }
            }
            else
            {
                game1.doMove(answer[0], answer[1], answer[2], answer[3], playerTurn);
                MiniArray temp = game1.getMiniArray(answer[0], answer[1]);
                Square temp2 = temp.getSquare(answer[2], answer[3]);
                temp2.setStatus(playerTurn);
                game1.getMiniArray(answer[0], answer[1]).checkWon();
                
                previousX = answer[3];
                previousY = answer[4];
                count++;  
            } 
              
        }
            
        }
 }
    
