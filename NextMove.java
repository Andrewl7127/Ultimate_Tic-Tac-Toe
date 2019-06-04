import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
/**
 * Write a description of class NextMove here.
 *
 * @author (Birla, Chang, Chung ,Liu)
 * @version (1.0)
 */
public class NextMove extends HBox
{
    //the label object printed at the bottom of the board
    private final Label moveLabel;
    
    /**
     * Constructor for objects of class NextMove
     */
    public NextMove()
    {
        //label at the beginning, prints message stating the next move
        moveLabel = new Label("Next Move: Any");
        //grabs the information from Graphics.css
        moveLabel.getStyleClass().add("info");
        //changes label color to white
        moveLabel.setTextFill(Color.web("#FAEBD7"));
        //causes the label to show up
        getChildren().addAll(moveLabel);
    }
    
    /**
     * changes the label to reflect whether the game is won or where the next
     * move should be
     * @param    prevX   used to determine where the last play was made
     *                   so we can print where the next move should be
     * @param    prevY   used to determine where the last play was made
     *                   so we can print where the next move should be
     * @param    master  the board we are using
     */
    public void changeCoord(int prevX, int prevY, MasterArray master)
    {
        //if the game is finished
        if(!master.checkWon().equals(" "))
        {
            //if the game is a draw, prints draw
            if(master.getMyWinner().equals("D"))
                moveLabel.setText("Draw!");
            //states the winning player
            else
                moveLabel.setText("Player " + master.getMyWinner() + " wins!");
        }
        else
        {
            //determines and prints where the next move should be
            if(master.getMiniArray(prevX, prevY).getFinishedSquare().equals(" "))
            {
                moveLabel.setText("Next Move: " + getNext(prevX,prevY));
            }
            else
            {   
                //if the square that should be played is already filled,
                //any move can be made
                moveLabel.setText("Next Move: Any");
            }
        }
    }
    
    //method used in changeCoord to translate number location of square
    //into words. param is where the squares should be
    private String getNext(int x, int y)
    {
       //the final printed statement
       String temp = "";
       //determines where the square is on the horizontal level
       if(y==0)
          temp = "Top";
          else
              if (y==1)
                  temp = "Middle";
                  else
                     temp = "Bottom";
       temp += " Row, ";
       //determines where the square is on the vertical level
       if(x==0)
         temp += "Left";
         else
             if (x==1)
                temp += "Middle";
                else
                    temp += "Right";
       temp+= " Column";
       return temp;
    }
}
