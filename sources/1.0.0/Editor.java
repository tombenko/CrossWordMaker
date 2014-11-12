import java.awt.Point;
import java.awt.event.KeyEvent;

class Editor implements java.awt.event.KeyListener{
	
	/**
	 * The editor class is where the editing done. Mostly we use the
	 * claviature for input, so I found it a good idea to make it as a
	 * KeyListener extension. Here we references the crossword what we
	 * edit, the point where we edit it and the display to repaint the
	 * window.
	 * */
	 
	//References to the work.
	private CrossWord edited;
	private Point where;
	private Display display;
	
	//The direction for stepping the cursor. The default value is for
	//left to right.
	private Point direction = new Point(1,0);
	
	public Editor(CrossWord cw, Point p, Display d){
		this.edited = cw;
		this.where = p;
		this.display = d;
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	public void keyPressed(KeyEvent e){
		/**
		 * The full editing is made here. Looks disgusting long but I
		 * don't know if it can be made simpler. The following keys have
		 * any meaning:
		 * 		letters:	writing the letters in the active square
		 * 		numbers:	add a new number to the active squares
		 * 					number
		 * 		space:		changes the step direction
		 * 		bckspace:	deletes the active squares contents, then
		 * 					steps backward
		 * 		delete:		deletes the active squares content
		 * 		comma:		toggles the active squares bottom line
		 * 		minus:		toggles the active squares right line
		 * 		dot:		this means the black square.
		 * */
		switch(e.getKeyCode()){
			case KeyEvent.VK_COMMA:{
				edited.toggleSideLine(Square.BOTTOM, where);
				break;
			}
			case KeyEvent.VK_MINUS:{
				edited.toggleSideLine(Square.RIGHT, where);
				break;
			}
			case KeyEvent.VK_SPACE:{
				int h = direction.x;
				direction.x = direction.y;
				direction.y = h;
				break;
			}
			case KeyEvent.VK_PERIOD:{
				edited.setLetter('.', where);
				stepCursor(direction);
				break;
			}
			case KeyEvent.VK_BACK_SPACE:{
				edited.setLetter(' ', where);
				edited.setNumber(0, where);
				stepCursor(new Point(-1 * direction.x, -1 * direction.y));
				break;
			}
			case KeyEvent.VK_DELETE:{
				edited.setLetter(' ', where);
				edited.setNumber(0, where);
				break;
			}
			case KeyEvent.VK_UP:{
				stepCursor(new Point(0,-1));
				break;
			}
			case KeyEvent.VK_DOWN:{
				stepCursor(new Point(0,1));
				break;
			}
			case KeyEvent.VK_LEFT:{
				stepCursor(new Point(-1,0));
				break;
			}
			case KeyEvent.VK_RIGHT:{
				stepCursor(new Point(1,0));
				break;
			}
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
				edited.setNumber(edited.getNumber(where) * 10 + Integer.parseInt(Character.toString(e.getKeyChar())), where);
			}
			default:{
				if(Character.isLetter(e.getKeyChar())){
					edited.setLetter(e.getKeyChar(),where);
					stepCursor(direction);
				}
			}
		}
		display.repaint();
	}
	
	public void keyReleased(KeyEvent e){
		
	}
	
	private void stepCursor(Point way){
		if( (where.x >= 0) && (where.x < edited.getSize().width) && (where.y >= 0) && (where.y < edited.getSize().height) ){
			where.translate(way.x, way.y);
		}
		
		if(where.x >= edited.getSize().width){
			where.x = edited.getSize().width - 1;
		}
		
		if(where.x < 0){
			where.x = 0;
		}
		
		if(where.y >= edited.getSize().height){
			where.y = edited.getSize().height - 1;
		}
		
		if(where.y < 0){
			where.y = 0;
		}
	}
}
