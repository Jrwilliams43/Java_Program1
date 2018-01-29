
/**
 * @author Jerrold Williams 
 * @version 3/2/2015
 * 
 * This class is a concrete member of the decorator 
 * and models a cruise ship activity
 */
public class Dining extends CruiseShipActivity
{
    public Dining(CruiseVacation vac)
    {
        super(vac);
    }
     public Dining(CruiseShipActivity act)
    {
        super(act);
    }
    public double cost()
    {
        return super.cost()+21.67;    
    }
    public String toString()
    {
        return super.toString()+" Specialty Dining" + "\r\n";
    }
}