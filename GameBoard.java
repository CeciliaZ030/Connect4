import java.util.ArrayList;


public class GameBoard {
	
	char[][] board;
	int column;
	int row;
	int aligment;
	int player;
	
	public GameBoard(int m, int n, int k, int p) {
		this.board = init_board(m, n);
		this.row = m;
		this.column = n;
		this.aligment = k;
		this.player = p;
	}
	
	public char[][] init_board(int m, int n) {
		char[][] board = new char[m][n];
		for (int i = 0; i < m; i++) 
			for (int j = 0; j < n; j++) 
				board[i][j] = ' ';
		return board;
	}
	
	public void print_Board() {
		switch (this.column) {
			case 7:
				System.out.println(" 0 1 2 3 4 5 6 7 ");
				for (int i = 0; i < this.row; i++) {
					System.out.print(i+" ");
					for (int j = 0; j < this.column; j++) {
						System.out.print(j+" ");
					}
					System.out.print(i);
				}
				System.out.println(" 0 1 2 3 4 5 6 7 ");
				break;
			case 5:
				System.out.println(" 0 1 2 3 4 ");
				for (int i = 0; i < this.row; i++) {
					System.out.print(i+" ");
					for (int j = 0; j < this.column; j++) {
						System.out.print(j+" ");
					}
					System.out.print(i);
				}
				System.out.println(" 0 1 2 3 4 ");
				break;
			case 3:
				System.out.println(" 0 1 2 ");
				for (int i = 0; i < this.row; i++) {
					System.out.print(i+" ");
					for (int j = 0; j < this.column; j++) {
						System.out.print(j+" ");
					}
					System.out.print(i);
				}
				System.out.println(" 0 1 2 ");
				break;
		}
	}
	
	public char[][] getBoard() {
		return this.board;
	}
	
	public void setBoard(int nth) {
		int i = 0;
		while (this.board[i][nth] == ' ') 
			i++;
		if (this.player == 1)
			this.board[i][nth] = 'O';
		else
			this.board[i][nth] = 'X';
	}

	public int getAligment() {
		return aligment;
	}

	public void setAligment(int aligment) {
		this.aligment = aligment;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public boolean isFinish() {
		// TODO Auto-generated method stub
		//Think of a way to sea if one side has won		
		return false;
	}

}
