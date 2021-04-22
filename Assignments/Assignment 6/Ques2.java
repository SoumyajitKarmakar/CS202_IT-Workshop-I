package assignment6;

public class Ques2 {
	public static void main(String[] args) {
		if(args.length != 0 && args[0].compareTo("Divide") == 0) {
			if(args.length == 1) {
				System.out.print("Error : No numbers to perform division");
			}
			else if(args.length == 2) {
				System.out.print("Error : Divide requires two numbers");
			}
			else if(Integer.parseInt(args[2]) == 0) {
				System.out.print("Error : Division by zero not possible");
			}
			else if(args.length == 3) {
				if(Integer.parseInt(args[1]) % Integer.parseInt(args[2]) != 0) {
					System.out.print("Not divisible");
				}
				else {
					System.out.print(Integer.parseInt(args[1]) / Integer.parseInt(args[2]));
				}
			}
		}
		
	}

}
