import javax.swing.SwingUtilities;

public class CrossWordMaker{
	/*
	 * Does nothing just hides the classes.
	 * */
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					new WorkingWindow().setVisible(true);
				}
			}
		);
	}

}
