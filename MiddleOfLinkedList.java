package LinkedList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MiddleOfLinkedList {

	public static void main(String[] args)
	{
	   LinkedList<Integer> linkedList=new LinkedList<Integer>();
	   HashSet<Integer> s=new HashSet<Integer>();
	   linkedList.add(1);
	   linkedList.add(2);
	   linkedList.add(3);
	   linkedList.add(4);
	   linkedList.add(5);
//	    addNum(linkedList);
//		printList(linkedList);
		midValue(linkedList);
	}
//------------------------------------------------------------------
//------------------------------------------------------------------	
	public static void printList(LinkedList<Integer> linkedList)
	{
		Iterator<Integer> iterator=linkedList.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
//-------------------------------------------------------------------	
   public static void midValue(LinkedList<Integer> linkedList)
   {
	   Iterator<Integer> iterator=linkedList.iterator();
	   
		   int n=linkedList.size();
	         for(int j=0;j<(n/2);j++)
	         {
	        	 iterator.next();
	         }
	         System.out.println("==============");
	         System.out.println(iterator.next());
    }
}
