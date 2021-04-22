package assignment4;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Ques1 {
	abstract public static class Employee {
		String name;
		Date dateOfBirth;
		int empID;
		Date dateOfJoining;
		
		Employee(){
			name = "NA";
			empID = 0;
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	        	dateOfBirth = formatter.parse("01/01/1950");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
	        	dateOfJoining = formatter.parse("01/01/1950");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		abstract public void setDetails();
		
		public void showDetails(){
		    System.out.println("name "+ name);
		    System.out.println("dob "+ dateOfBirth);
		    System.out.println("ID "+ empID);
		    System.out.println("doj "+ dateOfJoining);
		  }
	}
	
	public static class Staff extends Employee {
		String sectionName;
		String designation;
		
		Staff(){
			sectionName = "NA";
			designation = "NA";
		}
		
		public int sameDesig(Staff s1) {
			if(designation.equals(s1.designation)) {
				return 1;
			}
			return 0;
		}
		
		public void setDetails() {
			Scanner sc = new Scanner(System.in);
			String s;
			System.out.println("Name ");
			s = sc.nextLine();
			name = s;
			System.out.println("dateOfBirth ");
			s = sc.nextLine();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	        	dateOfBirth = formatter.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("ID ");
	        s = sc.nextLine();
	        empID = Integer.parseInt(s);
	        System.out.println("dateOfJoining ");
	        s = sc.nextLine();
	        try {
	        	dateOfJoining = formatter.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("Section Name ");
	        s = sc.nextLine();
	        sectionName = s;
	        System.out.println("designation ");
	        s = sc.nextLine();
	        designation = s;
	        sc.close();
		}
		
		public void showDetails(){
		    super.showDetails();
		    System.out.println("sectionName "+ sectionName);
		    System.out.println("designation "+ designation);
		    System.out.println("");
		  }
	}
	
	public static class Faculty extends Employee {
		String departmentName;
		int noOfPublications;
		
		Faculty(){
		    noOfPublications=0;
		    departmentName="NA";
		  }
		
		public int sameDepart(Faculty f1) {
			if(departmentName.equals(f1.departmentName)) {
				return 1;
			}
			return 0;
		}
		public void setDetails() {
			Scanner sc = new Scanner(System.in);
			String s;
			System.out.println("Name ");
			s = sc.nextLine();
			name = s;
			System.out.println("dateOfBirth ");
			s = sc.nextLine();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	        	dateOfBirth = formatter.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("ID ");
	        s = sc.nextLine();
	        empID = Integer.parseInt(s);
	        System.out.println("dateOfJoining ");
	        s = sc.nextLine();
	        try {
	        	dateOfJoining = formatter.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("departmentName ");
	        s = sc.nextLine();
	        departmentName = s;
	        System.out.println("noOfPublications ");
	        s = sc.nextLine();
	        noOfPublications = Integer.parseInt(s);
	        sc.close();
		}
		
		public void showDetails(){
		    super.showDetails();
		    System.out.println("departmentName "+ departmentName);
		    System.out.println("noOfPublications "+noOfPublications);
		    System.out.println("");
		  }
	}
	
	public static class TempEmployee extends Employee {
		String sectionName;
		Date lastWorkingDay;
		
		TempEmployee(){
			sectionName = "NA";
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	        	lastWorkingDay = formatter.parse("01/01/1950");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void totalDays() {
			int diff = (int)( (lastWorkingDay.getTime() - dateOfJoining.getTime()) / (1000 * 60 * 60 * 24) );
			System.out.print(diff);
		}
		public void setDetails() {
			Scanner sc = new Scanner(System.in);
			String s;
			System.out.println("Name ");
			s = sc.nextLine();
			name = s;
			System.out.println("dateOfBirth ");
			s = sc.nextLine();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	        	dateOfBirth = formatter.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("ID ");
	        s = sc.nextLine();
	        empID = Integer.parseInt(s);
	        System.out.println("dateOfJoining ");
	        s = sc.nextLine();
	        try {
	        	dateOfJoining = formatter.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("sectionName ");
	        s = sc.nextLine();
	        sectionName = s;
	        System.out.println("lastWorkingDay ");
	        s = sc.nextLine();
	        try {
	        	lastWorkingDay = formatter.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        sc.close();
		}
		
		public void showDetails(){
		    super.showDetails();
		    System.out.println("sectionName "+ sectionName);
		    System.out.println("lastWorkingDay "+ lastWorkingDay);
		    System.out.println("");
		  }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    Faculty[] fac=new Faculty[5];
	    TempEmployee[] tem=new TempEmployee[5];
	    Staff[] sta=new Staff[5];
	    for(int i = 0; i < 5; i++) {
	    	fac[i]=new Faculty();
		    tem[i]=new TempEmployee();
		    sta[i]=new Staff();
	    }
	    int a = 0, b = 0, c = 0;
	    int i = 1, j, k;
	    while(i != 0) {
	    	System.out.println("Enter your choice(10 for help,0 for exit)\n");
	    	i = sc.nextInt();
	    	switch(i){
	        case 0:
	        	System.out.println("Exit");
	        	break;
	        case 1:
	        	System.out.println("Enter 1/2/3 for setting details for Staff/Faculty/TemporaryEmployee");
	        	j = sc.nextInt();
	        	if(j == 1) {
	        		sta[a++].setDetails();
	        	}
	        	else if(j == 2) {
	        		fac[b++].setDetails();
	        	}
	        	else if(j == 3) {
	        		tem[c++].setDetails();
	        	}
	        	break;
	        case 2:
	        	System.out.println("Enter joining year to show details");
	        	j = sc.nextInt();
	        	Calendar cal = Calendar.getInstance();
	        	for(k = 0; k < 5; k++) {
	        		cal.setTime(sta[k].dateOfJoining);
	        		if(cal.get(Calendar.YEAR) == j)
	        			sta[k].showDetails();
	        		cal.setTime(fac[k].dateOfJoining);
	        		if(cal.get(Calendar.YEAR) == j)
	        			fac[k].showDetails();
	        		cal.setTime(tem[k].dateOfJoining);
	        		if(cal.get(Calendar.YEAR) == j)
	        			tem[k].showDetails();
	        	}
	        	break;
	        case 3:
	        	System.out.println("Enter ID to show details");
	        	j = sc.nextInt();
	        	for(k = 0; k < 5; k++) {
	        		if(sta[k].empID == j)
	        			sta[k].showDetails();
	        		if(fac[k].empID == j)
	        			fac[k].showDetails();
	        		if(tem[k].empID == j)
	        			tem[k].showDetails();
	        	}
	        	break;
	        case 4:
	        	System.out.println("Enter the index of 2 staffs to compare their designation");
	        	j = sc.nextInt();
	        	k = sc.nextInt();
	        	sta[j].sameDesig(sta[k]);
	        	break;
	        case 5:
	        	System.out.println("Enter the index of 2 faculties to compare their department");
	        	j = sc.nextInt();
	        	k = sc.nextInt();
	        	fac[j].sameDepart(fac[k]);
	        	break;
	        case 10:
	        	System.out.println("1:Set Details\n2:Show Details according to joining year\n3:Show Details by ID\n4:check if 2 staff have same designation\n5:if 2 faculty have same department");
	            break;
	        default:
	        	System.out.println("Wrong choice.");
	        }
	    }
	    sc.close();
	}

}
