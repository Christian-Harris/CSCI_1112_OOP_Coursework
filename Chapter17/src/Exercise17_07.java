/*
*	Modified by: Christian Harris
*	Date: 18 September 2020.
*	This class has been modified to include the outputData method.
*/
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
		
		Exercise17_07.outputData();
    }
	
	public static void outputData(){
		try{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
			try{
				while(true){
					Loan currentLoan = (Loan)input.readObject();
					System.out.println(currentLoan.getLoanAmount());
				}
			}catch(EOFException ex){
				System.out.println("End of file.");
			}
			catch(ClassNotFoundException ex){
				System.out.println("Loan class not found.");
			
			}
		}catch(IOException ex){
			System.out.println("Error reading file Exercise17_07.dat.");
		}
	}
}
