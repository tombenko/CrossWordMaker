import java.awt.Point;

class Communicator{
	
	private boolean isActiveMessage = false;
	private Message message;
	
	public synchronized void putMessage(CrossWord crossWord, Point activePoint){
		while(isActiveMessage){
			try{
				wait();
			} catch(InterruptedException e){
				
			}
		}
		isActiveMessage = false;
		message = new Message(crossWord, activePoint);
		notify();
	}
	
	public synchronized Message getMessage(){
		while(!isActiveMessage){
			
		}
		isActiveMessage = true;
		notify();
		return message;
	}
}
