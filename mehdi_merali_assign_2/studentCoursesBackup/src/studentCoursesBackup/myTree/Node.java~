package studentCoursesBackup.myTree;

import java.util.ArrayList;

public class Node implements ObserverI , SubjectI, Cloneable{

    private int  bNumber;
    private ArrayList<String> courseNamesList = new ArrayList<String>();
    public Node left;
    public Node right;
	 public Node observerList[] = new Node[2];
	 
	 /**
	 *	Empty constuctor for Node. Used primarily in the clone() function
	 */
    public Node(){
		bNumber = -1;
		left = null;
		right = null;
		courseNamesList = new ArrayList<String>();
		observerList[0] = observerList[1] = null;
    }
    
    /**
    *	Main constructor used for creating nodes
    *	@param bNumIn the B-Number value for the node
    *	@param courseNameIn an individual course name for the node
    */
    public Node(int bNumIn, String courseNameIn){
		bNumber = bNumIn;
		courseNamesList.add(courseNameIn);
		left = null;
		right = null;
		observerList[0] = null;
		observerList[1] = null;
    }

	 /**
	 *	Getter method to retrieve B-Number data member
	 * @returns B-Number value
	 */
    public int getBNumber(){
		return bNumber;
    }
    
    /**
    *	Getter method to retrieve courseNamesList
    * @returns ArrayList of Strings
    */
    public ArrayList<String> get_course_list(){
		return courseNamesList;    
    }
    
    /**
    *	Adds class to courseNamesList for existing nodes if that class is not in arrayList
    */
    public void add_class(String classNameIn){
		if ((courseNamesList.contains(classNameIn)) == false){	
			courseNamesList.add(classNameIn);
			/*if (observerList[0] != null && observerList[1] != null){
				observerList[0].courseNamesList.add(classNameIn);
				observerList[1].courseNamesList.add(classNameIn);
			} */   
		}
    }
 
 	 /** 
	 *	Setter for B-Number
	 * @param bNumIn the new B-Number for the node 	 
 	 */   
    //May need error checking here
    public void setBNumber(int bNumIn){
			bNumber = bNumIn;		
    }
    
    /**
    *	Helper function for delete method that deletes course in
    * courseNamesList of all class names
    */
    public void delete_class(String className){
		 	courseNamesList.remove(className);
    }
	
	 /**
	 *	Creates exact copies of nodes for backups
	 *	@throws CloneNotSupportedException where node cannot be cloned
	 *	@returns New instance of Node
	 */
    public Node clone() throws CloneNotSupportedException{
    		Node newNode = new Node();
    		newNode.bNumber = bNumber;
    		newNode.courseNamesList = courseNamesList;
    		newNode.left = left;
    		newNode.right = right;
    		return newNode;
    }
    
	//do i need params?
	
	public void notifyAll(Node nodeIn){
		update(nodeIn);	
	}


	public void update(Node nodeIn){
		try{
			nodeIn.observerList[0] = nodeIn.clone();
			nodeIn.observerList[1] = nodeIn.clone(); 
		} catch (CloneNotSupportedException e){
			System.err.println("Node could not be cloned in update()");		
		}	
	}
	/**
	*	Prints out BNumbers of the observer nodes
	*/
	public void print_observer_list(){
		System.out.println("\tObservers:\t" + observerList[0].getBNumber() + '\t' + observerList[1].getBNumber());		
	}
}
