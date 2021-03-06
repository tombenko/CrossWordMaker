import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
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
	//If you want numbner one another, this counter helps you.
	int number = 1;
	
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
			case KeyEvent.VK_DELETE:{
				workInstance.setLetter(' ', activeSquare);
				workInstance.setNumber(0, activeSquare);
				moveCursor();
				break;
			}
			case KeyEvent.VK_BACK_SPACE:{
				if(activeSquare.x > 0){
					activeSquare.x -= writeDirection.x;
				}
				if(activeSquare.y > 0){
					activeSquare.y -= writeDirection.y;
				}
				workInstance.setLetter(' ', activeSquare);
				workInstance.setNumber(0, activeSquare);
				break;
			}
			//Setting the number the simplest way
			case KeyEvent.VK_NUMPAD0: case KeyEvent.VK_NUMPAD1:
			case KeyEvent.VK_NUMPAD2: case KeyEvent.VK_NUMPAD3:
			case KeyEvent.VK_NUMPAD4: case KeyEvent.VK_NUMPAD5:
			case KeyEvent.VK_NUMPAD6: case KeyEvent.VK_NUMPAD7:
			case KeyEvent.VK_NUMPAD8: case KeyEvent.VK_NUMPAD9:
			case KeyEvent.VK_1: case KeyEvent.VK_2:
			case KeyEvent.VK_3: case KeyEvent.VK_4:
			case KeyEvent.VK_5: case KeyEvent.VK_6:
			case KeyEvent.VK_7: case KeyEvent.VK_8:
			case KeyEvent.VK_9: case KeyEvent.VK_0:{
				workInstance.setNumber(Integer.parseInt(String.valueOf(workInstance.getNumber(activeSquare)).concat(String.valueOf(e.getKeyChar()))), activeSquare);
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
