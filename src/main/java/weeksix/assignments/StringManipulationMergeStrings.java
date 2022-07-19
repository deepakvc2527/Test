package weeksix.assignments;

import java.util.Scanner;

public class StringManipulationMergeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string: ");
		String str1 = sc.nextLine();
		System.out.println("Enter the second string: ");
		String str2 = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str1.length()||i<str2.length();i++) {
			if(i<str1.length()) {
				sb.append(str1.charAt(i));
			}
			if(i<str2.length()) {
				sb.append(str2.charAt(i));
			}
		}
		System.out.println(sb.toString());
	}

}
