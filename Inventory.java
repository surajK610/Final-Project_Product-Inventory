
/**
 * This class represents a store with Items.
 * It includes methods to add, remove, search, edit,
 * find a price range and more.
 * 
 * @author Suraj
 * @version 2
 */
import java.util.*;
import java.text.*;
public class Inventory
{
    private ArrayList <Item> store = new ArrayList <Item>(); //An ArrayList to hold items in the store
    private NumberFormat cur = NumberFormat.getCurrencyInstance();
    
    private ListIterator <Item> iterator;// An iterator used to traverse through the ArrayList

    private double totalPrice;
    private double totalCost;
    private int totalQuantity;
    private double totalProfit;
    private String mostCommon_type;
    private int count_REG = 16;
    private int count_DAM = 0;
    
    public Inventory()
    {
        //         Toys (String name, double price, int id, int quantity, String loc)
        //         Supplies (String name, double price, int id, int quantity, String loc)
        //         Food (String name, double price, int id, int quantity, String loc, ArrayList Tastes)
        
        //constructor to instantiate arraylists and add starting values
        ArrayList <Integer> burritoTastes = new ArrayList <Integer>();
        ArrayList <Integer> pizzaTastes = new ArrayList <Integer>();
        
        burritoTastes.add(9);
        burritoTastes.add(6);
        burritoTastes.add(4);
        burritoTastes.add(8);
        burritoTastes.add(7);
        
        pizzaTastes.add(2);
        pizzaTastes.add(7);
        pizzaTastes.add(4);
        pizzaTastes.add(5);
        pizzaTastes.add(9);
        
        Item burrito = new Food("BURRITO", 4.99, 10001, 87, "F1", burritoTastes);
        Item pizza = new Food("PIZZA", 1.25, 10002, 20, "F2", pizzaTastes);
        Item hotdog = new Food("HOTDOG", 3.00, 10003, 20, "F3");
        Item beef_jerky = new Food("BEEF JERKY", 1.25, 10004, 20, "F4");
        Item slurpee = new Food("SLURPEE", 2.40, 10005, 200, "F5");
        
        store.add(burrito);
        store.add(pizza);
        store.add(hotdog);
        store.add(beef_jerky);
        store.add(slurpee);
        
        Item bouncy_ball = new Toys("BOUNCY BALL", .25, 10006, 43, "T1");
        Item power_ranger = new Toys("POWER RANGER", 1.99, 10007, 30, "T2");
        Item hotwheels = new Toys("HOTWHEELS", 2.99, 10008, 40, "T3");
        Item barbie = new Toys("BARBIE", 1.99, 10009, 20, "T4");
        Item techdeck = new Toys("TECHDECK", 3.99, 10010, 30, "T5");
        
        store.add(bouncy_ball);
        store.add(power_ranger);
        store.add(hotwheels);
        store.add(barbie);
        store.add(techdeck);
        
        Item pencil = new Supplies("PENCIL", .25, 10011, 100, "S1");
        Item pen = new Supplies("PEN", .50, 10012, 100, "S2");
        Item lighter = new Supplies("LIGHTER", .99, 10013, 150, "S3");
        Item earbuds = new Supplies("EARBUD", 10.99, 10014, 30, "S4");
        Item tape = new Supplies("TAPE", 2.50, 10015, 50, "S5");
        
        store.add(pencil);
        store.add(pen);
        store.add(lighter);
        store.add(earbuds);
        store.add(tape);
        
        
    }
    
    
     /**
     * This method gets the invenotory.
     */
    public ArrayList get ()
    {
        return store;
    }
    
    /**
     * This method gets an item.
     */
    public Item get (int index)
    {
        return store.get(index);
    }
    
    /**
     * This method adds an item.
     */
    public void add (Item item, boolean damaged)
    {
        String name = item.getName();
        item.setName(name.toUpperCase());//String manipulation using toUpperCase
        
        if (damaged == false)
        {
            store.add(item);
            count_REG ++;
        }
        else 
        {
            item.setDamaged(true);
            if (item.getRefund())
            {
                store.add(item);
                count_DAM ++;
            }
        }
    }
    
