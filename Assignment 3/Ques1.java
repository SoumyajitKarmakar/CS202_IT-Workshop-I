package assignment3;

import java.util.*;

public class Ques1 {
	public static class G {
		static int number = 0;
	}
	
	public static void totalAccounts() {
		System.out.print(G.number);
	}
	
	public static class Account {
		int accountNumber;
		String accountType;
		String serviceBranchIFSC;
		float minimumBalance;
		float availableBalance;
		int customerID;
		String customerName;
		
		public void setDetails() {
			Scanner sc = new Scanner(System.in);
			String d;
			System.out.println("accountType : ");
			d = sc.nextLine();
			accountType = d;
			System.out.println("serviceBranchIFSC : ");
			d = sc.nextLine();
			serviceBranchIFSC = d;
			System.out.println("minimumBalance : ");
			d = sc.nextLine();
			minimumBalance = Float.parseFloat(d);
			System.out.println("availableBalance : ");
			d = sc.nextLine();
			availableBalance = Float.parseFloat(d);
			System.out.println("customerID : ");
			d = sc.nextLine();
			customerID = Integer.parseInt(d);
			System.out.println("customerName : ");
			d = sc.nextLine();
			customerName = d;
			sc.close();
		}
		
		public String getDetails(int accNum) {
			return customerName;
		}
		
		public float getBalance(int accNum) {
			return availableBalance;
		}
		
		public void deposite(int accNum, float amt) {
			availableBalance += amt;
		}
		
		public void withdraw(int accNum, float amt) {
			if(availableBalance - amt > 0) {
				availableBalance -= amt;
			}
			else {
				System.out.print("You cannot withdraw more than what you have.");
			}
		}
		
		
		
		Account(){
			accountNumber = G.number;
			G.number += 1;
			accountType = "0";
			serviceBranchIFSC = "0";
			minimumBalance = 0;
			availableBalance = 0;
			customerID = 0;
			customerName = "0";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a[] = new Account[10];
		int i;
		for(i = 0; i < 5; i++) {
			a[i] = new Account();
		}
		a[0].accountType = "Savings";
		a[0].serviceBranchIFSC = "SBI";
		a[0].minimumBalance = 20.00f;
		a[0].availableBalance = 100.50f;
		a[0].customerID = 9;
		a[0].customerName = "A";
		
		a[1].accountType = "Savings";
		a[1].serviceBranchIFSC = "SBI";
		a[1].minimumBalance = 20.00f;
		a[1].availableBalance = 100.50f;
		a[1].customerID = 19;
		a[1].customerName = "B";
		
		a[2].accountType = "Savings";
		a[2].serviceBranchIFSC = "SBI";
		a[2].minimumBalance = 20.00f;
		a[2].availableBalance = 100.50f;
		a[2].customerID = 4;
		a[2].customerName = "C";
		
		a[3].accountType = "Savings";
		a[3].serviceBranchIFSC = "SBI";
		a[3].minimumBalance = 20.00f;
		a[3].availableBalance = 100.50f;
		a[3].customerID = 75;
		a[3].customerName = "D";
		
		a[4].accountType = "Savings";
		a[4].serviceBranchIFSC = "SBI";
		a[4].minimumBalance = 20.00f;
		a[4].availableBalance = 100.50f;
		a[4].customerID = 35;
		a[4].customerName = "E";
		
		Scanner j = new Scanner(System.in);
		int h, k, o, q;
		System.out.print("Press the number corresponding to the operation you want to perform :\n1. Set Details\n2. Get Details\n3. Deposite\n4. Withdraw\n5. Number of Accounts\n6. Exit\n");
		while(true) {
			h = Integer.parseInt(j.nextLine());
			if(h == 1) {
				a[i] = new Account();
				a[i].setDetails();
				i++;
			}
			else if(h == 2) {
				System.out.print("Enter acc number : ");
				k = Integer.parseInt(j.nextLine());
				for(o = 0; o < 10; o++) {
					if(a[o].accountNumber == k) {
						break;
					}
				}
				a[o].getDetails(k);
			}
			else if(h == 3) {
				System.out.print("Enter acc number : ");
				k = Integer.parseInt(j.nextLine());
				for(o = 0; o < 10; o++) {
					if(a[o].accountNumber == k) {
						break;
					}
				}
				System.out.print("Enter amount : ");
				q = Integer.parseInt(j.nextLine());
				a[o].deposite(k, q);
			}
			else if(h == 4) {
				System.out.print("Enter acc number : ");
				k = Integer.parseInt(j.nextLine());
				for(o = 0; o < 10; o++) {
					if(a[o].accountNumber == k) {
						break;
					}
				}
				System.out.print("Enter amount : ");
				q = Integer.parseInt(j.nextLine());
				a[o].withdraw(k, q);
			}
			else if(h == 5) {
				break;
			}
			else if(h == 6) {
				totalAccounts();
			}
		}
		j.close();
	}

}
