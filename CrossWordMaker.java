import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class CrossWordMaker{
	/*
	 * Does nothing just hides the classes.
	 * */
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					new WorkingWindow("CrossWordMaker", new Dimension(21,13)).setVisible(true);
				}
			}
		);
	}

}
