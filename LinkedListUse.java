package LinkedList;

import java.util.Scanner;

public class LinkedListUse {

	public static void main(String[] args) {

		
//		Node<Integer> Node1 = new Node<Integer>(10);
//		System.out.println( Node1.data );
//		System.out.println( Node1.next );
//		
//		Node<Integer> Node2 = new Node<Integer>(20);
//		System.out.println( Node2.data );
//		System.out.println( Node2.next );
//		
//		Node1.next = Node2;
//		
//		System.out.println( Node2 );
//		System.out.println( Node1.next );
		
		Node<Integer> Node1 = new Node<Integer>(10);
		Node<Integer> Node2 = new Node<Integer>(20);
		Node<Integer> Node3 = new Node<Integer>(30);  //Making three nodes with data
		Node1.next = Node2;
		Node2.next = Node3;  //Linking all nodes, last node is pointing to null
		
		Node<Integer> head = Node1;   //as first node is head which will be pointed by both node1 and head
		print(head);
		print(head);
//		while( head != null ) {
//			System.out.println( head.data );
//			head = head.next;
//		}
		
	}
	public static void print(Node<Integer> head) {
		while( head != null ) {            
			System.out.println( head.data );  //printing data of nodes
			head = head.next;     //moving head ahead 
		}
	}
	public static Node<Integer> takeInput(){
		
//		Node<Integer> head = null;    //creating head which is pointing to head for now  //Time Complexity--->O(n^2)
//		Scanner s = new Scanner(System.in);
//		
//		int data = s.nextInt();
//		
//		while( data != -1 ) {   //taking input until -1 is proviided
//			
//			Node<Integer> newNode = new Node<Integer>(data);  // creating a node
//			
//			if(head == null) {
//				head = newNode;    //Assigning first node to head
//			}
//			else {
//				Node<Integer> temp = head;
//				while( temp.next != null ) {
//					temp = temp.next;
//				}
//				temp.next = newNode;   //adding newNode at last of list by checking null in next field
//					
//			}
//			data = s.nextInt();  // again taking input
//		}
//		return head;
//=========================================================================================================================
		//Now maintaing an tail node to improve time complexity
		
		Node<Integer> head = null, tail = null;    //creating head which is pointing to head for now  //Time Complexity--->O(n^2)
		Scanner s = new Scanner(System.in);        //Time Complexity--->O(n)
		
		int data = s.nextInt();
		
		while( data != -1 ) {   //taking input until -1 is proviided
			
			Node<Integer> newNode = new Node<Integer>(data);  // creating a node
			
			if(head == null) {
				head = newNode;    //Assigning first node to head
				tail = newNode;   //Assigning first node to tail
			}
			else {
				tail.next = newNode;
				tail = tail.next;  //or tail = newNode
					
			}
			data = s.nextInt();  // again taking input
		}
		return head;
	}
	    public static int length(Node<Integer> head){
		
        int length = 0;
        while( head != null ){
            length ++;
            head = head.next;
        }
        return length;

	}
//=========================================================================================================
    public static void printIth(Node<Integer> head, int i){  //time compkexity-->O(n)
		
        int count = 0;
        while( count < i && head !=null  ){
            count ++;
            head = head.next;
        }
        if(head == null){
            System.out.println(  );
        }
        else{
            System.out.println( head.data );
        }
	}
//==========================================================================================================
    public static Node<Integer> insert( Node<Integer> head, int pos, int data) {
    	
    	Node<Integer> newNode = new Node<>(data);
    	if( pos==0 ) {     //handling zero case
    		newNode.next = head;
    		head = newNode;
    		return head;   //adding return statement as there would be problem in case of pos being 0 as head will change
    	}
    	int i = 0;
    	Node<Integer> temp = head;
    	while( i < pos-1 ) {     //traversing to the position-1 as there you need to insert element
    		i++;
    		temp = temp.next;
    	}
       //Node<Integer> temp2 = temp.next;
       newNode.next = temp.next		;
       temp.next = newNode;
       return head;
    }    
//========================================================================================================= 
    public static Node<Integer> deleteIthNode( Node<Integer> head, int i ){
        
        Node<Integer> temp = head;        
        
        if( i==0 ) {                      //handling zero position case  
            head = head.next;
            return head;
        }
        
        int pos = 0;
        while( pos<i-1 && temp!=null ){
            pos++;
            temp = temp.next;            
        }
        
        if( temp == null ){
            return head;
        }
        else{
            if( temp.next == null ){     //Handling case when suppose there are 3 nodes 
                return head;             //i.e. index 0 to 2 an u try to delete 3 index node
            }
            else{
                temp.next = temp.next.next;
                return head; 
            }
        }      
	}
//============================================================================================================
   //Given a linked list and an integer n you need to find and return index
    //where n is present in the LL. Do this iteratively.
    public static int indexOfNIter( Node<Integer> head, int n ) {
		
        Node<Integer> temp = head;
        int pos = 0;
        
        while( temp != null && temp.data != n){
            pos++;
            temp = temp.next;
        }
        if( temp == null ){
            return -1;
        }
        else{
            return pos;
        }
	}
//==============================================================================================================
    //Rotate a Linked List
	public Node<Integer> rotate(Node<Integer> head, int k) {

		Node<Integer> temp = head;

		while (temp != null) {
			if (temp.next == null) {
				temp.next = head;
				break;
			}
			temp = temp.next;
		}
		temp = head;
		int i = 1;
		while (i < k) {
			temp = temp.next;
			i++;
		}
		head = temp.next;
		temp.next = null;
		return head;
	}
    
//==========================================================================================================
    //Given a linked list and an integer n, append the last n elements of the LL to front. 
    // 1 2 3 4 5 -1
    // 3
    //output->3 4 5 1 2
    public static Node<Integer> append( Node<Integer> root, int n ) {        
        
        Node<Integer> temp = root;
        if(n==0){                 //if n is 0 just return original linked list 
            return root;
        }
        
        int num = 0;
        while( temp != null ){           //Now iterate through the LL and get the total num of elements 
            if( temp.next == null ){     //and give adrs of first node to last node which will make an circular LL
                 temp.next = root;
                 num++;
                 break;
            }
           num++;
           temp = temp.next;           
        }        
     
        temp = root;
        int pos = num-n;      // getting position to append
        num = 0;
        while( num < pos-1 ){   
            num++;
            temp = temp.next;
        }
        
        root = temp.next;     //makeing new head
        temp.next = null;     //making new last element
        
        return root;
    }     
//===================================================================================================================
//    Print a given linked list in reverse order. You need to print the tail first and head last.
//    You can’t change any pointer in the linked list, just print it in reverse order.
    
