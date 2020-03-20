//The Stock Span Problem
//The stock span problem is a financial problem where we have a series of n daily price quotes
//for a stock and we need to calculate span of stock’s price for all n days.
//The span Si of the stock’s price on a given day i is defined as
//the maximum number of consecutive days just before the given day, 
//for which the price of the stock on the current day is less than or equal to 
//its price on the given day.
//For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
//then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}

package StackAndQueue;
import java.util.Stack;
public class StockSpan {

	public static void main(String[] args) {

		int[] price = { 10, 110, 14, 8, 115, 193 };
		int[] ans = stockSpan(price);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	public static int[] stockSpan(int[] price) {     // Time complexity O(n^2) will give
													//time limit exceed for large inputs
//        Stack< Integer > s = new Stack<>();
//
//        int[] ans = new int[ price.length ];
//        
//        for( int i = 0; i < price.length; i++ ){
//           int x = price[i]; 
//           int count = 1;
//           boolean flag = true;
//           while(  s.isEmpty() == false && flag == true ){
//                  
//             if( s.peek() < x ){
//                count++;
//                flag = true;
//                 s.pop();
//              }
//            else{
//                flag = false;      
//              }
//           }
//           ans[i] = count;
//           while(! s.isEmpty()) {
//        	   s.pop();
//           }
//            
//           for( int j =0; j <= i; j++ ){
//               s.push( price[j] ); 
//           }                   
//        }
//        return ans;
//=======================================================================
		// Another Method with O(n) complexity

		Stack<Integer> s = new Stack<>();
		int[] ans = new int[price.length];

		ans[0] = 1; // span for first index will be 1 always
		s.push(0); // will push indexes in stack

		for (int i = 1; i < price.length; i++) {
			
			// Pop elements from stack while stack is not
			// empty and top of stack is smaller than
			// price[i]
			while (!s.isEmpty() && price[s.peek()] < price[i]) {
				s.pop();
			}
			
			// If stack becomes empty, then price[i] is
			// greater than all elements on left of it, i.e.,
			// price[0], price[1], ..price[i-1]. Else price[i]
			// is greater than elements after top of stack
			if (!s.isEmpty()) {
				ans[i] = i - s.peek();
			} else {
				ans[i] = i + 1;
			}
			// Push this index to stack 
			s.push(i);
		}
		return ans;
	}
//========================================================================	
}