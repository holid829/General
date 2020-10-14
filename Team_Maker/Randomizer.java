

import java.util.*;


public class Randomizer {
	private double average;
	private ArrayList<Player> players;
	private Random rGen;
	private ArrayList<Team> teams; 
	
	Randomizer(ArrayList<Player> p){
		 rGen = new Random();
		 players = p;
		 teams = new ArrayList();
		 
		 System.out.println(players);
		 
		 teams.add(new Team());
		 teams.add(new Team());
		 teams.add(new Team());
		 teams.add(new Team());
		 
		 
		 teams.get(0).addPlayer(players.remove(0));
		 teams.get(1).addPlayer(players.remove(0));
		 teams.get(2).addPlayer(players.remove(0));
		 teams.get(3).addPlayer(players.remove(1));
		 
		 average = average();
		 System.out.println(average);
		 values();
	}
	
	
	public double average() {
		int total = 0;
		int num = 1;
		
		for(int i = 0; i < players.size(); i++) {
			total += players.get(i).score;
			num = i;
		}
		
		double toR = (double)total / num;
		return toR;
	}
	
	public void values() {
		
		while(!players.isEmpty()) {
		
			Player current = players.remove(rGen.nextInt(players.size()));
			int counter = 0;
			double diff =  (Math.abs(teams.get(0).pCheck(current) - average) -  Math.abs(teams.get(0).average() - average));
			
			//for(int i = 0; i < teams.size(); i++) 
			//	System.out.println(teams.get(i) + "   " + teams.get(i).pCheck(current));
			//System.out.println();

			
			for(int j = 0; j < teams.size()-1; j++) {
				double nDiff = Math.abs(teams.get(j+1).pCheck(current) - average) - Math.abs(teams.get(j + 1).average() - average);
				
				//System.out.println(teams.get(j+1) + "   ");
				//System.out.println(nDiff);
				
				if(nDiff < diff) {
					diff =  nDiff;
					counter = j + 1;
				}
				
			}
			
			teams.get(counter).addPlayer(current);
			
			for(int i = 0; i < teams.size(); i++) 
				if(teams.get(i).isFull()) 
					System.out.println(teams.remove(i));
		}
	}

	public static void main(String args[]) {
		
		ArrayList<Player> allPlayers = new ArrayList<Player>();
		//Possibly fix OR, Offset by 1
		//allPlayers.add(new Player("Name",Score1,Score2,Role1,Role2));

		//System.out.println(allPlayers);
		Randomizer rand = new Randomizer(allPlayers);
	}
}
