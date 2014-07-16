import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.Point;

class WorkingWindow extends JFrame{
	/**
	 * There is a lot of work to do, this is a very poor main window.
	 * For example there is a need for a menubar, saving and restoring
	 * puzzles, handling mouse (maybe this would be easy...) and finding
	 * out, how to set the bold lines in a square. And the
	 * most important: sizing the cossword.
	 * **/
	
	//Fields
	
	private WorkingPanel wp;
	
	//Constructors
	
	WorkingWindow(String title){
		wp = new WorkingPanel(new CrossWord(21,13));
		initUI(title);
	}
	
	//Methods
	
	private void initUI(String title){
		setTitle(title);
		add(wp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(
			new KeyListener(){
				public void keyPressed(KeyEvent e){
					switch(e.getKeyCode()){
						case KeyEvent.VK_LEFT:{
							wp.setCursorPos(new Point(--wp.getCursorPos().x,wp.getCursorPos().y));
							break;
						}
						case KeyEvent.VK_RIGHT:{
							wp.setCursorPos(new Point(++wp.getCursorPos().x,wp.getCursorPos().y));
							break;
						}
						case KeyEvent.VK_UP:{
							wp.setCursorPos(new Point(wp.getCursorPos().x,--wp.getCursorPos().y));
							break;
						}
						case KeyEvent.VK_DOWN:{
							wp.setCursorPos(new Point(wp.getCursorPos().x,++wp.getCursorPos().y));
							break;
						}
						case KeyEvent.VK_DELETE: {
							wp.setLetter(' ');
							break;
						}
						case KeyEvent.VK_SPACE: {
							wp.toggleOrientation();
							break;
						}
						default:{
							wp.setLetter(e.getKeyChar());
							wp.stepCursor();
							break;
						}
					}
					
				}
				
				public void keyReleased(KeyEvent e){
					
				}
				
				public void keyTyped(KeyEvent e){
					
				}
			}
		);
		addMouseListener(
			new MouseListener(){
				public void mouseEntered(MouseEvent e){
					
				}
				
				public void mouseExited(MouseEvent e){
					
				}
				
				public void mouseReleased(MouseEvent e){
					
				}
				
				public void mousePressed(MouseEvent e){
					
				}
				
				public void mouseClicked(MouseEvent e){
					
					if(e.getButton() == MouseEvent.BUTTON1){
						wp.setCursorPos(new Point(e.getX() / wp.getMetric(), e.getY() / wp.getMetric()));
					}
					if(e.getButton() == MouseEvent.BUTTON2){
						if( (e.getX() % wp.getMetric()) > 15){
							wp.toggleSideLine(Square.RIGHT, new Point(e.getX() / wp.getMetric(), e.getY() / wp.getMetric()));
						}
						if( (e.getY() % wp.getMetric()) > 15){
							wp.toggleSideLine(Square.BOTTOM, new Point(e.getX() / wp.getMetric(), e.getY() / wp.getMetric()));
						}
						wp.repaint();
					}
					
				}
			}
		);
		pack();
		
	}

}
