package assignment6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ques1 {
	
	public static Scanner sc = new Scanner(System.in);
	
	abstract public static class User{
		String name;
		int age;
		final int userNumber;
		
		User(int n){
			userNumber = n;
		}
		
		public final void displayUserNumber() {
			System.out.println(userNumber);
		}
		
		//@Overloading
		public final void displayUserNumber(int n) {
			if(n == 0) {
				System.out.println(name);
				System.out.println(userNumber);
			}
			else {
				System.out.println(age);
				System.out.println(userNumber);
			}
		}
		
		abstract public void getDetails();
	}
	
	public static class Student extends User{
		final int rollNo;
		int Class;
		
		Student(int n, int m){
			super(n);
			rollNo = m;
		}
		
		public final void displayRollNo() {
			System.out.println(name);
			System.out.println(Class);
		}
		
		//@Overloading
		public final void displayRollNo(int n) {
			if(n == 0) {
				System.out.println(name);
				System.out.println(Class);
				System.out.println(age);
			}
			else {
				System.out.println(name);
				System.out.println(Class);
				System.out.println(age);
				System.out.println(userNumber);
			}
		}
		
		//@Overriding
		public void getDetails() {
			//Scanner sc = new Scanner(System.in);
			System.out.println("Enter name : ");
			String s = sc.nextLine();
			name = s;
			System.out.println("Enter age");
			s = sc.nextLine();
			age = Integer.parseInt(s);
			System.out.println("Enter class");
			s = sc.nextLine();
			Class = Integer.parseInt(s);
			//sc.close();
		}
	}
	
	public static class Faculty extends User{
		final int facID;
		int departNo;
		
		Faculty(int n, int m){
			super(n);
			facID = m;
		}
		
		public final void displayFacID() {
			System.out.println(name);
			System.out.println(departNo);
		}
		
		//@Overloading
		public final void displayFacID(int n) {
			if(n == 0) {
				System.out.println(name);
				System.out.println(departNo);
				System.out.println(age);
			}
			else {
				System.out.println(name);
				System.out.println(departNo);
				System.out.println(age);
				System.out.println(userNumber);
			}
		}
		
		//@Overriding
		public void getDetails() {
			//Scanner sc = new Scanner(System.in);
			System.out.println("Enter name : ");
			String s = sc.nextLine();
			name = s;
			System.out.println("Enter age : ");
			s = sc.nextLine();
			age = Integer.parseInt(s);
			System.out.println("Enter department number");
			s = sc.nextLine();
			departNo = Integer.parseInt(s);
			//sc.close();
		}
	}
	
	public static class Staff extends User{
		final int staID;
		int subNo;
		
		Staff(int n, int m){
			super(n);
			staID = m;
		}
		
		public final void displayStaID() {
			System.out.println(name);
			System.out.println(subNo);
		}
		
		//@Overloading
		public final void displayStaID(int n) {
			if(n == 0) {
				System.out.println(name);
				System.out.println(subNo);
				System.out.println(age);
			}
			else {
				System.out.println(name);
				System.out.println(subNo);
				System.out.println(age);
				System.out.println(userNumber);
			}
		}
		
		//@Overriding
		public void getDetails() {
			//Scanner sc = new Scanner(System.in);
			System.out.println("Enter name : ");
			String s = sc.nextLine();
			name = s;
			System.out.println("Enter age : ");
			s = sc.nextLine();
			age = Integer.parseInt(s);
			System.out.println("Enter subject number");
			s = sc.nextLine();
			subNo = Integer.parseInt(s);
			//sc.close();
		}
	}
	
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		String s;
		int q = 0,i = -1, j = -1, k = -1, l = 0, m = 0, o = -1;
		int a = 0, b = 0, c = 0;
		int numUser = 1;
		
		ArrayList<Student> stuList = new ArrayList<Student>();
		ArrayList<Faculty> facList = new ArrayList<Faculty>();
		ArrayList<Staff> staList = new ArrayList<Staff>();
		
		Student stu;
		Faculty fac;
		Staff sta;
	    
		while(q == 0) {
			System.out.println("Press 1 for admin control\nPress 2 for non-admin control\nPress 3 to exit");
		    s = sc.nextLine();
		    i = Integer.parseInt(s);
		    
		    while(i == 1) {
		    	System.out.println("Enter your choice(10 for help,0 for exit)\n");
		    	s = sc.nextLine();
		    	o = Integer.parseInt(s);
		    	switch(o){
		        case 0:
		        	System.out.println("Exit");
		        	i = -1;
		        	break;
		        case 1:
		        	System.out.println("Enter 1/2/3 for setting details for Student/Faculty/Staff");
		        	s = sc.nextLine();
		        	j = Integer.parseInt(s);
		        	switch(j) {
		        	case 1:
		        		stu = new Student(numUser++, 1 + a++);
		        		stu.getDetails();
		        		stuList.add(stu);
		        		break;
		        	case 2:
		        		fac = new Faculty(numUser++, 1 + b++);
		        		fac.getDetails();
		        		facList.add(fac);
		        		break;
		        	case 3:
		        		sta = new Staff(numUser++, 1 + c++);
		        		sta.getDetails();
		        		staList.add(sta);
		        		break;
		        	default:
			        	System.out.println("Wrong choice");
		        	}
		        	break;
		        case 2:
		        	System.out.println("Enter 1/2/3 for deleting Student/Faculty/Staff");
		        	s = sc.nextLine();
		        	j = Integer.parseInt(s);
		        	switch(j) {
		        	case 1:
		        		System.out.println("Enter roll number : ");
		        		s = sc.nextLine();
		        		k = Integer.parseInt(s); 
		        		for(l = 0; l < stuList.size(); l++) {
		        			if(stuList.get(l).rollNo == k)
		        				break;
		        		}
		        		stuList.remove(l);
		        		break;
		        	case 2:
		        		System.out.println("Enter faculty ID : ");
		        		s = sc.nextLine();
		        		k = Integer.parseInt(s);
		        		for(l = 0; l < facList.size(); l++) {
		        			if(facList.get(l).facID == k)
		        				break;
		        		}
		        		facList.remove(l);
		        		break;
		        	case 3:
		        		System.out.println("Enter staff ID : ");
		        		s = sc.nextLine();
		        		k = Integer.parseInt(s);
		        		for(l = 0; l < 5; l++) {
		        			if(staList.get(l).staID == k)
		        				break;
		        		}
		        		staList.remove(l);
		        		break;
		        	default:
			        	System.out.println("Wrong choice");
		        	}
		        	break;
		        case 10:
		        	System.out.println("Press 0 to exit\n1 to set details\n2 to delete details\n10 to open help again\n");
		        	break;
		        default:
		        	System.out.println("Wrong choice");
		    	}
		    }
		    
		    while(i == 2) {
		    	System.out.println("Enter your choice(10 for help,0 for exit)\n");
		    	s = sc.nextLine();
		    	o = Integer.parseInt(s);
		    	switch(o){
		    	case 0:
		    		System.out.println("Exit");
		    		i = -1;
		        	break;
		        case 1:
		        	System.out.println("Enter 1/2/3 for viewing details for Student/Faculty/Staff");
		        	s = sc.nextLine();
		        	j = Integer.parseInt(s);
		        	System.out.println("Additional command : ");
		        	s = sc.nextLine();
		        	m = Integer.parseInt(s);
		        	switch(j) {
		        	case 1:
		        		System.out.println("Enter roll number : ");
		        		s = sc.nextLine();
		        		k = Integer.parseInt(s);
		        		for(l = 0; l < stuList.size(); l++) {
		        			if(stuList.get(l).rollNo == k)
		        				break;
		        		}
		        		if(m == -1)
		        			stuList.get(l).displayRollNo();
		        		if(m == 0)
		        			stuList.get(l).displayRollNo(0);
		        		if(m == 1)
		        			stuList.get(l).displayRollNo(1);
		        		break;
		        	case 2:
		        		System.out.println("Enter faculty ID : ");
		        		s = sc.nextLine();
		        		k = Integer.parseInt(s);
		        		for(l = 0; l < facList.size(); l++) {
		        			if(facList.get(l).facID == k)
		        				break;
		        		}
		        		if(m == -1)
		        			facList.get(l).displayFacID();
		        		if(m == 0)
		        			facList.get(l).displayFacID(0);
		        		if(m == 1)
		        			facList.get(l).displayFacID(1);
		        		break;
		        	case 3:
		        		System.out.println("Enter staff ID : ");
		        		s = sc.nextLine();
		        		k = Integer.parseInt(s);
		        		for(l = 0; l < 5; l++) {
		        			if(staList.get(l).staID == k)
		        				break;
		        		}
		        		if(m == -1)
		        			staList.get(l).displayStaID();
		        		if(m == 0)
		        			staList.get(l).displayStaID(0);
		        		if(m == 1)
		        			staList.get(l).displayStaID(1);
		        		break;
		        	default:
			        	System.out.println("Wrong choice");
		        	}
		        	break;
		        case 10:
		        	System.out.println("Press 0 to exit\n1 to view name and respective class, department or subject number respectively\n \t "
		        			+ "In the additional command press 0 if you wish to see the age or 1 if you wish to see age as well as the user number or -1 otherwise");
		        	break;
		        default:
		        	System.out.println("Wrong choice");
		    	}
		    }
		    if(i == 3) {
		    	q = 1;
		    }
		}
	    sc.close();
	}

}
