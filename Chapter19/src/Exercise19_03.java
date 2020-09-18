/*
*	Modified by: Christian Harris.
*	Date: 18 September 2020. 
*	Description: This program has been modified with a removeDuplicates method to remove duplicate items in an ArrayList.
*/

import java.util.ArrayList;

public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
	
	System.out.print(list);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
  
  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
	  ArrayList<E> result = new ArrayList<E>();
	  boolean duplicate = false;
	  for(int i = 0; i < list.size(); i++){
		  for(int j = 0; j < result.size(); j++){
			  if(list.get(i).equals(result.get(j))){
				  duplicate = true;
				  break;
			  }
		  }
		  if(!duplicate){
			  result.add(list.get(i));
		  }
		  duplicate = false;
	  }
	  return result;
  }
}