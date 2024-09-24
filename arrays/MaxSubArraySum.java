
package arrays;


public class MaxSubArraySum {

    public static void main(String[] args) {
        
        // Running the get max sub array sum 
        int a[] = {1,2,-3,4,5};
        int ans =  getMaxSubArraySum(a);
        System.out.println("max subarray sum = " + ans);
    }
    public static int getMaxSubArraySum(int a[]){

        // Using Kadane's algorithm
        int curr = 0;
        int max  = 0;
    
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            
            if(curr + a[i]>=0){
                curr = curr + a[i];
            }
            max = Math.max(max,curr);
            System.out.println(curr + " , " + max);
            
        }
        System.out.println();

        return max;
    }

    public static int getMaxSubArraySumTrial(int a[]){



        int max = 0;

        
        return max;
    }
}
