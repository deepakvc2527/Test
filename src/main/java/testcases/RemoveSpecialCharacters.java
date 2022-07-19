package testcases;

public class RemoveSpecialCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "My @am* is D&^ba(";
		String str2 = str.replaceAll("[^a-zA-Z0-9 ]","_");
		System.out.println(str2);

	}

}
