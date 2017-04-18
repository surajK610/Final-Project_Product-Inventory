/**
 * This represents toys objects
 * 
 * @author Suraj
 */
public class Toys extends Item //Inheritence is being utilized here as Toys inherit all the methods and qualities of Item
{
    public static final double MARKUP = .35;
    public static final boolean PERISHABLE = false;
    public static final boolean RETURNABLE = true;
    
    public Toys (String name, double price, int id, int quantity, String loc)
    {
        super(name, price, id, quantity, loc);
        
    }
    
    public Toys (String name, double price, int id, int quantity, String loc, boolean damaged)
    {
        super(name, price, id, quantity, loc, damaged);
        
    }
    
    /**
     * Polymorphic method to return the type of the item
     */
    public String getType()//This method is polymorphic as it is changed in all the subclasses of Item.
    {
        return "Toy Item";
    }
    
    /**
     * Polymorphic method to return the markup of the item
     */
    public double getMarkup ()
    {
        if (super.getDamaged())
            return super.getDamagedMarkup();
        return markup;
    }
    
    /**
     *  method to return the total price (selling price * quantity)
     */
    public double getTotalPrice()
    {
        setPrice(super.getTotalPrice() * (1 + MARKUP) * getQuantity());
        return super.getPrice();
    }
    
    /**
     *  Polymorphic method to return if refunds are allowed
     */
    public boolean getRefund()
    {
        System.out.println("Refunds for Toy items are allowed");
        return RETURNABLE;
    }
    
    /**
     *  method to return print string
     */
    @Override
    public String toString()
    {
        String result = super.toString();
        return result;
    }
}
