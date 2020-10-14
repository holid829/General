import java.util.*;

public class Team {
	public ArrayList<Player> tp;
	public ArrayList<Integer> roles;
	public int totScore;
	
	public Team() {
		tp = new ArrayList();
		roles = new ArrayList(5);
		
		roles.add(1);
		roles.add(2);
		roles.add(3);
		roles.add(4);
		roles.add(5);
		totScore = 0;
	}
	
	public void addPlayer(Player p) {
		tp.add(p);
		p.score = score(p);
		int pRole = rolecheck(p);
		totScore += p.score;
		if(pRole != -1) 
			roles.remove((Integer)p.roles[pRole]);
	}
	
	public int score(Player p) {
		
		int tempScore = p.score;
		
		int pRole = rolecheck(p);
			
		if(pRole == -1)
			return tempScore = (int) (p.score*.75);
		else if(pRole == 0)
			return tempScore;
		
	
		return p.offRole[pRole -1];
	}
	
	
	public int rolecheck(Player p) {
		int r = 0;
		boolean hasRole = true;
		
		while(hasRole && !roles.contains((Integer)p.roles[r])  ) {
			r++;
			if(r > p.roles.length - 1) {
				hasRole = false;
			}
		}
		
		if(hasRole) 
			return r;
		return -1;
	
	}
	
	public double pCheck(Player p) {
		if(tp.size() >= 5) 
			return -1;
		
		
		return average(p);
	}
	
	public double average(Player p) {

		
		return ((double)(totScore+score(p)))/(tp.size()+1);
		
	
	}
	
	public double average() {
		
		return( (double) totScore)/tp.size();
	}
	
	public String toString() {
		return tp.toString()  + " " + average();
	}
	
	public boolean isFull() {
		return tp.size() == 5;
	}

}
