import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
/**
 * Creates the graphics under the board to show who's turn it is
 *
 * @author (Birla, Chang, Chung ,Liu)
 * @version (1.0)
 */
public class PlayerStatus extends HBox
//HBox used to position the bottom labels to the left
{
    //gets the nought and cross images from the internet
    static final Image noughtImage = new Image
       ("http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/128/green-cd-icon.png");
    static final Image crossImage = new Image
      ("http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/128/blue-cross-icon.png");
    //imageView is the place where the image actually shows up
    private final ImageView imageView = new ImageView();
    //label at the bottom of the board to show who's turn it is
    private final Label playerLabel = new Label("Current Player: ");
        
        
    public PlayerStatus()
    {
        playerLabel.getStyleClass().add("info");
        //sets label color to white
        playerLabel.setTextFill(Color.web("#FAEBD7"));
        imageView.setMouseTransparent(true);
        //on the first call,image is set to x because x always goes first
        imageView.setImage(crossImage);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        //puts the label and the player image together
        getChildren().addAll(playerLabel, imageView);
    }
    
    public void currentPlayerX()
    {
       //sets the actual image and image size for x
       imageView.setImage(crossImage);
       imageView.setFitWidth(30);
       imageView.setFitHeight(30);
    }
    
    public void currentPlayerO()
    {
        //sets the actual image and image size for o
        imageView.setImage(noughtImage);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
    }
}