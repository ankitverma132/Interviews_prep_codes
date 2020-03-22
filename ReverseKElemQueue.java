//Reversing the first K elements of a Queue
//Given an integer k and a queue of integers, we need to reverse the 
//order of the first k elements of the queue, 
//leaving the other elements in the same relative order.
//Input : Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
//        k = 5
//Output : Q = [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]
package StackAndQueue;
import java.util.Stack;

public class ReverseKElemQueue {

	public static void main(String[] args) throws QueueEmptyException, QueueFullException {

		QueueUsingArray queue = new QueueUsingArray(3);
		
		for( int i = 1; i <= 10; i++) {
			try {
				queue.enqueue( i*10 );
			}catch( QueueFullException e ) {
				
			}
		}
		reverseKQueue(queue, 5 );

		while (!queue.isEmpty()) {
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {

			}
		}
	}

	private static void reverseKQueue(QueueUsingArray queue, int k ) throws QueueEmptyException, QueueFullException {

		Stack<Integer> s = new Stack<>();
		
		for( int i = 0; i < k; i++ ) {
			s.push( queue.dequeue() );
		}
		
		while(! s.isEmpty() ) {
			queue.enqueue( s.pop() );
		}
		
		for( int i = 0; i  < queue.size() - k ; i++ ) {
			queue.enqueue ( queue.dequeue() );
		}
	}
}	