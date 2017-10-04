//FILENAME: Results.java
//Author: Mehdi Merali, 2017

package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.lang.NullPointerException;
import java.io.File;
import java.util.ArrayList;

/**
*	Class is used to store results and write them to either file or terminal	
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	private ArrayList<String> msgContainer;
	
	/** 
	*Constructor creates arraylist data member	
	*/ 
	public Results(){
		msgContainer = new ArrayList<String>();	
	}	
	/**
	*	Stores string into arraylist data member
	*	@param message string that is being stored
	*/
	public void storeNewResult(String message){
		msgContainer.add(message);
	}	
	
	/**
	*	Writes String values in msgContainer data member to file
	*	@param fileName the name of the file being written to
	*/	
	public void writeToFile(String fileName){
		BufferedWriter wr = null;
		try{
			File outfile = new File(fileName);
			wr = new BufferedWriter(new FileWriter(outfile));
			for (int i=0; i<msgContainer.size(); i++){
				wr.write(msgContainer.get(i) + "\n");		
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
	
	/**
	*	Writing String values in msgContainer data member to stdout
	*/	
	public void writeToStdout(){
		for (int i=0; i<msgContainer.size(); i++){
			System.out.println(msgContainer.get(i));		
		}	
	}
}
