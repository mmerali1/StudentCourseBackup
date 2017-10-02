package studentCoursesBackup;

//adapted from http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
//used link for insert and search, delete was written by myself
import java.util.ArrayList;
public class TreeBuilder{

	Node root;
	
	public TreeBuilder(){
		root = null;
	}

	public void insert(int bNumIn, ArrayList<String> clsListIn){
		root = insert_recursive(root, bNumIn, clsListIn);	
	}
	
	public Node insert_recursive(Node rootIn, int bNumIn, ArrayList<String> clsListIn){
		if (root == null){
			root = new Node(bNumIn, clsListIn);		
			return root;
		}
		
		if (bNumIn < root.getBNumber()){
			root.left = insert_recursive(root.left, bNumIn, clsListIn);		
		}
		else if(bNumIn > root.getBNumber()){
			root.right = insert_recursive(root.right, bNumIn, clsListIn);		
		}
		//ADD CASE FOR DUPLICATE B-Numbers HERE
		return root;
	}

	public Node search(Node rootIn, int bNumIn){
		if (rootIn == null || rootIn.getBNumber() == bNumIn){
			return rootIn;		
		}
		
		if (rootIn.getBNumber() > bNumIn){
			return search(rootIn.left, bNumIn);		
		}
		return search(rootIn.right, bNumIn);
	}
	
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
		if (rootIn.left != null){
			print_tree_rec(rootIn.left);		
		}
		System.out.println("Node:\t" + rootIn.getBNumber() + rootIn.get_course_list());
		if (rootIn.right!= null){
			print_tree_rec(rootIn.right);		
		}		
	}
	
	
}
