//Implement queue using two stacks
package StackAndQueue;

import java.util.Stack;

public class QueueUsing2Stack {

	Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /* The method insert to push element into the queue */
    void insert(int B)
    {
	   // Your code here
	   while(! s1.isEmpty() ){
	       s2.push( s1.pop() );
	      
	   }
	    s1.push(B);
	    
	   while(! s2.isEmpty() ){
	       s1.push( s2.pop() );
	      
	   }
    }
    
    /* The method remove which return the  element popped out of the queue*/
    int remove()
    {
	   if(!s1.isEmpty()){
	     return s1.pop();
	   }
	   else
	   return -1;
    }
}