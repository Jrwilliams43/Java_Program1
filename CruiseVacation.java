/**
 * @author Jerrold Willaims 
 * @version 3/2/2015
 *
 * This class is a member of the decorator pattern 
 * and embodies the concept of a cruise item(vacation).
 */
public abstract class CruiseVacation extends CruiseItem
{
 private int days;//Number of days aboard the cruise
 public CruiseVacation(int days)
 {
	 super(null);
	 this.days = days;	 
 }
 public abstract double cost();
 public String toString()
 {
   return"# of Days: "+this.days +" Cruise Vacation: ";	 
 }
 public int getDays()
 {
     return days;
 }
}