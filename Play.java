
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
        int count = 1, previousX = 99, previousY = 99;
        String player = "";
        MasterArray game1 = new MasterArray();
        while (game1.checkWon().equals(" "))
        {
            if (count % 2 != 0)
                player = "X";
            else
                player = "O";
            if (
            
            game1.doMove(x1, y1, x, y, player);
            previousX = x;
            previousY = y;
        }
    }
}
