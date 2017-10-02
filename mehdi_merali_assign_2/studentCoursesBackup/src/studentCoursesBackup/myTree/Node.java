package studentCoursesBackup;

import java.util.ArrayList;

public class Node{

    private int  bNumber;
    private ArrayList<String> courseNamesList;
    Node left;
    Node right;
	 Node observerList[];

    public Node(){
		bNumber = -1;
		left = null;
		right = null;
		courseNamesList = new ArrayList<String>();
		observerList[0] = observerList[1] = null;
    }
   public Node(int bNumIn, ArrayList<String> courseNameListIn){
		bNumber = bNumIn;
		courseNamesList = courseNameListIn;
		left = null;
		right = null;
		observerList[0] = observerList[1] = null;
    }
    public Node(int bNumberIn){
		bNumber = bNumberIn;
    }

    public int getBNumber(){
		return bNumber;
    }
    
    public ArrayList<String> get_course_list(){
		return courseNamesList;    
    }
    
    //May need error checking here
    public void setBNumber(int bNumIn){
			bNumber = bNumIn;		
    }
    
    public void clear_class_list(){
		courseNamesList.clear();  
    }
    
}