    public class Solution {
    	public void printReverseRecursive(Node<Integer> root) {        
            
            if( root.next == null ){           //Time complexity-->O(n)
               System.out.print( root.getData() + " ");  
                 return;
            }       

            printReverseRecursive( root.next );
            System.out.print( root.getData() + " ");
      
        }
    }
//====================================================================================================================         
  
//    Given a sorted linked list (elements are sorted in ascending order).
//    Eliminate duplicates from the given LL, such that output LL contains only unique elements.
//    1 2 3 3 3 4 4 5 5 5 7 -1
//    1 2 3 4 5 7
     public Node<Integer> removeDuplicates(Node<Integer> head) {  
        
        if( head == null || head.next == null ){
            return head;
        }       
        
       Node<Integer> i = head;      //point to first node of LL
       Node<Integer> j = head.next;  //point to second node of LL

       while(  j != null ){
         
    	   if(! i.getData().equals( j.getData())){
            
             i.next = j;        //connecting two non-equal nodes
             i = i.next;        //moving i and j forward
             j = j.next;             
         }
    	   if( i.getData().equals( j.getData())){             
             j = j.next;                     
         }   
     } 
        i.next = j;
        return head;
     }
//=========================================================================================================    
    // Check if a given linked list is palindrome or not. Return true or false.
       
