package javaCore22Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise22MaxSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] charArr = str.toCharArray();
		
		ArrayList<String> l = new ArrayList<String>();
		int count = 0;
	    for(int i = 0; i < charArr.length - 1; i++) {
	    	if(charArr[i] == charArr[i+1]) {
	    		int back = i, next = i + 1;
	    		String palindromic = "";
	    		while(charArr[back] == charArr[next]) {
	    			palindromic += charArr[next];
	    			back--;
	    			next++;
	    			if(next > charArr.length -1 || back < 0) {
	    				break;
	    			}
	    		}
	    		count++;
	    		l.add(palindromic);
	    	}
	    }
	   if(count == 0) {
		   System.out.println("OUTPUT: Khong ton tai substring palindromic !");
	   }else {
		   String max = l.get(0);
		    for(int i = 1; i < l.size(); i++) {// size = so luong phan tu
		    	int result = l.get(i).length() - max.length(); // do dai chuoi 
		    	if(result > 0) {
		    		max = l.get(i);
		    	}
		    }
		    
		    System.out.printf("OUTPUT: %s", max);
	   }
	    
//    	DATA test:        adcbgchoohccjfhsdufibinhhnibdhkj1234554321fsdf
		sc.close();
	}

}
