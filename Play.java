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
     * @return game1 masterArray being used for the game
     */
    public MasterArray getMA()
    {
       return game1;   
    }
    
    /**
     * Gets the graphic for who's player turn it is
     * @return playStatus "X" or "O" depending on whose turn it is
     */
    public PlayerStatus getPS()
    {
        return playStatus;
    }
    
    /**
     * Gets the graphic for where the next move should be
     * @return move    the graphic for the next move 
     */
    public NextMove getNM()
    {
        return move;
    }
    
    /**
     * THis is the method that runs everytime a click is made 
     * It is called in the square graphics class 
     * @param square   the sqaure object in which the next move was made 
     */
    public void playGame(Square square)
    {
        int[] answer = new int[4];
        
        //if the move is on a square that was not taken previously 
        if(game1.checkWon().equals(" "))
        {
            //get the coordinates for the move the user made
            answer = game1.inputConvert(square.getInput());
            
            //change the person whose turn it is 
            helpChange(count);
            
            //if the last move resulted in a won square 
            if (state)
            {
              
              //if the user must make a move that goes in a big square that has already been won
              //let the user make a move anywhere
              if (!game1.getMiniArray(previousX, previousY).getFinishedSquare().equals(" "))
                  {
                      
                //these are all moves that need to be made everytime a legal move 
                //is played so the game works 
                makeTurn(answer, playerTurn, square);
                previousX = answer[2];
                previousY = answer[3];
                count++;   
                
                //this needs to be done in here to avoid messing up not counting a turn 
                //when this if statement executes
                helpChange(count);
                
                move.changeCoord(previousX, previousY, game1);
                if(DEBUG)
                    System.out.print("First if statement run");
                }
                else
                
                //if the move is made in the correct big squae and the square has not
                //been wo n by someone
              if (answer[0] == previousX && answer[1] == previousY && game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals(" "))
               {
                //make the move 
                
                makeTurn(answer, playerTurn, square);
                previousX = answer[2];
                previousY = answer[3];
                count++;   
                
                //this needs to be done in here to avoid messing up not counting a turn 
                //when this if statement executes
                helpChange(count);
               
                move.changeCoord(previousX, previousY, game1);
                if(DEBUG)
                    System.out.print("First if statement run");
                }
            }
            else //the last move did not result in a won square 
            {  
            // if it is not the first move 
            if (count != 1)
            {
                //if the move is played in a big square that has already been won
                if (!game1.getMiniArray(answer[0], answer[1]).getFinishedSquare().equals(" "))
                {
                    //do nothing;illegal move
                    if(DEBUG)
                        System.out.println("If statemnt 2");
                }
                else //the move was played in a big square that is open
                {
                    //if the move is played in the wrong big square 
                    //(does not follow the rules of the game)
                     if (answer[0] != previousX || answer[1] != previousY)
                    {
                        
                        //if the sqaure was won in the last move
                        if(game1.getMiniArray(previousX, previousY).checkWon())
                        {
                            //they should be able to play anywhere
                            makeTurn(answer, playerTurn, square);
                            previousX = answer[2];
                            previousY = answer[3];
                            count++;  
                             move.changeCoord(previousX, previousY, game1);
                             if(DEBUG)
                                System.out.println("If statemnt 4");
                    
                        }
                        
                        //if the previous if statement evaluates to false
                        //the move is illegal and cannot be made
                    }
                    else //the move was played in the correct big square
                    {
                    //the move is legal and can be played
                    makeTurn(answer, playerTurn, square);
                    previousX = answer[2];
                    previousY = answer[3];
                    count++; 
                     move.changeCoord(previousX, previousY, game1);
                    }
                }
            }
            else //this is the first move of the game
            {
                //you can make any move
                makeTurn(answer, playerTurn, square);
                previousX = answer[2];
                previousY = answer[3];
                count++;  
                move.changeCoord(previousX, previousY, game1);
            } 
            
        }
     }
     
     //function call to color the big sqaure the correct color if the necessary conditions
     //are met
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
    