     public static boolean isPalindrome_2(Node<Integer> head) {
         if(head == null || head.next == null)
         {
             return true;
         }
         
            Node<Integer> fast = head;          // to get the mid point of the list slow will be at mid
            Node<Integer> slow = head;
            while(fast.next != null && fast.next.next != null)
            {
                fast = fast.next.next;
                slow = slow.next;
            }
            
            Node<Integer> secondHead = slow.next;
            slow.next = null;                             //breaking list into two parts
            secondHead = reverse_I(secondHead);
            Node<Integer> p = secondHead;
            Node<Integer> q = head;
            while(p != null)
            {
                if(p.data != q.data)
                {
                    return false;
                }
                p = p.next;
                q = q.next;
            }
            return true;
        }
     
        private static Node<Integer> reverse_I(Node<Integer> head){
            Node<Integer> curr = head;
            Node<Integer> prev = null;
            Node<Integer> fwd = null;
            
            while(curr != null)
            {
                fwd = curr.next;
                curr.next = prev;
                prev = curr;
                curr = fwd;
            }
            return prev;
        }
 //=====================================================================================================
//        Given a linked list, find and return the midpoint.
//       If the length of linked list is even, return the first mid point.
        public static int printMiddel( Node<Integer> head ) {
            
            if(head.next==null){
                return head.getData();
            }
            
           Node<Integer> slow = head;
           Node<Integer> fast = head;
            
            while( fast.next != null && fast.next.next!=null ){

                    slow = slow.next;
                    fast = fast.next.next;           
                
            }
            return slow.getData();   
        }
        
//=========================================================================================================     
//     Given two linked lists sorted in increasing order. Merge them in such a way that
//     the result list is also sorted (in increasing order).
//     Try solving with O(1) auxiliary space (in-place). You just need to return
//    the head of new linked list, don't print the elements. 
//     
//     2 5 8 12 -1
//     3 6 9 -1
//     2 3 5 6 8 9 12 
     
 	public static Node<Integer> mergeTwoList( Node<Integer> head1, Node<Integer> head2) {   //time complexity--->O(n)
		if (head1 == null) 
            return head2; 
        if (head2 == null) 
            return head1; 
        
	     Node<Integer> t1 = head1;
         Node<Integer> t2 = head2;	
        
         Node<Integer> H3 = head1;
         Node<Integer> T3 = head1;
         
        
        if( t1.data < t2.data ){   
            H3 = t1;
            T3 = t1;
            t1 = t1.next;
        }
        else{
            H3 = t2;
            T3 = t2;
            t2 = t2.next;
        }
        
        while( t1 != null && t2 != null ){
            
            if( t1.data <= t2.data ){
                T3.next = t1;
                 T3 = t1;
                t1 = t1.next;
              
            }
            else if( t1.data > t2.data ){
                T3.next = t2;
                T3 = t2;
                t2 = t2.next;
                
            }
        }
        if( t1 == null ){
           T3.next = t2; 
        }
        else{
           T3.next = t1; 
        }
        
        return H3;
	}  
 	
 //=========================================================================================
 	//Sort a given linked list using Merge Sort.
 	public static Node<Integer> mergeSort(Node<Integer> head) {  //time Complexity->O(nlogn)
		// write your code here
         if( head == null || head.next == null){
            
            return head;
           }
        
         Node<Integer> slow = head;
         Node<Integer> fast = head;
        
         while( fast.next != null && fast.next.next!=null ){

                slow = slow.next;
               fast = fast.next.next;                  
           }
         Node<Integer> secondHead = slow.next;   //head of second half of LL
         slow.next = null;
        
         Node<Integer> sortHead =  mergeSort( head );
         Node<Integer> sortSecondHead =  mergeSort( secondHead );
         return mergetwoList( sortHead, sortSecondHead );
              
	}
    
