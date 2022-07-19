package weeksix.assignments;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String input = sc.nextLine();
		
		char[] chars = input.toCharArray();
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		for(char c : chars) {
			set.add(c);
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character ch: set) {
		sb.append(ch);
		}
		System.out.println(sb.toString());
		//System.out.println(set.hashCode());

	}

}
