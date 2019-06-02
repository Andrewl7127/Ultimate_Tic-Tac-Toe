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
        //gets everything necessary to start the game
        Play game = new Play();
        GameGraphics graphics = new GameGraphics(game);
        Scene myScene = new Scene(graphics);
        myScene.getStylesheets().add(getResource("Graphics.css"));
           
        primaryStage.setTitle("Tic-Tac-Toe"); 
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
    //Allows us to use graphics.css
    private String getResource(String resourceName) 
    {
        return getClass().getResource(resourceName).toExternalForm();
    } 
    
    /**
     * Launches the application
     */
    public static void main(String[] args) 
    {
        Application.launch(TicTacToe.class);
    }
}
