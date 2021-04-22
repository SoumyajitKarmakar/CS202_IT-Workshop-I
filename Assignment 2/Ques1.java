package assignment2;

import java.util.*;

public class Ques1 {
	
	public static String readKeyboard() {
		Scanner sc = new Scanner(System.in);
		String d = sc.nextLine();
		sc.close();
		return d;
	}
	
	public static int words(String s) {
		Scanner sc = new Scanner(s);
		sc.useDelimiter(" ");
		int i = 0;
		while(sc.hasNext()) {
			i ++;
		}
		sc.close();
		System.out.print(i);
		return 0;
	}
	
	public static int longest(String s) {
		String[] word = s.split( " " );
        String rts = " ";

        for ( int i = 0; i < word.length; i++ )
        {
            if ( word[i].length() > rts.length() )
                rts = word[i];

        }
        System.out.println( rts );
        return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter Sentence : ");
		String s;
		s = readKeyboard();
		words(s);
		longest(s);
	}

}
