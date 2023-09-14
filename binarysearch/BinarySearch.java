package binarysearch;
import java.util.Scanner;



public class BinarySearch{
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();

        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            
            a[i] = sc.nextInt();

        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }


        System.out.println("\nkey  is at index "  +  Search(a,2));

        sc.close();
    }

    public static int Search(int a[],int key){

        // Binary Search    

        int n = a.length;
        int start = 0;
        int end = n-1;
        int mid = 0;

        while(start<=end){

            mid = (start+end)/2;
            if(a[mid]==key){
                return mid;
            }else if(a[mid]>key){

                end = mid - 1;
            }else{

                start = mid +1 ;
            }

        }

        // If start> end , means break out of the loop. that number aint here

        return -1;
    }
}