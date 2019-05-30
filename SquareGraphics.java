

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
   
    static final Image blue = new Image(
    "https://rlv.zcache.com.au/solid_blue_solid_background_solid_color_square_sticker-rc755b95b45bb48888138093c66cfeea3_v9wf3_8byvr_307.jpg?rvtype=content"
    );
    
    static final Image green = new Image(
    "https://re-mm-assets.s3.amazonaws.com/product_photo/21547/large_Poly_NeonGreen_375u_1471502194.jpg"
    );
    
    static final Image gray = new Image(
    "https://rlv.zcache.ca/glacier_gray_grey_trend_color_background_square_sticker-r4921143c931140039a82119823021dac_v9wf3_8byvr_307.jpg?rvtype=content"
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
    setPrefSize(crossImage.getHeight()/2, crossImage.getHeight()/2);
        
        
     setOnMousePressed(new EventHandler<MouseEvent>() 
     {
      @Override public void handle(MouseEvent mouseEvent) {
        if (square.getStatus().equals(" "))
        {
         square.clicked(square.getPlay());
         Square squarey = square;
        if(square.getStatus().equals(" "))
            imageView.setImage(null); 
        if(square.getStatus().equals("X") && imageView.getImage() == null)
        {    
            imageView.setImage(crossImage);
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);
        }
        
        if(square.getStatus().equals("O") && imageView.getImage() == null)
        {    
            imageView.setImage(noughtImage);
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);
        }
      }
    }
    
     });
      
     
    }
    
    public void changeColor(String winner)
    {
        System.out.println(winner);
        if(winner.equals("X"))
        {
            imageView.setImage(blue);
            imageView.setFitWidth(62);
            imageView.setFitHeight(62);
        }
        
        if(winner.equals("O"))
        {
            imageView.setImage(green);
            imageView.setFitWidth(62);
            imageView.setFitHeight(62);
        }
        
        if(winner.equals("D"))
        {
            imageView.setImage(gray);
            imageView.setFitWidth(62);
            imageView.setFitHeight(62);
        }
    }
}

    
