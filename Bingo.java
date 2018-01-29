
/** 
 * @author Jerrold Williams 
 * @version 3/2/2015
 * 
 * This class is a concrete member of the decorator 
 * and models a cruise ship activity
 */
public class Bingo extends CruiseShipActivity
{
    public Bingo(CruiseVacation vac)
    {
        super(vac);
    }
     public Bingo(CruiseShipActivity act)
    {
        super(act);
    }
    public double cost()
    {
       return super.cost()+21.67;    
    }
    public String toString()
    {
        return super.toString()+" Bingo "+"\r\n";
    }
}
