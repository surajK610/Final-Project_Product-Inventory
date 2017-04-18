
/**
 * Controller of SevenEleven_GUI.
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
import javafx.scene.control.Alert.*;
public class SevenEleven_GUIController
{
    //needed to find which event is used to see what to print (ex. totalPrice)
    static String eventHap;
    //needed to find selected item
    static Item itemSel;
    //needed to find the array in priceRange() and checkQuantities()
    static boolean[]priceQuantOK;
    
    //Controls used in this fxml document
    @FXML
     Button inventory;
    
    @FXML 
    Button totalRevenue;
    @FXML 
    Button totalProfit;
    @FXML 
    Button totalCost;
    @FXML 
    Button totalQuantity;
     
    @FXML 
    Button priceOK;
    @FXML 
    Button quantOK;
     
    @FXML
    TextField minPrice;
    @FXML 
    TextField maxPrice;
     
    @FXML
    Label priceRangeLabel;
    @FXML 
    Label quanRangeLabel;

     
    @FXML 
    TextField minQuant;
    
    @FXML
    CheckBox food;
    @FXML
    CheckBox supplies;
    @FXML
    CheckBox toys;
    
    @FXML
    TextField name;
    @FXML 
    TextField price;
    @FXML
    TextField quan;
    @FXML 
    TextField loc;
    
    @FXML
    CheckBox damaged;
    
    @FXML
    Button add;
    
    @FXML 
    TextField nameRem;
    @FXML
    Button remove;
    @FXML
    Button edit;
    
     
    @FXML 
    Button logout;
    
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
    TableColumn<Item, Double> priceSCol;
    
    //Initializies the Seven_ElevenPage
    public void initialize()
    {
        //sets the values of the colums and fills in the table
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceSCol.setCellValueFactory(new PropertyValueFactory<>("prices"));
        quantCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        locCol.setCellValueFactory(new PropertyValueFactory<>("loc"));
        markupCol.setCellValueFactory(new PropertyValueFactory<>("markup"));
        table.setItems(getProduct());
    }
    
    
    public ObservableList<Item> getProduct(){
        ObservableList<Item> products = FXCollections.observableArrayList();
        //Get all of the items
        ArrayList <Item> inventory = SevenEleven_GUI.inventory().get();
        for(Item item: inventory)
            products.add(item);
        return products;
    }
    
    
    @FXML
    public void priceRange(ActionEvent e) throws java.io.IOException
    {
        boolean canMake = true;
        int minPrice = 0, maxPrice = 0;
        //tries to parse input, if incorrect outputs error box
        try
        {
            minPrice = Integer.parseInt(this.minPrice.getText());
            maxPrice = Integer.parseInt(this.maxPrice.getText());
        }
        catch (java.lang.NumberFormatException exc)
        {
            String error = "Incorrect data input.";
            quan.setText("");
            AlertBox(error);
            canMake = false;
            
            this.minPrice.setText("");
            this.maxPrice.setText("");
        
        }
        
        if(canMake)
        {
            //opens a new pane with all items between this price range
            priceQuantOK = SevenEleven_GUI.inventory().priceRange(minPrice, maxPrice);
            paneSet(e);
        }
        
        this.minPrice.setText("");
        this.maxPrice.setText("");
        
        
    }
    
    
    @FXML
    public void quantRange(ActionEvent e) throws java.io.IOException
    {
        boolean canMake = true;
        int minQuant = 0;
        //tries to parse input, if incorrect outputs error box
        try
        {
            minQuant = Integer.parseInt(this.minQuant.getText());
        }
        catch (java.lang.NumberFormatException exc)
        {
            String error = "Incorrect data input.";
            quan.setText("");
            AlertBox(error);
            canMake = false;
            
            this.minQuant.setText("");
        }
        
        this.minQuant.setText("");
        //opens a new pane with all items above this quantity
        if(canMake)
        {
            priceQuantOK = SevenEleven_GUI.inventory().checkQuantities(minQuant);
            paneSet(e);
        }
    }
    
    //prints total revenue
    @FXML
    public void totalRevenue(ActionEvent e) throws java.io.IOException
    {
        paneSet(e);
    }
    
    //prints total cost
    @FXML
    public void totalCost(ActionEvent e) throws java.io.IOException
    {
        paneSet(e);
    }
    
    //prints total profit
    @FXML
    public void totalProfit(ActionEvent e) throws java.io.IOException
    {
        paneSet(e);
    }
    
    //print total quantities in popup
    @FXML
    public void totalQuantities(ActionEvent e) throws java.io.IOException
    {
        paneSet(e);
    }
    
    //adds item
    @FXML
    public void add(ActionEvent e) throws java.io.IOException
    {
        //used to make sure have all the variables
        boolean canMake = true;
        String type = "";
        String nameItem = "";
        String locItem = "";
        int quanItem = 0;
        double priceItem = 0;
        
        if (food.isSelected())
            type = "Food";
        else if (supplies.isSelected())
        {
            type = "Supplies";
        }
        else if (toys.isSelected())
        {
            type = "Toys";
        }
        else 
        {
            String error = "No type selected.";
            AlertBox(error);
            canMake = false;
            
        }
        nameItem = name.getText();
        locItem = loc.getText();
        
        //tries to parse input, if incorrect outputs error box
        if (canMake)
            {
            try 
            {
                quanItem = Integer.parseInt(quan.getText());
            }
            catch (java.lang.NumberFormatException exc)
            {
                String error = "Incorrect data input.";
                quan.setText("");
                AlertBox(error);
                canMake = false;
                
                food.setSelected(false);
                supplies.setSelected(false);
                toys.setSelected(false);
                
                name.setText("");
                loc.setText("");
                quan.setText("");
                price.setText("");
                
                damaged.setSelected(false);
            }
            
            //tries to parse input, if incorrect outputs error box
            try
            {
                priceItem = Double.parseDouble(price.getText());
            }
            catch (java.lang.NumberFormatException exc)
            {
                String error = "Incorrect data input.";
                price.setText("");
                AlertBox(error);
                canMake = false;
                
                food.setSelected(false);
                supplies.setSelected(false);
                toys.setSelected(false);
                
                name.setText("");
                loc.setText("");
                quan.setText("");
                price.setText("");
            }
        }
        
        if (canMake)
        {
            if (type.equals("Food") && damaged.isSelected())
            {
                AlertBox("Food cannot be damaged. Item not added");
            }
            else
                SevenEleven_GUI.inventory().add(type, nameItem, priceItem, quanItem, locItem, damaged.isSelected());
        }
        
        food.setSelected(false);
        supplies.setSelected(false);
        toys.setSelected(false);
        
        name.setText("");
        loc.setText("");
        quan.setText("");
        price.setText("");
        paneSet(e);
        
        
    }
    
    
    
    @FXML
    public void edit(ActionEvent e) throws java.io.IOException
    {
        //if something is selected opens pop up to edit selected item
        if (table.getSelectionModel().getSelectedIndex() >= 0)
        {
            int index = table.getSelectionModel().getSelectedIndex();
            itemSel = SevenEleven_GUI.inventory().get(index);
            paneSet(e);
        }
    }
    
    @FXML
    public void remove(ActionEvent e) throws java.io.IOException
    {
        //if something is selected opens pop up to remove selected item
        if (table.getSelectionModel().getSelectedIndex() >= 0)
        {
            int index = table.getSelectionModel().getSelectedIndex();
            SevenEleven_GUI.inventory().get().remove(index);
            paneSet(e);
        }
    }
    
    
    @FXML
    public void paneSet(ActionEvent event) throws java.io.IOException
    {
        //sets the screen
       Stage stage = null; 
       Parent root = null;
       boolean makeScene = true;
       if(event.getSource()==add || event.getSource()==remove){
          //get reference to the button's stage         
           stage =(Stage) add.getScene().getWindow();
           //load up OTHER FXML document
           root = FXMLLoader.load(getClass().getResource("SevenEleven.fxml"));
        }
        else if(event.getSource()==edit){
          //get reference to the button's stage         
           stage =new Stage();
           //load up OTHER FXML document
           root = FXMLLoader.load(getClass().getResource("ItemFunctions.fxml"));
        }
       else if(event.getSource()==inventory){
          //get reference to the button's stage         
           stage =(Stage) inventory.getScene().getWindow();
           //load up OTHER FXML document
           root = FXMLLoader.load(getClass().getResource("Print1.fxml"));
        }
        
         else  if(event.getSource()==totalRevenue){
          //get reference to the button's stage         
           stage = new Stage();
           //load up OTHER FXML document
           eventHap = "totalRevenue";
           root = FXMLLoader.load(getClass().getResource("OutputBox.fxml"));
           
        }
        else  if(event.getSource()==totalCost){
          //get reference to the button's stage         
           stage = new Stage();
           //load up OTHER FXML document
           eventHap = "totalCost";
           root = FXMLLoader.load(getClass().getResource("OutputBox.fxml"));
           
        }
        else  if(event.getSource()==totalProfit){
          //get reference to the button's stage         
           stage = new Stage();
           //load up OTHER FXML document
           eventHap = "totalProfit";
           root = FXMLLoader.load(getClass().getResource("OutputBox.fxml"));
           
        }
        else  if(event.getSource()==totalQuantity){
          //get reference to the button's stage         
           stage = new Stage();
           //load up OTHER FXML document
           eventHap = "totalQuantity";
           root = FXMLLoader.load(getClass().getResource("OutputBox.fxml"));
           
        }
         else  if(event.getSource()==logout){
          //get reference to the button's stage         
           stage =(Stage) logout.getScene().getWindow();
           //load up OTHER FXML document
           root = FXMLLoader.load(getClass().getResource("LoginBox.fxml"));
        }
        else if (event.getSource()==table){
          //get reference to the button's stage         
           stage = new Stage();
           //load up OTHER FXML document
           root = FXMLLoader.load(getClass().getResource("ItemFunctions.fxml"));
           
        }
        else  if(event.getSource()==priceOK){
          //get reference to the button's stage         
           stage = new Stage();
           //load up OTHER FXML document
           eventHap = "priceRange";
           root = FXMLLoader.load(getClass().getResource("Checked.fxml"));
           
        }
        else if(event.getSource()==quantOK){
           //get reference to the button's stage         
           stage = new Stage();
           //load up OTHER FXML document
           eventHap = "checkQuantities";
           root = FXMLLoader.load(getClass().getResource("Checked.fxml"));
           
        }
        else
        {
            //get reference to the button's stage         
           stage = new Stage();
           //load up OTHER FXML document
           root = FXMLLoader.load(getClass().getResource("Checked.fxml"));
           
        }
        
        //create a new scene with root and set the stage
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.showAndWait();
       
       paneSet();
    }
    
    
    @FXML
    public void logout(ActionEvent e) throws java.io.IOException
    {
        //logs out
        SevenEleven_GUI.logout();
        paneSet(e);
    }
    
    
    private void paneSet() throws java.io.IOException
    {
       Stage stage = null; 
       Parent root = null;
       
        //get reference to the button's stage         
       stage =(Stage) add.getScene().getWindow();
        //load up OTHER FXML document
       root = FXMLLoader.load(getClass().getResource("SevenEleven.fxml"));
         
       //refreshes the screen
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }
    
    
    public static String getEvent()
    {
        //returns which button was clicked to format pop up
        return eventHap;
    }
    
    
    public static Item getItem()
    {
        //gets the item selected (in table)
        return itemSel;
    }
    
    
    public static boolean[] getPriceQuant()
    {
        //returns the boolean array from priceRange or quantitiesCheck
        return priceQuantOK;
    }
    
    //information hiding as sets the type of the error to remove that parameter
    public void AlertBox(String alertText)
    {
        //makes a new Alert with customizable text
        Stage stage = new Stage();
        Alert alert = new Alert(AlertType.ERROR, alertText);
        alert.showAndWait();
    }
}
