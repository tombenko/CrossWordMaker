import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
	
	private WorkingPanel workArea; //Where we will see what we did.
	private Editor edit; //Where we do what we would like.
	private Communicator communicator = new Communicator(); //It is the information chanel.
	private CrossWord workInstance; //It is the crossword we plan to create.
	
	public WorkingWindow(String title){
		initUI(title);
	}
	
	public WorkingWindow(String title, Dimension size){
		workInstance = new CrossWord(size);
		edit = new Editor(workInstance, communicator);
		workArea = new WorkingPanel(workInstance, communicator);
		new Thread(edit).start();
		new Thread(workArea).start();
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
