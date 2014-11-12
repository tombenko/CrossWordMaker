import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

class MainWindow extends javax.swing.JFrame{
	private Display display;
	private Editor editor;
	private CrossWord crossword;
	private JPanel workArea = new JPanel();
	
	public MainWindow(Editor e, Display d, CrossWord cw){
		this.display = d;
		this.editor = e;
		this.crossword = cw;
		initUI();
	}
	
	private void initUI(){
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(editor);
		add(workArea, BorderLayout.CENTER);
		setJMenuBar(menuMaker());
		workArea.add(display);
		setResizable(false);
		pack();
	}
	
	private JMenuBar menuMaker(){
		JMenuBar menu = new JMenuBar();
		
		JMenu file = new JMenu("Fájl");
		JMenu setup = new JMenu("Beállítások");
		JMenu help = new JMenu("Súgó");
		menu.add(file);
		menu.add(setup);
		menu.add(help);
		
		return menu;
	}
}
