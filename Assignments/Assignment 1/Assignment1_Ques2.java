import java.util.*;
public class Assignment1_Ques2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number for additon - ");  
        int a = sc.nextInt();  
        System.out.println("Enter second number for additon - ");  
        int b = sc.nextInt();
        int c = a + b;
        System.out.println(c);
        System.out.println("Enter first number for subtraction - ");
        int d = sc.nextInt();
        System.out.println("Enter second number for subtraction - ");
        int e = sc.nextInt();
        int f = d - e;
        System.out.println(f);
        System.out.println("The addition of " + a + " and " + b + " is " + c + " and when " + e + " is subtracted from " + d + ", result is " + f);
        sc.close();
    }
}