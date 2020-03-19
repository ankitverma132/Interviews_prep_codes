package StackAndQueue;

public class QueueUsingLL<T> {

	private Node<T> front;
	private Node<T> rear;
	int size;

	public QueueUsingLL() {
			front = null;
			rear = null;
			size = 0;
	}
	int size() {        //time complexity--->O(1)
		return size;
	}
	
	boolean isEmpty() {                 //time complexity--->O(1)
		return ( size == 0 );
		
	}
	
	T front() throws QueueEmptyException {             //time complexity--->O(1)
		if( size == 0 ) {
			throw (new QueueEmptyException() );
			
		}
		return front.data;
	}
	
	void enqueue( T element ) {               //time complexity--->O(1)
		
		Node<T> newNode = new Node<>( element );
		if( size() == 0 ) {
			rear =newNode;
			front = newNode;
			size++;
			return;
		}
		rear.next = newNode;
		rear = newNode;
		size++;
		
	}
	
	T dequeue() throws QueueEmptyException {         //time complexity--->O(1)
		
		if( size() == 0 ) {
			throw ( new QueueEmptyException() );
		}
		
		T temp = front.data;
		front = front.next;
		if( size() == 1 ) {    //when size is going to be zero 
			rear = null;       //we have to explicitly set rear to null
		}
		size--;
		return temp;
	}
}

