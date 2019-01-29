import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Connect4 by Yixin Zhang & Ziyi Wang");
		System.out.println("1. Tiny 3x3x3 Connect-Three");
		System.out.println("2. Wider 3x5x3 Connect-Three");
		System.out.println("3. Standard 6x7x4 Connect-Four");
		System.out.println("CYour choice?");
		
		Scanner sc = new Scanner(System.in);
		int ans1 = sc.nextInt();
		
		System.out.println("Choose your opponent:");
		System.out.println("1. An agent that plays randomly");
		System.out.println("2. An agent that uses MINIMAX");
		System.out.println("3. An agent that uses MINIMAX with alpha-beta pruning");
		System.out.println("4. An agent that uses H-MINIMAX with a fixed depth cutoff");
		System.out.println("Your choice?");

		int ans2 = sc.nextInt();
		
		System.out.println("Do you want to play RED (1) or YELLOW (2)?");

		int ans3 = sc.nextInt();
		
		GameBoard GB;
		Agent AI;
		if(ans1 == 1) {
			GB = new GameBoard(3,3,3, ans3);
			AI = new Agent(GB, ans2);
			
		} else if(ans1 == 2) {
			GB = new GameBoard(3,5,3, ans3);
			AI = new Agent(GB, ans2);
			
		} else if(ans1 == 3) {
			GB = new GameBoard(6,7,4, ans3);
			AI = new Agent(GB, ans2);
			
		} else {
			System.out.println("Invalid option.");
			GB = null;
		}
		
		//REPL Gaming start
		System.out.println("Game start!");
		if (ans2 ==1 ) {
			//User plays first (REPL --> getBoard --> AI)
			while(!GB.isFinish()) {
				
			}
			//AI plays first (AI--> setBoard --> REPL)
		} else {
			while(!GB.isFinish()) {
				
			}
		}
		
		//When the game is considered to be finished, use getPlayer to decide who won
		System.out.println("Game over!");
		System.out.println(GB.getPlayer() + "won the game!");
		

	}
}
