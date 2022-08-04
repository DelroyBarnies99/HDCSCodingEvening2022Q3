/** This program create's a function that, given a string with at least three characters, returns an array of its:
 *
 * Length.
 * First character.
 * Last character.
 * Middle character, if the string has an odd number of characters. Middle TWO characters, if the string has an even number of characters.
 * Index of the second occurrence of the second character in the format "@ index #" and "not found" if the second character 
 * doesn't occur again.
 *
 * @author  Delroy Barnies
 * @version 1.0 2022/08/04
 */
package StringChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringChallenge {
	
	public static void main(String[] arg) {
		System.out.println(challengeAnswer().toString());
	}
	/**
	 * Method returns the list that has been processed by the string
	 *  
	 * @return list   list containing all values we want to determine 
	 * @since      version 1.0
	 */ 
	public static ArrayList<String> challengeAnswer() {
		
		System.out.print("Enter a String of 3 or more characters:");
		Scanner i = new Scanner(System.in);
		String string = i.next();
		
	    while (!(string.length() >= 3)) {
	    	
	    	System.out.print("\nInvalid number of characters!\nPlease enter a String of 3 or more characters:");
			i = new Scanner(System.in);
			string = i.next();
	    }
	    
	    ArrayList<String> list = new ArrayList<String>(5);
	    
	    list.add(String.valueOf(string.length())); 
	    list.add(String.valueOf(string.charAt(0)));
	    list.add(String.valueOf(string.charAt(string.length() - 1)));
	    list.add(middleChar(string));
	    list.add(SecondCharAtIndex(string));
	    
	    return list;
	    
	}
	/**
	 * Method returns the middle character of a string, if the string has an odd number of characters it will return the 
	 * the two middle characters.
	 *  
	 * @param str  The string in which we want to find the middle character
	 * @return middle character
	 * @since      version 1.0
	 */ 
	public static String middleChar(String str) {
		
		int middleIndex = 0;
	    int length = str.length();
	    
	    if (str.length() % 2 == 0) {
	    	middleIndex = length / 2 - 1;
	    	length = 2;
	    	
	    }	
	    else {
	    	middleIndex = length / 2 - 1;
	    	length = 1;
	    }
		return str.substring(middleIndex, middleIndex + length);
	}
	/**
	 * Method returns the index of the duplicate of the second character in a string
	 *  
	 * @param str  The string in which we want to find the duplicate
	 * @return index of the second characters duplicate 
	 * @since      version 1.0
	 */ 
	public static String SecondCharAtIndex(String str) {
		
		String[] charList = str.split("");
		List<String> arrayList = new ArrayList<String>();
		
		String secondChar  = charList[1];
		
		for (String character : charList) {
			arrayList.add(character);
		}
		
		arrayList.remove(0);
		int nextOccurance = 0; 
		
		for (int i = 0; i < arrayList.size(); i++) {
			
			if (secondChar == arrayList.get(i)) {
				nextOccurance = arrayList.indexOf(arrayList.get(i));
				
				return "@ index " + String.valueOf(nextOccurance);
			}
		}
		return "not found";
	}
}