    /**
     * This method adds an item with specified parameters.
     */
    public void add (String type, String name, double price, int quantity, String loc)
    {
        //This method uses information hiding by not having the person enter an id but instead making one on the spot and by automatically uppercasing the name.
        name = name.toUpperCase();
        Item item;
        // Use of if-then-else statements
        if (type.equalsIgnoreCase("Food"))
        {
             store.add(new Food(name, price, (10000 + count_REG), quantity, loc));
             count_REG++;
            }
        else if (type.equalsIgnoreCase("Supplies"))
        {
              store.add(new Supplies(name, price, (10000 + count_REG), quantity, loc));
              count_REG++;
            }
        else if (type.equalsIgnoreCase("Toys"))
        {
             store.add(new Toys(name, price, (10000 + count_REG), quantity, loc));
             count_REG++;
            }
        else
            System.out.println("Invalid type, please try again.");
    }
    
    /**
     * This method adds an item with specified parameters.
     */
    public void add (String type, String name, double price, int quantity, String loc, boolean damaged)
    {
        //This method uses information hiding by not having the person enter an id but instead making one on the spot and by automatically uppercasing the name.
        name = name.toUpperCase();
        Item item;
        // Use of if-then-else statements
        if (type.equalsIgnoreCase("Food"))
        {
             store.add(new Food(name, price, (10000 + count_REG), quantity, loc));
             count_REG++;
            }
        else if (type.equalsIgnoreCase("Supplies"))
        {
              store.add(new Supplies(name, price, (10000 + count_REG), quantity, loc, damaged));
              count_REG++;
            }
        else if (type.equalsIgnoreCase("Toys"))
        {
             store.add(new Toys(name, price, (10000 + count_REG), quantity, loc, damaged));
             count_REG++;
            }
        else
            System.out.println("Invalid type, please try again.");
    }
    
    /**
     * This method deletes an item by name.
     */
    public void deleteByName (String name)
    {
        Item item = searchByName(name);
        if(item!= null)
            store.remove(store.indexOf(item));
        else
            System.out.println("There is no item with that name.");
    }
    
    /**
     * This method deletes an item by location.
     */
    public void deleteByLoc (String loc)
    {
        Item item = searchByLocation(loc);
        if(item!= null)
            store.remove(store.indexOf(item));
        else
            System.out.println("There is no item with that location.");
            
    }
    
    /**
     * This method deletes an item by id.
     */
    public void deleteByID(int id)
    {
        Item item = searchByID(id);
        if(item!= null)
            store.remove(store.indexOf(item));
        else
            System.out.println("There is no item with that location.");
    }
    
    /**
     * This method deletes an item.
     */
    public void delete (Item item)
    {
        Item remove = searchByName(item.getName());
        store.remove(store.indexOf(remove));
    }
    
    /**
     * This method asks for a refund
     */
    public boolean askRefund(Item item)
    {
        //calls on the items askRefund method to see if a refund is allowed
        return item.getRefund();
    }
    
    /**
     * This method searches for an item by name.
     */
     public Item searchByName(String item)
    {
        Iterator <Item> iterator = store.listIterator();
        while(iterator.hasNext())// A while loop using the iterator 
        {
            Item search = iterator.next();
            if((search).getName().equalsIgnoreCase(item))
                return search;
        }
        System.out.println("There is no item called " + item);
        return null;
    }
    
    /**
     * This method searches for an item by location.
     */
         public Item searchByLocation(String loc)
    {
        Iterator <Item> iterator = store.listIterator();
        while(iterator.hasNext())
        {
            Item search = iterator.next();
            if((search).getLoc().equalsIgnoreCase(loc))
                return search;
        }
        System.out.println("There is no item at " + loc);
        return null;
    }
    
    /**
     * This method searches for an item by location.
     */
    public Item searchByID(int id)
    {
        Iterator <Item> iterator = store.listIterator();
        while(iterator.hasNext())
        {
            Item search = iterator.next();
            if((search).getID() == (id))
                return search;
        }
        System.out.println("There is no item with ID " + id);
        return null;
    }
    
