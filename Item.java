import java.text.*;
public abstract class Item 
{
    public final double markup = .30;
    public final double damaged_markup = .15;
    private String name;
    private double price;
    private int id; //Converts to and from an object to a primitive data type to demonstrate differences in methods and reference vs no reference
    private int quantity;
    private String loc;
    private boolean damaged = false;
    
    public Item(String name, double price, int id, int quantity, String loc)
    {
        this.name = name;
        this.price = price;
        this.id =id;
        this.quantity = quantity;
        this.loc = loc;
     }
     
     public Item(String name, double price, int id, int quantity, String loc, boolean damaged)
    {
        this.name = name;
        this.price = price;
        this.id = new Integer(id);
        this.quantity = quantity;
        this.loc = loc;
        this.damaged = damaged;
     }
    
    /**
     * method to return name
     */
    public String getName ()
    {
        return name;
    }
    
    /**
     * method to set name
     */
    public void setName (String name)
    {
        this.name = name;
    }
    
    /**
     * method to return price
     */
    public double getPrice ()
    {
        return price;
    }
    
    /**
     * method to get price(selling)
     */
    public double getPrices ()
    {
        return Math.round((price * (1 + getMarkup()))*100.0)/100.0;
    }
    
    /**
     * method to set price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    /**
     * method to return if damaged
     */
    public boolean getDamaged()
    {
        return damaged;
    }
    
    /**
     * method to set if damaged
     */
    public void setDamaged(boolean damaged)
    {
        this.damaged = damaged;
    }
    
    /**
     * method to return damaged markup
     */
    public double getDamagedMarkup()
    {
        return damaged_markup;
    }
    
    /**
     * method to return id
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * method to set price
     */
    public void setID(int id)
    {
        this.id =id;
    }

    /**
     * method to return quantity
     */
    public int getQuantity ()
    {
        return quantity;
    }
    
    /**
     * method to add quantity
     */
    public void addQuantity (int quantity)
    {
        this.quantity += quantity;
    }
    
    /**
     * method to remove quantity
     */
    public void removeQuantity (int quantity)
    {
        this.quantity -= quantity;
    }
    
    /**
     * method to set quantity
     */
    public void setQuantity (int quantity)
    {
        this.quantity = quantity;
    }
    
    /**
     * method to return location
     */
    public String getLoc()
    {
        return loc;
    }
    
    /**
     * method to set location
     */
    public void setLoc(String loc)
    {
        this.loc = loc;
    }
    
    /**
     * method to return total price
     */
    public double getTotalPrice()
    {
        double totprice = getPrice() * getQuantity() * (1 + getMarkup());
        return totprice;
    }
    
    @Override
    public String toString ()
    {
        NumberFormat cur = NumberFormat.getCurrencyInstance();
        String item = "\nName: " + name;
        item += "   Individial Price Obtained: " + cur.format(getPrice());
        item += "   Total Cost Obtained: " + cur.format(getPrice() * getQuantity());
        if (!getDamaged())
        {
            item += "   Markup: " + this.getMarkup();
            item += "   Individial Price: " + cur.format((1 + getMarkup()) * getPrice());
        }
        else
        {
            item += "   Markup: " + this.getDamagedMarkup();
            item += "   Individial Price: " + cur.format((1 + getDamagedMarkup()) * getPrice());
        }
        item += "   ID: " + id;
        item += "   Quantity: " + quantity;
        if (!getDamaged())
        {
            item += "   Total Quantity Price: " + cur.format(getPrice() * getQuantity() * (1 + getMarkup()));
        }
        else
        {
            item += "   Total Quantity Price: " + cur.format(getPrice() * getQuantity() * (1 + getDamagedMarkup()));
        }
        item += "     Type: " + getType();
        return item;
    }
    
    
    public abstract String getType();
    public abstract double getMarkup();
    public abstract boolean getRefund();
}
