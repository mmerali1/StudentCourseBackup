//FILENAME: FileProcessor.java
//Author: Mehdi Merali, 2017

package studentCoursesBackup.util;


import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * FileProcessor is used to open, read, and close files from the directory
 */
public class FileProcessor {
	private File file;
	private Scanner sc;

    /**
     * Constructor takes in filename to open file
     * @param filename the name of the file being opened
     * @throws  FileNotFoundException if file cannot be found
     */
	public FileProcessor(String filename){
		file = new File(filename);
		try{
			sc = new Scanner(file);
		} catch (FileNotFoundException e){
			System.err.println("Exception thrown. File " + filename + " not found.");
			System.exit(0);
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
