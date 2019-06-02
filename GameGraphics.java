import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.*;
/**
 * Binds together the board graphics, labels, and player status graphics 
 * together
 *
 * @author (Birla, Chang, Chung ,Liu)
 * @version (1.0)
 */
public class GameGraphics extends VBox
//VBox is used so that the label is under the board
{
    public GameGraphics(Play game)
    {
        getChildren().addAll(game.getMA().getGraphics(), game.getPS(), game.getNM());
        //puts all the graphics together in one place so it can be 
        //called at the same time at the beginning of the game
    }
}
