/**
 * @author Jerrold Williams 
 * @version 3/2/2015
 * 
 * This class is a member of the decorator pattern
 * and embodies the concept of a cruise ship activity
 */
public abstract class CruiseShipActivity extends CruiseItem
{
 public CruiseShipActivity(CruiseVacation vac)
 {
  super(vac);
 }
 public CruiseShipActivity(CruiseShipActivity act)
 {
  super(act);    
 }
 public double cost()
 {
   return super.cost(); 
 }
 public String toString()
 {
  return super.toString()+"Activity: ";    
 }
}

