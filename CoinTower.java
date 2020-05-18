//Coin Tower
//Whis and Beerus are playing a new game today . 
//They form a tower of N coins and make a move in alternate turns . 
//Beerus being the God plays first . In one move player can remove
//1 or X or Y coins from the tower . The person to make the
//last move wins the Game . Can you find out who wins the game ?
//Sample Input :
// 4 2 3
//Sample Output :
// Whis
//Input :  n = 5, x = 3, y = 4
//Output : A
//There are 5 coins, every player can pick 1 or
//3 or 4 coins on his/her turn.
//A can win by picking 3 coins in first chance.
//Now 2 coins will be left so B will pick one 
//coin and now A can win by picking the last coin.
//
//Input : 2 3 4
//Output : B
package DP_2;

public class CoinTower {
	
	public static  String solve(int n,int x,int y){
		
		//False representing loose, true win
		boolean[] storage = new boolean[n+1];
		
		storage[0] = false;
//		A will always win if there is only 
//		one coin as he will pick that coin
		storage[1] = true;
		
		for( int i = 2; i <= n; i++ ) {
			
			if( i - 1 >= 0 && storage[i - 1] == false ) {
				storage[i] = true;
			}
			else if( i - x >= 0 && storage[i - x] == false ) {
				storage[i] = true;
			}
			else if( i - y >= 0 && storage[i - y] == false ) {
				storage[i] = true;
			}
			else {
				storage[i] = true;
			}
		}
		if( storage[n] == true ) {
			return "Beerus";
		}
		else {
			return "Whis";
		}
	}
	
	public static void main(String[] args) {
		System.out.println( solve( 5,3,4 ));
	}
}