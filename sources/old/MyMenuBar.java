import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Dimension;

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
		
		//Here will be the saving operations.
		JMenuItem save = new JMenuItem("Mentés");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JFrame dialogPanel = new JFrame("Készülőben");
				JLabel label = new JLabel("Készülőben...");
				JButton button = new JButton("OK");
				dialogPanel.setLayout(new GridLayout(2,1));
				dialogPanel.add(label);
				dialogPanel.add(button);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent E){
						dialogPanel.dispose();
					}
				});
				dialogPanel.pack();
				dialogPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				dialogPanel.setVisible(true);
			}
		});
		
		//Here will be the restoring operation.
		JMenuItem restore = new JMenuItem("Megnyitás");
		restore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JFrame dialogPanel = new JFrame("Készülőben");
				JLabel label = new JLabel("Készülőben...");
				JButton button = new JButton("OK");
				dialogPanel.setLayout(new GridLayout(2,1));
				dialogPanel.add(label);
				dialogPanel.add(button);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent E){
						dialogPanel.dispose();
					}
				});
				dialogPanel.pack();
				dialogPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				dialogPanel.setVisible(true);
			}
		});
		
		//This menupoint is for a new puzzle.
		JMenuItem newcw = new JMenuItem("Új");
		newcw.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JFrame dialogPanel = new JFrame("Új keresztrejtvényhálózat megadása");
				JLabel rows = new JLabel("A sorok száma:");
				JLabel columns = new JLabel("Az oszlopok száma:");
				final JTextField rowText = new JTextField(3);
				final JTextField columnText = new JTextField(3);
				JPanel input = new JPanel();
				JButton button = new JButton("OK");
				input.setLayout(new GridLayout(2,2));
				input.add(rows);
				input.add(rowText);
				input.add(columns);
				input.add(columnText);
				dialogPanel.setLayout(new BorderLayout());
				dialogPanel.add(input, BorderLayout.PAGE_START);
				dialogPanel.add(button, BorderLayout.CENTER);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent E){
						try{
							int row = Integer.parseInt(rowText.getText());
							int column = Integer.parseInt(columnText.getText());
							newPuzzle(row, column);
							dialogPanel.dispose();
						} catch(NumberFormatException nfe){
							
						}
					}
				});
				dialogPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				dialogPanel.pack();
				dialogPanel.setVisible(true);
			}
		});
		
		//Here will be the printing operations.
		JMenuItem print = new JMenuItem("Nyomatás");
		print.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JFrame dialogPanel = new JFrame("Készülőben");
				JLabel label = new JLabel("Készülőben...");
				JButton button = new JButton("OK");
				dialogPanel.setLayout(new GridLayout(2,1));
				dialogPanel.add(label);
				dialogPanel.add(button);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent E){
						dialogPanel.dispose();
					}
				});
				dialogPanel.pack();
				dialogPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				dialogPanel.setVisible(true);
			}
		});
		
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
				final JFrame dialogPanel = new JFrame("Készülőben");
				JLabel label = new JLabel("Készülőben...");
				JButton button = new JButton("OK");
				dialogPanel.setLayout(new GridLayout(2,1));
				dialogPanel.add(label);
				dialogPanel.add(button);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent E){
						dialogPanel.dispose();
					}
				});
				dialogPanel.pack();
				dialogPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				dialogPanel.setVisible(true);
			}
		});
		
		setup.add(setMetric);
		setup.add(setFont);
		
		//These are for the information menu.
		
		//When I will be in the mood, I will write this...
		JMenuItem help = new JMenuItem("Súgó");
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JFrame dialogPanel = new JFrame("Készülőben");
				JLabel label = new JLabel("Készülőben...");
				JButton button = new JButton("OK");
				dialogPanel.setLayout(new GridLayout(2,1));
				dialogPanel.add(label);
				dialogPanel.add(button);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent E){
						dialogPanel.dispose();
					}
				});
				dialogPanel.pack();
				dialogPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				dialogPanel.setVisible(true);
			}
		});
		
		//Some informations about the program.
		JMenuItem information = new JMenuItem("Információ");
		information.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JFrame infoPanel = new JFrame("Információk");
				JLabel creator = new JLabel("Készítette");
				JLabel version = new JLabel("Verzió");
				JLabel creatorInfo = new JLabel("Benkó Tamás tombenko@gmail.com");
				JLabel versionInfo = new JLabel("0.3.2");
				JButton button = new JButton("Bezárás");
				JPanel top = new JPanel();
				top.setLayout(new GridLayout(2,2));
				top.add(creator);
				top.add(creatorInfo);
				top.add(version);
				top.add(versionInfo);
				infoPanel.setLayout(new BorderLayout());
				infoPanel.add(top, BorderLayout.PAGE_START);
				infoPanel.add(button, BorderLayout.CENTER);
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent E){
						infoPanel.dispose();
					}
				});
				infoPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				infoPanel.pack();
				infoPanel.setVisible(true);
			}
		});
		
		info.add(help);
		info.add(information);
		
		//Making the menubar.
		this.add(file);
		this.add(setup);
		this.add(info);
	}
	
	private void newPuzzle(int row, int column){
		referenceWW.newPuzzle(row, column);
	}
}
