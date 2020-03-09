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
}