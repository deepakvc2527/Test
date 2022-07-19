package weeksix.assignments;

import java.util.HashMap;
import java.util.Scanner;

public class CountCharOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = sc.nextLine();
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		char[] chars = str.toCharArray();
		for(char c : chars) {
			if(hmap.containsKey(c)) {
				hmap.put(c, hmap.get(c) + 1);
			} else {
				hmap.put(c, 1);
			}
		}
		System.out.println(hmap);
		
	}

}
