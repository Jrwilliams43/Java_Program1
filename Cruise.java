/**
 * This class embodies a complete cruise
 */
public class Cruise
{
   private CruiseItem top;// holds the stack representing that cruise

   public Cruise(CruiseItem ci)
   {
      top = ci;
   }

   public double cost()
   {
      if (top != null)
      {
         return top.cost();
      }
      return 0.00;
   }

   public String toString()
   {
      if (top != null)
      {
         return top.toString();
      }
      return "Cruise without a destination area";
   }
}
