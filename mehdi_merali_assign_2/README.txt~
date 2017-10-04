Mehdi Merali
Design Patterns -- Assignment 2

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
cd mehdi_merali_assign_2/studentCoursesBackup
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=out1.txt -Darg3=out2.txt -Darg4=out3.txt
	-Darg0 --> the input file
	-Darg1 --> the delete nodes file
	-Darg2 --> the output file for the original tree
	-Darg3 --> the output file for backup tree 1
	-Darg4 --> the output file for backup tree 2

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf mehdi_merali_assign_2.tar.gz mehdi_merali_assign_2

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/4/2017]	Mehdi Merali

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Used a linked list for building the binary search tree. The BST held all the nodes for the 
original tree and all the backup trees. The worst case time complexity for an insert or 
search or delete function for this tree is O(n). For printing the entire tree the best 
case time complexity is O(n).

I used this tree because of the simplicity of its implementation and linear
growth rate. Its simplicity made it easier to track and identify where nodes should go
and also made it easier to print out each node sorted by B-Number.
Its liner growth rate did not visually affect performance when I ran input-22.txt and
delete22.txt from mycourses which had 10000 nodes. It is possible that the runtime will
deteriorate with higher input  

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).
http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	Used implemention of search and insert as basis for my search and input files in 
	TreeBuilder.java
	Based my printNodes function off search function as well, but it was mostly modified
	Also used Node class from link as reference
	
http://www.cs.binghamton.edu/~mgovinda/courses/java_guidelines/cloneDetails.txt
	Used as guide to write clone method in Class Node