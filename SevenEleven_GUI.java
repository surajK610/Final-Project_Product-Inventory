
/**
 * This is the GUI display class.
 * 
 * @author Suraj Anand
 * @version 1
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
 public class SevenEleven_GUI extends Application{
    private boolean login = false;
    private static Inventory sevenEleven = new Inventory();
    static Users user = new Users();
    
    Stage stage;
    Pane root;
    
    @FXML 
    TextField fieldUser;
    
    @FXML
    PasswordField fieldPass;
    
    @FXML
    CheckBox checkMan;
    
    @FXML
    Button okButton;
    
    public static void main(String[] args)
     {   
       launch(args);    
     }

    @Override
    public void start(Stage stage) throws Exception
    {
        //printLabel.setText(sevenEleven.toString());
        System.out.println(sevenEleven);
        // Users user = new Users();
       
        Pane pane = FXMLLoader.load(getClass().getResource("SevenEleven.fxml"));   
        GridPane login =  (FXMLLoader.load(getClass().getResource("LoginBox.fxml")));

        //Stage window = new Stage();
        //Block events to other windows: found from youtube thenewboston
        //stage.initModality(Modality.APPLICATION_MODAL);
        
        
        //Display window and wait for it to be closed before returning
        Scene scene1 = new Scene(pane);
        Scene scene2 = new Scene(login);
        
        stage.setTitle("Seven Eleven"); 
        
        stage.setScene(scene2);
        stage.show();  
        
     }
    
    @FXML
    public void login(ActionEvent e) throws java.io.IOException
    {
        
        
        login = ((checkMan.isSelected()) ? user.userManager(fieldUser.getText(), fieldPass.getText()) : user.login(fieldUser.getText(), fieldPass.getText()));
        if (login)
        {    
           ((Node)(e.getSource())).getScene().getWindow().hide();
           //stage.setScene(store);
           paneSet(e);
        }
        
    }
    
    public static String getInventory()
    {
        return sevenEleven.toString();
    }
    
     public static Inventory inventory()
    {
        return sevenEleven;
    }
    
    public void paneSet(ActionEvent event) throws java.io.IOException
    {
       Stage stage = null; 
       Parent root = null;
       if(event.getSource()==okButton){
          //get reference to the button's stage         
           stage =(Stage) okButton.getScene().getWindow();
           //load up OTHER FXML document
           root = FXMLLoader.load(getClass().getResource("SevenEleven.fxml"));
        }
        //create a new scene with root and set the stage
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
    }
    
    public static String totalRevenue()
    {
        DecimalFormat fmt = new DecimalFormat("0.##");
        double rev = 0;
        rev = sevenEleven.totalPrice();
        return "The total revenue is " + fmt.format(rev) + ".";
    }
    
    public static String totalCost()
    {
        DecimalFormat fmt = new DecimalFormat("0.##");
        double cost = 0;
        cost = sevenEleven.totalCost();
        return "The total cost is " + fmt.format(cost) + ".";
    }
    
    @FXML
    public static String totalProfit()
    {
        DecimalFormat fmt = new DecimalFormat("0.##");
        double profit = 0;
        profit = sevenEleven.totalProfit();
        return "The total profit is " + fmt.format(profit) + ".";
    }
    
    @FXML
    public static String totalQuantities()
    {
        int quant = sevenEleven.totalQuantity();
        return "The total quantities is " + quant + ".";
    }
    
    public static void logout()
    {
        user.logout();
    }


 }
 