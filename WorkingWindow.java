import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Dimension;

class WorkingWindow extends JFrame{
	/**
	 * There is a lot of work to do, this is a very poor main window.
	 * For example there is a need for a menubar, saving and restoring
	 * puzzles, handling mouse (maybe this would be easy...) and finding
	 * out, how to set the bold lines in a square. And the
	 * most important: sizing the cossword.
	 * **/
	
	private WorkingPanel workArea;		//Where we will see what we did.
	private CrossWord workInstance;		//It is the crossword we plan to create.
	
	public WorkingWindow(String title){
		workInstance = new CrossWord(new Dimension(15, 17));
		initUI(title);
	}
	
	public WorkingWindow(String title, Dimension size){
		workInstance = new CrossWord(size);
		workArea = new WorkingPanel(workInstance);
		initUI(title);
	}
	
	private void initUI(String title){
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(workArea);
		pack();
		setResizable(false);
	}

}
