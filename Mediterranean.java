
/** 
 * @author Jerrold Williams
 * @version 3/2/15
 * 
 * This class is a concrete member of the decorator pattern
 * and models a cruise vacation.
 */
public class Mediterranean extends CruiseVacation
{
    public Mediterranean(int days)
    {
        super(days);
        
    }
    public double cost()
    {
        return this.getDays()*199.97;
        
    }
    public String toString()
    {
        return super.toString()+"Mediterranean"+"\r\n";
    }
}
