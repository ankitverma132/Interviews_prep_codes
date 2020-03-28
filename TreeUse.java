package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import StackAndQueue.QueueEmptyException;

class pair {
	TreeNode<Integer> Node;
	int Sum;
}
class minMax{
	TreeNode<Integer> first;
	TreeNode<Integer> second;
}

public class TreeUse {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
//		TreeNode<Integer> root = new TreeNode<>(4);
//		TreeNode<Integer> node1 = new TreeNode<>(5);
//		TreeNode<Integer> node2 = new TreeNode<>(6);
//		TreeNode<Integer> node3 = new TreeNode<>(7);
//		TreeNode<Integer> node4 = new TreeNode<>(8);
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node2.children.add(node4);

		// System.out.println(root);
		// TreeNode<Integer> root = takeInput( s );
		TreeNode<Integer> root = takeInputLevelWise();
		// printLevelWise2(root);
		// System.out.println("Number of nodes " + findNumOfNodes(root));
		// System.out.println("Sum of Nodes " + sumOfNodes(root));
		// System.out.println( "Largest Data " + largestData( root ) );
		// System.out.println( "Number of nodes greater than x " +
		// numOfNodeGreaterThanX(root, 2) );
		/// System.out.println("Height " + height(root));
		// System.out.println(countLeafNodes( root ));
		// levelOrder( root );
		// preOrder( root );
		// postOrder(root);
		// System.out.println(maxSumNode(root).data);
		//System.out.println(checkIdentical(root, root));
		//System.out.println(findNextLargerNode(root, 10).data);
		System.out.println(findSecondLargest( root).data );
		//replaceWithDepthValue( root );
	}

//============================================================================	
	public static TreeNode<Integer> takeInput(Scanner s) {

		System.out.println("Enter next node Data"); // taking data of the node
		int n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(n);

		System.out.println("Enter number of children for " + n); // takinng number of nodes for root node
		int childCount = s.nextInt();

		for (int i = 0; i < childCount; i++) {
			TreeNode<Integer> child = takeInput(s); // getting child nodes of root node
			root.children.add(child); // connecting children with root
		}
		return root;
	}

//=============================================================================	
	public static void print(TreeNode<Integer> root) {

		String str = root.data + " :"; // creating an string to print root node data and

		for (int i = 0; i < root.children.size(); i++) {

			str = str + root.children.get(i).data + ","; // adding child node data to root node data
		}
		System.out.println(str);
		for (int i = 0; i < root.children.size(); i++) {

			print(root.children.get(i)); // calling print function for each children
		}
	}

//==============================================================================
	public static TreeNode<Integer> takeInputLevelWise() {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter Root Data "); // taking root data and making
		int rootData = s.nextInt(); // an tree root node from that
		TreeNode<Integer> root = new TreeNode<>(rootData);

		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root); // creating an queue for pending nodes
									// and adding root to that
		while (!pendingNodes.isEmpty()) {

			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter num of children of " + frontNode.data);
				int numChildren = s.nextInt();

				for (int i = 0; i < numChildren; i++) {
					System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);
					int child = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<>(child);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
			} catch (QueueEmptyException e) {
				// should not come here
				return null;
			}
		}
		return root;
	}

//==========================================================================	
	public static void printLevelWise(TreeNode<Integer> root) {

		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {

			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				String str = frontNode.data + ":";

				for (int i = 0; i < frontNode.children.size(); i++) {

					str = str + frontNode.children.get(i).data + ","; // adding child node data to root node data
					pendingNodes.enqueue(frontNode.children.get(i));
				}
				System.out.println(str);

			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
	}

//=============================================================================	
//	Given a generic tree, print the input tree in level wise order. 
//	That is, print the elements at same level in one line (separated by space). 
//	Print different levels in differnet lines.
//	Sample Input :
//		10 3 20 30 40 2 40 50 0 0 0 0 
//		Sample Output :
//		10
//		20 30 40 
//		40 50
	public static void printLevelWise2(TreeNode<Integer> root) {

		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		pendingNodes.add(null);

		while (!pendingNodes.isEmpty()) {
			if (pendingNodes.peek() == null) {
				System.out.println();
				pendingNodes.poll();
			} else {
				while (pendingNodes.peek() != null) {
					TreeNode<Integer> node = pendingNodes.poll();
					System.out.print(node.data + " ");
					for (int i = 0; i < node.children.size(); i++) {
						pendingNodes.add(node.children.get(i));
					}
				}
				pendingNodes.add(null);
			}
		}
	}

//===========================================================================	
	public static int findNumOfNodes(TreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}
		int count = 1;
		// for loop will become base case here when there would be no child of a node
		// it will not execute for loop and return count to last call
		for (int i = 0; i < root.children.size(); i++) {
			count = count + findNumOfNodes(root.children.get(i));
		}
		return count;
		// using queue
//		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>(); 
//		pendingNodes.enqueue( root );
//		int count = 0;
//		while(!pendingNodes.isEmpty()) {
//			
//			try {
//				TreeNode<Integer> frontNode = pendingNodes.dequeue();
//				count ++;
//				for( int i = 0; i < frontNode.children.size(); i++ ) {
//					
//					pendingNodes.enqueue(frontNode.children.get(i));
//				}
//			} 
//			catch (QueueEmptyException e) {
//				return -1;
//			}	
//		}
//		
//		return count;		
	}

