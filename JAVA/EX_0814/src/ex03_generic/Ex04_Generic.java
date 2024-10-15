package ex03_generic;

import java.util.ArrayList;
import java.util.LinkedList;

/*중첩타입 파라미터*/

public class Ex04_Generic {
	public static void main(String[] args) {
		
	
	    // LinkedList<String>을 원소로서 저장하는 ArrayList
		//문자열데이터를 저장하는 LinkedList객체를 저장할 수 있는 ArrayList
	    ArrayList<LinkedList<String>> list = new ArrayList<LinkedList<String>>();
	    
	    LinkedList<String> link1 = new LinkedList<>();
	    link1.add("aa");
	    link1.add("bb");

	    LinkedList<String> link2 = new LinkedList<>();
	    link2.add("11");
	    link2.add("22");
	    
	    //ArrayList에 LinkedList 객체 추가
	    list.add(link1);
	    list.add(link2);
	    System.out.println(list);

	    
	    
	    
	    
	    
	    
	    
	    
}}
