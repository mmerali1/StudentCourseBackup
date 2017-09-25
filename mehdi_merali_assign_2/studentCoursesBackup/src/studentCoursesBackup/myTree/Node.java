package studentCoursesBackup;

import java.util.ArrayList;

public class Node{

    private int  bNumber;
    ArrayList<String> courseNamesList = new ArrayList<String>();
    
    public Node(){
		bNumber = -1;
    }

    public Node(int bNumberIn){
		bNumber = bNumberIn;
    }

    public int getBNumber(){
		return bNumber;
    }

   public void insert_node(){}
   public void search_node(){}
   public void delete_node(){}
    
}
