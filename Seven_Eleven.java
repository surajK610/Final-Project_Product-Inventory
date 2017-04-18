/**
 * This is the driver class, console version
 * 
 * @author Suraj
 */
import java.util.*;
public class Seven_Eleven
{
    static Inventory store = new Inventory();
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        String user, pass;
        boolean login;
        
        Users users = new Users();
        
        
        //method to clear screan by printing 25 new lines
        char c = '\n';
        int length = 100;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
        
        
        Users sam = new Users("Sam", "samsam");
        Item item = new Supplies("usb 8gb", 9.99, 10015, 30, "S6");
        store.add(item, false);
        System.out.println(store);
        login = sam.getManager();
        
        //whiel the login is wrong either try again or exit
       while(!login)
       {
            System.out.println("Would you like to try again(y/n)?");
            String again = scan.next();
            
            if(again.equalsIgnoreCase("y"))
            {
               login = users.login();
            }
            else
            {
                System.exit(0);
            }
       }
        
       System.out.println("Enter the name of the method:" + 
              "\n To remove an item by name: ENTER Name." +
              "\n To remove an item by location: ENTER Loc." + 
              "\n To remove an item by ID: ENTER ID." + 
              "\n To exit: ENTER Exit." );
       String func = scan.next(); 
       if (func.equalsIgnoreCase("Name"))
       {
           System.out.println("Enter the name of the item.");
           String name = scan.next();
           store.deleteByName(name);
       }
       else if (func.equalsIgnoreCase("Loc"))
       {
           System.out.println("Enter the location of the item.");
           String loc = scan.next();
           store.deleteByLoc(loc);
       }
       else if (func.equalsIgnoreCase("ID"))
       {
           System.out.println("Enter the ID of the item.");
           int ID = scan.nextInt();
           store.deleteByID(ID);
       }
       else if (func.equalsIgnoreCase("Exit"))
       {
        }
       else 
       {
           System.out.println("Sorry, that is not a valid function. Please reenter.");
        }
       
       Perform_Functions.functions(store, login);
    }
}
