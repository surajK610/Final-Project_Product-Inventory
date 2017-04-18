/**
 * Controller of Checked.
 * 
 * @author Suraj
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.geometry.*;
import java.text.*;
import java.util.*;
import javafx.util.*;
public class CheckedController
{
    @FXML
    TableView<Item> table;
    
    @FXML
    TableColumn<Item, String> nameCol;
    @FXML
    TableColumn<Item, Double> priceCol;
    @FXML
    TableColumn<Item, Integer> quantCol;
    @FXML
    TableColumn<Item, String> typeCol;
    @FXML
    TableColumn<Item, String> locCol;
    @FXML
    TableColumn<Item, String> idCol;
    @FXML
    TableColumn<Item, String> markupCol;
    
    @FXML 
    Button finish;
    public void initialize()
    {
        //sets up table
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        locCol.setCellValueFactory(new PropertyValueFactory<>("loc"));
        markupCol.setCellValueFactory(new PropertyValueFactory<>("markup"));
        //adds items to table
        table.setItems(getProduct());

    }
    
    
    
    public ObservableList<Item> getProduct(){
        ObservableList<Item> products = FXCollections.observableArrayList();
        ArrayList <Item> inventory = SevenEleven_GUI.inventory().get();
        boolean [] inRange = SevenEleven_GUIController.getPriceQuant();
        //Gets all of the items
        for(int i = 0; i < inventory.size(); i ++)
        {
            System.out.println(inRange[i]);
            if(inRange[i] == true)
                products.add(inventory.get(i));
        }
        return products;
    }
    
    @FXML
    public void finish(ActionEvent e) throws java.io.IOException
    {
        //closes the open pane
       Stage stage = null; 
       Parent root = null;
       if(e.getSource()==finish){
          //get reference to the button's stage         
          ((Stage) finish.getScene().getWindow()).hide();
          
       }
    }
}