    /**
     * This method takes a maximum and a minumum 
     * price and returns a boolean array with true 
     * at items that are in the price range and false otherwise.
     */
     public boolean[] priceRange(double min, double max)
    {
        boolean [] returnList = new boolean[store.size()];
        //iterator to iterate through the classes
        Iterator <Item> iterator = store.listIterator();
        while(iterator.hasNext())
        {
            Item search = iterator.next();
            System.out.print(search.getName());
            if((search).getPrice() >= min && (search).getPrice() <= max) // Use of relational(< >) and logical (||)operators to see whether the item fits the price.
                {
                    int index = store.indexOf(search);
                    returnList[index] = true;
                    System.out.print("  true");
                }
            else 
            {
                System.out.print("  false");
            }
            System.out.println();
        }
        return returnList;
    }
    
    /**This method checks the quanities of the items in the inventory.
     * The threshold (passed as an int parameter), it will make the value 
     * at that location in the arraylist equal to true. This method will 
     * return a boolean array with trues at the locations of the quantities 
     * below the threshold and false at those above.
     */
     public boolean [] checkQuantities(int min_quant)
    {
        boolean [] returnList = new boolean[store.size()];
        //Iterator made to iterate through the store
       Iterator <Item> iterator = store.listIterator();
       while(iterator.hasNext())
        {
            Item search = iterator.next();
            System.out.print(search.getName());
            //verifies that the quantity of the item is greater than the min qunat
            if((search).getQuantity() >= min_quant)
                {
                    int index = store.indexOf(search);
                    returnList[index] = true;
                    System.out.print("  true");
                }
            else 
            {
                System.out.print("  false");
            }
            System.out.println();
        }
        return returnList;
    }
    
    /**
     * This method returns the total revenue of the stocked inventory.
     */
    public double totalPrice()
    {
        double totalPrice = 0;
        //Iterator made to iterate through the store
        Iterator <Item> iterator = store.listIterator();
        while(iterator.hasNext())
        {
            Item search = iterator.next();
            totalPrice += search.getPrice() * search.getQuantity() * (1 + search.getMarkup());
        }
        
        this.totalPrice = totalPrice;
        return totalPrice;
    }
    
    
    /**
     * This method returns the total cost of the stocked inventory.
     */
    public double totalCost()
    {
        double totalCost = 0;
        //Iterator made to iterate through the store
        Iterator <Item> iterator = store.listIterator();
        while(iterator.hasNext())
        {
            Item search = iterator.next();
            totalCost += search.getPrice() * search.getQuantity();
        }
        this.totalCost = totalCost;
        return totalCost;
    }
    
    /**
     * This method returns the total quantity of the stocked inventory.
     */
    public int totalQuantity()
    {
        int quantity = 0;
        //enhanced for loop to iterate through the store
        for(Item item: store)
        {
            quantity += item.getQuantity();
        }
        this.totalQuantity = quantity;
        return quantity;
    }
    
    /**
     * This method returns the total profit of the inventory by subtracting the 
     * cost of the sotcked inventory from the total revenue of stock.
     */
    public double totalProfit()
    {
        double totalCost = totalCost();
        double totalRevenue = totalPrice();
        
        double profit = totalRevenue - totalCost;
        this.totalProfit = profit;
        //System.out.println("profit  " + totalProfit );
        return profit;
    }
    
    /**
     * This is the toString method, exhibiting polymorphism and 
     * calling on each item's toString method to add to the result.
     */
    public String toString ()
    {
        //Shows polymorphism as different calls to getType in the toString methods of the classes have different results.
        String result = "";
        for (Item item: store)//Use of an enhanced for loop
        {
            result += item + "\n";
        }
        result += "\n  Store Statistics:";
        result += "\nTotal Cost: " + cur.format(totalCost());
        result += "\nTotal Revenue: " + cur.format(totalPrice());
        result += "\nTotal Profit: " + cur.format(totalProfit());
        result += "\nTotal Quantity: " + totalQuantity();
        return result;
    }
}
