import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;
import javafx.event.*;
/**
 * Write a description of class SquareGraphics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SquareGraphics extends StackPane
{
 
    /**
     * Constructor for objects of class SquareGraphics
     */
    public SquareGraphics(Square square)
    {
     setOnMousePressed(new EventHandler<MouseEvent>() 
     {
      @Override public void handle(MouseEvent mouseEvent) {
        square.clicked();
      }
     });
    
    }
}

    
