package studentCoursesBackup.util;

//adapted from http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
//used link for insert and search; delete and print was written by myself.
import java.util.ArrayList;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.myTree.Node;
public class TreeBuilder{

	private Node root;
	private Node backup_Node_1;
	private Node backup_Node_2;
	
	/**
	*	Empty constructor for class.
	*/
	public TreeBuilder(){
		root = new Node();
		backup_Node_1 = null;
		backup_Node_2 = null;
	}
	/**
	*	Inserts a new node into the binary search tree using recursive helper function
	*	
	*	@param bNumIn B-Number for new node
	*	@param clsListIn The course list which corresponds to a unique B-Number
	*	@return void
	*	@throws CloneNotSupportedException if node cannot be cloned
	*/
	public void insert(int bNumIn, String clsListIn, int cloneTotal){
		//Node origNode = new Node();		
		root = insert_recursive(root, bNumIn, clsListIn, cloneTotal/*, backup_Node_1, backup_Node_2*/);
		backup_Node_1 = set_observer_tree(backup_Node_1, root, bNumIn, 0);
		backup_Node_2 = set_observer_tree(backup_Node_1, root, bNumIn, 1);
	}
	
	/** 
	*	Helper function for insert() which recursively adds a clone node to a 
	*	backup tree
	*	@param backup a backup node instance from the backup tree
	*	@param orig an instance of the current node in the original tree
	*	@param bNumIn B-Number for new node
	*	@param obsID the observerList index number
	*	@returns Node instance to the backup tree
	*/
	public Node set_observer_tree(Node backup, Node orig, int bNumIn, int obsID){
		if (backup ==null){
			try{
				orig.setObserverList(obsID, (Node)orig.clone());
				backup = orig.observerList[obsID];
				//System.out.println("\tObservers:\t + root.observerList[0].getBNumber() + '\t' + root.observerList[1].getBNumber());
			} catch (CloneNotSupportedException | NullPointerException e){
				System.err.println("Node could not be cloned. Clone() failed");
				//System.exit(0);
			}	
		}if (bNumIn < orig.getBNumber()){
			backup.left = set_observer_tree(backup.left, orig.left, bNumIn, obsID);		
		}
		if(bNumIn > orig.getBNumber()){
			backup.right = set_observer_tree(backup.right, orig.right, bNumIn, obsID);		
		}
		return backup;
	}
	
	/** 
	*	Helper function for insert() which recursively adds a new node to the tree
	*	@param rootIn is an instance of the current node in the tree
	*	@param bNumIn B-Number for new node
	*	@param clsListIn Course List which corresponds to a unique B-Number
	*	@returns Node instance
	*/
	public Node insert_recursive(Node rootIn, int bNumIn, String clsListIn, int cloneTotal/*, Node backup1, Node backup2*/){
		if ((rootIn == null) || (rootIn.getBNumber() == -1)){
			rootIn = new Node(bNumIn, clsListIn);
			return rootIn;
		}/*
		NEED TO FIX INSERT FOR DELETED NODES
		if (rootIn.getBNumber() == -1){
			rootIn = new Node(bNumIn, clsListIn);		
			return rootIn;		
		}*/
		if(bNumIn == rootIn.getBNumber()){
			rootIn.add_class(clsListIn);
		//	rootIn.observerList[0].add_class(clsListIn);
		//	rootIn.observerList[1].add_class(clsListIn);
		}
		if (bNumIn < rootIn.getBNumber()){
			rootIn.left = insert_recursive(rootIn.left, bNumIn, clsListIn, cloneTotal/*, backup1.left, backup2.left*/);		
		}
		if(bNumIn > rootIn.getBNumber()){
			rootIn.right = insert_recursive(rootIn.right, bNumIn, clsListIn, cloneTotal/*, backup1.right, backup2.right*/);		
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
		if(selectedNode != null){		
			if(selectedNode.get_course_list().contains(clsNameIn)){
				selectedNode.delete_class(clsNameIn);
			}
			
			if (selectedNode.get_course_list().isEmpty()){
				selectedNode.setBNumber(-1);	
			}
			selectedNode.notifyAll(selectedNode);
		}
		
	}
	
	/**
	* Calls function that recursively iterates through the tree and prints
	* each node's B-Number, course list, and observer list.
	* @param res[] an array of Result instances
	*/
	public void printNodes(Results res[]){
			print_tree_rec(root, res[0]);
			res[0].storeNewResult("\n");
			print_tree_rec(backup_Node_1, res[1]);
			res[1].storeNewResult("\n");
			print_tree_rec(backup_Node_2, res[2]);
			res[2].storeNewResult("\n");	
	}
	
	/**
	* Recursively iterates through the tree and prints
	*	each node's B-Number, course list, and observer list.
	* @param rootIn Node that function is currently pointing to
	*/
	public void print_tree_rec(Node rootIn, Results r){
		if (rootIn.left != null){
			print_tree_rec(rootIn.left, r);
		}				
		r.storeNewResult("" + rootIn.getBNumber() + ':' + rootIn.get_course_list());				
		//rootIn.print_observer_list();		
		if (rootIn.right != null){			
			print_tree_rec(rootIn.right, r);		
		}
	}
	
	/**
	*	Returns private data member root
	*/
	public Node getRoot(){
		return root;	
	}
	
	/**
	*	Returns private data member backup_Node_1
	*/
	public Node getObserver1(){
		return backup_Node_1;	
	}
	
	/**
	*	Returns private data member backup_Node_2
	*/
	public Node getObserver2(){
		return backup_Node_2;	
	}
	
}
