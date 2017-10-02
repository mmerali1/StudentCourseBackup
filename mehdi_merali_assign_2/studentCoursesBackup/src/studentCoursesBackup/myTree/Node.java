package studentCoursesBackup;

import java.util.ArrayList;

public class Node{

    private int  bNumber;
    ArrayList<String> courseNamesList = new ArrayList<String>();
    Node left, right;
	Node observerList[2];

    public Node(){
		bNumber = -1;
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

    
}
