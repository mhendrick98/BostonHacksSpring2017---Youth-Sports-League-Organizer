package BostonHacksLeagueOrganizer;

public class RosterNode {
  
    String value;
    String name;
    RosterNode next = null;

    RosterNode(String name, String value) {
      this.value = value;
      this.name = name;
    }
}
