import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuBar extends javax.swing.JMenuBar{
	/**
	 * The menubars class. It will be added in the main program to the
	 * main window to allow opening a new crossword and some file
	 * operations. This makes these must be overriden there, and here are
	 * no code for them.
	 * */
	
	//The head menus
	JMenu file = new JMenu("Fájl");
	JMenu setup = new JMenu("Beállítások");
	JMenu helpMenu = new JMenu("Súgó");
	
	//The menu items
	JMenuItem getnew = new JMenuItem("Új");
	JMenuItem open = new JMenuItem("Megnyitás");
	JMenuItem save = new JMenuItem("Mentés");
	JMenuItem saveas = new JMenuItem("Mentés másként");
	JMenuItem print = new JMenuItem("Nyomtatás");
	JMenuItem export = new JMenuItem("Exportálás");
	JMenuItem exit = new JMenuItem("Kilépés");
	
	JMenuItem resize = new JMenuItem("Átméretezés");
	JMenuItem fonts = new JMenuItem("Betűtípus");
	JMenuItem colors = new JMenuItem("Színek");
	
	JMenuItem help = new JMenuItem("Súgó");
	JMenuItem version = new JMenuItem("Verzió");
	
	//And last: the reference for the crossword, because I didn't find
	//out, how to return a value from a void method...
	CrossWord temporaryCrossWord;
	
	public MenuBar(CrossWord cw){
		
		this.temporaryCrossWord = cw;
		
		//Headmenus
		add(file);
		add(setup);
		add(helpMenu);
		
		//File menu
		file.add(getnew);
		file.add(open);
		file.add(save);
		file.add(saveas);
		file.add(print);
		file.add(export);
		file.add(exit);
		
		//Setup menu
		setup.add(resize);
		setup.add(fonts);
		setup.add(colors);
		
		//Help menu
		helpMenu.add(help);
		helpMenu.add(version);
		
		//File submenus.
		getnew.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		open.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		save.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		saveas.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		print.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		export.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		
		//Setup submenus
		resize.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		fonts.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		colors.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		
		//Help submenus
		help.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
		version.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					}
				});
	}
}
