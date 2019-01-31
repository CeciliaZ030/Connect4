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
		Agent AI = null;
		if(ans1 == 1) {
			GB = new GameBoard(3,3,3, ans3);
			AI = new Agent(GB, ans2);
			GB.init_board(3, 3);
			
		} else if(ans1 == 2) {
			GB = new GameBoard(3,5,3, ans3);
			AI = new Agent(GB, ans2);
			GB.init_board(3, 5);
			
		} else if(ans1 == 3) {
			GB = new GameBoard(6,7,4, ans3);
			AI = new Agent(GB, ans2);
			GB.init_board(6, 7);
			
		} else {
			System.out.println("Invalid option.");
			GB = null;
		}
		
		//REPL Gaming start
		System.out.println("Game start!");
		
		
		if (ans3 ==1 ) { //ans3 is the order of playing
			//User plays first (REPL --> getBoard --> AI)
			//User is always player2
			int moveVal1 = 0;
			while(!GB.isFinish(ans1)) {
				GB.print_Board();
				int maxCol = GB.column-1;
				System.out.println("Your move [column 0-" + maxCol +"]" );
				GB.setPlayer(2);
				//Set the current player as 2
				moveVal1 = sc.nextInt();
				GB.setBoard(moveVal1);
				GB.print_Board();
				
				GB.setPlayer(1);
				System.out.println("I'm thinking...");
				AI.algorithm(AI.level);
				// GB.print_Board();
			}
			
		} else {
			//AI plays first (AI--> setBoard --> REPL)
			//AI is always player1
			while(!GB.isFinish(ans1)) {
					
				GB.setPlayer(1);
				System.out.println("I'm thinking...");
				AI.algorithm(AI.level);
				GB.print_Board();
				
				int maxCol = GB.column-1;
				System.out.println("Your move [column 0-" + maxCol +"]" );
				GB.setPlayer(2);
				int moveVal2 = 0;
				moveVal2 = sc.nextInt();
				GB.setBoard(moveVal2);
				GB.print_Board();
			}
			
			if (GB.getPlayer() == 1) {
				System.out.print("Whooops!!! The Computer won the game.");
			} 
			if (GB.getPlayer() == 2) {
				System.out.print(" Congratulations!!! You won the game.");
			} 
			
		}
	}
}
