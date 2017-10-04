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
    	//Checks that arguments are correct
		boolean runFlag = true;		
		String strTemp;		
		for(int j=0; j<args.length; j++){
			strTemp = args[j];			
			if(strTemp.charAt(0) == '$'){
				runFlag = false;
				break;			
			}
		}
		//Error message if runFlag set to false
		if (runFlag == false){
			System.err.println("Invalid number of arguments");
			System.exit(0);
		} else {
			//Otherwise run program
			//Declaration of instances and variables
			String line;
			FileProcessor inputFile;
			FileProcessor deleteFile;
			TreeBuilder treeOrig = new TreeBuilder();
			Results[] resArr = new Results[3];
			resArr[0] = new Results();
			resArr[1] = new Results();
			resArr[2] = new Results();
			inputFile = new FileProcessor(args[0]);
			
			//Reading in inputs from file and adding them to tree
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
			//Write 3 trees to 3 result instances
			treeOrig.printNodes(resArr);
			//Close input file
			inputFile.closeFile();
			
			//Open delete file
			deleteFile = new FileProcessor(args[1]);
			//Read in delete file and delete specified nodes from tree
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
			
			//Write three trees to 3 result instances
			treeOrig.printNodes(resArr);
			deleteFile.closeFile();
			
			//Write Result instances to file
			for (int i=0; i<3; i++){
				resArr[i].writeToFile(args[i+2]);			
			}
		}
    }
}
