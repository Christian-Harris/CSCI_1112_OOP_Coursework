/**
*	Author: Christian Harris
*	Date Created: 17 September 2020
*	This program creates a file Exercise17_01 if it does not already exist and writes 100 random integers between 0 and 100 to it.
*	The integers are separated by a space and each line of 100 is on a new line.
*/

import java.io.*;

public class Exercise_17_1{
	
	
	public static void main(String[] args){
		File file = new File("Exercise17_01.txt");
		PrintWriter writer;
		int rand;
		
		try{
			writer = new PrintWriter(new FileWriter(file, true));	
		
			for(int i = 0; i < 100; i++){
				rand = (int)(Math.random() * 101);
				writer.print(rand + " ");
			}
			writer.print("\n");
			writer.close();
		}catch(IOException ex){
			System.out.println("Unable to write to file.");
		}
	}
}