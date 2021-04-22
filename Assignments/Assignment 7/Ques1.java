import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ques1 {
	
	static Scanner sc = new Scanner(System.in);

	public static class Person implements Serializable{
		String Fname;
		String Lname;
		String PAN;
		int pin;
		String email;
		
		Person(String F, String L, String P, int p, String e){
			Fname = F;
			Lname = L;
			PAN = P;
			pin = p;
			email = e;
		}
	}
	
	public static class Student extends Person{
		int RollNo;
		
		Student(String F, String L, String P, int p, String e, int R){
			super(F, L, P, p, e);
			RollNo = R;
		}
		
		public void validate(){
			try {
				if(!Fname.matches("[A-Z][a-z]*")) {
					throw new Exception();
				}
				
				if(!Lname.matches("[A-Z][a-z]*")) {
					throw new Exception();
				}
				
				if(!PAN.matches("[A-Z0-9]*")) {
					throw new Exception();
				}
				
				String q = Integer.toString(RollNo);
				if(!q.matches("\\d{3}")) {
					throw new Exception();
				}
				
				String p = Integer.toString(pin);
				if(!p.matches("\\d{6}")) {
					throw new Exception();
				}
				
				String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
				 
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(email);
				if(!matcher.matches()) {
					throw new Exception();
				}

			}
			catch(Exception e) {
				System.out.print("Invalid input. First and last name must start with a capital letter followed by small letters. PAN must have 10 characters, capital letters or digits. PIN must be 6 digits long. Email must be alphanumeric, must contain @ followed by a domain name. Roll No must be 3 digits long. \n");
			}
			
		}
	}
	
	public static class Emp extends Person{
		int EmpID;
		
		Emp(String F, String L, String P, int p, String e, int E){
			super(F, L, P, p, e);
			EmpID = E;
		}
		
		public void validate(){
		
			try {
				if(!Fname.matches("[A-Z][a-z]*")) {
					throw new Exception();
				}
				
				if(!Lname.matches("[A-Z][a-z]*")) {
					throw new Exception();
				}
				
				if(!PAN.matches("[A-Z0-9]*")) {
					throw new Exception();
				}
				
				String q = Integer.toString(EmpID);
				if(!q.matches("\\d{4}")) {
					throw new Exception();
				}
				
				String p = Integer.toString(pin);
				if(!p.matches("\\d{6}")) {
					throw new Exception();
				}
				
				String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
				 
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(email);
				if(!matcher.matches()) {
					throw new Exception();
				}

			}
			catch(Exception e) {
				System.out.print("Invalid input. First and last name must start with a capital letter followed by small letters. PAN must have 10 characters, capital letters or digits. PIN must be 6 digits long. Email must be alphanumeric, must contain @ followed by a domain name. ID must be 4 digits long. \n");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int j = 1, i, p, R, E;
		String F, L, P, e;
		
		while(j == 1) {
			System.out.print("Enter 1 for student, 2 for emp, 3 to exit");
			i = Integer.parseInt(sc.nextLine());
			if(i == 1) {
				System.out.print("First Name : ");
				F = sc.nextLine();
				System.out.print("Last Name : ");
				L = sc.nextLine();
				System.out.print("PAN : ");
				P = sc.nextLine();
				System.out.print("Pin : ");
				p = Integer.parseInt(sc.nextLine());
				System.out.print("Email : ");
				e = sc.nextLine();
				System.out.print("Roll : ");
				R = Integer.parseInt(sc.nextLine());
				
				Student stu = new Student(F, L, P, p, e, R);
				stu.validate();
			}
			else if(i == 2) {
				System.out.print("First Name : ");
				F = sc.nextLine();
				System.out.print("Last Name : ");
				L = sc.nextLine();
				System.out.print("PAN : ");
				P = sc.nextLine();
				System.out.print("Pin : ");
				p = Integer.parseInt(sc.nextLine());
				System.out.print("Email : ");
				e = sc.nextLine();
				System.out.print("ID : ");
				E = Integer.parseInt(sc.nextLine());
				
				Emp emp = new Emp(F, L, P, p, e, E);
				emp.validate();
			}
			else if(i == 3) {
				j = 0;
			}
		}
		sc.close();
		
		
	}

}
