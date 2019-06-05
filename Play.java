import chn.util.*;
/**
 * Class that runs the game
 *
 * @author (Birla, Chang, Chung ,Liu)
 * @version (1.0)
 */
public class Play
{
    //keeps track of player turn
    private String playerTurn;
    //counts how many moves have been made to determine player turn
    private int count;
    //keeps track of last turn played
    private int previousX;
    private int previousY;
    //does the graphics for the player's turn
    private PlayerStatus playStatus;
    //does the graphics for where the player should go next
    private NextMove move; 
    //the board used
    private MasterArray game1;
    //keeps track if the last move reslted in a won big square
    boolean state;
    //used for debugging
    private final boolean DEBUG = false;
    
    /**
     * Constructor for objects of class Play
     */
    public Play()
    {
      //instantiations
      count = 1;
      playerTurn = "";
      game1 = new MasterArray(this);
      previousX = 5;
      previousY = 5;
      state = false;
      playStatus = new PlayerStatus();
      move = new NextMove();
    }
    
    /**
     * Gets the board(masterarray)
     * @return game1
     */
    public MasterArray getMA()
    {
       return game1;   
    }
    
    /**
     * Gets the graphic for who's player turn it is
     * @return playStatus
     */
    public PlayerStatus getPS()
    {
        return playStatus;
    }
    
    /**
     * Gets the graphic for where the next move should be
     * @return move
     */
    public NextMove getNM()
    {
        return move;
    }
    
    /**
     * 
     */
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
     
     //does the move, does grapics for the clicked square and playerturn
     private void makeTurn(int [] temp, String player, Square current)
     {
         //does the move     
         game1.doMove(temp[0], temp[1], temp[2], temp[3], player);
         //changes clicked square to the x or o
         current.setStatus(playerTurn);
         //tells you if the square is won after that move
         state = game1.getMiniArray(temp[0], temp[1]).checkWon();
         //changes graphics to reflect the current player's turn
         if(player.equals("X"))
            playStatus.currentPlayerO();
         if(player.equals("O"))
            playStatus.currentPlayerX();
     }
     
     //Passes the correct info to colorMini in MiniArray to color the square
     //after a square is won
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
            game1.getSquare(answer[0], answer[1]).colorMini("O");
            if(DEBUG)
                System.out.print("O COLOR RUNS");
        }
        
        if(game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals("D"))
        {
            game1.getSquare(answer[0], answer[1]).colorMini("D");
            if(DEBUG)
                System.out.print("D COLOR RUNS");
        }
     }
     
     //changes the playerTurn  to reflect the correct player
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
    
