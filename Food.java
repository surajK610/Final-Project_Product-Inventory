/**
 * This represents food objects
 * 
 * @author Suraj
 */
import java.util.*;
public class Food extends Item implements Tastiness // Interaction between classes using an interface (Tastiness)
//Inheritence is being utilized here as Toys inherit all the methods and qualities of Item
{
    public static final boolean PERISHABLE = false;
    public static final boolean RETURNABLE = false;
    
    public static final double MARKUP = .5;
    ArrayList <Integer> tastes;
    int Tastiness = 0;
    double max = 10;
    double min = 1;
    
    public Food (String name, double price, int id, int quantity, String loc)
    {
        super(name, price, id, quantity, loc);
      
    }
    
    public Food (String name, double price, int id, int quantity, String loc, ArrayList <Integer> tastes)
    {
        super(name, price, id, quantity, loc);
        this.tastes = tastes;
        setTastiness(tastes);
    }
    
    /**
     * Polymorphic method return type
     */
    public String getType()//This method is polymorphic as it is changed in all the subclasses of Item.
    {
        return "Food Item";
    }
    
    /**
     * Polymorphic method get markup
     */
    public double getMarkup ()
    {
        return MARKUP;
    }
    
    /**
     * Polymorphic method to get refund
     */
    public boolean getRefund()
    {
        System.out.println("Sorry, no refunds for Food items.");
        return RETURNABLE;
    }
    
    /**
     * Polymorphic method to get the total price
     */
    public double getTotalPrice()
    {
        setPrice(super.getPrice() * (1 + MARKUP) * getQuantity());
        return super.getPrice();
    }

    /**
     * Method from the tastiness interface to set tastiness
     */
    public void setTastiness(ArrayList <Integer> tastes)
    {
        this.tastes = tastes;
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int average;
        for (int i = 0; i < tastes.size(); i ++)
        {
            if (tastes.get(i) <= 10 && tastes.get(i) >= 1)
                sum += tastes.get(i);
            else 
            {
                System.out.println("The element at " +  i  + " is not between 1 and 10. Please enter a new number");
                tastes.set(i,  scan.nextInt());
            }
        }
        average = (int)((sum + .5)/tastes.size()); 
        Tastiness = average;
    }
    
    /**
     * Overloaded method from the tastiness interface to set tastiness
     */
    public void setTastiness()
    {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int average;
        for (int i = 0; i <= tastes.size(); i ++)
        {
            if (tastes.get(i) <= 10 && tastes.get(i) >= 1)
                sum += (int)tastes.get(i);
            else 
            {
                System.out.println("The element at " +  i  + " is not between 1 and 10. Please enter a new number");
                tastes.set(i,  scan.nextInt());
            }
        }
        average = (int)((sum + .5)/tastes.size()); 
        Tastiness = average;
    }
    
    /**
     * Method from the tastiness interface to get tastiness
     */
    public int getTastiness()
    {
        return Tastiness;
    }
    
    /**
     * Method from the tastiness interface to add tastiness
     */
    public void addTaste(int taste)
    {
        tastes.add(taste);
        setTastiness();
        adjustPrice(max, min);
    }
    
    /**
     * Method from the tastiness interface to adjust price based on tastiness
     */
    public double adjustPrice(double max, double min)
    {
        this.max = max;
        this.min = min;
        double price = super.getPrice();
        int change = 0;
        switch(Tastiness){
            case 1:
            change = -4;
            case 2:
            change = -3;
            case 3:
            change = -2;
            case 4:
            change = -1;
            case 5:
            change = 0;
            case 6:
            change = 0;
            case 7:
            change = 1;
            case 8:
            change = 2;
            case 9:
            change = 3;
            case 10:
            change = 4;
        }
        
        while (price + change <= min)
        {
            change ++;
        }
        while( price + change <= max && price + change >= min)
        {
            change --;
        }
        
        super.setPrice(price + change);
        return price + change;
    }
   
    /**
     * Overriden method to return item
     */
    public String toString()
    {
        String result = super.toString();
        result += "     Tastiness: " + ((Tastiness == 0)? "NA" : Tastiness);
        return result;
    }
}
