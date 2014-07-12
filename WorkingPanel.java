import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Font;

class WorkingPanel extends JPanel{
	/*
	 * In this class do we draw the crossword. The metrics still
	 * hardcoded, I want first to have the editing works. Parts of the
	 * class are from zetcode.com (or .org, I always forget it...) in
	 * hope they don't mind it.
	 * */
	
	private CrossWord cw;
	private Dimension size;
	private int[] cursorposition = {0, 0};
	
	WorkingPanel(int w, int h){
		cw = new CrossWord(w, h);
		size = new Dimension(w, h);
		setPreferredSize(new Dimension(size.width * 20, size.height * 20));
	}
	
	public void doDrawing(Graphics g){
		
		Graphics2D painter = (Graphics2D) g;
		int i,j;
		
		// Some preparations...
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		
		painter.setColor(Color.LIGHT_GRAY);
		painter.setRenderingHints(rh);
		painter.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		// Now paint the net.
		for(i = 0; i <= size.width; i++){
			painter.drawLine(i * 20, 0, i * 20, size.height * 20);
		}
		
		for(i = 0; i <= size.height; i++){
			painter.drawLine(0, i * 20, size.width * 20, i * 20);
		}
		
		// At last we draw the contents of the sqares.
		painter.setColor(Color.BLACK);
		
		for(i = 0; i < size.width; i++){
			for(j = 0; j < size.height; j++){
				//Somewhere here must be the bold lines drawing. Maybe...
				if( (i == cursorposition[0]) && (j == cursorposition[1]) ){
					painter.setColor(Color.RED);
				}
				painter.drawString(cw.getLetter(i,j), i * 20 + 4, j * 20 + 16);
				painter.setColor(Color.BLACK);
				if(cw.getLetter(i, j).equals(".")){
					// Dot marks the black squares. It is because I plan
					// to export the whole puzzle into the cwpuzzle
					// LaTeX package's format.
					painter.fillRect(i * 20, j * 20, 20, 20);
				}
			}
		}
		
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		doDrawing(g);
	}
	
	public int[] getCursorPos(){
		return cursorposition;
	}
	
	public void setCursorPos(int x, int y){
		cursorposition[0] = x;
		cursorposition[1] = y;
		if(cursorposition[0] >= size.width){
			cursorposition[0] = size.width;
		}
		if(cursorposition[0] < 0){
			cursorposition[0] = 0;
		}
		if(cursorposition[1] >= size.height){
			cursorposition[1] = size.height;
		}
		if(cursorposition[1] < 0){
			cursorposition[1] = 0;
		}
		repaint();
	}
	
	public void setLetter(char c){
		cw.setLetter(c, cursorposition[0], cursorposition[1]);
		repaint();
	}

}
