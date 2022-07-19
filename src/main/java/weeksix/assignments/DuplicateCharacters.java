package weeksix.assignments;

import java.util.Scanner;

public class DuplicateCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		while(true) {
		
		System.out.println("Enter the string : ");
		String str = sc.nextLine();
		char[] inp = str.toCharArray();
		System.out.println("The Duplicate characters in the given string are : ");
		for(int i = 0; i<str.length();i++) {
			for(int j=i+1;j<str.length();j++) {
				if(inp[i] == inp[j]) {
					System.out.println(inp[j]);
					break;
				}
			}
		}

	}
	
	}
}
