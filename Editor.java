import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;

class Editor implements KeyListener, MouseListener{
	private CrossWord workingInstance;
	private Point activeSquare = new Point(0,0);
	
	
	public Editor(CrossWord cw){
		workingInstance = cw;
	}
	
	public Editor(CrossWord cw, Point ap){
		workingInstance = cw;
		activeSquare = ap;
	}
	
	public void keyPressed(KeyEvent e){
		
	}
	
	public void keyReleased(KeyEvent e){
		
	}
	
	public void keyTyped(KeyEvent e){
		
		System.out.println("key");
		
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:{
				if(activeSquare.y > 0){
					activeSquare.translate(0,-1);
				}
				break;
			}
			case KeyEvent.VK_DOWN:{
				if(activeSquare.y < workingInstance.getSize().height){
					activeSquare.translate(0,1);
				}
				break;
			}
			case KeyEvent.VK_LEFT:{
				if(activeSquare.x < workingInstance.getSize().width){
					activeSquare.translate(-1,0);
				}
				break;
			}
			case KeyEvent.VK_RIGHT:{
				if(activeSquare.x > 0){
					activeSquare.translate(1,0);
				}
				break;
			}
			default:{
				System.out.println(Character.toString(e.getKeyChar()));
				workingInstance.setLetter(e.getKeyChar(), activeSquare);
			}
		}
		notify();
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
