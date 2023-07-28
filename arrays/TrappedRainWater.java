

public class TrappedRainWater{


      public static int getTrappedRainwater(int height[]){


        // First figure out left max boundary
        // Then Figure out right max boundary
        int n = height.length;
        int leftMaxBoundary[] = new int[n];
        int rightMaxBoundary[] = new int[n];
        leftMaxBoundary[0] =height[0];
        rightMaxBoundary[n-1] =height[n-1];

        for (int i = 1; i < n; i++) {
            leftMaxBoundary[i] = Math.max(height[i], leftMaxBoundary[i-1]);
            rightMaxBoundary[n-1-i] = Math.max(height[i], rightMaxBoundary[n-i]);
        }

        System.out.println("\nARRAY");
        for (int i = 0; i < n; i++) {
            System.out.print(height[i] + " ");
        }

        System.out.println("\nLeft MAX");
        for (int i = 0; i < n; i++) {
            System.out.print(leftMaxBoundary[i] + " ");
        }

        System.out.println("\nRight MAX");
        for (int i = 0; i < n; i++) {
            System.out.print(rightMaxBoundary[i] + " ");
        }


        // Getting the water level 
        int waterLevel = 0;
        int trappedWater = 0;
        int width = 1;

        System.out.println("\nWATER LEVEL");
        System.out.print(waterLevel + " ");
        for (int i = 1; i < n-1; i++) {
            waterLevel = Math.min(leftMaxBoundary[i], rightMaxBoundary[i]) ;
            trappedWater += (waterLevel - height[i])*width;
        }


      

        return trappedWater;
    }

    public static void main(String[] args) {
    
        int a[] = {4,2,0,6,3,2,5};
        int ans = getTrappedRainwater(a);
        System.out.println("\nANSWER");
        System.out.println(ans);
    }
}