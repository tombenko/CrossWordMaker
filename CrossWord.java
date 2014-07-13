import java.lang.reflect.Array;

class CrossWord{
	/*
	 * A crossword puzzle is a matrix of squares in my point of view.
	 * The essential content is in the squares.
	 * */
	
	//Fields
	
	private Square[][] crossWordNet;
	
	//Constructors
	
	CrossWord(int row, int column){
		
		crossWordNet = new Square[row][column];
		
		for(int i = 0; i < Array.getLength(crossWordNet); i++){
			for(int j = 0; j < Array.getLength(crossWordNet[i]); j++){
				// In the beginning are there nothing.
				crossWordNet[i][j] = new Square(' ');
			}
		}
		
	}
	
	//Methods
	
	public void setLetter(char letter, int row, int column){
		
		crossWordNet[row][column].setLetter(letter);
		
	}
	
	public String getLetter(int row, int column){
		return String.valueOf(crossWordNet[row][column].getLetter());
		
	}
	
	public void setNumber(int number, int row, int column){
		
		crossWordNet[row][column].setNumber(number);
		return;
		
	}
	
	public int getNumber(int row, int column){
		return crossWordNet[row][column].getNumber();
		
		
	}
	
	public void toggleSideLine(byte which, int row, int column){
		
		crossWordNet[row][column].toggleSideLine(which);
		return;
		
	}
	
	public byte getSideLine(int row, int column){
		return crossWordNet[row][column].getSideLine();
		
	}

}
