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
    *	Constructor which is called in clone()
    *	Does a deep copy of all data members in the Array
	 * @param bNumIn bNumber to be set to private data member    
    * @param listIn the course names list
    *	@param leftIn left child node reference
    * @param rightIn right child node pointer
    */
    public Node(int bNumIn, ArrayList<String> listIn, Node leftIn, Node rightIn){
		bNumber = bNumIn;
		courseNamesList = listIn;
		left = leftIn;
		right = rightIn;
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
    public Object clone() throws CloneNotSupportedException{
    		Node newNode = new Node(this.bNumber, this.courseNamesList, this.left, this.right);
			return newNode;    
    }
    
	/**
	*	notifies all observers that a change has been made to the subject
	*	@param nodeIn is the subject node
	*/
	public void notifyAll(Node nodeIn){
		update(nodeIn, 0);
		update(nodeIn, 1);	
	}

	/**
	*	updates observers following being called from notifyAll()
	*	@param nodeIn the subject node
	*	@param obsID the observer being updated
	*/
	public void update(Node nodeIn, int obsID){
		if (nodeIn != null && nodeIn.observerList[obsID] != null){		
			if(nodeIn.bNumber != nodeIn.observerList[obsID].getBNumber()){
				nodeIn.observerList[obsID].bNumber = nodeIn.bNumber;		
			}

			nodeIn.observerList[obsID].courseNamesList.clear();
			for (int i=0; i<nodeIn.courseNamesList.size(); i++){
				nodeIn.observerList[obsID].courseNamesList.add(nodeIn.courseNamesList.get(i));
			}
		}
	}
	
	/**
	*	Prints out BNumbers of the observer nodes
	*/
	public void print_observer_list(){
		System.out.println("\tObservers:\t" + observerList[0].getBNumber() + '\t' + observerList[1].getBNumber());		
	}

	/**
	*	sets observer list to a node
	*	@param index used to index the observerList array
	*	@param nodeIN is the node being set to the observerList array
	*/	
	public void setObserverList(int index, Node nodeIN){
		observerList[index] = nodeIN;	
	}
	
}
