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
  
            moveLabel.setText("Next Move: " + getNext(prevX,prevY));
            
        }
        else
        {
            //any move
            moveLabel.setText("Next Move: Any");
            
        }
    }
        
  
    }
    
    private String getNext(int x, int y)
    {
       String temp = "";
       if(y==0)
        temp = "Top";
        else
            if (y==1)
                temp = "Middle";
                else
                    temp = "Bottom";
        
       temp += " Row, ";
       
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
