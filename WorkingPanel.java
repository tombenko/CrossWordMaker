import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.Point;

class WorkingPanel extends JPanel{
	/*
	 * In this class do we draw the crossword. The metrics still
	 * hardcoded, I want first to have the editing works. Parts of the
	 * class are from zetcode.com (or .org, I always forget it...) in
	 * hope they don't mind.
	 * */
	
	private CrossWord cw;
	private Dimension size;
	private Point cursorPosition = new Point(0, 0);
	enum Orientation {HORIZONTAL, VERTICAL};
	Orientation orientation = Orientation.HORIZONTAL;
	
	WorkingPanel(int w, int h){
		cw = new CrossWord(w, h);
		size = new Dimension(w, h);
		setPreferredSize(new Dimension(size.width * 20, size.height * 20));
	}
	
	public void doDrawing(Graphics g){
		
		Graphics2D painter = (Graphics2D) g;
		
		// Some preparations...
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		
		painter.setColor(Color.LIGHT_GRAY);
		painter.setRenderingHints(rh);
		painter.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		//Let's paint the puzzle. This is done by some private methods
		//for every square. Maybe it would be better to take into a very
		//new class...
		
		for(int i = 0; i < size.width; i++){
			for(int j = 0; j < size.height; j++){
				Point whichSquare = new Point(i, j);
				drawBorders(painter, whichSquare);
				drawLetter(painter, whichSquare, cw.getLetter(whichSquare.x, whichSquare.y));
				if(cw.getNumber(whichSquare.x, whichSquare.y) != 0){
					drawNumber(painter, whichSquare, cw.getNumber(whichSquare.x, whichSquare.y));
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
	
	public void setCursorPos(int x, int y){
		cursorPosition.setLocation(x, y);
		if(cursorPosition.x >= size.width){
			cursorPosition.x = size.width;
		}
		if(cursorPosition.x < 0){
			cursorPosition.x = 0;
		}
		if(cursorPosition.y >= size.height){
			cursorPosition.y = size.height;
		}
		if(cursorPosition.y < 0){
			cursorPosition.y = 0;
		}
		repaint();
	}
	
	public void setLetter(char c){
		cw.setLetter(c, cursorPosition.x, cursorPosition.y);
		if(orientation == Orientation.VERTICAL){
			cursorPosition.y++;
		} else {
			cursorPosition.x++;
		}
		repaint();
	}
	
	private void drawBorders(Graphics2D g, Point position){
		/*
		 * Here we draw the borders as a gray rectangle. The bold lines
		 * around the square will be drawn here too. But first I ensure
		 * the method works as I expected. The size of the rectangle is
		 * hardcoded yet by the same cause.
		 * */
		g.setColor(Color.GRAY);
		g.drawRect(position.x * 20, position.y * 20, 20, 20);
	}
	
	private void drawLetter(Graphics2D g, Point position, String letter){
		if(position.equals(cursorPosition)){
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLACK);
		}
		g.drawString(letter, position.x * 20 + 4, position.y * 20 + 16);
		if(letter.equals(".")){
			g.fillRect(position.x * 20, position.y * 20, 20, 20);
		}
	}
	
	private void drawNumber(Graphics2D g, Point position, int number){
		g.setFont(new Font("Monospaced", Font.PLAIN, 6));
		g.drawString(Integer.toString(number), position.x * 20 + 2, position.y * 20 + 6);
	}
	
	public void toggleOrientation(){
		if(orientation == Orientation.VERTICAL){
			orientation = Orientation.HORIZONTAL;
		} else {
			orientation = Orientation.VERTICAL;
		}
	}

}
