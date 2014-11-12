import java.lang.Character;

class Square{
	/**
	 * This class describes a square in a crossword. It has a letter
	 * written in, possibly a number (with any meaning) and maybe lines
	 * round of it. The only lines we have to set is the right and the
	 * bottom lines.
	 * 
	 * Because there can be only one letter in a square, it's enough to 
	 * declare it as char. The numbers are usually under 100, but in 
	 * special cases, eg. giant crosswords can have more, so it is 
	 * good to be int. The border lines are just a true/false informati-
	 * on, therefore they are stored in a boolean array.
	 * **/
	
	public static final short RIGHT = 0;	//These two values are for
	public static final short BOTTOM = 1;	//setting the bold sidelines.
	
	private char letter;
	private int number;
	private boolean[] sideLine = {false, false};
	
	Square(){
		/**
		 * The normal constructor. The letter written into is a simple
		 * emptiness. No other constructor is needed.
		 * */
		
		letter = ' ';
		number = 0;
		
	}
	
	public void setLetter(char letter){
		/**
		 * Sets the letter written into the square. Capital letters are
		 * more readable, so all the letters changed to this shape.
		 * */
		
		this.letter = Character.toUpperCase(letter);
		
	}
	
	public char getLetter(){
		/**
		 * Returns the letter written into.
		 * */
		
		return letter;
		
	}
	
	public void setNumber(int number){
		/**
		 * Sets the number of the square.
		 * */
		
		this.number = number;
		
	}
	
	public int getNumber(){
		/**
		 * Returns the sqares number.
		 * */
		
		return number;
		
	}
	
	public void toggleSideLine(short which){
		
		/**
		 * The which parameter is described above. For sure we take the
		 * modulo 2 remains of the given parameter for not slipping out
		 * of the array bounds.
		 * */
		
		which %= 2;
		
		this.sideLine[which] ^= true;
		
	}
	
	public boolean[] getSideLine(){
		
		/**
		 * Returns the border lines existence.
		 * */
		
		return sideLine;
		
	}

}
