import javax.swing.JMenu;
import javax.swing.JMenuItem;

abstract class MenuBar extends javax.swing.JMenuBar implements java.awt.event.ActionListener{
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
	
	public MenuBar(){
		
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
		getnew.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		print.addActionListener(this);
		export.addActionListener(this);
		exit.addActionListener(this);
		
		//Setup submenus
		resize.addActionListener(this);
		fonts.addActionListener(this);
		colors.addActionListener(this);
		
		//Help submenus
		help.addActionListener(this);
		version.addActionListener(this);
	}
}
