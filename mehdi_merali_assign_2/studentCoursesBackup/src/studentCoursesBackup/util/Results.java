//FILENAME: Results.java
//Author: Mehdi Merali, 2017

package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.lang.NullPointerException;
import java.io.File;
import java.util.ArrayList;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	private ArrayList<String> msgContainer = new ArrayList<String>();
	public Results(){}	
	
	public void storeNewResult(String message){
		msgContainer.add(message);
		//System.out.println(msgContainer[index]);
	}	
	
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
	
	
	public void writeToStdout(){
		for (int i=0; i<msgContainer.size(); i++){
			System.out.println(msgContainer.get(i));		
		}	
	}
}
