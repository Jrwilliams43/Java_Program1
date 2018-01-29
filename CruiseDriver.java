
/**
 * @author Jerrold Williams
 * @version 3/2/2015
 * 
 * This program helps a user organize 
 * a cruise.
 */
public class CruiseDriver
{
 private static Keyboard keyboard = Keyboard.getKeyboard();
public static void main(String[] args)
{
     int choice = 0;
     boolean quit = false;
     double total = 0;
     int cruiseCount =0;
     while(!quit)
     {
      String userInput = keyboard.readString("\r\n"+"Would you like to book a Cruise(y/n):");
      while(userInput.isEmpty()) userInput = keyboard.readString("\r\n"+"Would you like to book a Cruise(y/n):");
      char userSelect = userInput.charAt(0);
      userSelect = Character.toUpperCase(userSelect);
      
       while(!(userSelect == 'Y' || userSelect == 'N'))//inital yes / no
      {
      
          userInput = keyboard.readString("\r\n"+"Would you like to book a Cruise(y/n):");
          while(userInput.isEmpty()) userInput = keyboard.readString("\r\n"+"Would you like to book a Cruise(y/n):");
          userSelect = userInput.charAt(0);
          userSelect = Character.toUpperCase(userSelect);
        
      }
      if(userSelect == 'N')
      {
         choice = -1;
      }
      else
      {
        choice = menu();   
      }
      // dealing with user input after menu   
      if (choice == 1)
      {
        CruiseBuilder builder = new CruiseBuilder();//heavy lifting delegated to this object
        requestVacation(builder);
        requestShipActivities(builder);
        requestShoreExcursions(builder);
        Cruise userCruise = builder.bookCruise();
        showCruise(userCruise);
        double cruiseCost = userCruise.cost();
        total = total + cruiseCost;
        System.out.println("your cruise cost: "+ Currency.formatCurrency(cruiseCost));
        cruiseCount++;
      }
      else if(choice == 2)
      {  
        ExtraSpecialHawaiianCruise Hbuilder = new ExtraSpecialHawaiianCruise();
        Cruise userCruise = Hbuilder.bookCruise();
        showCruise(userCruise);
        double cruiseCost = userCruise.cost();
        total = total + cruiseCost;
        System.out.println("your cruise cost: "+ Currency.formatCurrency(cruiseCost));
        cruiseCount++; 
      }
      else if(choice == 3)
      {
        LuxuryCaribbeanCruise Cbuilder = new LuxuryCaribbeanCruise();
        Cruise userCruise = Cbuilder.bookCruise();
        showCruise(userCruise);
        double cruiseCost = userCruise.cost();
        total = total + cruiseCost;
        System.out.println("your cruise cost: "+ Currency.formatCurrency(cruiseCost));
        cruiseCount++;
      }
      else quit = true;
     }
     System.out.println("\r\n"+"You booked "+ cruiseCount + " cruise(s) for a grand total of " + Currency.formatCurrency(total));
 }
 /**
  * helper method 
  * displays main menu and takes input
  */
private static int menu()
{
    int input = 0;
    while(input <= 0 || input >  3)
    {
      System.out.print("\r\n"+"1.Build your own cruise" + "\r\n" + "2.Extra Special Hawaiian Cruise"+"\r\n" + "3.Luxury Caribbean Cruise"+"\r\n");
      input = keyboard.readInt("\r\n"+"Select from the above: ");
    }
    return input;
}
/**
 * helper method 
 * dipslays vacation sub menu and takes input
 */
private static void requestVacation(CruiseBuilder cb)
{
    String userVacation = "`";
    int days = 0;
    boolean addedVacation = false;
    System.out.println("\r\n"+"Please select your cruise vacation.");
    while(!addedVacation)
    {
        userVacation = keyboard.readString("\r\n"+"(C)aribbean,(H)awaii,(M)editerranean :");
        days = keyboard.readInt("\r\n"+"How many days would you like to sail? ");
        while(userVacation.isEmpty())
        {
         userVacation = keyboard.readString("\r\n"+"(C)aribbean,(H)awaii,(M)editerranean :");
         days = keyboard.readInt("\r\n"+"How many days would you like to sail? ");
        }
        char selection = userVacation.charAt(0);
        addedVacation = cb.buildVacation(selection,days);
    }
    System.out.println("\r\n"+"Thank you for selecting your cruise vacation");
}
/**
 * helper method 
 * dipslays activites sub menu and takes input
 * At least one CruiseShipActivites has to made
 */
private static void requestShipActivities(CruiseBuilder cb)
{
    System.out.println("\r\n"+"Please select your activites.");
    String userAct = "`";
    boolean addedActivity = false;
    boolean more_than_one = false;
    int activityCount = 0;
    while(!more_than_one) 
    {
        userAct = keyboard.readString("\r\n"+"(B)ingo,(D)ining in a Specialty Resturant,(G)ratuity aka Tips for Staff,(Q)uit: ");
        while(userAct.isEmpty())userAct = keyboard.readString("\r\n"+"(B)ingo,(D)ining in a Specialty Resturant,(G)ratuity aka Tips for Staff,(Q)uit: ");
        char selection = Character.toUpperCase(userAct.charAt(0));
        String seletString = Character.toString(selection);
        if(userAct.equalsIgnoreCase("Q")&& activityCount > 0)
        {
         more_than_one = true;
         System.out.println("\r\n"+"Thank you for selecting your activites");
        }
        if (seletString.equalsIgnoreCase("B")||seletString.equalsIgnoreCase("D")||seletString.equalsIgnoreCase("G"))
        {
         addedActivity = cb.buildActivity(selection);
         activityCount++;
        }
    }
}
/**
 * helper method 
 * dipslays excursions sub menu and takes input
 * dynamic menu system to show availabilty of CruiseShoreExcursions
 */
private static void requestShoreExcursions(CruiseBuilder cb)
{
    System.out.println("\r\n"+"Please select your shore excursions.");
    String userExcur = "`";
    boolean golfDone = false;
    boolean shopDone = false;
    boolean tourDone = false;
    boolean cultTDone = false;
    boolean beachDone = false;
    String options = "\r\n" ;
    String optCult = ("(C)ultural Tour, ");
    String optShopping = ("(D)uty Free Shopping, ");
    String optGolf = ("(G)olfing, ");
    String optBeach = ("(P)rivate Beach, ");
    String optQuit =("(Q)uit: ");
    
    do
    {
      if(!cultTDone)options = options+optCult;
      if(!shopDone)options = options+optShopping;
      if(!golfDone)options = options+optGolf;
      if(!beachDone)options = options+optBeach;
      options = options + optQuit;
      userExcur = keyboard.readString(options);
      while(userExcur.isEmpty())userExcur = keyboard.readString(options);
      char selection = Character.toUpperCase(userExcur.charAt(0));
      String selectString = Character.toString(selection);
      if(!userExcur.equalsIgnoreCase("Q"))
      {
       if(selectString.equalsIgnoreCase("C"))
       {
        cultTDone = cb.buildShoreExcursion(selection);
        optCult ="";
       }
       if(selectString.equalsIgnoreCase("D") )
       {
        shopDone = cb.buildShoreExcursion(selection);
         optShopping ="";
       }
       if(selectString.equalsIgnoreCase("G"))
       {
        golfDone = cb.buildShoreExcursion(selection);
         optGolf ="";
       }
       if(selectString.equalsIgnoreCase("P"))
       {
        beachDone = cb.buildShoreExcursion(selection);
        optBeach ="";
       }
      }
      options = "\r\n";
    }while(!userExcur.equalsIgnoreCase("Q"));
     System.out.println("\r\n"+"Thank you for choosing your shore excursions.");
}
/**
 * helper method
 * Shows user their finished cruise
 */
private static void showCruise(Cruise bi)
{
    System.out.println(bi.toString());
}
};
