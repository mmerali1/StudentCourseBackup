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
		System.out.print(args.length);
		if (args.length != 5){
			System.err.println("Invalid number of arguments");
			System.exit(0);
		} else {
			String line;
			FileProcessor inputFile;
			FileProcessor deleteFile;
			TreeBuilder treeOrig = new TreeBuilder();
			Results[] resArr = new Results[3];
			resArr[0] = new Results();
			resArr[1] = new Results();
			resArr[2] = new Results();
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
					treeOrig.insert(bNum, course,2);
				}
			}
			treeOrig.printNodes(resArr);


			
			System.out.println();
			//res1.writeToStdout();
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
			
			treeOrig.printNodes(resArr);
			//res1.writeToStdout();
			deleteFile.closeFile();
			
			for (int i=0; i<3; i++){
				resArr[i].writeToFile(args[i+2]);			
			}			
		}
    }
}
