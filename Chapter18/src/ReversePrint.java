/*
*	Author: Christian Harris.
*	Date: 18 September 2020.
*	This program accepts a line of input from the user and prints that line in reverse order.
*/

import java.util.Scanner;

public class ReversePrint{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter a line of text:\n>");
		String input = in.nextLine();
		ReversePrint.reverseDisplay(input);
	}
	
	public static void reverseDisplay(String value){
		if(value.length() == 1){
			System.out.print(value);
		}
		else{
			System.out.print(value.charAt(value.length() - 1));
			reverseDisplay(value.substring(0, value.length() - 1));
		}
	}
}