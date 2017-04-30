package BostonHacksLeagueOrganizer;

public class RosterObject {
  
  String roster;
  String coach;
  String jerseyColorH;
  String jerseyColorA;
  String teamName;
  
  public RosterObject(String teamName, String roster, String coach, String jerseyColorH, String jerseyColorA)
  {
    this.roster = roster;
    this.coach = coach;
    this.jerseyColorH = jerseyColorH;
    this.jerseyColorA = jerseyColorA;
    this.teamName = teamName;
  }

}