    public static Node<Integer> mergetwoList(Node<Integer> head1, Node<Integer> head2) {
		if (head1 == null) 
            return head2; 
        if (head2 == null) 
            return head1; 
        
	     Node<Integer> t1 = head1;
         Node<Integer> t2 = head2;	
        
         Node<Integer> H3 = head1;
         Node<Integer> T3 = head1;
         
        
        if( t1.data < t2.data ){   
            H3 = t1;
            T3 = t1;
            t1 = t1.next;
        }
        else{
            H3 = t2;
            T3 = t2;
            t2 = t2.next;
        }
        
        while( t1 != null && t2 != null ){
            
            if( t1.data <= t2.data ){
                T3.next = t1;
                 T3 = t1;
                t1 = t1.next;
              
            }
            else if( t1.data > t2.data ){
                T3.next = t2;
                T3 = t2;
                t2 = t2.next;
                
            }
        }
        if( t1 == null ){
           T3.next = t2; 
        }
        else{
           T3.next = t1; 
        }
        
        return H3;
	}
 //========================================================================================= 
 	//Reverse a LL recursively
 	
 	public static Node<Integer> reverse_R(Node<Integer> head) {   //time complexity O(n^2)
        
       if( head.next == null || head == null ) {
    	   return head;
       }
 		
 		Node<Integer> finalHead = reverse_R( head.next );
 		Node<Integer> temp = finalHead;
 		
 		while( temp.next != null ) {
 			temp = temp.next;
 		}
 		temp.next = head;
 		head.next = null;
 		
 		return finalHead;		
 		
	}
 //==========================================================================================	
 	
 	//Reverse a LL recursively double node
 	
 	public static DoubleNodeClass reverseDouble( Node<Integer> head) {
 		
 		if( head == null || head.next==null ) {      //time complexity--->O(n)
 			
 			DoubleNodeClass ans = new DoubleNodeClass();   //defined in starting 
 			ans.head = head;                              //this is how we can return two values from a function
 			ans.tail = head;
 			return ans;
 		}
 		
 		DoubleNodeClass smallAns = reverseDouble( head.next );
 		smallAns.tail.next = head;
 		head.next = null;
 		
 		DoubleNodeClass ans = new DoubleNodeClass();
			ans.head = smallAns.head;
			ans.tail = head;
			return ans;
 	}
 	

 //========================================================================================

 	//Reverse a LL with tail without double node
 	
 	public static Node<Integer> reverse_T(Node<Integer> head) {   //time complexity O(n^2)
        
        if( head.next == null || head == null ) {
     	   return head;
        }
        
        Node<Integer> revTail = head.next; 
  		Node<Integer> finalHead = reverse_R( head.next );
  		
  		revTail.next = head;
  		head.next = null;
  		
  		
  		return finalHead;		
  		
 	}
//========================================================================================== 	
 	//Reverse a LL Iteratively
 	
 	public static Node<Integer> reverse_It(Node<Integer> head) {
        
        Node<Integer> prev = null;  
        Node<Integer> curr = head;
        Node<Integer> temp;
       
       while( curr != null){
                      
           temp  = curr.next;
           curr.next = prev;
           prev = curr;
           curr = temp;            
       }
        head = prev;   
        return head;
	}
 //=====================================================================================	
 	
 	//Insert recursively
 	
 	public static Node<Integer> insertRec( Node<Integer> head, int pos, int elem ) {    //time complexity-->O(n)
 		
 		if( pos == 0 ) {
 			Node<Integer> newNode = new Node<>(elem);
 			newNode.next = head;
 			return newNode;
 		}
 		if( head == null ) {
 			return head;
 		}
 		
 		head.next = insertRec( head.next, pos-1,  elem );
 		return head;
 	}
 //======================================================================================	
 	//Insert recursively
    public static Node<Integer> deleteRec( Node<Integer> head, int pos ) {
    	
    	if( head == null ) {                   //time complexity-->O(n)
 			return head;
 		}
 		if( pos == 0 ) {
 			return head.next;
 		}
 				
 		head.next = deleteRec( head.next, pos-1 );
 		return head;
 	}
 //======================================================================================
//    Given a linked list and an integer n you need to find and 
//    return index where n is present in the LL. Do this recursively.
//    		Return -1 if n is not present in the LL.

    public static int indexOfNRec(Node<Integer> head, int n) {
        
		int i = 0;
        return helper( head, n, i );    
	}
    
