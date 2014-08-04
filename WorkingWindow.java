import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Dimension;

class WorkingWindow extends JFrame{
	/**
	 * There is a lot of work to do, this is a very poor main window.
	 * For example there is a need for a menubar, saving and restoring
	 * puzzles, handling mouse (maybe this would be easy...) and finding
	 * out, how to set the bold lines in a square. And the
	 * most important: sizing the cossword.
	 * **/
	
	private WorkingPanel workArea;
	private CrossWord workInstance;
	private Point activeSquare = new Point(0,0);
	private Point writeDirection = new Point(1,0);
	
	public WorkingWindow(String title){
		workInstance = new CrossWord(new Dimension(15, 17));
		initUI(title);
	}
	
	public WorkingWindow(String title, Dimension size){
		workInstance = new CrossWord(size);
		workArea = new WorkingPanel(workInstance);
		initUI(title);
	}
	
	private void initUI(String title){
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(workArea);
		
		//It feels like bad coding to me, but it works. Planning to move
		//the inner class to an outer (but functioning) class.
		addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				switch(e.getKeyCode()){
					//Moving the cursor. Mostly invisible...
					case KeyEvent.VK_UP:{
						if(activeSquare.y > 0){
							activeSquare.translate(0, -1);
						}
						break;
					}
					case KeyEvent.VK_DOWN:{
						if(activeSquare.y < (workInstance.getSize().height - 1)){
							activeSquare.translate(0, 1);
						}
						break;
					}
					case KeyEvent.VK_LEFT:{
						if(activeSquare.x > 0){
							activeSquare.translate(-1, 0);
						}
						break;
					}
					case KeyEvent.VK_RIGHT:{
						if(activeSquare.x < (workInstance.getSize().width - 1)){
							activeSquare.translate(1, 0);
						}
						break;
					}
					//Changing the direction
					case KeyEvent.VK_SPACE:{
						int temp = writeDirection.y;
						writeDirection.y = writeDirection.x;
						writeDirection.x = temp;
						break;
					}
					//Toggling the borderlines
					case KeyEvent.VK_COMMA:{
						workInstance.toggleSideLine(Square.BOTTOM, activeSquare);
						break;
					}
					case KeyEvent.VK_MINUS:{
						workInstance.toggleSideLine(Square.RIGHT, activeSquare);
						break;
					}
					//Writing the content
					default:{
						if(Character.isLetter(e.getKeyChar()) || (e.getKeyChar() == '.') ){
							workInstance.setLetter(e.getKeyChar(), activeSquare);
							activeSquare.translate(writeDirection.x, writeDirection.y);
						}
						if(activeSquare.x >= workInstance.getSize().width){
							activeSquare.x = workInstance.getSize().width - 1;
						}
						if(activeSquare.y >= workInstance.getSize().height){
							activeSquare.y = workInstance.getSize().height - 1;
						}
						
						break;
					}
				}
				workArea.setDrawing(workInstance, activeSquare);
			}
			
			public void keyTyped(KeyEvent e){
				
			}
			
			public void keyReleased(KeyEvent e){
				
			}
		});
		pack();
		setResizable(false);
	}

}
