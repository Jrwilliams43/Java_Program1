
/**
 * @author Jerrold Williams 
 * @version 3/2/2015
 * 
 * This class is a member of the decorator pattern
 * and embodies the concept of a cruise item(excursion).
 */
public abstract class CruiseShoreExcursion extends CruiseItem
{    
 public CruiseShoreExcursion(CruiseShipActivity act)
 {
   super(act);
 }
 public CruiseShoreExcursion(CruiseShoreExcursion excur)
 {
   super(excur);    
 }
 public boolean isDuplicate()
 {
     return super.isDuplicate(this);
 }
 public double cost()
 {
   return super.cost();    
 }
 public String toString()
 {
  return super.toString()+"Shore Excursion: ";    
 }
 public abstract boolean equals(CruiseShoreExcursion se);//key detail to check duplicates
};


