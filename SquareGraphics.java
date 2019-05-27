

import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;
import javafx.event.*;
import javafx.scene.image.*;
/**
 * Write a description of class SquareGraphics here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SquareGraphics extends StackPane
{
    //Image = class that allows pictures to be added through URLs
  //image of X
  static final Image noughtImage = new Image(
      "http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/128/green-cd-icon.png"
  );
  
  //image of O
  static final Image crossImage = new Image(
      "http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/128/blue-cross-icon.png"
  );
  
  //ImageView = allows Image objects to be used
  //need this variable to add the X or O
  private final ImageView imageView = new ImageView();
  
    /**
     * Constructor for objects of class SquareGraphics
     */
    public SquareGraphics(Square square)
    {
     //built-in method for associating string "square" with Square object 
    getStyleClass().add("square"); 
    
    //images will be hidden initially (X and O not seen)
    imageView.setMouseTransparent(true);

    getChildren().setAll(imageView); //adds imageView as children
    
    //set size of square
    setPrefSize(crossImage.getHeight() + 20, crossImage.getHeight() + 20);
        
        
     setOnMousePressed(new EventHandler<MouseEvent>() 
     {
      @Override public void handle(MouseEvent mouseEvent) {
        square.clicked();
        
        if(square.getStatus().equals(""))
            imageView.setImage(null); 
        if(square.getStatus().equals("X"))
            imageView.setImage(crossImage);
        if(square.getStatus().equals("O"))
            imageView.setImage(noughtImage);
      }
     });
    
    }
    
    
}

    
