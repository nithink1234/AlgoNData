import java.util.*;

// Creating a custom object name Player information of name and score.
class Player {
	String name ;
	int score;
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

// This is the class which actually compares objects of type players
class Checker implements Comparator<Player>{
	
	public int compare(Player p1 , Player p2) {
		
		// Since we need it in reverse order u compare p2 to p1 
		if(p2.score > p1.score)
			return 1;
		else if (p2.score < p1.score)
			return -1;
		
		// In case their scores are equal return by comparing their names 
		// We dont do this reverse .. normal comparision 
		else {
			return p1.name.compareTo(p2.name);
		}
		
	}
}

public class AB_crackingCodingComparatorSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player[] team = new Player[5];
		
		team[0] = new Player("david" , 100);
		team[1] = new Player("amy" , 100);
		team[2] = new Player("heraldo" , 50);
		team[3] = new Player("aakansha" , 75);
		team[4] = new Player("aleska" , 150);
		
		Checker comparing = new Checker();
		
		Arrays.sort(team, comparing);
		
		for(int i=0; i<team.length; i++) {
			System.out.println(team[i].name + " : " + team[i].score);
		}
		
	}

}
