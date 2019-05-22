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
        Board myBoard = new Board();
        Scene myScene = new Scene(myBoard.getGraphics());
        myScene.getStylesheets().add(
        getResource(
        "tictactoe-blueskin.css" 
        ) //getStylesheets() actually allows external URL images to be used
           );
           
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
