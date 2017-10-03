package studentCoursesBackup.driver;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import java.lang.Integer;
import java.util.Arrays;
import java.lang.String;

public class Driver{


    public static void main(String[] args){

		if (args.length != 5){
			System.err.println("Invalid number of arguments");
			System.exit(0);
		} else {
			String line;
			FileProcessor inputFile;
			FileProcessor deleteFile;
			TreeBuilder treeOrig = new TreeBuilder();
			Results res = new Results();
			inputFile = new FileProcessor(args[0]);

			boolean readFlag = true;
			while (readFlag){
				line = inputFile.readLine();
				if (line.equals("-1")){
					readFlag = false;				
				} else {
					//Possible pattern exception here if input is wrong.
					//Madhu said assume correct input.
					String[] splitLine = line.split(":");
					int bNum = Integer.parseInt(splitLine[0]);					
					String course = splitLine[1];
					treeOrig.insert(bNum, course);
				}
			}
			treeOrig.printNodes(res);
			res.writeToStdout();
			inputFile.closeFile();
			System.out.println();
			deleteFile = new FileProcessor(args[1]);
			readFlag = true;
			while (readFlag){
				line = deleteFile.readLine();
				if (line.equals("-1")){
					readFlag = false;
				} else {
					String[] splitLine = line.split(":");
					int bNum = Integer.parseInt(splitLine[0]);					
					String course = splitLine[1];
					treeOrig.delete(bNum, course);
									
				}			
			
			}
			
			//System.out.println(treeOrig.printNodes(res));
			deleteFile.closeFile();
		}

    }
}
