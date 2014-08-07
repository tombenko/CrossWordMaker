import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

class MyMenuBar extends JMenuBar{
	/**
	 * This is the menubar. The dialog windows are written as inner
	 * classes not to have a lot of tiny and used only once source fi-
	 * les. There is a reference to the edited puzzle, to the display
	 * panel and the window itself, to easily update them if necessary.
	 * */
	
	private CrossWord referenceCW;
	private WorkingPanel referenceWP;
	private WorkingWindow referenceWW;
	private boolean wasSaved = false; //For later...
	
	public MyMenuBar(CrossWord referenceCW, WorkingPanel referenceWP, WorkingWindow referenceWW){
		this.referenceCW = referenceCW;
		this.referenceWP = referenceWP;
		this.referenceWW = referenceWW;
		initMenuBar();
	}
	
	private void initMenuBar(){
		JMenu file = new JMenu("File");
		JMenu setup = new JMenu("Beállítások");
		JMenu info = new JMenu("Információk");
		
		//These items are for the File menu.
		JMenuItem save = new JMenuItem("Mentés");
		
		JMenuItem restore = new JMenuItem("Megnyitás");
		
		JMenuItem newcw = new JMenuItem("Új");
		
		JMenuItem print = new JMenuItem("Nyomatás");
		
		//Ends the work. Yet it is very rough, but since I didn't do the
		//saving part, it's enough.
		JMenuItem exit = new JMenuItem("Kilépés");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		file.add(newcw);
		file.add(restore);
		file.add(save);
		file.add(print);
		file.add(exit);
		
		//These items are for the setup menu.
		
		//Here we can resize the display if necessary.
		JMenuItem setMetric = new JMenuItem("Átméretezés");
		setMetric.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent A){
				final JFrame dialogPanel = new JFrame("Méret beállítása");
				JLabel label = new JLabel("A megjelenítéshez használt méret:");
				final JTextField text = new JTextField(3);
				JButton button = new JButton("OK");
				JPanel bottom = new JPanel();
				dialogPanel.setLayout(new GridLayout(2,1));
				bottom.setLayout(new GridLayout(1,2));
				bottom.add(text);
				bottom.add(button);
				dialogPanel.add(label);
				dialogPanel.add(bottom);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent B){
						try{
							referenceWW.resize(Integer.parseInt(text.getText()));
							dialogPanel.dispose();
							
						} catch(NumberFormatException e){
							
						}
					}
				});
				dialogPanel.pack();
				dialogPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				dialogPanel.setVisible(true);
			}
		});
		
		//Here we will be able to change the used font.
		JMenuItem setFont = new JMenuItem("Betűtípus");
		setFont.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				final JFrame dialog = new JFrame("Fejlesztés alatt!");
				JButton button = new JButton("OK");
				dialog.setLayout(new GridLayout(2,1));
				dialog.add(new JLabel("A menüpont még fejlesztés alatt van!"));
				dialog.add(button);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent B){
						dialog.dispose();
					}
				});
				dialog.pack();
				dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		
		setup.add(setMetric);
		setup.add(setFont);
		
		//These are for the information menu.
		JMenuItem help = new JMenuItem("Súgó");
		JMenuItem creator = new JMenuItem("Készítette");
		JMenuItem version = new JMenuItem("Verzió");
		info.add(help);
		info.add(creator);
		info.add(version);
		
		//Making the menubar.
		this.add(file);
		this.add(setup);
		this.add(info);
	}
}
