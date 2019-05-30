import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.*;
/**
 * Write a description of class PlayerStatus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerStatus extends HBox
{
    static final Image noughtImage = new Image(
       "http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/128/green-cd-icon.png"
  );
        static final Image crossImage = new Image(
      "http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/128/blue-cross-icon.png"
  );
        private final ImageView imageView = new ImageView();
        private final Label playerLabel = new Label("Current Player: ");
    public PlayerStatus()
    {
        imageView.setMouseTransparent(true);
        getChildren().setAll(imageView);
        
        
    }
    
    public void currentPlayerX()
    {
       imageView.setImage(crossImage);
       imageView.setFitWidth(40);
       imageView.setFitHeight(40);
    }
    
    public void currentPlayerO()
    {
        imageView.setImage(noughtImage);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
    }
}
