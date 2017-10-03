package studentCoursesBackup.driver;

import java.util.ArrayList;

import studentCoursesBackup.util.TreeBuilder;

public class Driver{


    public static void main(String[] args){
    		 /*ArrayList<String> s = new ArrayList<String>();
    		 s.add("S");
    		 s.add("T");
		    TreeBuilder tree = new TreeBuilder();
		    tree.insert(1000, s);
			 s.add("A");			 
			 tree.insert(1002, s);
			 tree.insert(999, s);
			 tree.insert(1001, s);
			 tree.insert(300, s);
			 tree.print_tree();
			 
			 tree.delete(999);    
    		 tree.print_tree();
    		 tree.insert(301, s);
    		 System.out.println("NM");
    		 tree.print_tree();*/
	
		if (args.length != 5){
			System.err.println("Invalid number of arguments");
		} else {
			try{
				FileProcessor fileIn = new FileProcessor(args[0]);
			} catch(FileNotFoundException e){
				System.err.println("File does not exist");
			}
			
			while (fileIn.readline() != "-1"){
				
			}


		}


    }


}
