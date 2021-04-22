

import java.io.*;
import java.util.*;

public class Ques1 {

	static Scanner sc;
	
	public static class reader implements Runnable{
		String s;
		ArrayList<ArrayList<String>> list;
		
		public reader(String t) {
			this.s = t;
			this.list = new ArrayList<ArrayList<String>>();
		}
		
		public synchronized void run(){
			File f= new File(this.s);
			try {
				sc = new Scanner(f);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String t;
			ArrayList<String> n = new ArrayList<>();
			int l = 0;
			int i, j;
			String[] line;
			while(sc.hasNext()) {
				t = sc.nextLine();
				l++;
				line = t.trim().split("\\s+");
				for(i = 0; i < line.length; i++) {
					if(l == 1 && i == 0) {
						n = new ArrayList<String>();
						n.add(line[i]);
						n.add("" + l);
						n.add("" + i);
//							System.out.print(n);
						list.add(n);
					}
					for(j = 0; j < list.size(); j++) {
						
						if(line[i].equalsIgnoreCase(list.get(j).get(0))) {
							list.get(j).add("" + l);
							list.get(j).add("" + i);
						}
						else {
							n = new ArrayList<String>();
							n.add(line[i]);
							n.add("" + l);
							n.add("" + i);
							list.add(n);
						}
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter two files : ");
		
		sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		reader r1 = new reader(s1);
		reader r2 = new reader(s2);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		int i, j, k;
		
		for(i = 0; i < r1.list.size(); i++) {
			for(j = 0; j < r2.list.size(); j++) {
				if(r1.list.get(i).get(0).equalsIgnoreCase(r2.list.get(j).get(0))) {
					System.out.print(r1.list.get(i).get(0) + ": length " + r1.list.get(i).get(0).length() + ", appeared in, ");
					for(k = 1; k < r1.list.get(i).size(); k+= 2) {
						System.out.print("line " + r1.list.get(i).get(k) + " position " + r1.list.get(i).get(k + 1) + ", ");
					}
					System.out.print("in " + s1 + " and, ");
					for(k = 1; k < r2.list.get(j).size(); k+= 2) {
						System.out.print("line " + r2.list.get(j).get(k) + " position " + r2.list.get(j).get(k + 1) + ", ");
					}
					System.out.print("in " + s2 + ".\n");
				}
			}
		}
		
	}

}
