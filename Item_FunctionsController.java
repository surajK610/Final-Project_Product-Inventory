
/**
 * Controller of Item_Functions.
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
import javafx.scene.control.Alert.*;
public class Item_FunctionsController
{
    Item item = SevenEleven_GUIController.getItem();
    //fxml variables
    @FXML
    Label name;
    @FXML
    Label type;
    @FXML
    Label priceOb;
    @FXML
    Label priceSel;
    @FXML
    Label markup;
    @FXML
    Label loc;
    @FXML
    Label id;
    @FXML
    Label quantity;
    
    @FXML
    TextField quantAdd;
    @FXML
    TextField quantRem;
    @FXML
    Button add;
    @FXML
    Button rem;
    
    @FXML
    TextField nameSet;
    @FXML
    TextField priceSet;
    @FXML
    TextField locSet;
    @FXML
    TextField idSet;
    
    @FXML
    Button nameE;
    @FXML
    Button priceE;
    @FXML
    Button locE;
    @FXML
    Button idE;

    @FXML
    Button Finish;
     
    public void initialize()
    {
        //Initializies the Item_Functions to print out existing valuse
        name.setText(item.getName());
        type.setText("Type: " + item.getType());
        priceOb.setText("Price(obtained): " + item.getPrice());
        priceSel.setText("Price(selling): " + item.getPrices());
        markup.setText("Markup: " + item.getMarkup());
        loc.setText("Location: " + item.getLoc());
        id.setText("ID: " + Integer.toString(item.getID()));
        quantity.setText("Quantity: " + Integer.toString(item.getQuantity()));
    }
    
    @FXML
    public void add (ActionEvent e) throws java.io.IOException
    {
        //adds quantity 
        //outputs error box if wrong input
        try
        {
            item.addQuantity(Integer.parseInt(quantAdd.getText()));
            paneSet(e);
        }
        catch (java.lang.NumberFormatException exc)
         {
            String error = "Incorrect data input.";
            quantAdd.setText("");
            AlertBox(error);
        }
    }
    
    @FXML
    public void remove (ActionEvent e) throws java.io.IOException
    {
        //removes quantity
        //outputs error box if wrong input
        try
        {
            int rem = Integer.parseInt(quantRem.getText());
            if(item.getQuantity() - rem >= 0)
            {
                item.removeQuantity(rem);
            }
            paneSet(e);
        }
        catch (java.lang.NumberFormatException exc)
        {
            String error = "Incorrect data input.";
            quantRem.setText("");
            AlertBox(error);
        }
    }
    
    
    @FXML
    public void setName (ActionEvent e) throws java.io.IOException
    {
        //capitalizes and sets the items name
        item.setName((nameSet.getText().toUpperCase()));
        paneSet(e);
    }
    
    @FXML
    public void setPrice (ActionEvent e) throws java.io.IOException
    {
        //sets the price
        //outputs error box if wrong input
        try
        {
            item.setPrice(Double.parseDouble(priceSet.getText()));
            paneSet(e);
        }
        catch (java.lang.NumberFormatException exc)
        {
            String error = "Incorrect data input.";
            priceSet.setText("");
            AlertBox(error);
        }
    }
    
    @FXML
    public void setLoc (ActionEvent e) throws java.io.IOException
    {
        //sets the location
        item.setLoc(locSet.getText());
        paneSet(e);
    }
    
    @FXML
    public void setID (ActionEvent e) throws java.io.IOException
    {
        //sets the id
        //outputs error box if wrong input
        try
        {
            item.setID(Integer.parseInt(idSet.getText()));
            paneSet(e);
        }
        catch (java.lang.NumberFormatException exc) //if wrong input (cannot parse) then alertbox pops up
        {
            String error = "Incorrect data input.";
            idSet.setText("");
            AlertBox(error);
            
        }
    }
    
    @FXML
    public void finish (ActionEvent e) throws java.io.IOException
    {
        //closes the console to exit
        paneSet(e);
    }
    
    @FXML
    public void paneSet(ActionEvent event) throws java.io.IOException
    {
       Stage stage = null; 
       Parent root = null;
         if(event.getSource()==Finish){
          //closes the window       
           ((Stage) Finish.getScene().getWindow()).close();
           root = FXMLLoader.load(getClass().getResource("SevenEleven.fxml"));
       }
        else{
          //get reference to the name button's stage         
           stage =(Stage) name.getScene().getWindow();
           //load up OTHER FXML document
           root = FXMLLoader.load(getClass().getResource("ItemFunctions.fxml"));
           
           //create a new scene with root and set the stage
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
        }
        
    }
    
    
    public void AlertBox(String alertText)
    {
        //alert box
        Stage stage = new Stage();
        Alert alert = new Alert(AlertType.ERROR, alertText);
        alert.showAndWait();
    }
}
