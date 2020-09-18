/*
*	Author: Christian Harris.
*	Date: 18 September 2020.
*	This program uses recursion to compute the GCD of two integers.
*/

import java.util.Scanner;

public class RecursiveGCD{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter first integer:\n>");
		int m = in.nextInt();
		
		System.out.print("Enter second integer:\n>");
		int n = in.nextInt();
		
		System.out.println("The gcd of " + m + " and " + n + " is " + RecursiveGCD.gcd(m,n));
	}
	
	public static int gcd(int m, int n){
		int result = 0;
		if(m % n == 0){
			result = n;
		}
		else{
			result = RecursiveGCD.gcd(n, m % n);
		}
		return result;
	}
}