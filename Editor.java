import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;

class Editor implements Runnable, KeyListener, MouseListener{
	private CrossWord workingInstance;
	private Point activeSquare;
	private Communicator communicator;
	private boolean wasModify = false;
	private int metric = 20;
	
	
	public Editor(CrossWord cw, Communicator communicator){
		this.communicator = communicator;
		workingInstance = cw;
	}
	
	public Editor(CrossWord cw, Point ap, Communicator communicator){
		this.communicator = communicator;
		workingInstance = cw;
		activeSquare = ap;
	}
	
	public void run(){
		while(true){
			if(wasModify){
				communicator.putMessage(workingInstance, activeSquare);
				wasModify = false;
			}
		}
	}
	
	public void keyPressed(KeyEvent e){
		
	}
	
	public void keyReleased(KeyEvent e){
		
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	public void mouseEntered(MouseEvent e){
		
	}
	
	public void mouseExited(MouseEvent e){
		
	}
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	public void mouseClicked(MouseEvent e){
		
	}
}
