
/**
 * Controller of Print1
 * @author Suraj Anand
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.geometry.*;



import java.text.*;
public class PrintController 
{
     @FXML
     Label printLabel;
     @FXML
     Button stopPrint;
     
     @FXML
    private void initialize() {
        printLabel.setText(SevenEleven_GUI.getInventory());
    }

    @FXML
    public void paneSet(ActionEvent event) throws java.io.IOException
    {
       Stage stage = null; 
       Parent root = null;
       //goes back to the seven eleven main page if the ok button is pressed
         if(event.getSource()==stopPrint){
          //get reference to the button's stage         
           stage =(Stage) stopPrint.getScene().getWindow();
           //load up OTHER FXML document
           root = FXMLLoader.load(getClass().getResource("SevenEleven.fxml"));
        }
      //create a new scene with root and set the stage
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }
    
}
