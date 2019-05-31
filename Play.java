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
    boolean state;
    
    public Play()
    {
      count = 1;
      playerTurn = "";
      game1 = new MasterArray(this);
      previousX = 5;
      previousY = 5;
      state = false;
    }
    
    public MasterArray getMA()
    {
     return game1;   
    }
    
    public void playGame(Square square)
    {
        int[] answer = new int[4];
        PlayerStatus stauts = new PlayerStatus();
        stauts.currentPlayerX();
        System.out.print("x image");
        if(game1.checkWon().equals(" "))
        {
            answer = game1.inputConvert(square.getInput());
            
            if (count % 2 != 0)
            {
                playerTurn = "X";
                
            }
            else
                playerTurn = "O";
            
            if (state)
            {
              if (answer[0] == previousX && answer[1] == previousY && game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals(" "))
               {
                makeTurn(answer, playerTurn, square);
                previousX = answer[2];
                previousY = answer[3];
                count++;   
                }

            }
            
            if (count % 2 != 0)
                playerTurn = "X";
            else
                playerTurn = "O";
                
            if (count != 1)
            {
                if (!game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals(" "))
                {
                    
                }
                else
                {
                     if (answer[0] != previousX || answer[1] != previousY)
                    {
                        System.out.print("dhadosfh");
                        if(game1.getMiniArray(previousX, previousY).checkWon())
                        {
                            System.out.println("hfowfn");
                            makeTurn(answer, playerTurn, square);
                            previousX = answer[2];
                            previousY = answer[3];
                            count++;  
                    
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
            else
            {
                makeTurn(answer, playerTurn, square);
                previousX = answer[2];
                previousY = answer[3];
                count++;  
            } 
            color(answer);
        }
        
        
        
     }
         
     private void makeTurn(int [] temp, String player, Square current)
     {
              game1.doMove(temp[0], temp[1], temp[2], temp[3], player);
              current.setStatus(playerTurn);
              state = game1.getMiniArray(temp[0], temp[1]).checkWon();
    
     }
     
     private void color(int[] answer)
     {
        if(game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals("X"))
            game1.getMiniArray(answer[0], answer[1]).colorMini("X");
        
        if(game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals("O"))
            game1.getMiniArray(answer[0], answer[1]).colorMini("O");
        
        if(game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals("D"))
            game1.getMiniArray(answer[0], answer[1]).colorMini("D");
     }
  }
    
