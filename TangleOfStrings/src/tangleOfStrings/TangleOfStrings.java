package tangleOfStrings;
import java.util.*;

public class TangleOfStrings {

	// Creates a public scanner that can be used throughout the whole program
	public static Scanner input = new Scanner(System.in);

	
	// Initializes the Scanner so every time the user presses enter it takes that as the input
	public static void main(String[] args) {
		input.useDelimiter(System.lineSeparator());
		myPassWord();
	}

	// Simple password checker
	public static void myPassWord() {
		String a = "";
		System.out.print("Please enter your password: ");
		a = input.next();
		if(a.equals("me")) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			menu();
		} else {
			System.out.println("Incorrect passowrd.");
			myPassWord();
		}
	}

	public static void menu() {
		int temp = 0;
		String str= "";
		System.out.print("Please enter the fun string: ");
		str = input.next();
		System.out.println("----------------------------------------");
		System.out.print(" 1: Print my string backward\n 2: Make a list of words in my string with a given length\n 3: Print out number of vowels in my string\n 4: Inverse the character case of my string\n 5: Compare to a 2nd string for content equality\n 6: Replace a word in your string with a new word\n 7: Quit");
		System.out.print("\nPlease eneter a number: ");
		
		// Giant try/catch to make sure that the user enters a real number
		try {

			temp = input.nextInt();
			if(temp > 0 && temp < 8) {
				
				// Switch statement to bring the user to the proper
				switch(temp) {
				case 1:
					System.out.println("----------------------------------------\n" + reverse(str) + "\n----------------------------------------");
					Repeat();
					break;
				case 2:
					int n = 0;
					System.out.print("What length of words would you like to recieve: ");
					n = input.nextInt();
					System.out.println(wordList(str, n) + "----------------------------------------");
					Repeat();
					break;
				case 3:
					System.out.println("----------------------------------------\n  There are " + Vowels(str) + " vowels in your string.\n----------------------------------------");
					Repeat();
					break;
				case 4:
					System.out.println("----------------------------------------\n" + Inverse(str) + "\n----------------------------------------");
					Repeat();
					break;
				case 5:
					System.out.println("\n----------------------------------------\n Do the strings match: " + isMatch(str) + "\n----------------------------------------\n");
					Repeat();
					break;
				case 6:
					findReplace(str);
					Repeat();
					break;
				case 7:
					Repeat();
					break;
				}
			} else {
				System.out.println("Please enter a number between 1 and 7");
				menu();
			}
		} catch(Exception e) {
			System.out.println("Please enter a valid number");
			// resets info in the scanner
			input.nextLine();
			menu();
		}
	}

	public static String reverse(String str) {
		String temp = "";
		for (int i = str.length() -1; i >= 0; i--) { 
			temp += str.charAt(i);
		}
		return temp;
	}

	public static void Repeat() {
		int test = 0;
		System.out.println("Would you like to do more things? (1) for Yes / (2) for No");
		try {
			test = input.nextInt();
			if(test==1) {
				menu();
			}
			if(test==2) {
				System.out.println("\n\n\n\n\n\n\n");
				System.out.println("All done :)");
				System.out.println("\n\n");
			}
		}
		catch(Exception e) {
			System.out.println("Incorrect number");
			Repeat();
		}
	}

	public static String wordList(String str, int n) {
		String temp = "";
		System.out.println("----------------------------------------");
		for(int i = 0; i < str.length(); i++) {
			if(!Character.toString(str.charAt(i)).equals(" ")) {
				temp += str.charAt(i);
			} else {
				if(temp.length() == n) {
					System.out.println(temp);
				}
				temp = "";
			}
		}
		if(temp.length() == n) {
			return temp + "\n";
		}
		return "";

	}

	public static int Vowels(String str) {
		int counter = 0;
		for(int i = 0; i < str.length(); i++) {
			if(Character.toString(str.charAt(i)).toLowerCase().equals("a") || Character.toString(str.charAt(i)).toLowerCase().equals("e") || Character.toString(str.charAt(i)).toLowerCase().equals("i") || Character.toString(str.charAt(i)).toLowerCase().equals("o") || Character.toString(str.charAt(i)).toLowerCase().equals("u")) {
				counter++;
			}
		}
		return counter;
	}

	public static String Inverse(String str) {
		String temp = "";
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))){
				temp += Character.toString(str.charAt(i)).toLowerCase();
			}
			if(!Character.isUpperCase(str.charAt(i))){
				temp += Character.toString(str.charAt(i)).toUpperCase();
			}
		}
		return temp;
	}

	public static boolean isMatch(String str) {
		boolean temp;
		String tempstr = ""; 
		System.out.println("What would you like to compare your string to?");
		tempstr = input.next();
		if(tempstr.equals(str)) {
			return true;
		}
		return false;
	}

	public static void findReplace(String str) {
		// Creates a List of strings
		List<String> words = new ArrayList<>();

		// Separates the strings at every space, and puts them into the list
		String temp = "";
		for(int i = 0; i < str.length(); i++) {
			if(!Character.toString(str.charAt(i)).equals(" ")) {
				temp += str.charAt(i);
			} else {
				words.add(temp);
				temp = "";
			}
		}
		words.add(temp);

		// tempstr is what the user wants to find
		String tempstr = ""; 
		System.out.println("What word would you like to replace?");
		tempstr = input.next();

		// Checks if the list of strings contains the word that the user wants to find
		if(words.contains(tempstr)) {

			// Locates the index in the list that matches tempstr 
			for(int i = 0; i < words.size(); i ++) {
				if(words.get(i).equals(tempstr)) {
					String tempstr2 = "";
					System.out.println("What word would you like to replace it with?");
					tempstr2 = input.next();

					// Replaces it with the users desired word at the index of tempstr
					words.set(words.indexOf(tempstr), tempstr2);
				}
			}

			// Prints the list in a readable way
			System.out.println("----------------------------------------      ");
			for(int i = 0; i < words.size(); i++) {
				System.out.print(words.get(i) + " ");
			}
			System.out.println("\n----------------------------------------");
		} else {

			// Catches if the user tries to find a word that isn't in the original string
			System.out.println("That word does not exist in your fun string\nPlease try again");
			input.nextLine();
			findReplace(str);
		}

	}
}