     public static int helper( Node<Integer> head, int n, int i ) {
        
         if( head==null ){
            return -1;
         }
         if( head.data == n ){
            return i;
         }

        int smallAns = helper(  head.next, n, i+1 );
        if( smallAns != -1 ){
            return smallAns;
        }
        if( head.data == n ){
           return i;
        }
        else{
            return -1;
        }       
    }
 //==============================================================================================
//     Arrange elements in a given Linked List such that, all even numbers are placed after odd numbers.
//     Respective order of elements should remain same.
//     1 4 5 2 -1
//     1 5 4 2
	public static Node<Integer> sortEvenOdd(Node<Integer> head) {
        
        if( head == null || head.next == null ){
            return head;
        }

        
        Node<Integer> oddH = null;
        Node<Integer> oddT = null;
        Node<Integer> evenH = null;
        Node<Integer> evenT = null;
        
        while( head!=null ){
            
            if( head.data %2 != 0 ){
                
                if( oddH == null ){
                   oddH = head;
                   oddT = head;
                   head = head.next;                  
                }
                else{
                   oddT.next = head;
                   oddT = oddT.next;
                   head = head.next;
                    
                }                
            }
            else{
                
                if(evenH==null){
                    evenH = head;
                    evenT = head;
                    head = head.next; 
                    
                }
                else{
                   evenT.next = head;
                   evenT = evenT.next;
                   head = head.next;
                    
                }
            }   
        }
        if( oddH == null ){
           return evenH; 
        }
        if(evenH==null){
           return oddH; 
        }
        else{
        oddT.next = null;
        evenT.next = null;
        oddT.next = evenH;
        return oddH;
        }

	}
//=================================================================================================
//	Given a linked list and two integers M and N. Traverse the linked list such that 
//	you retain M nodes then delete next N nodes, continue the same until end of the linked list. 
//	That is, in the given linked list you need to delete N nodes after every M nodes.
//	1 2 3 4 5 6 7 8 -1
//	2
//	3
//	1 2 6 7
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        
        if( M==0 ){
            head = null;
            return head;
        }
        
        if( head == null || head.next == null ){
            return head;
        }
        
       Node<Integer> temp = head;
       Node<Integer> temp2 = head;
        int count1 = 1;
        int count2 = 1;
        
        while( temp != null && temp2 != null ){   //time Complexity-->O(n)
          
              while( count1 < M && temp != null ){               
                temp = temp.next;               
                count1++;       
               }
                  if( temp == null ){
                      break;
                   }
                  else if( count1 == M ){
                     temp2 = temp.next;
                     count1 = 1;
                   }
            
              while( count2 < N && temp2 != null ){
                 temp2 = temp2.next; 
                 count2++;
               }
                  if( temp2 == null ){
                     temp.next = temp2;
                   }  
                  else if( count2 == N  ){
                     temp2 = temp2.next;
                     temp.next = temp2;
                     temp = temp.next;
                     count2 = 1;                
                   }  
        }
        return head;
	}
//=====================================================================================
//	Given a linked list, i & j, swap the nodes that are present at i & j position in the LL. 
//	You need to swap the entire nodes, not just the data.
	public static  Node<Integer> swap_nodes(Node<Integer> head,int i,int j){
        
        if( head == null || head.next == null ){
            return head;
        }    
        if( i == j ){
            head = null;
            return head;
        }
        
        Node<Integer> prev1 = null;
        Node<Integer> curr1 = head;
        Node<Integer> prev2 = null;
        Node<Integer> curr2 = head;
        Node<Integer> temp = head;
        
        
        int pos = 0;
        while( temp != null ){
            
            if( pos == i-1){
               prev1 = temp; 
            }
            if( pos == j-1 ){
               prev2 = temp; 
            }
            if( pos == i ){
                curr1 = temp;
            }
            if( pos == j ){
                curr2 = temp;  
            }
            pos++;
            temp = temp.next;            
        }
        
        if( (curr1 == prev2 || curr2 == prev1) && (prev1 == null || prev2 == null)){
            if( prev1 == null){
              curr1.next = curr2.next; 
              curr2.next = curr1;
              head = curr2;
                
          }  
          else{
              curr2.next = curr1.next; 
              curr1.next = curr2;
              head = curr1; 
              
          }
        }
        
         else if( curr1 == prev2 || curr2 == prev1 ){
             if( curr1 == prev2 ){                
                 prev1.next = curr2;
                 curr1.next = curr2.next;
                 curr2.next = curr1;
                  
             }
              if( curr2 == prev1 ){
                 prev2.next = curr1;
                 curr2.next = curr1.next;
                 curr1.next = curr2;
                  
             }
        }
        
        else if( prev1 == null || prev2 == null ){
          if( prev1 == null){
              temp = curr2.next;
              head = curr2;
              curr2.next = curr1.next;
              prev2.next = curr1;
              curr1.next = temp;  
          }  
          else{
              temp = curr1.next;
              head = curr1;
              curr1.next = curr2.next;
              prev1.next = curr2;
              curr2.next = temp;  
          }  
        }
    
        else{
              temp = curr2.next;
              prev1.next = curr2;
              curr2.next = curr1.next;
              prev2.next = curr1;
              curr1.next = temp;
        }
       return head;
	}

