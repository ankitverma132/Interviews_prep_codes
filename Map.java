package Maps;
import java.util.ArrayList;

public class Map< K, V > {
	
	ArrayList< MapNode< K, V> > buckets;
	int size;      //number of entries
	int numBuckets;  //number of buckets
	
	public Map() {
		//take 20 sized bucket arraylist initially which will have 20 buckets
		numBuckets = 20; 
		buckets = new ArrayList<>();
		for( int i = 0; i < 20; i++ ) {
			buckets.add(null);     //intially sare buckets null ko point krege
		}
	}
	
	//it will give index for key i.e. it will have hash function
	private int getBucketIndex( K key ) {
		int hashCode = key.hashCode();
		return hashCode % numBuckets;
	}
	
	public int size() {
		return size;
	}
	
	public void insert( K key, V value ) {
		int bucketIndex = getBucketIndex( key );
		//if there is something alrdy on that index then 
		//update that else put new value.
		MapNode<K, V> head = buckets.get(bucketIndex);
		while( head != null ) {
			//here we will use .equals not == 
			//as == checks memory adrs
			if( head.key.equals(key)) {
				head.value = value;
				return; //update value and return
			}
			head = head.next;
		}
		head = buckets.get(bucketIndex);
		MapNode<K, V> newElementNode = new MapNode<K, V>(key,value);
		size++;
		newElementNode.next = head;
		buckets.set( bucketIndex, newElementNode );
		
		double loadFactor = (1.0*size)/numBuckets;
		if( loadFactor > 0.7 ) {
			rehash();
		}
		
	}
	
	public double loadFactor() {
		return (1.0*size)/numBuckets;
	}
	
	//By this function we will double the size of bucket array
	private void rehash() {
		System.out.println( "rehashing : buckets " + numBuckets + " size " + size  );
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList();
		for( int i = 0; i < 2*numBuckets; i++ ) {
			buckets.add( null );
		}
		size = 0;         //size 0 means abi ek b element nhi h
		numBuckets *= 2;  //ab number of buckets double ho gya h
		//now we will trvrs old arraylist and linkedlist and
		//copy is elemenet one by one
		for( int i = 0; i < temp.size(); i++ ) {
			MapNode< K, V > head = temp.get(i);
			while( head != null ) {
				
				K key = head.key;
				V value = head.value;
				insert( key, value );
				head = head.next;
			}
		}
	}

	//This function will take a key and give corresponding value
	public V getValue( K key ) {
		int bucketIndex = getBucketIndex( key );
		MapNode<K, V> head = buckets.get(bucketIndex);
		while( head != null ) {
			if( head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;	
	}
	
	//This function will delete an key
	public V removeKey( K key ) {
		int bucketIndex = getBucketIndex( key );
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		while( head != null ) {
			if( head.key.equals(key)) {
				size--;
				if( prev == null ) {
					//sbse first key hi h thn second key
					//ko point kra dege arraylist m 
					buckets.set(bucketIndex, head.next );
				}
				else {
					prev.next = head.next;
				}
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
} 