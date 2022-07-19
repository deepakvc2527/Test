package testcases;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println("Enter the string: ");
		s = s.replace(" ", "");
		char[] ch = s.toCharArray();
		HashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		int count = 0;
		for(int i=0;i<ch.length;i++) {
			count = 0;
			for(int j=0;j<ch.length;j++) {
				if(ch[i]==ch[j]) {
					count++;
				}
		

	}
			map.put(ch[i], count);
		}
		System.out.println(map);
	}
}


