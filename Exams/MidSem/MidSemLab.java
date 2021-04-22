package MidSem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class MidSemLab {
	
	public static Scanner sc = new Scanner(System.in);
	
	abstract public static class User{
		int userID;
		String name;
		Date dateOfBirth;
		String Address;
		int PAN;
		
		//abstract public void setDetails();
	}
	
	public static class Admin extends User{
		Date dateOfJoining;
		int salary;
		int permissibleOperations;
		
		
	}
	
	public static class General extends User{
		Date dateOfJoining;
		int salary;
		int dutyHourPerDay;
	}
	
	abstract public static class Item{
		int itemCode;
		int price;
		int AvailableQty;
		
		abstract public void setDetails();
		abstract public void display();
		
		abstract public void addNewStock(Item i);
	}
	
	public static class FoodItem extends Item{
		Date dateOfExpiry;
		
		public void addNewStock(Item i) {
			
    		i.setDetails();
    		item.add(i);
		}
		
		public void display() {
			System.out.println(this.itemCode);
			System.out.println(this.price);
			System.out.println(this.AvailableQty);
			System.out.println(this.dateOfExpiry);
		}
		
		public void setDetails() {
			String s;
			System.out.println("itemCode : ");
			s = sc.nextLine();
			itemCode = Integer.parseInt(s);
			System.out.println("price : ");
			s = sc.nextLine();
			price = Integer.parseInt(s);
			System.out.println("AvailableQty : ");
			s = sc.nextLine();
			AvailableQty = Integer.parseInt(s);
			System.out.println("DoE : ");
			s = sc.nextLine();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	        	dateOfExpiry = formatter.parse("s");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static class NonFoodItem extends Item{
		int returnCount;
		
		public void addNewStock(Item i) {
			
    		i.setDetails();
    		item.add(i);
		}
		
		public void display() {
			System.out.println(this.itemCode);
			System.out.println(this.price);
			System.out.println(this.AvailableQty);
			System.out.println(this.returnCount);
		}
		
		public void setDetails() {
			String s;
			System.out.println("itemCode : ");
			s = sc.nextLine();
			itemCode = Integer.parseInt(s);
			System.out.println("price : ");
			s = sc.nextLine();
			price = Integer.parseInt(s);
			System.out.println("AvailableQty : ");
			s = sc.nextLine();
			AvailableQty = Integer.parseInt(s);
			System.out.println("DoE : ");
			s = sc.nextLine();
			returnCount = Integer.parseInt(s);
		}
	}
	
	public static class Sell{
		Date dateOfSell;
		int itemCode;
		int quantity;
		int totalAmount;
		
		public void displayStock(int itemCode) {
			
		}
	}
	
	public static class Return{
		Date dateOfReturn;
		int itemCode;
		int quantity;
		int returnAmount;
		
	}

	static ArrayList<Item> item = new ArrayList<Item>();
	static ArrayList<Sell> sell = new ArrayList<Sell>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int i = -1, o = 0, j = 0, k = 0, l = 0;
		String s;
		
		FoodItem f = new FoodItem();
		NonFoodItem nf = new NonFoodItem();
		
//		Sell sell = new Sell();
//		Return ret = new Return();
		
		String[] admin = {"Manojit", "Abhay", "Ravi"};
		String[] general = {"Manojit", "Chintu", "Ravi"};
		
		
		if(args[0].compareTo("Admin") == 0) {
			for(k = 0; k < 3; k++) {
				if(admin[k].compareTo(args[1]) == 0) {
					i = 0;
				}
			}
		}
		if(args[0].compareTo("General") == 0) {
			for(k = 0; k < 3; k++) {
				if(general[k].compareTo(args[1]) == 0) {
					i = 1;
				}
			}
		}
		
		
		
		while(i == 0) {
			System.out.println("Enter your choice(1 to add, 2 to remove,0 to exit)\n");
			s = sc.nextLine();
	    	o = Integer.parseInt(s);
	    	switch(o){
	        case 0:
	        	System.out.println("Exit");
	        	i = -1;
	        	break;
	        case 1:
	        	System.out.println("Enter 1/2 for setting details for Food/NonFood");
	        	s = sc.nextLine();
	        	j = Integer.parseInt(s);
	        	switch(j) {
	        	case 1:
	        		FoodItem a = new FoodItem();
	        		f.addNewStock(a);
	        		break;
	        		
	        	case 2:
	        		NonFoodItem b = new NonFoodItem();
	        		nf.addNewStock(b);
	        		break;
	        	}
	        	break;
	        case 2:
	        	System.out.println("Enter itemCode : ");
        		s = sc.nextLine();
        		k = Integer.parseInt(s);
        		
        		for(l = 0; l < item.size(); l++) {
        			if(item.get(l).itemCode == k)
        				break;
        		}
        		item.remove(l);
        		break;
	        case 3:
	        	System.out.println("Enter itemCode : ");
        		s = sc.nextLine();
        		k = Integer.parseInt(s);
        		for(l = 0; l < item.size(); l++) {
        			if(item.get(l).itemCode == k)
        				break;
        		}
        		System.out.println("Enter 1/2 for updating price/availavleQty");
        		s = sc.nextLine();
	        	j = Integer.parseInt(s);
	        	switch(j) {
	        		case 1:
	        			System.out.println("Enter new price : ");
		        		s = sc.nextLine();
		        		k = Integer.parseInt(s);
		        		//Item item.get(l)
	        	}
	    	}
		}
		
		while(i == 1) {
			System.out.println("Enter your choice(1 to disply,0 for exit)\n");
			s = sc.nextLine();
	    	o = Integer.parseInt(s);
	    	switch(o){
	        case 0:
	        	System.out.println("Exit");
	        	i = -1;
	        	break;
	        case 1:
	        	System.out.println("Enter itemCode : ");
        		s = sc.nextLine();
        		k = Integer.parseInt(s);
        		for(l = 0; l < item.size(); l++) {
        			if(item.get(l).itemCode == k)
        				break;
        		}
        		item.get(l).display();
	    	}
		}
	}

}
