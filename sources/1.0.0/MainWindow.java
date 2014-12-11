import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

class MainWindow extends javax.swing.JFrame{
	private JPanel workArea = new JPanel();
	
	public MainWindow(){
		initUI();
	}
	
	private void initUI(){
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(workArea, BorderLayout.CENTER);
		setResizable(false);
	}
	
	public void addDisplay(Display d){
		workArea.add(d);
	}
	
	public void removeDisplay(Display d){
		workArea.remove(d);
	}
}
