
/**
 * @author Jerrold Williams 
 * @version 3/2/2015
 * 
 * This class models a specific variation of CruiseBuilder
 */
public class LuxuryCaribbeanCruise extends CruiseBuilder
{
    public LuxuryCaribbeanCruise()
    {
        super();
    }
    public Cruise bookCruise()//calls parent methods to create a cruise
    {
        super.buildVacation('C',42);
        for(int i = 0; i < 3; i++)super.buildActivity('B');
        for(int i = 0; i < 4; i++) super.buildActivity('G');
        for(int i = 0; i < 5; i++) super.buildActivity('D');
        super.buildShoreExcursion('C');
        super.buildShoreExcursion('P');
        super.buildShoreExcursion('D');
        return super.bookCruise();
    }
};