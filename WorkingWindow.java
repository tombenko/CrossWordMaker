import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

class WorkingWindow extends JFrame{
	/*
	 * There is a lot of work to do, this is a very poor main window.
	 * For example there is a need for a menubar, saving and restoring
	 * puzzles, handling mouse (maybe this would be easy...) and finding
	 * out, how to set the bold lines in a square. And the
	 * most important: sizing the cossword.
	 * */
	
	//Fields
	
	private WorkingPanel wp = new WorkingPanel(21,13);
	
	//Constructors
	
	WorkingWindow(){
		initUI();
	}
	
	//Methods
	
	private void initUI(){
		setTitle("CrossWordMaker");
		add(wp);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		addKeyListener(
			new KeyListener(){
				public void keyPressed(KeyEvent e){
					switch(e.getKeyCode()){
						case KeyEvent.VK_LEFT:{
							wp.setCursorPos(--wp.getCursorPos()[0],wp.getCursorPos()[1]);
							break;
						}
						case KeyEvent.VK_RIGHT:{
							wp.setCursorPos(++wp.getCursorPos()[0],wp.getCursorPos()[1]);
							break;
						}
						case KeyEvent.VK_UP:{
							wp.setCursorPos(wp.getCursorPos()[0],--wp.getCursorPos()[1]);
							break;
						}
						case KeyEvent.VK_DOWN:{
							wp.setCursorPos(wp.getCursorPos()[0],++wp.getCursorPos()[1]);
							break;
						}
						default:{
							wp.setLetter(e.getKeyChar());
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
						wp.setCursorPos(e.getX() / 20, e.getY() / 20 - 1);
					}
					
				}
			}
		);
		
	}

}
