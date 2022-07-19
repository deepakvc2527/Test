package weeksix.assignments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PrintAllUniqueCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String str = input.nextLine();
		
		LinkedHashMap<Character , Integer> map = new LinkedHashMap<Character, Integer>();
		char[] chars = str.toCharArray();
		for(char c : chars) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		Set<Map.Entry<Character, Integer>> hmap = map.entrySet();
		for(Map.Entry<Character, Integer> data : hmap) {
			if(data.getValue()==1) {
				System.out.println(data.getKey());
			}
		}

	}

}
