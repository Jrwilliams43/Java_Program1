/**
 * @author Jerrold Willaims 
 * @version 3/2/2015
 * 
 * This class is part of the decorator pattern 
 * and embodies the concept of a general cruise item.
 * This class is the most general member in the decorator pattern.
 */
public abstract class CruiseItem
{
	private CruiseItem item;// Allows for linked list structure
	public CruiseItem(CruiseItem newItem)
	{
	 this.item = newItem;    
	}
	/**
	 * returns true if check is the same type as top
	 */
	public boolean isDuplicate(CruiseShoreExcursion check)
	{
	    boolean dupe = true;
	    if(item instanceof CruiseShipActivity)dupe = false;
	    else
	    {
	      if( !check.equals((CruiseShoreExcursion)item))dupe = item.isDuplicate(check);
	    }
	    return dupe;
	}
	public double cost()
	{
	    return this.item.cost();
	}
	public String toString()
    {
        return this.item.toString();   
    }
}