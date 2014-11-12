import java.awt.Point;
import java.awt.Dimension;

public class MainProgram{
	
	private CrossWord theCrossWord;
	private Point theCursor = new Point(0,0);
	private Editor theEditor;
	private Display theDisplay;
	private MainWindow theMainWindow;
	
	public MainProgram(String fileName){
		//The filename is the opened crossword. When it is an empty
		//string, we opening a window to set up the beginning size.
		
		if(fileName != ""){
			theCrossWord = FileOperations.LoadFile(new java.io.File(fileName));
		} else {
			theCrossWord = new CrossWord(new Dimension(15,17));
			//For testing purposes...
		}
		
		initUI();
		theMainWindow.setTitle("Crossword Maker" + fileName);
	}
	
	private void initUI(){
		theDisplay = new Display(theCrossWord, theCursor);
		theEditor = new Editor(theCrossWord, theCursor,theDisplay);
		theMainWindow = new MainWindow(theEditor, theDisplay, theCrossWord);
		theMainWindow.setVisible(true);
	}
}
