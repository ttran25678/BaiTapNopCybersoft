package javaCore22Exercises;

import java.util.Scanner;

public class Exercise8UppercaseFirstLetter {

	public static void main(String[] args) {
		// TODO In hoa chữ cái đầu
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("Please enter the string: ");
		String str = sc.nextLine();

		// 1. cắt string vừa nhập thành mảng ký tự
		// 2. Duyệt mảng ký tự,
		// 3. nếu nó là chữ (or là ký tự đầu tiên) và không phải space = false, thì IN HOA ký tự đó, 
		//    đồng thời đặt biến kiểm tra space = false. 
		// 4. nếu gặp ký tự space thì phải đổi = true
		
		char[] words = str.toCharArray(); // 1
		boolean space = true;
		for(int i = 0; i < words.length; i++) { // 2
			if(Character.isLetter(words[i])) { // 3 nếu nó là ký tự 
				
				if(space) {
					words[i] = Character.toUpperCase(words[i]); // in hoa chữ cái đầu (đã là ký tự)
					space = false;								// (thì không phải space)
				}
			}else {
				space = true; // 4 nếu không là ký tự thì nó là space
			}
		}
		
		// convert charArray to String
		str = String.valueOf(words);
		System.out.println("Uppercase first letter: "+str);

		sc.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		// create a string
//	    String message = "everyone         loves java";
//
//	    // stores each characters to a char array
//	    char[] charArray = message.toCharArray();
//	    boolean foundSpace = true;
//
//	    for(int i = 0; i < charArray.length; i++) {
//
//	      // if the array element is a letter
//	      if(Character.isLetter(charArray[i])) {
//
//	        // check space is present before the letter
//	        if(foundSpace) {
//
//	          // change the letter into uppercase
//	          charArray[i] = Character.toUpperCase(charArray[i]);
//	          foundSpace = false;
//	        }
//	      }else {
//	        // if the new character is not character
//	        foundSpace = true;
//	      }
//	    }
//
//	    // convert the char array to the string
//	    message = String.valueOf(charArray);
//	    System.out.println("Message: " + message);
//		
		
	}

}