//===========================================================================	
	public static int sumOfNodes(TreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}
		int Sum = root.data;
		// for loop will become base case here when there would be no child of a node
		// it will not execute for loop and return count to last call
		for (int i = 0; i < root.children.size(); i++) {
			Sum += sumOfNodes(root.children.get(i));
		}
		return Sum;

		// using queue
//		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>(); 
//		pendingNodes.enqueue( root );
//		int Sum = 0;
//		while(!pendingNodes.isEmpty()) {
//			
//			try {
//				TreeNode<Integer> frontNode = pendingNodes.dequeue();
//				Sum = Sum + frontNode.data;
//				for( int i = 0; i < frontNode.children.size(); i++ ) {
//					
//					pendingNodes.enqueue(frontNode.children.get(i));
//				}
//			} 
//			catch (QueueEmptyException e) {
//				return -1;
//			}	
//		}
//		return Sum;		
	}

//==========================================================================	
	public static int largestData(TreeNode<Integer> root) {

		if (root == null) {
			return -Integer.MIN_VALUE;
		}

		int max = root.data;
		for (int i = 0; i < root.children.size(); i++) {

			int data = largestData(root.children.get(i));
			if (data > max) {
				max = data;
			}
		}
		return max;
	}

//==========================================================================	
//	Given a tree and an integer x, find and return number of Nodes
//	which are greater than x.
//	Sample Input 1 :
//	35 10 3 20 30 40 2 40 50 0 0 0 0 
//	Sample Output 1 :
//	3
	public static int numOfNodeGreaterThanX(TreeNode<Integer> root, int x) {

		if (root == null) {
			return -Integer.MIN_VALUE;
		}
		int count = 0;
		if (root.data > x) {
			count++;
		}
		for (int i = 0; i < root.children.size(); i++) {

			count = count + numOfNodeGreaterThanX(root.children.get(i), x);
		}
		return count;
	}

// ==========================================================================
	//Heigth or depth of a tree
	public static int height(TreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}
		int max = 0;

		for (int i = 0; i < root.children.size(); i++) {

			int newHeight = height(root.children.get(i));

			if (newHeight > max) {
				max = newHeight;
			}
		}
		return max + 1;
	}

//===========================================================================  
	// Print all nodes at depth K
	public static void printNodeOfDepthK(TreeNode<Integer> root, int k) {

		if (k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
		}
		// Har node k = 0 hai to khud ko print krti h
		// otherwise aage cll kar detti h k-1 kr ke

		for (int i = 0; i < root.children.size(); i++) {
			printNodeOfDepthK(root.children.get(i), k - 1);
		}
	}

//==========================================================================

//	Given a generic tree, count and return 
//	the number of leaf nodes present in the given tree.

	public static int countLeafNodes(TreeNode<Integer> root) {

		if (root == null) {
			return 0;
		}
		if (root.children.size() == 0) {
			return 1;
		}

		int count = 0;
		for (int i = 0; i < root.children.size(); i++) {
			count = count + countLeafNodes(root.children.get(i));
		}

		return count;
	}
//===========================================================================	

	public static void levelOrder(TreeNode<Integer> root) {

		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {

			TreeNode<Integer> node = pendingNodes.remove();
			System.out.print(node.data + " ");

			for (int i = 0; i < node.children.size(); i++) {
				pendingNodes.add(node.children.get(i));
			}
		}
	}

//=========================================================================	
	public static void preOrder(TreeNode<Integer> root) {

		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");

		for (int i = 0; i < root.children.size(); i++) {
			preOrder(root.children.get(i));
		}
	}

//==========================================================================
	public static void postOrder(TreeNode<Integer> root) {

		if (root == null) {
			return;
		}

		for (int i = 0; i < root.children.size(); i++) {
			postOrder(root.children.get(i));
		}
		System.out.print(root.data + " ");
	}
//=========================================================================

//	Check if generic tree contain element x
//	Given a generic tree and an integer x, check if x is present
//	in the given tree or not. Return true if x is present, return false otherwise.
//	Sample Input 1 :
//	40
//	10 3 20 30 40 2 40 50 0 0 0 0 
//	Sample Output 1 :
//	true

	public static boolean checkIfContainsX(TreeNode<Integer> root, int x) {

		if (root == null) {
			return false;
		}
		if (root.data == x) {
			return true;
		}
		for (int i = 0; i < root.children.size(); i++) {

			boolean smallAns = checkIfContainsX(root.children.get(i), x);
			if (smallAns == true) {
				return true;
			}
		}
		return false;
	}
