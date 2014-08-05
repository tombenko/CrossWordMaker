import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.Dimension;

class Editor implements KeyListener{
	
	/**
	 * This is the class wheer can we edit the crossword. I'm planning 
	 * to have some mouse movement (mostly for the numbers), but I found
	 * it better to have the editing done fully with the keyboards.
	 * */
	
	//The reference for the drawing class
	private WorkingPanel drawer;
	//The reference for the work
	private CrossWord workInstance;
	//The pointer of the edited square
	private Point activeSquare = new Point(0, 0);
	//The cursors moving direction. Normally L-R oriented.
	private Point writeDirection = new Point(1,0);
	
	public Editor(WorkingPanel drawer, CrossWord workInstance){
		this.drawer = drawer;
		this.workInstance = workInstance;
	}
	
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
			//Moving around
			case KeyEvent.VK_UP:{
				if(activeSquare.y >0){
					activeSquare.translate(0, -1);
				}
				break;
			}
			case KeyEvent.VK_DOWN:{
				if(activeSquare.y < (workInstance.getSize().height - 1) ){
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
				if(activeSquare.x < (workInstance.getSize().width - 1) ){
					activeSquare.translate(1, 0);
				}
				break;
			}
			//Toggling the bold edges
			case KeyEvent.VK_COMMA:{
				workInstance.toggleSideLine(Square.BOTTOM, activeSquare);
				break;
			}
			case KeyEvent.VK_MINUS:{
				workInstance.toggleSideLine(Square.RIGHT, activeSquare);
				break;
			}
			//Setting the black square
			case KeyEvent.VK_PERIOD:{
				workInstance.setLetter('.', activeSquare);
				moveCursor();
				break;
			}
			//Toggling the direction between L-R and U-D
			case KeyEvent.VK_SPACE:{
				int temp = writeDirection.x;
				writeDirection.x = writeDirection.y;
				writeDirection.y = temp;
				break;
			}
			//Deleting the edited square
			case KeyEvent.VK_DELETE: case KeyEvent.VK_BACK_SPACE:{
				workInstance.setLetter(' ', activeSquare);
				moveCursor();
				break;
			}
			//The default behaviour is to write in a letter. For safe-
			//ty's sake here is the key checked again if it is a letter.
			//Crossword puzzles from numbers are very easy to create...
			default:{
				if(Character.isLetter(e.getKeyChar())){
					workInstance.setLetter(e.getKeyChar(), activeSquare);
					moveCursor();
				}
				break;
			}
		}
		drawer.setDrawing(activeSquare);
		drawer.repaint();
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	public void keyReleased(KeyEvent e){
		
	}
	
	private void moveCursor(){
		if(activeSquare.x < (workInstance.getSize().width - 1) ){
			activeSquare.x += writeDirection.x;
		}
		if(activeSquare.y < (workInstance.getSize().height - 1) ){
			activeSquare.y += writeDirection.y;
		}
	}
}
