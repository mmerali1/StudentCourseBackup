package studentCoursesBackup.util;

//adapted from http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
//used link for insert and search, delete was written by myself
import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;
public class TreeBuilder{

	Node root;
	
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
	public void insert(int bNumIn, ArrayList<String> clsListIn){
		root = insert_recursive(root, bNumIn, clsListIn);
		try{
			root.observerList[0] = (Node)root.clone();
			root.observerList[1] = (Node)root.clone();
		} catch (CloneNotSupportedException e){
			System.err.println("Node could not be cloned. Clone() failed");
		}
	}
	/** 
	*	Helper function for insert() which recursively adds a new node to the tree
	*	@param rootIn is an instance of the current node in the tree
	*	@param bNumIn B-Number for new node
	*	@param clsListIn Course List which corresponds to a unique B-Number
	*	@returns Node instance
	*/
	public Node insert_recursive(Node rootIn, int bNumIn, ArrayList<String> clsListIn){
		if (rootIn == null){
			rootIn = new Node(bNumIn, clsListIn);		
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
	* @returns void	
	*/
	//Add something to handle clearing observers lists and deleting observers
	public void delete(int bNumIn){
		Node selectedNode = search(root, bNumIn);
		selectedNode.setBNumber(-1);
		selectedNode.clear_class_list();	
	}
	
	public void print_tree(){
			print_tree_rec(root);
	}

	public void print_tree_rec(Node rootIn){
	   System.out.println("Node:\t" + rootIn.getBNumber() + '\t' + rootIn.get_course_list());
		if (rootIn.left != null){
			print_tree_rec(rootIn.left);		
		}

		if (rootIn.right!= null){
			print_tree_rec(rootIn.right);		
		}		
	}
	
	
}
