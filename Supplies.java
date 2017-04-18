
/**
 * This represents supplies objects
 * 
 * @author Suraj
 */
public class Supplies extends Item//Inheritance is being utilized here as Toys inherit all the methods and qualities of Item
{
    public static final boolean PERISHABLE = false;
    public static final boolean RETURNABLE = true;
    public static final double markup = .20;
    
    public Supplies (String name, double price, int id, int quantity, String loc)
    {
        super(name, price, id, quantity, loc);
        
    }
    
    public Supplies (String name, double price, int id, int quantity, String loc, boolean damaged)
    {
        super(name, price, id, quantity, loc, damaged);
        
    }
    
    /**
     *  polymorphic method to return the type
     */
    public String getType()
    {
        return "Supply Item";
    }
    
    /**
     *  polymorphic method to return the markup
     */
    public double getMarkup ()
    {
        if (super.getDamaged())
            return super.getDamagedMarkup();
        return markup;
    }
    
    /**
     *  polymorphic method to return if refunds are allowed
     */
    public boolean getRefund()
    {
        System.out.println("Refunds are allowed for Supplies");
        return RETURNABLE;
    }
    
    /**
     *  Overriden method to return the total price
     */
    public double getTotalPrice()
    {
        setPrice(super.getPrice() * (1 + markup) * getQuantity());
        return super.getPrice();
    }
    
    @Override
    public String toString()
    {
        String result = super.toString();
        return result;
    }
}
