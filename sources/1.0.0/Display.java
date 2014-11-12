import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.Dimension;

class Display extends javax.swing.JPanel{
	/**
	 * In this class is the crossword drawn. The crossword and the
	 * cursor is referenced from the MainProgram class for communication
	 * purposes.
	 * 
	 * The drawing made in a double for cycle. I'm planning a resizable
	 * display, but at first I have more impotrant things to do.	
	 * */
	private CrossWord crossWord;
	private Point cursor;
	private Dimension crossWordSize;
	
	//The variables for drawing the whole crossword.
	private int size = 30; //This great will be the display.
	private int letterSize = (size * 9) / 10;
	private int numberSize = (size * 3) / 10;
	private BasicStroke thin = new BasicStroke(size / 60 + 1);
	private BasicStroke thick = new BasicStroke(size / 20 + 1);
	private Font letterFont = new Font("Monospaced", Font.PLAIN, letterSize);
	private Font numberFont = new Font("Monospaced", Font.PLAIN, numberSize);
	private RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	private Dimension drawSize;
	
	
	public Display(CrossWord cw, Point as){
		super();
		this.crossWord = cw;
		this.cursor = as;
		this.crossWordSize = crossWord.getSize();
		this.drawSize = new Dimension(crossWordSize.width * size, crossWordSize.height * size);
		setPreferredSize(drawSize);
		rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
	}
	
	public void paintComponent(Graphics g){
		/**
		 * Here we override the JPanel class' method to make the display.
		 * */
		super.paintComponent(g);
		doDrawing(g);
	}
	
	private void doDrawing(Graphics g){
		Graphics2D drawer = (Graphics2D) g;
		drawer.setRenderingHints(rh);
		drawer.setColor(Color.LIGHT_GRAY);
		
		//Let's draw! First the upper and left borders...
		drawer.drawLine(0,0,drawSize.width,0);
		drawer.drawLine(0,0,0,drawSize.height);
		
		//...and then the whole net.
		for(int i = 0; i < crossWordSize.width; i++){
			for(int j = 0; j < crossWordSize.height; j++){
				Point p = new Point(i, j);
				drawer.setColor(Color.LIGHT_GRAY);
				
				if( (cursor.x == i) && (cursor.y == j) ){
					drawer.fillRect(i *size, j * size, size, size);
				}
				
				if(crossWord.getSideLine(p)[Square.RIGHT]){
					drawer.setStroke(thick);
					drawer.setColor(Color.BLACK);
				} else {
					drawer.setStroke(thin);
					drawer.setColor(Color.LIGHT_GRAY);
				}
				drawer.drawLine( (i + 1) * size - 1, j * size, (i + 1) * size - 1, (j + 1) * size - 1);
				
				if(crossWord.getSideLine(p)[Square.BOTTOM]){
					drawer.setStroke(thick);
					drawer.setColor(Color.BLACK);
				} else {
					drawer.setStroke(thin);
					drawer.setColor(Color.LIGHT_GRAY);
				}
				drawer.drawLine( i * size, (j + 1) * size - 1, (i + 1) * size - 1, (j + 1) * size - 1);
				
				if(crossWord.getLetter(p) == '.'){
					drawer.setColor(Color.BLACK);
					drawer.fillRect(i * size, j * size, size, size);
				}
				
				//The fonts placing is ugly, but works. Maybe later I
				//take care of it.
				drawer.setFont(letterFont);
				drawer.setColor(Color.BLACK);
				drawer.drawString(Character.toString(crossWord.getLetter(p)), i * size + letterSize / 4, j * size + letterSize);
				drawer.setFont(numberFont);
				if(crossWord.getNumber(p) != 0){
					drawer.drawString(Integer.toString(crossWord.getNumber(p)), i * size + numberSize / 6, j * size + numberSize);
				}
			}
		}
	}
	
		
	
}
