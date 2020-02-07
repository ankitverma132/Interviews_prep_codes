import java.util.Scanner;
public class Pangram {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();	
	String str=sc.next();
	
//	String T="";
//	if(n<26)
//    {
//       System.out.print("NO");
//    }
//   else
//   {
//	   for(int i=0;i<n;i++)
//	   {
//		   char c=str.charAt(i);
//		   if((int)c>64 && (int)c<91)
//		   {
//			  c=(char)(c+32);
//			  T=T + c;
//		   }
//		   else
//		   {
//			 T= T + c;  
//		   }
//	   }	   
//	     
//   }
//=====================From GeekforGeeks=======================//	
	// Create a hash table to mark the characters present in the string 
    // By default all the elements of mark would be false.
    boolean[] mark = new boolean[26];  
    int index = 0;                                // For indexing in mark[]   
    for (int i = 0; i < str.length(); i++)        // Traverse all characters 
    { 
        // If uppercase character, subtract 'A' to find index. 
        if ('A' <= str.charAt(i) &&  str.charAt(i) <= 'Z')                      
                index = str.charAt(i) - 'A'; 
            // If lowercase character, subtract 'a' to find index. 
        else if('a' <= str.charAt(i) &&  str.charAt(i) <= 'z')                          
            index = str.charAt(i) - 'a'; 
       
        mark[index] = true;  // Mark current character 
    } 
    int count=0;
    for (int i = 0; i <= 25; i++) 
        if (mark[i] == false) 
             { count++; }
    if(count==0)
    	System.out.print("YES");
    else
    	System.out.print("NO");  		
}
}