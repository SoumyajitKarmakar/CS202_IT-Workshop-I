

import java.io.*;
import java.util.ArrayList;

public class Ques2 {

	public static class Student implements Serializable{
		String fname;
		String lname;
		int roll;
		int cpi;
		int age;
		
		Student(String fname, String lname, int roll, int cpi, int age){
	        this.fname = fname;
	        this.lname = lname;
	        this.roll = roll;
	        this.cpi = cpi;
	        this.age = age;
	    }
		
		@Override
	    public String toString() {
	        return "First name:" + fname +"\nLast name: " + lname + "\nRoll No.: " + roll + "\nCPI: " + cpi + "\nAge: " + age;
	    }
		
		public void writeAFile(Student[] list) {
			int i;
			try {
				FileOutputStream f = new FileOutputStream(new File("Student.ser"));
				ObjectOutputStream o = new ObjectOutputStream(f);
				
				for(i = 0; i < 10; i++) {
					o.writeObject(list[i]);
				}

				o.close();
				f.close();

			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				System.out.println("Error initializing stream");
			}
		}
		
		public ArrayList<Student> readTheFile() {
			int i;
			ArrayList<Student> list = new ArrayList<Student>();
			Student s;
			
			try {
				
				FileInputStream fi = new FileInputStream(new File("Student.ser"));
				ObjectInputStream oi = new ObjectInputStream(fi);
				
				for(i = 0; i < 10; i++) {
					s = (Student) oi.readObject();
					list.add(s);
				}
				
				oi.close();
				fi.close();
				

			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				System.out.println("Error initializing stream");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
		public void displayNameM(ArrayList<Student> list) {
			int i, l = list.size();
			for(i = 0; i < l; i++) {
				if(list.get(i).fname.matches("M[a-z]*")) {
					System.out.println(list.get(i));
				}
			}
		}
		
		public void displayAge18(ArrayList<Student> list) {
			int i, l = list.size();
			for(i = 0; i < l; i++) {
				if(list.get(i).age < 18) {
					System.out.println(list.get(i));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] list = new Student[10];
		
		int i;
		for(i = 0; i < 10; i++) {
			list[i] = new Student("Masd", "jkl", 1, 2, 3);
		}
		
		Student s = new Student("a", "b", 9, 8, 7);
		s.writeAFile(list);
		ArrayList<Student> stu = s.readTheFile();
		s.displayNameM(stu);
		s.displayAge18(stu);
		
	}


}
