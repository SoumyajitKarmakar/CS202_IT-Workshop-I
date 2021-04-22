

import java.util.*;
import java.io.*;

public class Ques1 {

	static Scanner sc;
	
	public static ArrayList<String> load(String s) throws FileNotFoundException{
		sc = new Scanner(new File(s));
		String t;
		ArrayList<String> list = new ArrayList<String>();
		while (sc.hasNext()){
			t = sc.nextLine();
			list.add(t);
		}
		return list;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		ArrayList<String> f1 = load(args[0]);
		ArrayList<String> f2 = load(args[1]);
		
//		ArrayList<String> f1 = load("asd.txt");
//		ArrayList<String> f2 = load("jkl.txt");
		
		
		int i, j, k, l;
		String[] line1, line2;
		
//		line1 = f1.get(3).split(" ");
//		System.out.print(Arrays.toString(f1.get(3).split("\\s+")));
		
		System.out.println("Following words are common in both the files with the following details:");
		
		for(i = 0; i < f1.size(); i++) {
			line1 = f1.get(i).trim().split("\\s+");
			//System.out.println("1" + Arrays.toString(line1));
			for(j = 0; j < f2.size(); j++) {
				line2 = f2.get(j).trim().split("\\s+");
				//System.out.println("2" + Arrays.toString(line2));
				for(k = 0; k < line1.length; k++) {
					//System.out.println(line1[k]);
					if(!line1[k].equals("") && !line1[k].equals(" ") && !line1[k].equals("\n")) {
						for(l = 0; l < line2.length; l++) {
							//System.out.println(line2[l]);
							if(!line2[l].equals("") && !line2[l].equals(" ") && !line2[l].equals("\n")) {
								if(line1[k].equalsIgnoreCase(line2[l])) {
									System.out.println("" + line1[k] + ": length " + line1[k].length() + ", appeared in line " + (i + 1) + " of first file and line " + (j + 1) + " of second file.");
								}
							}
						}
					}
					
				}
			}
		}
		
		sc.close();
	}

}
