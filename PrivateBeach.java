
/**
 * @author Jerrold Williams 
 * @version 3/2/2015
 * 
 * This class is a concrete member of the decorator pattern
 * and models a cruise shore excursion
 */
public class PrivateBeach extends CruiseShoreExcursion
{
   public PrivateBeach(CruiseShoreExcursion excur)
   {
      super(excur);    
   }
   public PrivateBeach(CruiseShipActivity act)
   {
      super(act);
   }
   public boolean equals(CruiseShoreExcursion se) 
   {
       boolean eq = false;
       if(se instanceof PrivateBeach)eq = true;
       return eq;
   }
   public double cost()
   {
       return super.cost()+57.48;     
   }
   public String toString()
   {
       return super.toString()+ " Private Beach"+"\r\n";
   }
  
}