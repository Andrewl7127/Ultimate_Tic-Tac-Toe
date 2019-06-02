import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
/**
 * Write a description of class NextMove here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NextMove extends HBox
{
    private final Label moveLabel = new Label("Next Move: Any");
    private String coord1;
    private String coord2;
    
    /**
     * Constructor for objects of class NextMove
     */
    public NextMove()
    {
        moveLabel.getStyleClass().add("info");
        moveLabel.setTextFill(Color.web("#FAEBD7"));
        getChildren().addAll(moveLabel);
    }
    
    public void changeCoord(int prevX, int prevY, MasterArray master)
    {
        if(!master.checkWon().equals(" "))
        {
            if(master.getMyWinner().equals("D"))
                moveLabel.setText("Draw!");
            else
                moveLabel.setText("Player " + master.getMyWinner() + " wins!");
        }
        
        else{
        
           if(master.getMiniArray(prevX, prevY).getFinishedSquare().equals(" "))
        {
            //new label next move prevX+1. prevY+1
            coord1 = Integer.toString(prevX+1);
            coord2 = Integer.toString(prevY + 1);
            moveLabel.setText("Next Move: " + coord1 + " " + coord2);
            
        }
        else
        {
            //any move
            moveLabel.setText("Next Move: Any");
            
        }
    }
        
    }
}
