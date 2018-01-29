
/**
 * @author Jerrold Williams 
 * @version 3/2/2015
 * 
 * This class embodies the builder design pattern.
 * This class uses members of the decorator pattern to
 * build crusies.
 * This class abstracts the details of the decorator pattern
 * from the driver
 */
public class CruiseBuilder
{
    private CruiseItem top; // keeps track of the lastest item added to the linked list structure   
    public CruiseBuilder()
    {
        this.top = null;
    }
    private boolean hasVacation()//helper method
    { 
        boolean success = false;
        if(this.top instanceof CruiseVacation)success = true;
       return success;
    }
    private boolean hasExcurison()//helper method
    { 
        boolean success = false;
        if(this.top instanceof CruiseShoreExcursion)success = true;
       return success;
    }
    private boolean hasActivity()//helper method
    { 
        boolean success = false;
        if(this.top instanceof CruiseShipActivity)success = true;
       return success;
    }
    /**
     * Creates CruiseShipVacations
     * This method must be called 1st to build a Cruise properly.
     */
    public boolean buildVacation(char vacChar, int numDays)
    {
        boolean success = false;
        if(numDays % 7 == 0 && numDays>0)
        {
              vacChar = Character.toUpperCase(vacChar);
            if(vacChar=='H')
            {
                this.top = new CruiseVacationImproved(259.96,numDays,"Hawaii");
                success = true;
            }
            else if(vacChar=='M')
            {
             this.top = new CruiseVacationImproved(199.97,numDays,"Mediterrean");
             success = true;
            }
            else if(vacChar=='C')
            {
            this.top = new CruiseVacationImproved(149.93,numDays,"Caribbean");
             success = true;
            }
            else return success;
            
        }
        return success;
        /*boolean success = false;
        if(numDays % 7 == 0 && numDays>0)
        {
            vacChar = Character.toUpperCase(vacChar);
            if(vacChar=='H')
            {
             this.top = new Hawaii(numDays);
             success = true;
            }
            else if(vacChar=='M')
            {
             this.top = new Mediterranean(numDays);
             success = true;
            }
            else if(vacChar=='C')
            {
             this.top = new Caribbean(numDays);
             success = true;
            }
            else return success;
        } 
        return success;
        */
    }
    /**
     * Creates CruiseShipActivities 
     * This method creates CruiseShipActivites
     * either when a CruiseShipVacation or a CruiseShipActiviy 
     * has been preivous created.
     */
    public boolean buildActivity(char actChar)
    {
        boolean success = false;
        if(actChar == 'B' ) 
        {
          if(this.hasActivity())
          {
              this.top = new Bingo((CruiseShipActivity)this.top);
              success = true;
          }
          if(this.hasVacation())
          {
             this.top = new Bingo((CruiseVacation)this.top);
             success = true;  
          }
        }
        else if(actChar == 'D' ) 
        {
          if(this.hasActivity())
          {
              this.top = new Dining((CruiseShipActivity)this.top);
              success = true;
          }
          if(this.hasVacation())
          {
             this.top = new Dining((CruiseVacation)this.top);
             success = true;  
          }
        }
        else if(actChar == 'G' ) 
        {
          if(this.hasActivity())
          {
              this.top = new Gratuity((CruiseShipActivity)this.top);
              success = true;
          }
          if(this.hasVacation())
          {
             this.top = new Gratuity((CruiseVacation)this.top);
             success = true;  
          }
        }
        else return false;
        return success;
        
    }
     /**
      * This method creates CruiseShoreExcursions
      * either when a CruiseShipActivity or a CruiseShoreExcursion 
      * has been preivous created.
      * Note that duplicate CruiseShoreExcursions are not allowed
      */
    public boolean buildShoreExcursion(char excChar)
    {   boolean success = false;
        if(excChar == 'G')
        {
         if(this.hasActivity())
         {
           this.top = new Golfing((CruiseShipActivity)this.top);
           success = true;
         }
         else if(this.hasExcurison())
          {
           Golfing golf = new Golfing((CruiseShoreExcursion)this.top);
           if(!golf.isDuplicate())
           {
            top = golf;
            success = true; 
          }
          else return success;
         }
        }
        else if(excChar == 'C')
        {
          if(this.hasActivity())
          {
           this.top = new CultTour((CruiseShipActivity)this.top);
           success = true;
          }
          else if(this.hasExcurison())
          {
               CultTour tour = new CultTour((CruiseShoreExcursion)this.top);
           if(!tour.isDuplicate())
           {
            top = tour;
            success = true; 
           }
           else return success;
          } 
        }
        else if(excChar == 'D')
        {
          if(this.hasActivity())
          {
           this.top = new DutyFreeShopping((CruiseShipActivity)this.top);
           success = true;
          }
          else if(this.hasExcurison())
          {
            DutyFreeShopping shop = new DutyFreeShopping((CruiseShoreExcursion)this.top);
            if(!shop.isDuplicate())
            {
             top = shop;
             success = true; 
            }
            else return success;
           }
        } 
        else if(excChar == 'P')
        {
          if(this.hasActivity())
          {
           this.top = new PrivateBeach((CruiseShipActivity)this.top);
           success = true;
          }
          else if(this.hasExcurison())
          {
              PrivateBeach beach= new PrivateBeach((CruiseShoreExcursion)this.top);
           if(!beach.isDuplicate())
           {
            top = beach;
            success = true; 
           }
           else return success;
          }
        
        }
        else return false;
        return success;
    
    }
    /**
     * returns a complete cruise
     * A cruise must have an activity
     */
    public Cruise bookCruise()
    {
        if(this.top != null && !(this.top instanceof CruiseVacation ))return new Cruise(top);
        return null;
    }
 };
