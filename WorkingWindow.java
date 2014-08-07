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
import java.awt.BorderLayout;

class WorkingWindow extends JFrame{
	/**
	 * There is a lot of work to do, this is a very poor main window.
	 * For example there is a need for a menubar, saving and restoring
	 * puzzles. We are in need of setting up a new puzzle.
	 * **/
	
	private WorkingPanel workArea;
	private CrossWord workInstance;
	private Editor editke;
	
	public WorkingWindow(String title){
		workInstance = new CrossWord(new Dimension(15, 17));
		workArea = new WorkingPanel(workInstance);
		editke =  new Editor(workArea, workInstance);
		initUI(title);
	}
	
	public WorkingWindow(String title, Dimension size){
		workInstance = new CrossWord(size);
		workArea = new WorkingPanel(workInstance);
		editke =  new Editor(workArea, workInstance);
		initUI(title);
	}
	
	private void initUI(String title){
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(new MyMenuBar(workInstance, workArea), BorderLayout.PAGE_START);
		add(workArea, BorderLayout.CENTER);
		addKeyListener(editke);
		pack();
		setResizable(false);
	}

}
