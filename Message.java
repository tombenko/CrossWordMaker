import java.awt.Point;

class Message{
	
	private CrossWord cwpMessage;
	private Point activeSquare;
	
	public Message(CrossWord cw, Point ap){
		cwpMessage = cw;
		activeSquare = ap;
	}
	
	public CrossWord getCrossWord(){
		return cwpMessage;
	}
	
	public Point getActiveSquare(){
		return activeSquare;
	}
}
