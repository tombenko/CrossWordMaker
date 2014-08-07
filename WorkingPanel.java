import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class WorkingPanel extends JPanel{
	/**
	 * In this class do we draw the crossword. Parts of the
	 * class are from zetcode.com (or .org, I always forget it...) in
	 * hope they don't mind. Planning to set up the metrics from the
	 * main window.
	 * **/
	
	//This is the instance we try to draw.
	private CrossWord cw;
	//How big is a square. The font metrics is defined through this va-
	//riable. The default value is 30 because I found it readable but
	//not too big.
	private int metric = 30;
	//Variable for the fonts size. It is important to resize the fonts
	//with the whole panel.
	private int fontsize;
	//A pointer  where we are in the puzzle.
	private Point activeSquare = new Point(0,0);
	//Setting the thin and the bold lines.
	private BasicStroke thick;
	private BasicStroke thin;
	//The fonts for the squares drawing
	Font letterFont;
	Font numberFont;
	
	public WorkingPanel(CrossWord given){
		cw = given;
		initPanel();
	}
	
	public WorkingPanel(CrossWord given, int metric){
		cw = given;
		this.metric = metric;
		initPanel();
	}
	
	private void initPanel(){
		setPreferredSize(new Dimension(cw.getSize().width * metric, cw.getSize().height * metric));
		thick = new BasicStroke(metric / 10 + 1);
		thin = new BasicStroke(metric / 40 + 1);
		fontsize = (metric * 4) / 5;
		letterFont = new Font("Monospaced", Font.PLAIN, fontsize);
		numberFont = new Font("Monospaced", Font.PLAIN, fontsize / 3);
	}
	
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
		
		//Let's paint the puzzle. This is done by some private methods
		//for every square. Maybe it would be better to take into a very
		//new class...
		
		//First we draw the borders...
		
		painter.drawLine(0, 0, cw.getSize().width * metric, 0);
		painter.drawLine(0, 0, 0, cw.getSize().height * metric);
		
		//..then the squares one by one.
		
		for(int i = 0; i < cw.getSize().width; i++){
			for(int j = 0; j < cw.getSize().height; j++){
				Point pos = new Point(i, j);
				drawSquare(painter, pos);
				drawLetter(painter, pos, Character.toString(cw.getLetter(pos)));
				drawNumber(painter, pos, cw.getNumber(pos));
			}
		}
	}
	
	public void paintComponent(Graphics g){
		/**
		 * This is the overridden method of the original JPanel class.
		 * Here we don't do any drawing, but the private class doDrawing
		 * is called from here.
		 * */
		super.paintComponent(g);
		doDrawing(g);
	}
	
	private void drawSquare(Graphics2D g, Point position){
		/**
		 * Here is drawn the borders of the square. Exactly the right
		 * and bottom edges, before they are the neighbour squares top
		 * and left edges too. The bold lines are drawn here too, just
		 * because they are also edges.
		 */
		if(cw.getSideLine(position)[Square.RIGHT]){
			g.setStroke(thick);
			g.setColor(Color.BLACK);
		} else {
			g.setStroke(thin);
			g.setColor(Color.LIGHT_GRAY);
		}
		g.drawLine((position.x + 1) * metric, position.y * metric, (position.x + 1) * metric, (position.y + 1) * metric);
		if(cw.getSideLine(position)[Square.BOTTOM]){
			g.setStroke(thick);
			g.setColor(Color.BLACK);
		} else {
			g.setStroke(thin);
			g.setColor(Color.GRAY);
		}
		g.drawLine(position.x * metric, (position.y + 1) * metric, (position.x + 1) * metric, (position.y + 1) * metric);
		if( (activeSquare.x == position.x) && (activeSquare.y == position.y) ){
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(position.x * metric, position.y * metric, metric, metric);
		}
	}
	
	private void drawLetter(Graphics2D g, Point position, String letter){
		/**
		 * Here are the letters drawn. Needed the letter and where to
		 * draw. The period have the meaning of the black squares, beca-
		 * use I plan to have a LaTeX export, and the cwpuzzle macro u-
		 * ses the same meaning.
		 */
		 
		g.setFont(letterFont);
		 
		g.setColor(Color.BLACK);
		if( letter.equals(".") ){
			g.fillRect(position.x * metric, position.y * metric, metric, metric);
		}
		g.drawString(letter, position.x * metric + (metric - fontsize) / 2, (position.y + 1) * metric - (metric - fontsize) /2);
		
	}
	
	private void drawNumber(Graphics2D g, Point position, int number){
		/**
		 * Drawn are the numbers. Drawn to their faces. And it is a
		 * human number and it is six hundred and sixty six.
		 */
		 
		 g.setFont(numberFont);
		 g.setColor(Color.BLACK);
		 
		 if(number != 0){
			 g.drawString(String.valueOf(number), position.x * metric + metric / 20, position.y * metric + fontsize / 3 + metric / 20);
		 }
		
	}
	
	public void setDrawing(Point ap){
		/**
		 * Here we get the momentary place of the cursor.
		 * */
		activeSquare.setLocation(ap);
	}

}
