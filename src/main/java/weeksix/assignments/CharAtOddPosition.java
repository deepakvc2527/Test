package weeksix.assignments;

import java.util.Scanner;

public class CharAtOddPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = sc.nextLine();
		for(int i=0;i<str.length();i=i+2) {
			
				System.out.println(str.charAt(i));
			
		}

	}

}
