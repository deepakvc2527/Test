 package weeksix.assignments;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string: ");
		String str1 = sc.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("Enter the second string: ");
		String str2 = sc.nextLine().toLowerCase().replaceAll("\\s", "");
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		
		char[] chars1 = str1.toCharArray();
		for(char c : chars1) {
			if(map1.containsKey(c)) {
				map1.put(c, map1.get(c) + 1);
			} else {
				map1.put(c, 1);
			}
		}
		char[] chars2 = str2.toCharArray();
		for(char ch : chars2) {
			if(map2.containsKey(ch)) {
				map2.put(ch, map2.get(ch) + 1);
			} else {
				map2.put(ch, 1);
			}
		}
		
		System.out.println((map1.equals(map2)));
		}
		

	}

