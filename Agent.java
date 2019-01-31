import java.util.Random;

public class Agent {
	
	GameBoard GB;
	int level;
	
	public Agent (GameBoard b, int choice) {
		this.GB = b;
		this.level = choice;
	}


	Random r = new Random();
	
	public void algorithm (int choice){
		if (choice == 1)
			randomly();
		else if (choice == 2)
			alpha_beta(GB);
		else if (choice == 3)
			fixed_depth(GB);
	}
	
	public void randomly() {
		int nth = r.nextInt(GB.column);
		GB.setBoard(nth);
	}
	
	public void alpha_beta(GameBoard GB){
		//implement the alpha beta prunning here
	}
	
	private void fixed_depth(GameBoard gB2) {
		// TODO Auto-generated method stub
		
	}


}
