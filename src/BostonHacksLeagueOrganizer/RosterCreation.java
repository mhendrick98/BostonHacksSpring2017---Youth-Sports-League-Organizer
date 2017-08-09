package BostonHacksLeagueOrganizer;

import java.util.LinkedList;
import java.util.Scanner;

public class RosterCreation {
  public static LinkedList<RosterObject> teamList = new LinkedList<RosterObject>();
  public static int numberOfFullTeams = 0;
  
  public static LinkedList<RosterObject> getTeamList() {
    return teamList;
  }
  
  public static int getNumberOfTeams() {
    return numberOfFullTeams;
  }


  private static String createRosterToString(LinkedList<RosterNode> rosterList){
    //Takes in an input of a LinkedList with Roster Information. Returns Team Name, Player Names, and Player Numbers as one String
    String ret = "";
    if(rosterList.isEmpty())
      return ret;
    RosterNode item = rosterList.pop();
    while(!rosterList.isEmpty())
    {
      String number = item.value;
      String name = item.name;
      ret = ret + name + "-" + number + ", ";
      item = rosterList.pop();
    }
    String number = item.value;
    String name = item.name;
    ret = ret + name + "-" + number;
    return ret; 
  }
  
  private static String createRoster(int numberOfPlayers)
  {
    //Takes numberOfPlayes as an input. Returns a roster with Player Names and Player Numbers
    int counter = 0;
    LinkedList<RosterNode> rosterList = new LinkedList<RosterNode>();
    while(counter != numberOfPlayers)
    {
      System.out.println("Give Player's Name");
      Scanner scanName = new Scanner(System.in);
      String currentPlayerName = scanName.next();
      System.out.println("Give " + currentPlayerName + "'s Number");
      Scanner scanNumber = new Scanner(System.in);
      String currentPlayerNumber = scanNumber.next();
      RosterNode Player = new RosterNode(currentPlayerName, currentPlayerNumber);
      rosterList.offer(Player);
      counter++;
    }
    return createRosterToString(rosterList);
  }

  public static String createLeague(int numberOfTeams, int numberOfPlayers)
  {
    //Takes in numberOfTeams and numberOfPlayeres as an input. Returns a String with Coaches, Rosters, and Jersey Colors. Also creates each Team as an Object entitled 'RosterObject'.
    String ret = "";
    int counter = 0;
    while(counter != numberOfTeams)
    {
      String counterString = Integer.toString(counter + 1);
      System.out.println("Set up for Team" + counterString);
      System.out.println("Give The Team A Name");
      Scanner scanTeamName = new Scanner(System.in);
      String currentTeamName = scanTeamName.nextLine();
      System.out.println("Coach's Name?");
      Scanner scanCoachName = new Scanner(System.in);
      String currentCoachName = scanCoachName.nextLine();
      String roster = createRoster(numberOfPlayers);
      System.out.println("Home Jersey Color?");
      Scanner scanHomeColor = new Scanner(System.in);
      String currentHomeColor = scanHomeColor.nextLine().toUpperCase();
      System.out.println("Away Jersey Color?");
      Scanner scanAwayColor = new Scanner(System.in);
      String currentAwayColor = scanAwayColor.nextLine().toUpperCase();
      ret = ret + "Team Name:" + currentTeamName + " Coach:" + currentCoachName + " Players:" + roster + " // Home Jersey Color-" + currentHomeColor + " Away Jersey Color-" + currentAwayColor + "\n";
      teamList.offer(new RosterObject(currentTeamName,roster,currentCoachName, currentHomeColor, currentAwayColor));
      counter++;
      numberOfFullTeams++;
    }
    return ret;
  }
  
}
