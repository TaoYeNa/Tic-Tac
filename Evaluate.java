package cs2210as2;

public class Evaluate {
	private char gameBoard[][];
	private int boardRows;
	private int boardColumns;
	private int tilesNeeded;
	private int maxLevels;
	public Evaluate (int boardRows, int boardColumns, int tilesNeeded, int maxLevels) {
		this.boardRows = boardRows;
		this.boardColumns = boardColumns;
		this.tilesNeeded = tilesNeeded;
		this.maxLevels = maxLevels;
		gameBoard = new char[boardRows][boardColumns];
		for(int i=0; i<boardRows; i++) {
			for (int j=0; j<boardColumns; j++) {
				gameBoard[i][j] = 'g';
			}
		}
	}
	public Dictionary createDictionary() {
		Dictionary dict = new Dictionary(9973);//the largest prime number under 10000
		return dict;
	}
	public Data repeatedConfig(Dictionary dict) {
		String r ="";
		for(int i=0; i<boardRows; i++) {
			for (int j=0; j<boardColumns; j++) {
				r+= gameBoard[i][j];
			}
			 //find the position of the given gameboard figure in our dictionary
		}
		return dict.get(r);
	}
	public void insertConfig(Dictionary dict, int score, int level) {
		String r ="";
		for(int i=0; i<boardRows; i++) {
			for (int j=0; j<boardColumns; j++) {
				r+= gameBoard[i][j];
			}
		}
			Data item = new Data(r,score,level);
			dict.put(item);
	}
	public void storePlay(int row, int col, char symbol) {
		gameBoard[row][col] = symbol;
	}
	public boolean squareIsEmpty (int row, int col) {
		return gameBoard[row][col] == 'g';
	}
	public boolean tileOfComputer (int row, int col) {
		return gameBoard[row][col] == 'o';
	}
	public boolean tileOfHuman (int row, int col) {
		return gameBoard[row][col] == 'b';
	}
	public boolean wins (char symbol) {
		 
		 if(check_row(symbol)==true) {
			 return true;
		 }
		 if(check_column(symbol)==true) {
			 return true;
		 }
		 if(check_tlbr (symbol)==true) {
			 return true;
		 }
		 if(check_trbl(symbol)==true) {
			 return true;
		 }
		 return false;
	}
		 
	 
	public boolean isDraw() {
		for(int i=0; i<boardRows; i++) {
			for (int j=0; j<boardColumns; j++) {
				if(gameBoard[i][j] == 'g' ) {
					return false;
				}
	}		
	}
		return true;
	}
		
	public int evalBoard() {
		if(wins('o')) {
			return 3 ;
		}
		else if(wins('b')) {
			return 0 ;
		}
		else if(isDraw()) {
			return 2;
		}
		else{
			return 1;
		}
	}
	private boolean check_row (char symbol) {

		 for(int i=0; i<boardRows; i++) {
				int chess =0;
			 for (int j=0; j<boardColumns; j++) {
					if(gameBoard[i][j] == symbol ) {
						chess++;  //we record how many same chess we got in the same Rows
									// for example like: xxx
														
									//      
					}
					else {
						chess=0; //initialize the chess again because this chess did not 
								//forms continued
					}
					if(chess == tilesNeeded) {
						return true;
					}
		 }
		 }
		 return false;
	}
	
	private boolean check_column(char symbol) {
		for(int i=0; i<boardColumns; i++) {
			int chess =0;
		 for (int j=0; j<boardRows; j++) {
				if(gameBoard[j][i] == symbol ) {
					chess++;  
				}
				else {
					chess=0; 
				}
				if(chess == tilesNeeded) {
					return true;
				}
	 }
	 }
	 return false;
	}
	private boolean check_tlbr (char symbol) {
		for (int i =0; i<boardRows-tilesNeeded+1; i++)
		  { 
			 
			 //we check if from the top left to the bottom right is the symbol
			 for(int j=0; j<boardColumns-tilesNeeded+1;j++) {
				int chess = 0;
				 for(int num=0; num<tilesNeeded;num++ ) {
		            	if(gameBoard[i+num][j+num]==symbol &&gameBoard[i+num][j+num]!='d') {
		            		chess++;
		            		;//if it is and it is not blocked add 1 to chess
		            	}
		            	if(chess == tilesNeeded) {
							return true;
						}
		            }   
		 }
			
		 }
		return false;
	}
	private boolean check_trbl (char symbol) {
		for (int i =0; i<boardRows-tilesNeeded+1; i++) { 
			//this is for checking from the top right to the bottom left
			 
			 for( int j=boardColumns-1; j>= tilesNeeded-1; j--) {
				 int chess =0; //reset the chess everytime when the j changes 
				 			//which means we will recount the number of the symbol(chess)
				 
				 for(int num=0; num<tilesNeeded;num++ ) {
					 if(gameBoard[i+num][j-num]==symbol&&gameBoard[i+num][j-num]!='d') {
						 chess++;
					 }
					 if(chess == tilesNeeded) {
							return true;
						}
				 }
			 }
		 }
		return false;
	}
}
