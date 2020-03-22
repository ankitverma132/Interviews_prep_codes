//Add 1 to a number represented as linked list
//Number is represented in linked list such that each digit
//corresponds to a node in linked list. Add 1 to it. 
//For example 1999 is represented as (1-> 9-> 9 -> 9)
//and adding 1 to it should change it to (2->0->0->0)
//Below are the steps :
//
//Reverse given linked list. For example, 1-> 9-> 9 -> 9 is converted to 9-> 9 -> 9 ->1.
//Start traversing linked list from leftmost node and add 1 to it. If there is a carry, move to the next node. Keep moving to the next node while there is a carry.
//Reverse modified linked list and return head.

package LinkedList;

public class AddOneToNumber {

	public static void main(String[] args) {

		Node<Integer> head = newNode(9);  
	    head.next = newNode(9);  
	    head.next.next = newNode(9);  
	    head.next.next.next = newNode(9);  
	  
	    System.out.print("List is ");  
	    printList(head);  
	  
	    head = addOne(head);  
	    System.out.println(); 
	    System.out.print("Resultant list is ");  
	    printList(head);  
	}
	
	// A utility function to print a linked list  
	static void printList(Node<Integer> node)  
	{  
	    while (node != null)  
	    {  
	        System.out.print(node.data);  
	        node = node.next;  
	    }  
	    System.out.println();  
	}  
	
	static Node<Integer> addOne(Node<Integer> head)  
	{  
	    
	    head = reverse(head);     // Reverse linked list  
	  
	    head = addOneUtil(head);  	    // Add one from left to right of reversed list 
	  
	    return reverse(head);        // Reverse the modified list
	} 
	
	static Node<Integer> reverse(Node<Integer> head)  
	{  
		Node<Integer> prev = null;  
		Node<Integer> current = head;  
		Node<Integer> next = null;  
	    while (current != null)  
	    {  
	        next = current.next;  
	        current.next = prev;  
	        prev = current;  
	        current = next;  
	    }  
	    return prev;  
	}  
	
	/* Adds one to a linked lists and return the head node of resultant list */
	
	static Node<Integer> addOneUtil(Node<Integer> head)  
	{  
	    // res is head node of the resultant list  
		Node<Integer> res = head;  
		Node<Integer> temp = null;  
	  
	    int carry = 1, sum;  
	  
	    while (head != null)             //while list exist  
	    {  
	
	        sum = carry + head.data;    //calculating sum using head data and previous carry
	  
	        carry = sum / 10;           //carry for next calulation
	        head.data = sum % 10;      // Update data at head  
	         
	        temp = head;             // Move head and second pointers to next nodes 
	        head = head.next;  
	    }  
	  
	    if (carry > 0)   // if some carry is still there, add a new node to result list.
	        temp.next = newNode(carry);  
	  
	    // return head of the resultant list  
	    return res;  
	}  
	
	static Node<Integer> newNode(int data)  
	{  
		Node<Integer> new_node = new Node<Integer>(data);  
	    new_node.next = null;  
	    return new_node;  
	}  
}