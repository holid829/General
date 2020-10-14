

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
		allPlayers.add(new Player("David",23,14,1,5));
		//allPlayers.add(new Player("Ethan",25, 22,3,4));
		allPlayers.add(new Player("Dmitri",28, 24, 23,17,3,4,2,1));
		allPlayers.add(new Player("The Gay",27, 24,2,1));
		allPlayers.add(new Player("James",17, 9,5,2));
		allPlayers.add(new Player("Jacob",24, 21,21,20,17,3,1,4,5,2));
		allPlayers.add(new Player("Ali",12, 10,4,1));
		allPlayers.add(new Player("Mina",19, 5));
		allPlayers.add(new Player("Connuer",22,2));
		allPlayers.add(new Player("Ken",21, 19,4,3));
		allPlayers.add(new Player("Joseph",12,6,6,1,3,5));
		allPlayers.add(new Player("Zeyzal",4,1,5,4));
		allPlayers.add(new Player("Jun",9, 9 ,2,5));
		allPlayers.add(new Player("Dom",20,17,3,2));
		allPlayers.add(new Player("Whylag",26, 25,24,24,5,4,3,1));
		allPlayers.add(new Player("Eliot",6, 6, 1,5,4,2));
		allPlayers.add(new Player("Chris",11,2));
		allPlayers.add(new Player("Good Ethan",19,13,4,5));
		//allPlayers.add(new Player("Miguel",23,15,4,1));
		//allPlayers.add(new Player("Edward",15,13,13,4,5,1));
		allPlayers.add(new Player("Jonah",16,13,9,1,3,4));
		//allPlayers.add(new Player("Gazi",17,4));
		allPlayers.add(new Player("Miles",13,9,8,1,5,4));
		allPlayers.add(new Player("Kevin",20,17,15,2,1,4));
	//	allPlayers.add(new Player("Good Ethan",19,13,4,5));
		//System.out.println(allPlayers);
		Randomizer rand = new Randomizer(allPlayers);
	}
}
