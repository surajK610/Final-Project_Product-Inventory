
/**
 * Write a description of class Perform_Functions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.text.*;
public class Perform_Functions
{
   public static void functions(Inventory inventory, boolean login)
   {
       //interface to ask method and then implement it
       NumberFormat currency = NumberFormat.getCurrencyInstance();
       
       Scanner scan = new Scanner(System.in);
       String another = "y";
       
       String fun = "";
       int function = 0;
       while(login)
       {
           while(another.equalsIgnoreCase("y"))
            {
              System.out.println("Enter the name of the method:" + 
              "\n To add an item: ENTER Add." +
              "\n To remove an item: ENTER Remove." +
              "\n To search for an item: ENTER Search." +
              "\n To enter a price range: ENTER PriceRange." +
              "\n To check for quantites of items in the inventory above or below a certain threshold: ENTER CheckQuantities." +
              "\n For more methods: ENTER More");
              fun = scan.next();
              if (fun.equalsIgnoreCase("More"))
              {
                  System.out.println(
                  "\n To find the total selling price of the current inventory: ENTER Price" +
                  "\n To find the total cost of the current inventory: ENTER Cost" + 
                  "\n To find the total profit of the current inventory: ENTER Profit" + 
                  "\n To find the number of items in the current inventory: ENTER Quanities" + 
                  "\n To list the current inventory: ENTER Inventory" +
                  "\n To logout: ENTER Logout");
                  fun = scan.next();
                }
                
              if (fun.equalsIgnoreCase("Add"))
              {
                  Add(inventory);
                  }
              else if (fun.equalsIgnoreCase("Remove"))
              {
                  Remove(inventory);
                  }   
              else if (fun.equalsIgnoreCase("Search"))
              {
                  Search(inventory);
                  }
              else if (fun.equalsIgnoreCase("PriceRange"))
              {
                  PriceRange(inventory);
                  }
              else if (fun.equalsIgnoreCase("CheckQuantities"))
              {
                  CheckQuantities(inventory);
                }
              else  if (fun.equalsIgnoreCase("Price"))
              {
                  System.out.println("The total selling price(revenue) of the current inventory is " + currency.format(inventory.totalPrice()) + ".");
                }
              else if (fun.equalsIgnoreCase("Cost"))
              {
                  System.out.println("The total cost of the current inventory is " + currency.format(inventory.totalCost()) + ".");
                }
              else if (fun.equalsIgnoreCase("Profit"))
              {
                  System.out.println("The total profit of the current inventory is " + currency.format(inventory.totalProfit()) + ".");
                }
              else if (fun.equalsIgnoreCase("Quantities"))
              {
                  System.out.println("The total number of items in the current inventory is " + currency.format(inventory.totalQuantity()) + ".");
                }
              else if (fun.equalsIgnoreCase("Inventory"))
              {
                  System.out.println(inventory);
                }
              else
              {
                  System.out.println("Sorry not a valid input. Please try again.");
                  functions(inventory, true);
                }
              System.out.println("Do you want to perform any other item functions(y/n)?");
              another = scan.next();
          }
        }
    }
    
    private static void Add(Inventory inventory)
   {
       //adds item
       Scanner scan = new Scanner(System.in);
       Item item_New;
       String type, name, loc;
       double price;
       int quantity;
       
       System.out.println("Enter the type of the item(Food, Supplies, Toys).");
       type = scan.next();
       System.out.println("Enter the name of the item.");
       name = scan.next();
       System.out.println("Enter the location of the item(F#, S#, T#).");
       loc = scan.next();
       System.out.println("Enter the price of the item(no $).");
       price = scan.nextDouble();
       System.out.println("Enter the quantity of the item.");
       quantity = scan.nextInt();
       
       inventory.add(type, name, price, quantity, loc);
    }
    
     private static void Remove(Inventory inventory)
   {
       //removes item
       Scanner scan = new Scanner(System.in);
       String func;
       System.out.println("Enter the name of the method:" + 
              "\n To remove an item by name: ENTER Name." +
              "\n To remove an item by location: ENTER Loc." + 
              "\n To remove an item by ID: ENTER ID." + 
              "\n To exit: ENTER Exit." );
       func = scan.next(); 
       if (func.equalsIgnoreCase("Name"))
       {
           System.out.println("Enter the name of the item.");
           String name = scan.next();
           inventory.deleteByName(name);
       }
       else if (func.equalsIgnoreCase("Loc"))
       {
           System.out.println("Enter the location of the item.");
           String loc = scan.next();
           inventory.deleteByLoc(loc);
       }
       else if (func.equalsIgnoreCase("ID"))
       {
           System.out.println("Enter the ID of the item.");
           int ID = scan.nextInt();
           inventory.deleteByID(ID);
       }
       
       else if (func.equalsIgnoreCase("Exit"))
       {
           //exits if this is typed
        }
       else 
       {
           System.out.println("Sorry, that is not a valid function. Please reenter.");
           Remove(inventory);
        }
    }
        
   private static void Search(Inventory inventory)
   {
       //searched based on typed method
       Scanner scan = new Scanner(System.in);
       String search;
       System.out.println("Enter the name of the method:" + 
              "\n To search for an item by name: ENTER Name." +
              "\n To search for an item by location: ENTER Loc." +
              "\n To search for an item by ID: ENTER ID.");
       search = scan.nextLine();
              
       if(search.equalsIgnoreCase("Name"))
       {
           String name;
           System.out.println("Enter the name of the item.");
           name = scan.nextLine();
           Item item = inventory.searchByName(name);
           itemFunc(item);
        }
        else if(search.equalsIgnoreCase("Loc"))
       {
           String loc;
           System.out.println("Enter the location of the item.");
           loc = scan.next();
           Item item = inventory.searchByLocation(loc);
           itemFunc(item);
        }
        else if(search.equalsIgnoreCase("ID"))
       {
           int ID;
           System.out.println("Enter the ID of the item.");
           ID = scan.nextInt();
           Item item = inventory.searchByID(ID);
           itemFunc(item);
        }
        else 
        {
           System.out.println("Not a valid command. Please reenter.");
           Search(inventory);
        }
       
    }
    
    
    private static void itemFunc(Item item)
   {
       //allows user to perform functions on the item he/she searched
       String another = "y";
       while(another.equalsIgnoreCase("y"))
       {
         
           Scanner scan = new Scanner(System.in);
           
           String func;
           System.out.println("Enter the name of the method:" + 
                  "\n To add quantity for an item: ENTER Add." +
                  "\n To remove quantity of an item: ENTER Remove." +
                  "\n To set the name of an item: ENTER Name." +
                  "\n To set the location of an item: ENTER Loc." +
                  "\n To set the individial price an item was bought for: ENTER Price." +
                  "\n To set quantity for an item: ENTER Quantity." +
                  "\n To set damaged for an item: ENTER Damaged." +
                  "\n To get all statistics: ENTER Stats." + 
                  
                  "\n\n To go back: ENTER Back.");
                  
           func = scan.next();
           
           if (func.equalsIgnoreCase("Add"))
           {
               System.out.println("Enter the amount of the item you want to add.");
               int add = scan.nextInt();
               
               item.addQuantity(add);
            }
           else if (func.equalsIgnoreCase("Remove"))
           {
               System.out.println("Enter the amount of the item you want to remove.");
               int rem = scan.nextInt();
               
               item.removeQuantity(rem);
            }
           else if (func.equalsIgnoreCase("Name"))
           {
               System.out.println("Enter the new name of the item.");
               String name = scan.next();
               
               item.setName(name);
            }
           else if (func.equalsIgnoreCase("Price"))
           {
               System.out.println("Enter the new price the item was bought for.");
               double price = scan.nextDouble();
               
               item.setPrice(price);
            }
           else if (func.equalsIgnoreCase("Loc"))
           {
               System.out.println("Enter the new location of the item.");
               String loc = scan.next();
               
               item.setLoc(loc);
            }
           else if (func.equalsIgnoreCase("Damaged"))
           {
               item.setDamaged(true);
            }
           else if (func.equalsIgnoreCase("Stats"))
           {
               System.out.println(item);
            }
           else if(func.equalsIgnoreCase("Back"))
            {
                break;
            }
            else
            {
                System.out.println("Sorry, not a valid function. Please enter a valid funtion or Quit to quit.");
                itemFunc(item);
            }
            
            
           
            
           System.out.println("Do you want to perform any other item functions(y/n)?");
           another = scan.next();
       }
       
   }
   
   private static void PriceRange(Inventory inventory)
   {
       //finds items in the selected price range
       Scanner scan = new Scanner (System.in);
       System.out.println("Enter a minimum price");
       double min = scan.nextDouble();
       System.out.println("Enter a maximum price");
       double max = scan.nextDouble();
       
       boolean [] inprice = inventory.priceRange(min, max);
       String result = "";
       //iterates through the boolean array to print the item and then true/false
       for (int i = 0; i < inprice.length; i ++)
       {
           result += inventory.get(i).getName() + "    "  + inprice[i] + "\n";
       }
    }
    
   private static void CheckQuantities(Inventory inventory)
   {
       //finds items in the selected quantity range
       Scanner scan = new Scanner (System.in);
       System.out.println("Enter a minimum quantity");
       int min = scan.nextInt();
       
       boolean [] quants = inventory.checkQuantities(min);
       String result = "";
       //iterates through the boolean array to print the item and then true/false
        for (int i = 0; i < quants.length; i ++)
        {
            result += inventory.get(i).getName() + "    "  + quants[i] + "\n";
        }
    }
 }

