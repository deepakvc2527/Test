package weeksix.assignments;

import java.util.HashMap;
import java.util.Scanner;

public class FirstRepeatedCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = sc.nextLine();
		HashMap<Character , Integer> map = new HashMap<Character, Integer>();
		char[] chars = str.toCharArray();
		for(char c : chars) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for(char c : chars) {
			if(map.get(c) > 1) {
				System.out.println("First Repeated Character in "+str+" is "+c);
				break;
			}
		}
		

	}

}
