package arrays;
public class PrintSubArray{

   PrintSubArray(int a[]){

        System.out.println("Original Array");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }


        System.out.println("\nSub Array");
        for (int i = 0; i < a.length; i++) {
            System.out.println("\n\n");
            for (int j = i; j < a.length; j++) {
                System.out.println("");
               for (int k = i; k <= j; k++) {
                System.out.print(a[k] + ",");
               }
            }
        }
    }
}