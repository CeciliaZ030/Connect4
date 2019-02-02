import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Agent {
	
	class Node {
		int value = 0;
		LinkedList<Node> child_nodes = new LinkedList<Node>();
	}
	
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
		//implement the alpha beta prunning here
	}
	
	private void fixed_depth(GameBoard gB2) {
		// TODO Auto-generated method stub
		
	}

	public int utility() {
		return 0;
	}
	
	public int heuristic() {
		GameBoard GB = this.GB;
		//evaluate the heruistic value based on the current game board
		//Manhattan distance?
		return 0;
	}
	
	public Node generate_game_tree(Node position) {
		int depth = heuristic();
		//a queue to store nodes to construct each child
		//stop when reach terminal state or the specified depth
		//return the game tree
		return null;
	}
	
	public int minimax(Node position, int depth, boolean maximizingPlayer, int ans1) {
		if(depth == 0 || GB.isFinish(ans1)) {
			return position.value;
		}
		
		if(maximizingPlayer) {
			int maxEval = Integer.MIN_VALUE;
			for(Node child : position.child_nodes) {
				int eval = minimax(child, depth-1, false, ans1);
				maxEval = Math.max(maxEval, eval);
			}
			return maxEval;
		} else {
			int minEval = Integer.MAX_VALUE;
			for(Node child : position.child_nodes) {
				int eval = minimax(child, depth - 1, true, ans1);
				minEval = Math.min(minEval, eval);
			}
			return minEval;
		}
	}

}
