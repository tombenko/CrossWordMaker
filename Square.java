import java.lang.Character;

class Square{
	/*
	 * This class describes a square in a crossword. It has a letter
	 * written in, possibly a number (with any meaning) and maybe lines
	 * round of it. Because there can be only one letter in a square,
	 * it's enough to declare it as char. The numbers are usually under 100,
	 * but in special cases, eg. giant crosswords can have more, so it
	 * is good to be int. The border lines are bit-sized informations,
	 * so the four lines existence can be a bytes first four bits. 
	 * */
	
	//Fields
	
	private char Letter;
	private int Number;
	private byte SideLine;	//The first 4 bits signs which line is drawn.
							//1 - left, 2 - right, 4 - top, 8 - bottom
	
	//Constructors
	
	Square(){
		/*
		 * The normal constructor. The letter written into is a simple
		 * emptiness.
		 * */
		
		Letter = ' ';
		Number = 0;
		SideLine = 0;
		
	}
	
	Square(char letter){
		
		Letter = letter;
		Number = 0;
		SideLine = 0;
		
	}
	
	//Methods
	
	void setLetter(char letter){
		/*
		 * Sets the letter written into the square. Capital letters are
		 * more readable, so all the letters changed to this shape.
		 * 
		 * TODO:
		 * Throw exception when the parameter is not a letter. (I take
		 * space as letter to have empty squares.)
		 * */
		
		Letter = Character.toUpperCase(letter);
		
	}
	
	char getLetter(){
		/*
		 * Returns the letter written into.
		 * */
		
		return Letter;
		
	}
	
	void setNumber(int number){
		/*
		 * Sets the number of the square.
		 * */
		
		Number = number;
		
	}
	
	int getNumber(){
		/*
		 * Returns the sqares number.
		 * */
		
		return Number;
		
	}
	
	void setSideLine(byte which){
		/*
		 * Here we set the border line. The 'which' parameter has the
		 * same description, as the SideLine variable. The set and unset
		 * goes the same way, therefore it is enough to made with XOR.
		 * */
		
		SideLine ^= which;
		
	}
	
	byte getSideLine(){
		
		/*
		 * Returns the border lines.
		 * */
		
		return SideLine;
		
	}

}
