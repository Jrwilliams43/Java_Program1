
/**
 * @author Jerrold Williams
 * @version 3/2/2015
 * 
 * This class is a concrete member of the decorator pattern.
 * and embodies a cruise vacation, 
 * but is more general than its siblings.
 */
public class CruiseVacationImproved extends CruiseVacation
{
    private String destination;//Location of Cruise
    private double cost;// Cost per day of Cruise   
    public CruiseVacationImproved(double cost ,int days, String dest)
    {
      super(days);
      this.destination = dest;
      this.cost = cost;
    }
    public double cost()
    {
        return super.getDays()*cost;   
    }
    public String toString()
    {
        return super.toString()+ destination+"\r\n";	 
    }
};