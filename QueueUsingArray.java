package StackAndQueue;

public class QueueUsingArray {

	private int[] data;
	private int front;    // to store index of front element
	private int rear;     // to store index of rear element
	private int size;
	
	public QueueUsingArray() {
		data = new int[10];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public QueueUsingArray( int capacity) {
		data = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	int size() {    //time complexity-->O(1)
		return size;
	}
	
	boolean isEmpty() {       //time complexity-->O(1)
		return ( size == 0 );
	}
	
	int front() throws QueueEmptyException {       //time complexity-->O(1)
		if( size() == 0 ) {
			//throw QueueEmptyException
			throw ( new QueueEmptyException() );
		}
		return data[front];
	}
	
	void enqueue( int element ) throws QueueFullException {     //time complexity-->O(1)
	  if( size() == data.length ) {

		 // throw ( new QueueFullException() );
		  doubleCapacity();
	  }
	  if( size() == 0 ) {
		  front = 0;
	  }
	    size++;
	    rear = ( rear + 1 ) % data.length;  // it is making queue circular annd preventing error
//		rear++;
//		if( rear == data.length ) {
//			rear = 0;
//		}
		data[rear] = element;
		
	}
	
	private void doubleCapacity() {

		int[] temp = data;
		data = new int[ 2*temp.length ];
		int index = 0;
		for( int i = front; i < temp.length; i++ ) {
			data[ index ] = temp[i];
			index++;
		}
		for( int  i = 0; i <= front-1; i++ ) {
			data[ index ] = temp[i];
			index++;
		}
		front = 0;
		rear = temp.length-1;
		
	}

	int dequeue() throws QueueEmptyException  {       //time complexity-->O(1)
		 if( size() == 0 ) {
			 throw ( new QueueEmptyException() );
		 }
			int temp = data[front];
			front = ( front + 1 ) % data.length;
//			front++;
//			if( front == data.length ) {
//				front = 0;
//			}
			size--;
			if( size == 0) {
				front = -1;
				rear = -1;
			}
			return temp;
		}
}