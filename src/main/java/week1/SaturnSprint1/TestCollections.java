package week1.SaturnSprint1;

import java.util.ArrayList;
import java.util.Collections;

public class TestCollections {

	public static void main(String[] args) {

  ArrayList<Integer> AL1 = new ArrayList<Integer>();
  AL1.add(1);
  AL1.add(2);
  AL1.add(3);
  AL1.add(4);
  AL1.add(5);
  AL1.add(6);
  AL1.add(10);
  AL1.add(7);
  AL1.add(8);
  
  //System.out.println(AL1.get(0));
  for (int i = 0; i < AL1.size(); i++) {
	System.out.println(AL1.get(i));
}
  System.out.println(AL1);
  ArrayList<Integer> AL2 = new ArrayList<Integer>();
  AL2.addAll(AL1);
  Collections.sort(AL1);
  System.out.println(AL1);
  System.out.println(AL2);
   if (AL1.equals(AL2)) {
	   System.out.println("both the collections are equal");
	   		}
	
else {
	 System.out.println("both the collections are not equal");
}
  
  
  
  
  
	}
	

}
