import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class CrossWordMaker{
	/**
	 * This is the entrypoint. No special methods declared here for sa-
	 * fety and security reasons. For beginning we have a standard sized
	 * puzzle, which will be resized later. At least I'm planning it.
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
