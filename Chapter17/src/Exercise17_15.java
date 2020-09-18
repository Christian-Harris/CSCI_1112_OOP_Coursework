/*
*	Author: Christian Harris.
*	Date: 18 September 2020.
*	This class prompts the user to enter a file name. The program then decrypts the file according to the scheme outlined in Exercise17_14.
*/

import java.util.Scanner;
import java.io.*;

public class Exercise17_15{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the name of the input file to decrypt:\n>");
		String inputFile = in.nextLine();
		
		System.out.print("Enter the name of the file after decryption:\n>");
		String outputFile = in.nextLine();

		
		try{
			DataInputStream input = new DataInputStream(new FileInputStream(inputFile));
			DataOutputStream output = new DataOutputStream(new FileOutputStream(outputFile));
			try{
				while(true){
					byte value = input.readByte();
					output.write(value - 5);
				}
			}catch(EOFException ex){
				System.out.println("End of file.");
			}catch(IOException ex){
				System.out.println("I/O Error.");
			}
			
		}catch(IOException ex){
				System.out.println("Files could not be opened.");
		}
	}
}