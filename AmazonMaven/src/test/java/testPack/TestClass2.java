package testPack;

import java.util.ArrayList;


public class TestClass2<E> {

	
	
	public static void main(String[] args) {
		
		ArrayList b = new ArrayList();
		b.add("shashnak");
		b.add(25);
		b.add(2.36);
		b.add('h');
		
		
		for(int i=0; i<b.size(); i++) {
			System.out.println(b.get(i));
		}
		
		System.out.println("================");
		
		
		
		
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("shashnak");
		a.add("asdsf");
		a.add("afsdf");
		a.add("afsf");
		
		
//		for(int i=0; i<a.size(); i++) {
//			System.out.println(a.get(i));
//		}
		
		for(String s:a) {
			System.out.println(s);
		}
		
		
		

		
	}
	
}
