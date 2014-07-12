

class CrossWord{
	/*
	 * A crossword puzzle is a matrix of squares in my point of view.
	 * The essential content is in the squares.
	 * */
	
	//Fields
	
	private int Row, Column;
	private Square[][] CrossWordNet;
	
	//Constructors
	
	CrossWord(int row, int column){
		
		CrossWordNet = new Square[row][column];
		Row = row;
		Column = column;
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				// In the beginning are there nothing.
				CrossWordNet[i][j] = new Square(' ');
			}
		}
		
	}
	
	//Methods
	
	void setLetter(char letter, int row, int column){
		
		CrossWordNet[row][column].setLetter(letter);
		
	}
	
	String getLetter(int row, int column){
		return String.valueOf(CrossWordNet[row][column].getLetter());
		
	}
	
	void setNumber(int number, int row, int column){
		
		CrossWordNet[row][column].setNumber(number);
		return;
		
	}
	
	int getNumber(int row, int column){
		return CrossWordNet[row][column].getNumber();
		
		
	}
	
	void setSideLine(byte which, int row, int column){
		
		CrossWordNet[row][column].setSideLine(which);
		return;
		
	}
	
	byte getSideLine(int row, int column){
		return CrossWordNet[row][column].getSideLine();
		
	}

}
