
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.*;
/**
 * Write a description of class GameGraphics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameGraphics extends VBox
{
    public GameGraphics(Play game)
    {
        getChildren().addAll(game.getMA().getGraphics(), game.getPS());
        
    }
}
