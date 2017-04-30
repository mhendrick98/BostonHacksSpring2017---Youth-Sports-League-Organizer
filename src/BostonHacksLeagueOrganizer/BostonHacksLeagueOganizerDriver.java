package BostonHacksLeagueOrganizer;

public class BostonHacksLeagueOganizerDriver {
  public static void main (String [] args) {
    System.out.println(RosterCreation.createLeague(4, 1));
    String[] Stadiums = {"Local Park", "Big Park", "Small Park"};
    System.out.println(LeagueScheduling.regularSeasonScheduling(7, Stadiums));
  }

}

