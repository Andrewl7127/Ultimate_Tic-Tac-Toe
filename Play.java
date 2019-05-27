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
    
    public Play()
    {
      count = 1;
      playerTurn = "";
    }
    
    public void playGame()
    {
        int previousX = 5, previousY = 5, input = 5;
        int[] answer;
        MasterArray game1 = new MasterArray();
        ConsoleIO keyboard = new ConsoleIO();
        while (game1.checkWon().equals(" "))
        {
            System.out.println("input: ");
            input = keyboard.readInt();
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
                        game1.getMiniArray(answer[0], answer[1]).getSquare(answer[3], answer[4]).setStatus(playerTurn);
                        game1.getMiniArray(answer[0], answer[1]).checkWon();
                    }
                }
            }
            previousX = answer[3];
            previousY = answer[4];
            count++;
        }
    }
    
 
}