//==========================================================================	

//	Node having sum of children and node is max
//	Given a tree, find and return the node for which sum of data of all children
//	and the node itself is maximum.
//	In the sum, data of node itself and data of immediate children is to be taken.
//	Sample Input 1 :
//	5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
//	Sample Output 1 :
//	1

	// public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root ) {

	// Solution using queue O(N) extra space
//		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
//		pendingNodes.enqueue(root); // creating an queue for pending nodes
//									// and adding root to that
//		int maxSum = Integer.MIN_VALUE;
//		TreeNode<Integer> resNode = null;
//		
//		while (!pendingNodes.isEmpty()) {
//
//			try {
//				TreeNode<Integer> frontNode = pendingNodes.dequeue();
//				int Sum = frontNode.data;
//				for (int i = 0; i < frontNode.children.size(); i++) {
//					
//					Sum = Sum + frontNode.children.get(i).data;
//					pendingNodes.enqueue(frontNode.children.get(i));
//				}
//				if( Sum > maxSum ) {
//					maxSum = Sum;
//					resNode = frontNode;
//				}
//				
//			} catch (QueueEmptyException e) {
//				// should not come here
//				return null;
//			}
//		}
//		return resNode;

	// Using recursion
	// In this mathod we are calculating each nodes sum twice so using pair class
	// this ques can be solved efficiently.
//	        if (root == null) {
//				return null;
//			}
//			
//			TreeNode<Integer> resNode = root;
//			int sum = root.data;
//			for (int i = 0; i < root.children.size(); i++) {
//
//				sum = sum + root.children.get(i).data;
//			}
//			for (int i = 0; i < root.children.size(); i++) {
//
//				TreeNode<Integer> smallAns = maxSumNode( root.children.get(i));
//				int smallSum = smallAns.data;
//				for(int j = 0; j < smallAns.children.size(); j++ ) {
//					
//					smallSum = smallSum + smallAns.children.get(j).data;
//				}
//				if( smallSum > sum ) {
//					sum = smallSum;
//					resNode = smallAns;
//				}
//			}
//			return resNode;
//		}
//	
//	            //Best approach-- Using Pair class
//
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {

		if (root == null) {
			return null;
		}
		pair p = helper(root);
		return p.Node;
	}

	public static pair helper(TreeNode<Integer> root) {

		int Sum = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			Sum = Sum + root.children.get(i).data;
		}
		// First I created an pair having root and sum of root and its chindren's
		// data. Then called recursivly on every child of root.
		// fir jo answer aae unhe root wale pair k sum se compare kar diya agr
		// sum part bda nikla to anspair update else nhi.
		pair ansPair = new pair();
		ansPair.Node = root;
		ansPair.Sum = Sum;

		for (int i = 0; i < root.children.size(); i++) {
			pair smallAns = helper(root.children.get(i));
			if (smallAns.Sum > ansPair.Sum) {
				ansPair = smallAns;
			}
		}

		return ansPair;
	}

//=========================================================================================
	// Check If Two Given Trees Are Identical Or Not
	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {

		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.data != root2.data || root1.children.size() != root2.children.size()) {
			return false;
		}
		for (int i = 0; i < root1.children.size(); i++) {
			if (i > root2.children.size()) {
				return false;
			}
			boolean smallAns = checkIdentical(root1, root2);
			if (smallAns == false) {
				return false;
			}
		}
		return true;

	}
	// public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
	// String str1 = returnString( root1 );
	// String str2 = returnString( root2 );
	// return str1.equals(str2);
//     }
// public static String returnString(TreeNode<Integer> root) {

//		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
//		pendingNodes.add(root);
//		String str = "";
//		while (!pendingNodes.isEmpty()) {

//			TreeNode<Integer> node = pendingNodes.poll();
//			str = str + node.data;
//			for (int i = 0; i < node.children.size(); i++) {
//				pendingNodes.add(node.children.get(i));

//			}
//		}
//		return str;
//	}
//===============================================================================
//	Next larger element
//	Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.
//	Return NULL if no node is present with value greater than n.
//	Sample Input 1 :
//	18
//	10 3 20 30 40 2 40 50 0 0 0 0 
//	Sample Output 1 :
//	20
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		
		if( root == null ) {
			return null;
		}
		TreeNode<Integer> ans = null;
		//root data is larger thn n root ko ans bna dege else ans null rkhege thn
		//child p recursive call
		if ( n < root.data ) {
			ans = root;
		}
		else {
			ans = null;
		}

		for( int i = 0; i < root.children.size(); i++ ) {
			TreeNode<Integer> smallAns = findNextLargerNode( root.children.get(i), n);
			if( ans == null ) {
				ans = smallAns;
			}
			//agr smallAns ka data ans k data se kam h mtlb
			//smallAns n se just bda hto ans = smallAns
			if( smallAns != null && smallAns.data <= ans.data ) {
				ans = smallAns;
			}
		}
		return ans;
	}
