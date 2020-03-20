//Implement a stack using single queue
package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

//public static void main(String[] args)  
//{ 
//    stack s = new stack(); 
//    s.push(10); 
//    s.push(20); 
//    System.out.println("Top element :" + s.top()); 
//    s.pop(); 
//    s.push(30); 
//    s.pop(); 
//    System.out.println("Top element :" + s.top()); 
//} 
class StackUsingSingleQueue {

	Queue<Integer> q = new LinkedList<Integer>();
	
	void push(int val) {          //to push new element first save the size and 
		int size = q.size();      //add the element at rear end 
		                          //then remove and add all elements before rear element
        q.add( val );
        for( int i = 0; i < size; i++ ) {
        	int temp = q.remove();
        	q.add( temp );
        }
	}
	// Removes the top element
	int pop() {
         if(! isEmpty() ) {
        	 return q.remove();
         }
         else {
        	 return -1;
         }
	}

	// Returns top of stack
	int top() {
       if(! isEmpty() ) {
    	   return q.peek();
       }
       else {
    	   return -1;
       }
	}

	// Returns true if Stack is empty else false
	boolean isEmpty() {

		if( q.size() == 0 ) {
			return true;
		}else {
			return false;
		}
	}
}