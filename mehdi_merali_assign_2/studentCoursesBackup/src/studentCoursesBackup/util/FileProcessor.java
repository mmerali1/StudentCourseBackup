//FILENAME: FileProcessor.java
//Author: Mehdi Merali, 2017

package studentCoursesBackup.util;


import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileProcessor {
	private File file;
	private Scanner sc;

    //FileProcessor constuctor
	public FileProcessor(String filename){
		file = new File(filename);
		try{
			sc = new Scanner(file);
		} catch (FileNotFoundException e){
			System.err.println("Exception thrown. File " + filename + " not found.");
			//System.exit(0);
		} 
	
	}

    /**
       readLine function reads a line from file using a private scanner data member
       @return (String) returns one line from a text file
     */
	public String readLine(){
		String temp = "-1";
		if (sc.hasNext()){
			temp = sc.next();		
		} else{
			temp = "-1";			
		}
		return temp;
	}
    /**
       closeFile() closes the Scanner used in this class
       @return void
     */
	public void closeFile(){
		sc.close();
	}
}
