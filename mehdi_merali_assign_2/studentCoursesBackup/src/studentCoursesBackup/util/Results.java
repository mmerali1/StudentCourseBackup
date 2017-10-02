//FILENAME: Results.java
//Author: Mehdi Merali, 2017

package studentCoursesBackup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.NullPointerException;
import java.io.File;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	private String msgContainer[] = new String[10]; 	//NEED TO FIX> FIGURE OUT HOW MUCH STORAGE IS NEEDED ETC.
	private int index = 0;
	public Results(){}	
	
	public void storeNewResult(String message){
		msgContainer[index] = message;
		//System.out.println(msgContainer[index]);
		index++;
	}	
	
	public void writeToFile(){
		BufferedWriter wr = null;
		try{
			File outfile = new File("output_file.txt");
			wr = new BufferedWriter(new FileWriter(outfile));
			for (int i=0; i<index; i++){
				wr.write(msgContainer[i] + "\n");		
			}
		} catch (IOException e){
			System.err.println("Failed to write to file");
		} finally{
			try{
				wr.close();
			} catch(Exception e){
				System.err.println("Failed to close writer. Writer NULL");
			}
		}
	}
	
	
	public void writeToStdout(){
		for (int i=0; i<index; i++){
			System.out.println(msgContainer[i] + "\n");		
		}	
	}
}