//		if (head == null || head.next == null) {
//			return head;
//		}
//		if (i == j) {
//			head = null;
//			return head;
//		}
//
//		Node<Integer> prev1 = null;
//		Node<Integer> curr1 = null;
//		Node<Integer> prev2 = null;
//		Node<Integer> curr2 = null;
//		Node<Integer> temp = head;		
//		Node<Integer> prev = null;
//		
//		int pos = 0;
//		while( temp != null) {
//			if( pos == i) {
//				prev1 = prev;
//				curr1 = temp;
//			}
//			else if( pos == j ) {
//				prev2 = prev;
//				curr2 = temp;
//			}
//			prev = temp;
//			temp = temp.next;
//		}
//		
//		if( curr1 != head ) {
//			prev1.next = curr2;
//		}
//		else {
//			head = curr2;
//		}
//		
//		if( curr2 != head ) {
//			prev2.next = curr1;
//		}
//		else {
//			head = curr1;
//		}
//		
//		Node<Integer> temp2 = curr2.next;
//        curr2.next = curr1.next;
//        curr1.next = temp2;
//        
//        return head;
//		
		
//=====================================================================================================
    
//    Sort a given linked list using Bubble Sort (iteratively).
//    While sorting, you need to swap the entire nodes, not just the data.   
//    1 4 5 2 -1
//    1 2 4 5  
    
	public static Node<Integer> bubbleSort(Node<Integer> head )
	{
        if( head == null || head.next == null ){
            return head;
        }
       
        int length = lengthAgain( head );
        
        for( int pos = 0; pos <= length-1; pos++){
            
           Node<Integer> prev = null; 
           Node<Integer> curr = head; 
           Node<Integer> nxt = curr.next;
            
           while( nxt != null ){               
                if( curr.data > nxt.data ){
                    if( prev != null){ 
                       prev.next = nxt;
                       curr.next = nxt.next;
                       nxt.next = curr;
                       prev = prev.next;
                       nxt = curr.next;
    
                    }
                    else{ 
                      curr.next = nxt.next;
                      nxt.next = curr;
                       prev = nxt;
                       nxt = curr.next;
                       head = prev;                      
                    }
                }
                else{
                   prev = curr;
                   curr = curr.next;
                   nxt = nxt.next;                                    
                }           
            }  
        }
        return head;
	}
    
    public static int lengthAgain( Node<Integer> head ){
		
        int length = 0;
        while( head != null ){
            length ++;
            head = head.next;
        }
        return length;
	}
    
//========================================================================================   
//    
//    kReverse
//    Send Feedback
//    Implement kReverse( int k ) in a linked list i.e. you need to reverse first K elements 
//    then reverse next k elements and join the linked list and so on.
//    Indexing starts from 0. If less than k elements left in the last, you need to reverse them as well. 
//  If k is greater than length of LL, reverse the complete LL.
//    You don't need to print the elements, just return the head of updated LL.
//
//    Sample Input 1 :
//    1 2 3 4 5 6 7 8 9 10 -1
//    4
//    Sample Output 1 :
//    4 3 2 1 8 7 6 5 10 9
    public static Node<Integer> kReverse(Node<Integer> head, int k) {
        
        Node<Integer> current = head; 
        Node<Integer> next = null; 
        Node<Integer> prev = null; 
          
        int count = 0; 
   
        /* Reverse first k nodes of linked list */
        while (count < k && current != null)  
        { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
            count++; 
        } 
   
        /* next is now a pointer to (k+1)th node  
           Recursively call for the list starting from current. 
           And make rest of the list as next of first node */
        if (next != null)  
           head.next = kReverse(next, k); 
   
        // prev is now head of input list 
        return prev; 
     }
