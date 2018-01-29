/**
 * @author Jerrold Williams
 * @version 3/2/2015
 * 
 * This class is a concrete member of the decorator pattern
 * and models a cruise vacation.
 */
public class Caribbean extends CruiseVacation
{
    public Caribbean(int days)
    {
        super(days);
        
    }
    public double cost()
    {
        return this.getDays()* 149.93;
        
    }
    public String toString()
    {
        return super.toString()+"Caribbean"+"\r\n";
    }
}
