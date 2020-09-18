/*
*	Modified by: Christian Harris.
*	Date: 18 September 2020.
*	Description: This program has been modified to include a sort method 
*	for sorting any ArrayList whose objects implement the Comparable interface.
*/
import java.util.ArrayList;

public class Exercise19_09 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    Exercise19_09.<Integer>sort(list);
    
    System.out.print(list);
  }
  
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
	boolean needNextPass = true;
	for(int k = 1; k < list.size() && needNextPass; k++){
		needNextPass = false;
		for(int i = 0; i < list.size() - k; i++){
			if(list.get(i).compareTo(list.get(i+1)) > 0){
				E temp = list.get(i);
				list.set(i, list.get(i+1));
				list.set(i+1, temp);
				
				needNextPass = true;
			}
		}
	}
  }
  
  public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		int maxIndex = 0;
		for(int i = 0; i < list.size(); i++){
			if(list.get(maxIndex).compareTo(list.get(i)) < 0){
				maxIndex = i;
			}
		}
		return list.get(maxIndex);
	}
}
