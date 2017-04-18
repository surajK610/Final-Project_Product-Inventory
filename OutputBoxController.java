
/**
 * Controller of OutputBox.
 * 
 * @author Suraj
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
public class OutputBoxController
{
    @FXML
    Button okB;
    @FXML
    Label output;
    
    @FXML
    public void initialize()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String event = SevenEleven_GUIController.getEvent();
        //depending on the event the outputBox contains different strings
        if (event.equals("totalRevenue"))
            output.setText("The total revenue is "  + fmt.format(SevenEleven_GUI.inventory().totalPrice()) + ".");
        else if (event.equals("totalCost"))
            output.setText("The total cost is " + fmt.format(SevenEleven_GUI.inventory().totalCost()) + ".");
        else if (event.equals("totalProfit"))
            output.setText("The total profit is " + fmt.format(SevenEleven_GUI.inventory().totalProfit()) + ".");
        else if (event.equals("totalQuantity"))
            output.setText("The total quantity is " + SevenEleven_GUI.inventory().totalQuantity() + ".");
    }
    
    @FXML
    public void paneSet(ActionEvent event) throws java.io.IOException
    {
       Stage stage = null; 
       Parent root = null;
       if(event.getSource()==okB){
          //closes window         
          ((Stage) okB.getScene().getWindow()).hide();
          
       }
    }
}
