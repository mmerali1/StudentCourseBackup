package studentCoursesBackup.myTree;

import java.util.ArrayList;

public class Node implements ObserverI , SubjectI, Cloneable{

    private int  bNumber;
    private ArrayList<String> courseNamesList;
    public Node left;
    public Node right;
	 public Node observerList[] = new Node[2];

  /*  public Node(){
		bNumber = -1;
		left = null;
		right = null;
		courseNamesList = new ArrayList<String>();
		observerList[0] = observerList[1] = null;
    }*/
   public Node(int bNumIn, ArrayList<String> courseNameListIn){
		bNumber = bNumIn;
		courseNamesList = courseNameListIn;
		left = null;
		right = null;
		observerList[0] = null;
		observerList[1] = null;
    }
    /**
    *	Setter method for private variable bNumber
    * @param bNumberIn the new b-number for the node
	* 
    */
    /*public  Node(int bNumberIn){
		bNumber = bNumberIn;
    }*/

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
    
    public Node clone() throws CloneNotSupportedException{
    		Node newNode = new Node(bNumber, courseNamesList);
    		newNode.left = left;
    		newNode.right = right;
    		return newNode;
    }
    
	//do i need params?
	public void notifyAll(Node nodeIn){
			
	}
}
