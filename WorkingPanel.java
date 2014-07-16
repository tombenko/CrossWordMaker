import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.Point;

class WorkingPanel extends JPanel{
	/**
	 * In this class do we draw the crossword. The metrics still
	 * hardcoded, I want first to have the editing works. Parts of the
	 * class are from zetcode.com (or .org, I always forget it...) in
	 * hope they don't mind.
	 * **/
	
	private CrossWord cw;
	private Dimension size;
	//The cursor starts in the upper left corner.
	private Point cursorPosition = new Point(0, 0);
	//How big is a square. The font metrics is defined through this va-
	//riable. The default value is 20 because I found it readable but
	//not too big.
	private int metric = 20;
	//This enum is defining the cursor's moving orientation.
	private enum Orientation {HORIZONTAL, VERTICAL};
	private Orientation orientation = Orientation.HORIZONTAL;
	
	WorkingPanel(int w, int h){
		cw = new CrossWord(w, h);
		size = new Dimension(w, h);
		setPreferredSize(new Dimension(size.width * metric, size.height * metric));
	}
	
	WorkingPanel(CrossWord workInstance){
		/**
		 * This constructor is written for the planned restoring. The
		 * restored instance of the crossword is given here to the wor-
		 * king instance. Then, by saving the work this instance is gi-
		 * ven back.
		 * */
		cw = workInstance;
		size = workInstance.getSize();
		setPreferredSize(new Dimension(size.width * metric, size.height * metric));
	}
	
	//Some more Constructors will be written for changing the metrics.
	
	private void doDrawing(Graphics g){
		/**
		 * Here we draw the crossword. Not directly, to get my life easy.
		 * It isn't necessary to set this method public, because we
		 * don't call it directly.
		 * */
		
		Graphics2D painter = (Graphics2D) g;
		
		// Some preparations...
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		
		painter.setColor(Color.LIGHT_GRAY);
		painter.setRenderingHints(rh);
		painter.setFont(new Font("Monospaced", Font.PLAIN, (metric * 4) / 5));
		
		//Let's paint the puzzle. This is done by some private methods
		//for every square. Maybe it would be better to take into a very
		//new class...
		
		for(int i = 0; i < size.width; i++){
			for(int j = 0; j < size.height; j++){
				Point whichSquare = new Point(i, j);
				drawBorders(painter, whichSquare);
				drawLetter(painter, whichSquare, Character.toString(cw.getLetter(whichSquare)));
				if(cw.getNumber(whichSquare) != 0){
					drawNumber(painter, whichSquare, cw.getNumber(whichSquare));
				}
			}
		}
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		doDrawing(g);
	}
	
	public Point getCursorPos(){
		return cursorPosition;
	}
	
	public void setCursorPos(Point where){
		cursorPosition.setLocation(where);
		if(cursorPosition.x >= size.width){
			cursorPosition.x = size.width - 1;
		}
		if(cursorPosition.x < 0){
			cursorPosition.x = 0;
		}
		if(cursorPosition.y >= size.height){
			cursorPosition.y = size.height - 1;
		}
		if(cursorPosition.y < 0){
			cursorPosition.y = 0;
		}
		repaint();
	}
	
	public void setLetter(char c){
		cw.setLetter(c, cursorPosition);
		repaint();
	}
	
	private void drawBorders(Graphics2D g, Point position){
		/**
		 * Here we draw the borders as a gray rectangle. The bold lines
		 * around the square will be drawn here too. 
		 * */
		g.setColor(Color.GRAY);
		g.drawRect(position.x * metric, position.y * metric, metric, metric);
		
		//Let's inspect if there are given bold lines!
		
		g.setColor(Color.BLACK);
		
		if(cw.getSideLine(position)[Square.RIGHT]){
			g.drawLine( (position.x + 1) * metric, position.y * metric, (position.x + 1) * metric, (position.y + 1) * metric);
			g.drawLine( (position.x + 1) * metric - 1, position.y * metric, (position.x + 1) * metric - 1, (position.y + 1) * metric);
		}
		
		if(cw.getSideLine(position.x, position.y)[Square.BOTTOM]){
			g.drawLine(position.x * metric, (position.y + 1) * metric, (position.x + 1) * metric, (position.y + 1) * metric);
			g.drawLine(position.x * metric, (position.y + 1) * metric - 1, (position.x + 1) * metric, (position.y + 1) * metric - 1);
		}
	}
	
	private void drawLetter(Graphics2D g, Point position, String letter){
		if(position.equals(cursorPosition)){
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLACK);
		}
		g.drawString(letter, position.x * metric + metric / 5, position.y * metric + (metric * 4) / 5);
		if(letter.equals(".")){
			g.fillRect(position.x * metric, position.y * metric, metric, metric);
		}
	}
	
	private void drawNumber(Graphics2D g, Point position, int number){
		g.setFont(new Font("Monospaced", Font.PLAIN, 6));
		g.drawString(Integer.toString(number), position.x * metric + 2, position.y * metric + 6);
	}
	
	public void toggleOrientation(){
		if(orientation == Orientation.VERTICAL){
			orientation = Orientation.HORIZONTAL;
		} else {
			orientation = Orientation.VERTICAL;
		}
	}
	
	public CrossWord getCrossWord(){
		return cw;
	}
	
	public void stepCursor(){
		if(orientation == Orientation.HORIZONTAL){
			setCursorPos(new Point(++getCursorPos().x, getCursorPos().y));
		} else {
			setCursorPos(new Point(getCursorPos().x, ++getCursorPos().y));
		}
	}
	
	public void toggleSideLine(short which, Point where){
		cw.toggleSideLine(which, where);
		repaint();
	}
	
	public int getMetric(){
		/**
		 * I don't think it is necessary to have the merics stored in
		 * more than one different class.
		 * */
		return metric;
	}

}
