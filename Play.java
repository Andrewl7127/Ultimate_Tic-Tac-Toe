import chn.util.*;
/**
 * Class that runs the game
 *
 * @author (Birla, Chang, Chung ,Liu)
 * @version (1.0)
 */
public class Play
{
    private String playerTurn;
    private int count;
    private int previousX;
    private int previousY;
    private PlayerStatus playStatus;
    private NextMove move; 
    private MasterArray game1;
    boolean state;
    private final boolean DEBUG = true;
    
    public Play()
    {
      count = 1;
      playerTurn = "";
      game1 = new MasterArray(this);
      previousX = 5;
      previousY = 5;
      state = false;
      playStatus = new PlayerStatus();
      move = new NextMove();
    }
    
    public MasterArray getMA()
    {
       return game1;   
    }
    
    public PlayerStatus getPS()
    {
        return playStatus;
    }
    
    public NextMove getNM()
    {
        return move;
    }
    
    public void playGame(Square square)
    {
        int[] answer = new int[4];
        
        if(game1.checkWon().equals(" "))
        {
            answer = game1.inputConvert(square.getInput());
            
            helpChange(count);
            if (state)
            {
              if (!game1.getMiniArray(previousX, previousY).getFinishedSquare().equals(" "))
                  {
                makeTurn(answer, playerTurn, square);
                previousX = answer[2];
                previousY = answer[3];
                count++;   
                helpChange(count);
                move.changeCoord(previousX, previousY, game1);
                if(DEBUG)
                    System.out.print("First if statement run");
                }
                else
              if (answer[0] == previousX && answer[1] == previousY && game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals(" "))
               {
                makeTurn(answer, playerTurn, square);
                previousX = answer[2];
                previousY = answer[3];
                count++;   
                helpChange(count);
                 move.changeCoord(previousX, previousY, game1);
                if(DEBUG)
                    System.out.print("First if statement run");
                }
            }
            else
            {
            if (count != 1)
            {
                if (!game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals(" "))
                {
                    if(DEBUG)
                        System.out.println("If statemnt 2");
                }
                else
                {
                     if (answer[0] != previousX || answer[1] != previousY)
                    {
                        if(game1.getMiniArray(previousX, previousY).checkWon())
                        {
                            makeTurn(answer, playerTurn, square);
                            previousX = answer[2];
                            previousY = answer[3];
                            count++;  
                             move.changeCoord(previousX, previousY, game1);
                             if(DEBUG)
                                System.out.println("If statemnt 4");
                    
                        }
                    }
                    else
                    {
                    makeTurn(answer, playerTurn, square);
                    previousX = answer[2];
                    previousY = answer[3];
                    count++; 
                     move.changeCoord(previousX, previousY, game1);
                    }
                }
            }
            else
            {
                makeTurn(answer, playerTurn, square);
                previousX = answer[2];
                previousY = answer[3];
                count++;  
                move.changeCoord(previousX, previousY, game1);
            } 
            
        }
    }
    color(answer);    
        
        
     }
         
     private void makeTurn(int [] temp, String player, Square current)
     {
              game1.doMove(temp[0], temp[1], temp[2], temp[3], player);
              current.setStatus(playerTurn);
              state = game1.getMiniArray(temp[0], temp[1]).checkWon();
              if(player.equals("X"))
                playStatus.currentPlayerO();
              if(player.equals("O"))
                playStatus.currentPlayerX();
                
     }
     
     private void color(int[] answer)
     {
        if(game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals("X"))
        {
            game1.getSquare(answer[0], answer[1]).colorMini("X");
            if(DEBUG)
            System.out.print("X COLOR RUNS");
        }
        
        if(game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals("O"))
        {    
            if(DEBUG)
            System.out.print("O COLOR RUNS");
            game1.getSquare(answer[0], answer[1]).colorMini("O");
        }
        
        if(game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals("D"))
        {
            game1.getSquare(answer[0], answer[1]).colorMini("D");
            if(DEBUG)
            System.out.print("D COLOR RUNS");
        }
     }
     
     private void helpChange(int count)
     {
        if (count % 2 != 0)
            {
                playerTurn = "X";
                if(DEBUG)
                    System.out.println("Changed to X");
            }
            else
            {
                playerTurn = "O";
                if(DEBUG)
                    System.out.println("Changed to O");
            } 
         
        }
  }
    
