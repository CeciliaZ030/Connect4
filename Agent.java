import java.util.Random;

public class Agent {
	
	GameBoard GB;
	int level;
	
	public Agent (GameBoard b, int choice) {
		this.GB = b;
		
// 		Level = 
//		1. An agent that plays randomly
//		2. An agent that uses MINIMAX
//		3. An agent that uses MINIMAX with alpha-beta pruning
//		4. An agent that uses H-MINIMAX with a fixed depth cutoff
		
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
		// GB.player = 2;
		GB.setBoard(nth);
	}
	
	public void alpha_beta(GameBoard GB){
		
	}
	
	private void fixed_depth(GameBoard gB2) {
		// TODO Auto-generated method stub
		
	}


}
