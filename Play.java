
/**
 * Write a description of class Play here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Play
{
    public static void main(String[] args)
    {
        int count = 1, previousX = 5, previousY = 5, input = 5;
        int[] answer = new int[4];
        String player = "";
        MasterArray game1 = new MasterArray();
        while (game1.checkWon().equals(" "))
        {
            answer = game1.inputConvert(input);
            if (count % 2 != 0)
                player = "X";
            else
                player = "O";
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
                        game1.doMove(answer[0], answer[1], answer[3], answer[4], player);
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
