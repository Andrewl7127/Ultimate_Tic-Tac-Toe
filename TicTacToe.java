import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


/**
 * Sets the scene and main graphic methods
 *
 * @author (Birla, Chang, Chung ,Liu)
 * @version (1.0)
 */
public class TicTacToe extends Application
{
    @Override public void start(Stage primaryStage)
    {
        //need to get new scene(getGraphics from new Board)
        Play game = new Play();
        GameGraphics graphics = new GameGraphics(game);
        Scene myScene = new Scene(graphics);
        myScene.getStylesheets().add(getResource("Graphics.css"));
           
        primaryStage.setTitle("Tic-Tac-Toe"); 
        primaryStage.setScene(myScene);
        primaryStage.show();
        
    }
    
    private String getResource(String resourceName) 
    {
        return getClass().getResource(resourceName).toExternalForm();
    } 
    
    public static void main(String[] args) 
    {
        Application.launch(TicTacToe.class);
    }
}
