
/**
 * @author Jerrold Williams 
 * @version 3/2/15
 * This class is a concrete member of the decorator pattern
 * and models a cruise vacation    
 */
public class Hawaii extends CruiseVacation
{
    public Hawaii(int days)
    {
        super(days);
        
    }
    public double cost()
    {
        return this.getDays()* 259.96;
        
    }
    public String toString()
    {
        return super.toString()+"Hawaii"+"\r\n";
    }
}
