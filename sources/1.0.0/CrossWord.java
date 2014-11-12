import java.lang.reflect.Array;
import java.awt.Dimension;
import java.awt.Point;

class CrossWord{
	/**
	 * A crossword puzzle is a matrix of squares in my point of view.
	 * The essential content is in the squares.
	 * **/
	
	private Square[][] crossWordNet;
	private Dimension size;
	
	public CrossWord(Dimension size){
		this.size = size;
		crossWordNet = new Square[size.width][size.height];
		initCrossWord();
	}
	
	public void setLetter(char letter, Point where){
		crossWordNet[where.x][where.y].setLetter(letter);
	}
	
	public char getLetter(Point where){
		return crossWordNet[where.x][where.y].getLetter();
	}
	
	public void setNumber(int number, Point where){
		crossWordNet[where.x][where.y].setNumber(number);
	}
	
	public int getNumber(Point where){
		return crossWordNet[where.x][where.y].getNumber();
	}
	
	public void toggleSideLine(short which, Point where){
		if( ((where.x == size.width - 1) && (which == Square.RIGHT)) || ((where.y == size.height - 1) && (which == Square.BOTTOM)) ){
			//When the chosen square is in the right or bottom side, we
			//don't have to set the bold line.
			return;
		} else{
			crossWordNet[where.x][where.y].toggleSideLine(which);
		}
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
				// In the beginning was there nothing.
				crossWordNet[i][j] = new Square();
			}
		}
	}
}
