package LinkedList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
public class LinkedListBasics {

	public static void main(String[] args) {
		
		 LinkedList<Integer> linkedList=new LinkedList<Integer>();
		   
		   linkedList.add(1);
		   linkedList.add(-1);
		   linkedList.add(3);
		   linkedList.add(4);
		   linkedList.add(5);
		   nthElementFromLast(linkedList,2);
		  // printList(linkedList);
		   //productOfFirstNodes(linkedList,6);
		  // productOfLastNodes(linkedList,2);
		 //  deleteTwoElements(linkedList);
	}
//-----------------------------------------------------------------------------	
		public static void printList(LinkedList<Integer> linkedList)
		{
			Iterator<Integer> iterator=linkedList.iterator();
			System.out.println("===============");
			while(iterator.hasNext())
			{
				System.out.println(iterator.next());
			}
			System.out.println("===============");
		}
//-------------------------------------------------------------------------------	
	private static void productOfFirstNodes(LinkedList<Integer> linkedList, int n)
	{
		Iterator<Integer> iterator=linkedList.iterator();
		int pro=1;
		if(linkedList.size()>=n)
		{
			for(int j=0;j<n;j++)
			{
				pro=pro*iterator.next();				
			}
		System.out.println(pro);
		}
		else
		{
			System.out.println("Chal chutiye");
		}
	}
//-----------------------------------------------------------------------------	
	private static void productOfLastNodes(LinkedList<Integer> linkedList, int n)
	{
		Iterator<Integer> iterator=linkedList.iterator();
		int pro=1;
		int k=linkedList.size();
		if(k>=n)
		{
			for(int j=0;j<(k-n);j++)
			{
				iterator.next();				
			}
			while(iterator.hasNext())
			{
				pro=pro*iterator.next();
			}
		 System.out.println(pro);
		}
		else
		{
			System.out.println("Chal chutiye");
		}
	}
//------------------------------------------------------------------------------------	
      public static void deleteTwoElements(LinkedList<Integer> linkedList)
        {
    	  Iterator<Integer> iterator=linkedList.iterator();
    	  for(int l=0;l<linkedList.size()-1;l++)
    	  {
    		if(iterator.hasNext())  
    		{
            int a=iterator.next();           
               for(int i=0;i<linkedList.size();i++)
               {
            	 if(iterator.hasNext()) 
            	 {
            	 int k=iterator.next();
            	   if(a+k==0)
            	   {
            		  System.out.println("vgyjnb");
            		  int m=linkedList.indexOf(a);
            		  int n=linkedList.indexOf(k);
            		  linkedList.remove(m);
            		  linkedList.remove(n) ; 
            	   }       	   
                  } 
            	 // printList(linkedList);
            	 break;
               }
             }
    		 // printList(linkedList);
    		break;
    	   }
    	  printList(linkedList);
      }
//-------------------------------------------------------------------------------
      public static void nthElementFromLast(LinkedList<Integer> linkedList, int m)
    {
    	  ListIterator<Integer> iterator=linkedList.listIterator();

            int n= linkedList.size();
             for(int i=0;i<n-m+1;i++)
             {
            	 iterator.next();
             }
              iterator.previous();
              System.out.println(iterator.next());
    }
}