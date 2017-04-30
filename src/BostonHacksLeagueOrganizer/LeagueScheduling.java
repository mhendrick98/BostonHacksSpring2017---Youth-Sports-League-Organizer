package BostonHacksLeagueOrganizer;

import java.util.LinkedList;
import java.util.Random;
public class LeagueScheduling {
  public static int stadiumCounter = 0;
  
  private static LinkedList<RosterObject> duplicateLinkedList(LinkedList<RosterObject> original)
  {
    //Duplicates a LinkedList
   LinkedList<RosterObject> duplicate = new LinkedList<RosterObject>();
   duplicate = (LinkedList<RosterObject>) original.clone();
   return duplicate;
  }
  
  private static String[] randomTeamListGenerator()
  {
    //Takes all the teams in the league and returns them in a random order.
    LinkedList<RosterObject> temp = duplicateLinkedList(RosterCreation.getTeamList());
    String [] ret = new String[RosterCreation.getNumberOfTeams()];
    while(!temp.isEmpty())
    {
      Random rand = new Random();
      int index = rand.nextInt(RosterCreation.getNumberOfTeams()) + 0;
      if(ret[index] == null)
      {
        ret[index] = temp.poll().teamName;
      }
    }
    return ret;
  }
  
  private static String listOfTeams()
  {
    //Provides the user with list of teams in the league.
    LinkedList<RosterObject> temp = duplicateLinkedList(RosterCreation.getTeamList());
    String ret = "";
    while(!temp.isEmpty())
    {
      ret = ret + temp.poll().teamName + "\n";
    }
    return ret;
  }
  
  private static String weekScheduling(String[] Stadiums)
  {
    //Schedules the games for each week at various stadiums
    String ret = "";
    int stackCounter = 0;
    int counter = 0;
    int numberOfTeams = RosterCreation.getNumberOfTeams();
    String[] randomTeams = randomTeamListGenerator();
    LinkedList<String> stackTeams = new LinkedList<String> ();
    while(stackCounter < randomTeams.length)
    {
      stackTeams.push(randomTeams[stackCounter]);
      stackCounter++;
    }
    if(stackCounter == (stackCounter / 2) * 2)
    {
      while(!stackTeams.isEmpty())
      {
        ret = ret + stackTeams.pop() + " vs. " + stackTeams.pop() + " at " + Stadiums[stadiumCounter] + "\n";
        if(stadiumCounter < Stadiums.length - 1)
          stadiumCounter++;
        else
          stadiumCounter = 0;
      }
    }
    else
    {
      while(!stackTeams.isEmpty())
      {
        String Team1 = stackTeams.pop();
        if(stackTeams.isEmpty())
        {
          ret = ret + Team1 + " has a bye this week" + "\n";
          break;
        }
        String Team2 = stackTeams.pop();
        ret = ret + Team1 + " vs. " + Team2 + " at " + Stadiums[stadiumCounter] + "\n";
        if(stadiumCounter < Stadiums.length - 1)
          stadiumCounter++;
        else
          stadiumCounter = 0;
      }
    }
    return ret;
  }
  
  public static String regularSeasonScheduling(int lengthOfRegularSeason, String[]Stadiums)
  {
    //Schedules the games for all weeks for the length of the season.
    String ret = "";
    int counter = 0;
    while(counter < lengthOfRegularSeason)
    {
      String counterString = Integer.toString(counter+1);
      ret = ret + "Week " + counterString + "\n";
      ret = ret + weekScheduling(Stadiums) + "\n";
      counter++;
    }
    return ret;
  }
   
  
}
