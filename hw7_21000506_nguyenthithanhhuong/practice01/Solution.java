package hw7_21000506_nguyenthithanhhuong.practice01;

import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Input test
        System.out.print("Enter N: ");
        int N = sc.nextInt();
        int arr[]= new int[N];
        System.out.print("Enter " + N + " elements of array: ");
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Output test
        System.out.print("Output: ");
        System.out.println(isRepresentingBST(arr, N));
    }

    // Solve
    public static int isRepresentingBST(int arr[], int N) {
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i - 1]) return 0;
        }
        return 1;
    }
}

//    Example test:
//    Enter N: 3
//    Enter 3 elements of array: 2 4 5
//    Output: 1