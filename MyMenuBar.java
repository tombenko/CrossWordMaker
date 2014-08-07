import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

class MyMenuBar extends JMenuBar{
	
	CrossWord referenceCW;
	WorkingPanel referenceWP;
	
	public MyMenuBar(CrossWord referenceCW, WorkingPanel referenceWP){
		this.referenceCW = referenceCW;
		this.referenceWP = referenceWP;
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
		JMenuItem exit = new JMenuItem("Kilépés");
		file.add(newcw);
		file.add(restore);
		file.add(save);
		file.add(print);
		file.add(exit);
		
		//These items are for the setup menu.
		JMenuItem setMetric = new JMenuItem("Átméretezés");
		JMenuItem setFont = new JMenuItem("Betűtípus");
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