//===========================================================================================================
//    Detect loop in a linked list
//    Given a linked list, check if the linked list has loop or not. Below diagram shows a linked list with a loop.
    
    public static boolean detectLoop( Node<Integer> head ) {   //timme complexity--->O(n)
    
    
    	Node<Integer> slow = head;
    	Node<Integer> fast = head;
    
    
        while( fast != null && fast.next != null ) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if( slow == fast ) {
        		return true;
        	}
        }
    
       return false;
    }
    
//============================================================================================================ 
   // Detect and Remove Loop in a Linked List
 
    int detectAndRemoveLoop(Node<Integer> head)     // Function that detects loop in the list 
    { 
        Node<Integer> slow = head, fast = head; 
        while (slow != null && fast != null && fast.next != null) { 
        	
            slow = slow.next; 
            fast = fast.next.next; 
            
            if (slow == fast) {            // If slow and fast meet at same point then loop is present 
                removeLoop( slow, head ); 
                return 1; 
            } 
        } 
        return 0; 
    } 
  
    void removeLoop( Node<Integer> loop, Node<Integer> head )    // Function to remove loop 
    { 
        Node<Integer> ptr1 = loop; 
        Node<Integer> ptr2 = loop; 
  
        int k = 1, i;                // Count the number of nodes in loop 
        while (ptr1.next != ptr2) { 
            ptr1 = ptr1.next; 
            k++; 
        } 
         
        ptr1 = head;                 // Fix one pointer to head
        ptr2 = head;    
        for (i = 0; i < k; i++) {    // And the other pointer to k nodes after head  
            ptr2 = ptr2.next; 
        } 
  
        while (ptr2 != ptr1) {      //Move both pointers at the same pace, they will meet at loop starting node
            ptr1 = ptr1.next; 
            ptr2 = ptr2.next; 
        } 
       
        while (ptr2.next != ptr1) {   // Get pointer to the last node 
            ptr2 = ptr2.next; 
        } 
  
        ptr2.next = null;            //Set the next node of the loop ending node to fix the loop
    } 
  //=======================================================================================
//    Delete Middle of Linked List
    Node<Integer> Delete(Node<Integer> head) {
        
    	Node<Integer> prev = null;
    	Node<Integer> slow = head;
    	Node<Integer> fast = head;
        
        while( fast != null && fast.next != null ){
            
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
//=========================================================================================
    
    //Nth node from end of linked list
    int getNthFromLast(Node<Integer> head, int n)
    {
    	Node<Integer> temp = head;
    	int length = 0;
    	
    	while( temp != null){
    	    temp = temp.next;
    	    length++;
    	}
    	if( length < n ){
    	    return -1;
    	}
    	int k = length - n + 1;
    	
    	temp = head;
    	int i = 1;
    	while( i < k ){
    	    
    	    temp = temp.next;
    	    i++;
    	    
    	}
    	return temp.data;
    }
//==========================================================================================    
   //Delete last occurrence of an item from linked list
    
    Node<Integer> deleteLast(Node<Integer> head, int key) {
    	
    	Node<Integer> curr = head;
    	Node<Integer> prev = null;
    	
    	Node<Integer> ptr1 = null;
    	Node<Integer> ptr2 = null;
    	
    	
    	while( curr != null ) {
    		if( curr.data == key ) {
    			ptr1 = prev;
    			ptr2 = curr;
    		}
    		prev = curr;
    		curr = curr.next;
    	}
    	if( ptr1 == null) {
    		head = ptr2.next;
    	}else {
    		ptr1.next = ptr2.next;
    	}
    	return head;
    }
//========================================================================================================== 
}
