package StackAndQueue;
import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String[] args) {

		String str = "{ a + [ b+ (c + d)] + (e + f) }";
		System.out.println( checkBalanced(str) );
	}
	
	public static boolean checkBalanced(String exp) {

		Stack<Character> stack = new Stack<>();
        
        for( int i = 0 ; i < exp.length(); i++ ){
            
          if( exp.charAt( i ) == '{' || exp.charAt( i ) == '(' || exp.charAt( i ) == '[' ){
              stack.push( exp.charAt(i) );                    
          }  
            
          else if( exp.charAt( i ) == '}' || exp.charAt( i ) == ')' || exp.charAt( i ) == ']' ){
        	  
              if( stack.size() == 0 ){
            	  
                  return false;
                  
              }
              else{
            	  if( exp.charAt( i ) == '}') {
                      if( stack.peek() == '{' ){
                          char ch = stack.pop(); 
                      }
                      else{             
                         return false;
                      }
            	   }
            	   else if( exp.charAt( i ) == ')') {
                        if( stack.peek() == '(' ){
                          char ch = stack.pop(); 
                        }
                        else{             
                          return false;
                        }
             	   }
            	  else {
                      if( stack.peek() == '[' ){
                    	  //System.out.println( "==" );
                         char ch = stack.pop(); 
                      }
                      else{             
                         return false;
                      }
             	  }
              }
          }   
          else{              
            //no action  
          }              
        }  
        if( stack.size() == 0 ){
            return true;
        }
        else{
            return false;
        } 
	}
}