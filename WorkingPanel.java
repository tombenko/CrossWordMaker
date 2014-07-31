import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.Dimension;

class WorkingPanel extends JPanel implements Runnable{
	/**
	 * In this class do we draw the crossword. The metrics still
	 * hardcoded, I want first to have the editing works. Parts of the
	 * class are from zetcode.com (or .org, I always forget it...) in
	 * hope they don't mind.
	 * 
	 * The class runs as a thread, communicating with the editor. Here
	 * we only draw the net. I found it too oversized and responsible
	 * for too much to let it do the editing too.
	 * 
	 * This way the class is thiner and more reliable in hopes.
	 * **/
	
	//This is the instance we try to draw.
	private CrossWord cw;
	//How big is a square. The font metrics is defined through this va-
	//riable. The default value is 20 because I found it readable but
	//not too big.
	private int metric = 20;
	private Communicator communicator;
	private Point activeSquare = new Point(0,0);
	
	public WorkingPanel(CrossWord given, Communicator comm){
		cw = given;
		this.communicator = comm;
		setPreferredSize(new Dimension(given.getSize().width * metric, given.getSize().height * metric));
	}
	
	public WorkingPanel(CrossWord given, int metric, Communicator comm){
		cw = given;
		this.metric = metric;
		this.communicator = comm;
		setPreferredSize(new Dimension(given.getSize().width * metric, given.getSize().height * metric));
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
		painter.setFont(new Font("Monospaced", Font.PLAIN, (metric * 4) / 5)); //it must be 'int'...
		
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
		
		super.paintComponent(g);
		doDrawing(g);
	}
	
	public void run(){
		/**
		 * Nothing extra. Sometimes we look for information what to
		 * draw. This is why this class implements the Runnable interfa-
		 * ce.
		 * */
		while(true){
			cw = communicator.getMessage().getCrossWord();
			activeSquare = communicator.getMessage().getActiveSquare();
			repaint();
		}
	}
	
	private void drawSquare(Graphics2D g, Point position){
		/**
		 * Here is drawn the borders of the square. The only information
		 * we need to this is where to draw and if there is bold line.
		 */
		g.drawLine((position.x + 1) * metric, position.y * metric, (position.x + 1) * metric, (position.y + 1) * metric);
		g.drawLine(position.x * metric, (position.y + 1) * metric, (position.x + 1) * metric, (position.y + 1) * metric);
	}
	
	private void drawLetter(Graphics2D g, Point position, String letter){
		/**
		 * Here are the letters drawn. Needed th letter and where to
		 * draw.
		 */
		
	}
	
	private void drawNumber(Graphics2D g, Point position, int number){
		/**
		 * Drawn are the numbers. Drawn to their faces. And it is a
		 * human number and it is six hundred and sixty six.
		 */
		
	}

}
