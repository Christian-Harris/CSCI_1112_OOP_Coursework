/*
*	Edited by: Christian Harris. 
*	Date: 18 September 2020.
*	Description: This program has been edited to contain a max method which will return the maximum entry of any array of object which implements the Comparable interface.
 */
public class Exercise19_05 {
	public static void main(String[] args) {
    Integer[] numbers = {1, 2, 3};
    System.out.println(max(numbers));
    
    String[] words = {"red", "green", "blue"};
    System.out.println(max(words));
    
    Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
    System.out.println(max(circles));
	}
  
	public static <E extends Comparable<E>> E max(E[] list) {
		int maxIndex = 0;
		for(int i = 0; i < list.length; i++){
			if(list[maxIndex].compareTo(list[i]) < 0){
				maxIndex = i;
			}
		}
		return list[maxIndex];
	}
  
  static class Circle implements Comparable<Circle> {
    double radius;
    
    public Circle(double radius) {
      this.radius = radius;
    }
    
    @Override
    public int compareTo(Circle c) {
      if (radius < c.radius) 
        return -1;
      else if (radius == c.radius)
        return 0;
      else
        return 1;
    }
    
    @Override
    public String toString() {
      return "Circle radius: " + radius;
    }
  }
}
