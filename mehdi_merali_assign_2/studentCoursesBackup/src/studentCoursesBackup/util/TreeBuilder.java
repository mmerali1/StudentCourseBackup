package studentCoursesBackup.util;

//adapted from http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
//used link for insert and search; delete and print was written by myself.
import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;
public class TreeBuilder{

	private Node root;
	
	/**
	*	Empty constructor for class.
	*/
	public TreeBuilder(){
		root = null;
	}
	
	/**
	*	Inserts a new node into the binary search tree using recursive helper function
	*	
	*	@param bNumIn B-Number for new node
	*	@param clsListIn The course list which corresponds to a unique B-Number
	*	@return void
	*	@throws CloneNotSupportedException if node cannot be cloned
	*/
	public void insert(int bNumIn, String clsListIn){
		root = insert_recursive(root, bNumIn, clsListIn);
		
	}
	
	/** 
	*	Helper function for insert() which recursively adds a new node to the tree
	*	@param rootIn is an instance of the current node in the tree
	*	@param bNumIn B-Number for new node
	*	@param clsListIn Course List which corresponds to a unique B-Number
	*	@returns Node instance
	*/
	public Node insert_recursive(Node rootIn, int bNumIn, String clsListIn){
		if ((rootIn == null) || (rootIn.getBNumber() == -1)){
			rootIn = new Node(bNumIn, clsListIn);
			try{
				rootIn.observerList[0] = rootIn.clone();
				rootIn.observerList[1] = rootIn.clone();
				//System.out.println("\tObservers:\t" + root.observerList[0].getBNumber() + '\t' + root.observerList[1].getBNumber());
			} catch (CloneNotSupportedException | NullPointerException e){
				System.err.println("Node could not be cloned. Clone() failed");
				//System.exit(0);
			}
			return rootIn;
		}/*
		NEED TO FIX INSERT FOR DELETED NODES
		if (rootIn.getBNumber() == -1){
			rootIn = new Node(bNumIn, clsListIn);		
			return rootIn;		
		}*/
		
		if (bNumIn < rootIn.getBNumber()){
			rootIn.left = insert_recursive(rootIn.left, bNumIn, clsListIn);		
		}
		if(bNumIn > rootIn.getBNumber()){
			rootIn.right = insert_recursive(rootIn.right, bNumIn, clsListIn);		
		}
		if(bNumIn == rootIn.getBNumber()){
			rootIn.add_class(clsListIn);		
		}
		//ADD CASE FOR DUPLICATE B-Numbers HERE
		return rootIn;
	}
	
	/**
	*	Recursively searches through the tree for a given node
	*	@param rootIn a Node instance used to parse through the tree
	*	@param bNumIn B-Number for the node instance being searched for
	*	@returns the specific node instance
	*/
	public Node search(Node rootIn, int bNumIn){
		if (rootIn == null || rootIn.getBNumber() == bNumIn){
			return rootIn;		
		}
		
		if (rootIn.getBNumber() > bNumIn){
			return search(rootIn.left, bNumIn);		
		}
		return search(rootIn.right, bNumIn);
	}
	/** 
	* Deletes a given node by resetting all its data values to default
	* @param bNumIn the unique B-Number of the node being deleted
	* @param clsNameList the name of the class being deleted
	* @returns void	
	*/
	//Add something to handle clearing observers lists and deleting observers
	public void delete(int bNumIn, String clsNameIn){
		Node selectedNode = search(root, bNumIn);
		if(selectedNode.get_course_list().size() > 0){
			selectedNode.delete_class(clsNameIn);
			//Notify observers here
		} else{
			selectedNode.setBNumber(-1);
			selectedNode.observerList[0] = null;
			selectedNode.observerList[1] = null;		
		}	
	}
	
	/**
	* Calls function that recursively iterates through the tree and prints
	*	each node's B-Number, course list, and observer list.
	*/
	public void print_tree(){
			print_tree_rec(root);
	}
	
	/**
	* Recursively iterates through the tree and prints
	*	each node's B-Number, course list, and observer list.
	* @param rootIn Node that function is currently pointing to
	*/
	public void print_tree_rec(Node rootIn){
		if (rootIn.left != null){
			print_tree_rec(rootIn.left);		
		}
	   System.out.println("Node:\t" + rootIn.getBNumber() + '\t' + rootIn.get_course_list());
		rootIn.print_observer_list();
		if (rootIn.right!= null){
			print_tree_rec(rootIn.right);		
		}		
	}
}
