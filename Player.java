import java.util.*;

public class Player {
	public int score;
	public String name;
	public int[] roles; //1 is top, 2 is jg, 3 is mid, 4 is ad, 5 is supp
	public int[] offRole;
	
	

	
	Player(String n, int s, int r1){
		offRole = new int[0];
		
		
		
		name = n;
		score = s;
		roles = new int[1];
		roles[0] = r1;
	}
	
	Player(String n,int s, int OR1, int r1, int r2){
		offRole = new int[2];
		offRole[0] = OR1;
		
		name = n;
		score = s;
		roles = new int[2];
		roles[0] = r1;
		roles[1] = r2;
	}
	
	Player(String n, int s,int OR1,int OR2, int r1, int r2, int r3){
		offRole = new int[2];
		offRole[0] = OR1;
		offRole[1] = OR2;

		
		name = n;
		score = s;
		roles = new int[3];
		roles[0] = r1;
		roles[1] = r2;
		roles[2] = r3;
	}
	
	Player(String n,int s, int OR1,int OR2,int OR3, int r1, int r2, int r3, int r4){
		offRole = new int[3];
		offRole[0] = OR1;
		offRole[1] = OR2;
		offRole[2] = OR3;
	
		
		name = n;
		score = s;
		roles = new int[4];
		roles[0] = r1;
		roles[1] = r2;
		roles[2] = r3;
		roles[3] = r4;
	}
	
	Player(String n, int OR1,int OR2,int OR3,int OR4,int s, int r1, int r2, int r3, int r4, int r5){
		offRole = new int[4];
		offRole[0] = OR1;
		offRole[1] = OR2;
		offRole[2] = OR3;
		offRole[3] = OR4;
		
		name = n;
		score = s;
		roles = new int[5];
		roles[0] = r1;
		roles[1] = r2;
		roles[2] = r3;
		roles[3] = r4;
		roles[4] = r5;
	}
	
	public String toString() {
		return name + " ";
	}
	
}
