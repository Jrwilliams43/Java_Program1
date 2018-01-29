
/**
 * @author Jerrold Williams 
 * @version 3/2/15
 * 
 * This class is a concrete member of the decorator pattern
 * and models a cruise shore excursion
 */
public class CultTour extends CruiseShoreExcursion
{
    public CultTour(CruiseShoreExcursion excur)
   {
     super(excur);    
   }
   public CultTour(CruiseShipActivity act)
   {
     super(act);
   }
   public boolean equals(CruiseShoreExcursion se) 
   {
       boolean eq = false;
       if(se instanceof CultTour)eq = true;
       return eq;
   }
   public double cost()
   {
       return super.cost()+57.48;
   }
   public String toString()
   {
        return super.toString()+ " Cultural Tour"+"\r\n";
   }
};
