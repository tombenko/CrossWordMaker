import java.awt.Dimension;
import java.io.*;

class FileOperations{
	
	public static final String defaultFileName = "$(HOME)/CrossWordMaker/";
	public static String fileName = defaultFileName;
		
		static public CrossWord LoadFile(File fn){
			/**
			 * When given a filename, this method opens it and returns
			 * as a CrossWord object.
			 * */
			 
			DataInputStream dis;
			CrossWord cw;
			
			try{
				dis = new DataInputStream(new FileInputStream(fn));
			} catch(FileNotFoundException e){
				//Here comes a window with an error report, sending the
				//error to stderr and then throw back a default
				//crossword.
				
				return new CrossWord(new Dimension(15,17));
			}
			
			try{
				cw = new CrossWord(new Dimension(dis.readInt(),dis.readInt()));
			} catch(IOException e){
				//An error message and throwing back the default
				//crossword.
				
				return new CrossWord(new Dimension(15,17));
			}
			
			//And now fill up the crossword.
			
			for(int i = 0; i < cw.getSize().width; i++){
				for(int j = 0; j < cw.getSize().height; j++){
					java.awt.Point p = new java.awt.Point(i, j);
					try{
						cw.setLetter(dis.readChar(), p);
					} catch(IOException e){
						//Send a report to stderr and set the letter
						//as empty.
						cw.setLetter(' ', p);
					}
					
					try{
						cw.setNumber(dis.readInt(), p);
					} catch(IOException e){
						//Send a report to stderr and set the number as
						//0
						cw.setNumber(0, p);
					}
					
					try{
						if(dis.readBoolean()){
							cw.toggleSideLine(Square.RIGHT, p);
						}
					} catch(IOException e){
						//fucking report and no line
					}
					
					try{
						if(dis.readBoolean()){
							cw.toggleSideLine(Square.BOTTOM, p);
						}
					} catch(IOException e){
						//Ehhh...
					}
				}
			}
			 
			return cw;
		}
		
		static public CrossWord LoadFile(){
			/**
			 * First we ask for the filename to load, then calling the
			 * method with it.
			 * */
			 
			//This is for testing purposes.
			return LoadFile(new File(defaultFileName));
		}
		
		static public void SaveFile(CrossWord cw){
			/**
			 * Wiriting the crossword to the given file. The file built
			 * up this way:
			 * 		- the first two integer is the crosswords dimension
			 * 		- then comes the squares, one by one by this sequence:
			 * 			* the letter
			 * 			* the number
			 * 			* the right thick line
			 * 			* the bottom thick line.
			 * */
			
			SaveFile(cw, defaultFileName);
			return;
		}
		
		static public void SaveFile(CrossWord cw, String fn){
			File targetFile = new File(fn);
			DataOutputStream dos;
			
			try{
				dos = new DataOutputStream(new FileOutputStream(targetFile));
			} catch(FileNotFoundException e){
				//Send a report to stderr, show an information window,
				//then fall back...
				return;
			}
			
			//And now write the crossword.
		}
		
		static public void PrintFile(){
			/**
			 * The print method. Later...
			 * */
			
		}
		
		static public void ExportFile(String fn){
			/**
			 * For exporting and writing out the crossword. The only
			 * sane format I found is the cwpuzzle macro for LaTeX. It
			 * is a text file with exact format and a .tex extension.
			 * */
			
		}
}
