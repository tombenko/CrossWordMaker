import javax.swing.SwingUtilities;

public class CrossWordMaker{
	
	public CrossWordMaker(String fileName){
		new MainProgram(fileName);
	}
	public static void main(String args[]){
		if(args.length == 1){
			//Here will be loaded the chosen crossword, which is then
			//given to the main program.
			new CrossWordMaker(args[0]);
		} else {
			//Here will be made a new and empty crossword file.
			new CrossWordMaker("");
		}
	}
}
