import java.lang.reflect.Array;
import java.awt.Dimension;
import java.awt.Point;

class CrossWord{
	/**
	 * A crossword puzzle is a matrix of squares in my point of view.
	 * The essential content is in the squares. Planning to use the
	 * Point class instead of direct reference to the array's elements.
	 * Even the size of the net will be given by a Dimension class to
	 * simplify this class.
	 * **/
	
	private Square[][] crossWordNet;
	private Dimension size;
	
	public CrossWord(int row, int column){
		crossWordNet = new Square[row][column];
		initCrossWord();
		this.size = new Dimension(row, column);
	}
	
	public CrossWord(Dimension size){
		this.size = size;
		crossWordNet = new Square[size.width][size.height];
		initCrossWord();
	}
	
	public void setLetter(char letter, int row, int column){
		crossWordNet[row][column].setLetter(letter);
	}
	
	public void setLetter(char letter, Point where){
		crossWordNet[where.x][where.y].setLetter(letter);
	}
	
	public char getLetter(int row, int column){
		return crossWordNet[row][column].getLetter();
	}
	
	public char getLetter(Point where){
		return crossWordNet[where.x][where.y].getLetter();
	}
	
	public void setNumber(int number, int row, int column){
		crossWordNet[row][column].setNumber(number);
	}
	
	public void setNumber(int number, Point where){
		crossWordNet[where.x][where.y].setNumber(number);
	}
	
	public int getNumber(int row, int column){
		return crossWordNet[row][column].getNumber();
	}
	
	public int getNumber(Point where){
		return crossWordNet[where.x][where.y].getNumber();
	}
	
	public void toggleSideLine(short which, int row, int column){
		crossWordNet[row][column].toggleSideLine(which);
	}
	
	public void toggleSideLine(short which, Point where){
		if( ((where.x == size.width - 1) && (which == Square.RIGHT)) || ((where.y == size.height - 1) && (which == Square.BOTTOM)) ){
			return;
		} else{
			crossWordNet[where.x][where.y].toggleSideLine(which);
		}
	}
	
	public boolean[] getSideLine(int row, int column){
		return crossWordNet[row][column].getSideLine();
	}
	
	public boolean[] getSideLine(Point where){
		return crossWordNet[where.x][where.y].getSideLine();
	}
	
	public Dimension getSize(){
		return size;
	}
	
	private void initCrossWord(){
		for(int i = 0; i < crossWordNet.length; i++){
			for(int j = 0; j < crossWordNet[i].length; j++){
				// In the beginning are there nothing.
				crossWordNet[i][j] = new Square(' ');
			}
		}
	}
}
