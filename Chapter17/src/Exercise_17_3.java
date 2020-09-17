/**
*	Author: Christian Harris
*	Date Created: 17 September 2020
*	This program creates a file Exercise17_03.dat if it does not already exist and writes 100 random integers between 0 and 100 to it.
*	The integers are separated by a space and each line of 100 is on a new line. The program then reads the values and prints the total to the console.
*/

import java.io.*;

public class Exercise_17_3{
	private File file;
	
	public static void main(String[] args) throws IOException{
		
		Exercise_17_3 myObject = new Exercise_17_3();
		myObject.writeNumbers();
		System.out.println(myObject.sumOfNumbers());
	}
	
	Exercise_17_3(){
		file = new File("Exercise17_03.dat");
	}
	
	public void writeNumbers() throws FileNotFoundException, IOException{
		DataOutputStream output = new DataOutputStream(new FileOutputStream(file, true));
		int rand;
		for(int i = 1; i <= 100; i++){
			rand = (int)(Math.random() * 101);	
			output.writeInt(rand);
			output.writeUTF(" ");
		}
		output.close();
	}
	
	public int sumOfNumbers() throws FileNotFoundException, IOException{
		DataInputStream input = new DataInputStream(new FileInputStream(file));
		int total = 0;;
		try{
			while(true){
				total += input.readInt();
				input.readUTF();
			}
		}catch(EOFException ex){
			//End of file.
		}
		return total;
		
	}
}