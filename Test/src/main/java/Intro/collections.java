package Intro;

import java.util.ArrayList;
import java.util.List;

public class collections {

	public static void main(String[] args) {
		ArrayList <String> a = new ArrayList<String> ();
		a.add("apple");
		a.add("banana");
		a.add("cherry");
		a.add("mango");
		a.add("apple");
		System.out.println(a);
		a.remove("apple");
		System.out.println(a);
	}

}
