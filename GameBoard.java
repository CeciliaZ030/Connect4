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
				System.out.println("  0 1 2 3 4 5 6 ");
				// int i = row number 
				for (int i = 0; i < this.row; i++) {
					
					// int j = col number 
					for (int j = 0; j < this.column; j++) {
						if( j == 0 ) {
							System.out.print(i + " ");
						}
						System.out.print(this.board[i][j] + " ");
						
						if (j == (this.column -1)) {
							System.out.print(i);
						}
					}
					System.out.println();	
				}
				
				
				System.out.println("  0 1 2 3 4 5 6 ");
				break;
			case 5:
				System.out.println("  0 1 2 3 4 ");
				
				for (int i = 0; i < this.row; i++) {
					
					for (int j = 0; j < this.column; j++) {
						if( j == 0 ) {
							System.out.print(i + " ");
						}
						System.out.print(this.board[i][j] + " ");
						
						if (j == this.column -1) {
							System.out.print(i);
						}
					}
					System.out.println();	
				}
				
				System.out.println("  0 1 2 3 4 ");
				break;
			case 3:
				System.out.println("  0 1 2 ");
				// int i = row number 
				for (int i = 0; i < this.row; i++) {
					
					// int j = col num
					
					for (int j = 0; j < this.column; j++) {
						if( j == 0 ) {
							System.out.print(i + " ");
						}
						System.out.print(this.board[i][j] + " ");
						
						if (j == this.column -1) {
							System.out.print(i);
						}
						
					}
					System.out.println();
				}
				System.out.println("  0 1 2 ");
				break;
		}
		System.out.println();
	}
	
	public char[][] getBoard() {
		return this.board;
	}
	
	public void setBoard(int nth) {
		int i = 0;
		while ( (this.board[i][nth] == ' ') && i < this.row ) {
			
			i++;
			// System.out.println("i: " + i);
			
			if (this.board[i][nth] == 'O' || this.board[i][nth] == 'X') {
				// System.out.println("O X break i: " + i);
				i -= 1;
				break;
			}
			if (i == this.row-1 ) {
				break;
			}
			
		}
		
		if (this.player == 1) {
			this.board[i][nth] = 'O';
			// System.out.println("col: " + nth + " || row: " + i);
		} else {
			this.board[i][nth] = 'X';
			// System.out.println("col:" + nth + " || row:" + i);
			
		}
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

	public boolean isFinish(int aligment) {
		// TODO Auto-generated method stub
		//Think of a way to sea if one side has won		
		int row = this.row;
		int col = this.column;
		
		if (aligment == 1 || aligment == 2) {
			//System.out.println("col:" + col);
			// check horizontal => for each row check for three consecutive column
			for (int i = 0; i < row ; i++) {
				for (int j = 0;j < col - 2; j++) {
					//System.out.println("i:" + i + "j:" + j);
					if (this.board[i][j] == 'O' && this.board[i][j+1] == 'O' && this.board[i][j+2] == 'O')
						return true;
							
					if (this.board[i][j] == 'X' && this.board[i][j+1] == 'X' && this.board[i][j+2] == 'X')
						return true;
				}
			}
			
			// check vertical 
			for (int j = 0; j < col; j++) {
				if (this.board[0][j] == 'O' && this.board[1][j] == 'O' && this.board[2][j] == 'O')
					return true;
				
				if (this.board[0][j] == 'X' && this.board[1][j] == 'X' && this.board[2][j] == 'X')
					return true;
			}
			
			// check diagonal up left to bottom right 
			for(int j = 0; j < col - 2; j++) {
				if (this.board[0][j] == 'O' && this.board[1][j+1] == 'O' && this.board[2][j+2] == 'O')
					return true;
				
				if (this.board[0][j] == 'X' && this.board[1][j+1] == 'X' && this.board[2][j+2] == 'X')
					return true;
				
			}
			
			// check diagonal up right to bottom left
			for (int j = col -1; j >= 2; j--) {
				if (this.board[0][j] == 'O' && this.board[1][j-1] == 'O' && this.board[2][j-2] == 'O')
					return true;
				
				if (this.board[0][j] == 'X' && this.board[1][j-1] == 'X' && this.board[2][j-2] == 'X')
					return true;
			}
			
		}else if (aligment == 3) {
			
			// check horizontal => for each row check for three consecutive column
			for (int i = 0; i < row ; i++) {
				for (int j = 0;j < col - 3; j++) {
					if (this.board[i][j] == 'O' && this.board[i][j+1] == 'O' && this.board[i][j+2] == 'O' 
							&& this.board[i][j+3] == 'O')
						return true;
										
					if (this.board[i][j] == 'X' && this.board[i][j+1] == 'X' && this.board[i][j+2] == 'X'
							&& this.board[i][j+3] == 'X')	
						return true;
				}
			}
			
			// check vertical 
			for (int j = 0; j < col; j++) {
				for (int i = 0; i < row -3; i++) {
					if (this.board[i][j] == 'O' && this.board[i+1][j] == 'O' && this.board[i+2][j] == 'O'
							&& this.board[i+3][j] == 'O')
						return true;
					
					if (this.board[i][j] == 'X' && this.board[i+1][j] == 'X' && this.board[i+2][j] == 'X'
							&& this.board[i+3][j] == 'X')
						return true;
					
				}
				
			}
			
			// check diagonal up left to bottom right 
			for(int j = 0; j <= col - 3; j++) {
				for (int i = 0; i < row -3; i++) {
					if (this.board[i][j] == 'O' && this.board[1+1][j+1] == 'O' && this.board[i+2][j+2] == 'O'
							&& this.board[i+3][j+3] == 'O')
						return true;	
								
					if (this.board[i][j] == 'X' && this.board[i+1][j+1] == 'X' && this.board[i+2][j+2] == 'X'
							&& this.board[i+3][j+3] == 'X')
						return true;	
				}
							
			}
			
			// check diagonal up right to bottom left
			for (int j = col -1; j >= 3; j--) {
				for (int i = 0; i < row -3; i++) {
					if (this.board[i][j] == 'O' && this.board[1+1][j-1] == 'O' && this.board[i+2][j-2] == 'O'
							&& this.board[i+3][j-3] == 'O')
						return true;	
								
					if (this.board[i][j] == 'X' && this.board[i+1][j-1] == 'X' && this.board[i+2][j-2] == 'X'
							&& this.board[i+3][j-3] == 'X')
						return true;			
				}
			}	
			
		}
		
		return false;
	}

}
