package assignment2;

import java.util.Scanner;

public class Ques2 {
	
	public static int[] takeInputs(int n) {
		Scanner sc = new Scanner(System.in);
		int i;
		int arr[] = new int[n];
		System.out.print("\n");
		for(i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		return arr;
	}
	
	public static int[] evenElements(int[] numbers, int n) {
        int[] arr = new int[n];
        int length = 0;

        for (int a : numbers) {
            if (a % 2 == 0) {
                arr[length] = a;
                length += 1;
            }
        }

        return arr;
    }
	
//	public static int[] evenElements(int a[], int n) {
//		int arr[] = new int[n];
//		int i, j = 0;
//		for(i = 0; i < n; i++) {
//			if(a[i]%2 == 0) {
//				arr[j++] = a[i];
//			}
//		}
//		return a;
//	}
	
	public static int[] reverse(int a[], int n) {
		int[] b = new int[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        }
        return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of inputs");
		int n = sc.nextInt();
		int arr[] = new int[n];
		arr = takeInputs(n);
		System.out.println("You entered : ");
		for (int k = 0; k < n; k++) { 
            System.out.print(arr[k] + " "); 
        } 
		int arrE[] = new int[n];
		arrE = evenElements(arr, n);
		System.out.println("\nEven elements : ");
		for (int k = 0; k < n; k++) { 
            System.out.print(arrE[k] + " "); 
        } 
		int arrR[] = new int[n];
		arrR = reverse(arrE, n);
		System.out.println("\nReversed : ");
		for (int k = 0; k < n; k++) { 
            System.out.print(arrR[k] + " ");
        }
	}

}
