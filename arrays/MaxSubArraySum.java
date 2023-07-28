public class MaxSubArraySum {
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
}