//====================================================================================	
	
//	Second Largest Element In Tree
//	Given a generic tree, find and return the node 
//	with second largest value in given tree. 
//	Return NULL if no node with required value is present.
//	
//	10 3 20 30 40 2 40 50 0 0 0 0 
//	Sample Output 1 :
//	40
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
		
		if( root == null ) {
			return null;
		}
		minMax ans = helperToFindSecLargest(root);
		//System.out.println( ans.first.data + " " + ans.second.data );
		return ans.second;
		}

	 private static minMax helperToFindSecLargest(TreeNode<Integer> root) {

		minMax ans = new minMax();
		ans.first = root;
		ans.second = null;
		
		for( int i = 0; i < root.children.size(); i++ ) {
			minMax smallAns = helperToFindSecLargest( root.children.get(i) );
		
			if( ans.second == null && smallAns.second == null ) {
				if( ans.first.data < smallAns.first.data ) {
					ans.first = smallAns.first;
					ans.second = ans.first;
				}
				else {
					ans.second = smallAns.first;
				}
			}
			if( ans.second != null && smallAns.second != null ) {
				if( ans.first.data > smallAns.first.data ) {
					if( smallAns.first.data > ans.second.data) {
						ans.second = smallAns.first;
					}
				}
				else {
					ans.first = smallAns.first;
					if( ans.first.data > smallAns.second.data) {
						ans.second = ans.first;
					}
					else {
						ans.second = smallAns.second;
					}
				}
			}
			if( ans.second == null && smallAns.second != null ) {
				if( ans.first.data > smallAns.first.data ) {
						ans.second = smallAns.first;
				}
				else {
					ans.first = smallAns.first;
					if( ans.first.data > smallAns.second.data) {
						ans.second = ans.first;
					}
					else {
						ans.second = smallAns.second;
					}
				}	
			}	
			if( ans.second != null && smallAns.second == null ) {
				if( ans.first.data > smallAns.first.data ) {
					if( smallAns.first.data > ans.second.data) {
						ans.second = smallAns.first;
					}
				}
				else {
					ans.first = smallAns.first;
					ans.second = ans.first;
				}	
			}	
		}
		return ans;
		}
//==============================================================================	
	
//	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
//
//		if( root == null ) {
//			return null;
//		}
//		int largestElem = largestData1( root );
//		return findNextSmallerNode( root, largestElem );
//
//	}	
//
//	public static int largestData1(TreeNode<Integer> root) {
//
//		int max = root.data;
//		for (int i = 0; i < root.children.size(); i++) {
//
//			int data = largestData1(root.children.get(i));
//			if (data > max) {
//				max = data;
//			}
//		}
//		return max;
//	}
//		public static TreeNode<Integer> findNextSmallerNode(TreeNode<Integer> root, int n){
//			
//			if( root == null ) {
//				return null;
//			}
//			TreeNode<Integer> ans = null;
//			//root data is smaller thn n root ko ans bna dege else ans null rkhege thn
//			//child p recursive call
//			if ( n > root.data ) {
//				ans = root;
//			}
//			else {
//				ans = null;
//			}
//	
//			for( int i = 0; i < root.children.size(); i++ ) {
//				TreeNode<Integer> smallAns = findNextSmallerNode( root.children.get(i), n);
//				if( ans == null ) {
//					ans = smallAns;
//				}
//				//agr smallAns ka data ans k data se jyada h mtlb
//				//smallAns n se just chota h to ans = smallAns
//				if( smallAns != null && smallAns.data >= ans.data ) {
//					ans = smallAns;
//				}
//			}
//			return ans;
//		}
//====================================================================================

//	 Replace node with depth
//	 In a given Generic Tree, replace each node with its depth value. You need to just update the data of each node, no need to return or print anything.
//	 Sample Input 1 :
//	 10 3 20 30 40 2 40 50 0 0 0 0 
//	 Sample Output 1 : (Level wise, each level in new line)
//	 0 
//	 1 1 1 
//	 2 2
	 public static void replaceWithDepthValue(TreeNode<Integer> root){

		if( root == null ) {
			return;
		}
		helperForDepthValue( root, 0 );
	 }
	 public static void helperForDepthValue( TreeNode<Integer> root, int k ) {
		 
		root.data = k; 
		for( int i = 0; i < root.children.size(); i++ ) {
			helperForDepthValue( root.children.get(i), k+1 );
		}
	 }
}