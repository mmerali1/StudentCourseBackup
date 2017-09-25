
public class Node{

    private int  bNumber;
    List<String> courseNamesList = new ArrayList<String>();
    
    public Node(){
	bNumber = -1;
    }

    public Node(int bNumberIn){
	bNumber = bNumberIn;
    }

    public int getBNumber(){
	return bNumber;
    }

    public void addCourse(String courseNameIn){
	courseNamesList.add(courseNameIn);
    }
    



}
