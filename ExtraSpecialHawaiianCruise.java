
/**
 * @author Jerrold Williams 
 * @version 3/3/2015
 * 
 * This class is models a specific cruisebuilder
 */
public class ExtraSpecialHawaiianCruise extends CruiseBuilder
{
    public ExtraSpecialHawaiianCruise()
    {
        super();
    }
    public Cruise bookCruise()//calls parent methods to create a cruise
    {
        super.buildVacation('H',7);
        for(int i = 0; i < 7; i++)super.buildActivity('D');
        for(int i = 0; i < 7; i++) super.buildActivity('G');
        super.buildShoreExcursion('D');
        super.buildShoreExcursion('C');
        return super.bookCruise();
    }
};
