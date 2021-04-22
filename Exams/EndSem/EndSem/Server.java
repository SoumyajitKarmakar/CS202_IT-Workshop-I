package EndSem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;







public class Server {

	public static class Student implements Serializable{
		String name;
		int roll;
		int age;
		
		public Student(String Name, int Roll, int Age)  {
			this.name = Name;
			this.roll = Roll;
			this.age = Age;
		}
		@Override
	    public String toString() {
	        return "Name:" + name + "\nRoll No.: " + roll +"\nAge: " + age;
	    }
		
		public void writeToFile(Student s) {
			
			try {
				FileOutputStream f = new FileOutputStream(new File("Student.ser"));
				ObjectOutputStream o = new ObjectOutputStream(f);
				
				
				o.writeObject(s);
				

				o.close();
				f.close();

			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				System.out.println("Error initializing stream");
			}
		}
		
		public Student readTheFile_Name(String n) {
			int i;
			
			Student s = null;
			Student d;
			
			try {
				
				FileInputStream fi = new FileInputStream(new File("Student.ser"));
				ObjectInputStream oi = new ObjectInputStream(fi);
				
				
				for(i = 0; i < 10; i++) {
					d = (Student) oi.readObject();
					if(d.name.equalsIgnoreCase(n)) {
						s = d;
						break;
					}
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
			
			return s;
		}
		
		public Student readTheFile_Roll(int n) {
			int i;
			
			Student s = null;
			Student d;
			
			try {
				
				FileInputStream fi = new FileInputStream(new File("Student.ser"));
				ObjectInputStream oi = new ObjectInputStream(fi);
				
				
				for(i = 0; i < 10; i++) {
					d = (Student) oi.readObject();
					if(d.roll == n) {
						s = d;
						break;
					}
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
			
			return s;
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ServerSocket server = new ServerSocket(1234);
		Socket connection = server.accept();
		
		ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
//		ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
		
		
		Student Cli;
		
		while(true){
			Cli = (Student)input.readObject();
			Cli.writeToFile(Cli);
			
		}
		
		
//		strCli = input.readUTF();
//		
//		output.writeUTF(strSer);
//		output.flush();
		
//		input.close();
//		connection.close();
//		server.close();
	}

}
