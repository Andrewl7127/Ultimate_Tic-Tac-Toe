import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


/**
 * Write a description of class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicTacToe extends Application
{
    @Override public void start(Stage primaryStage)
    {
        //need to get new scene(getGraphics from new Board)
        Play game = new Play();
        GameGraphics test123 = new GameGraphics();
        
        Scene myScene = new Scene(game.getMA().getGraphics());
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
