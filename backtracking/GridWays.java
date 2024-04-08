package backtracking;

public class GridWays {


    // no of ways to go from i,j to n,m
    public static int gridWays(int i,int j,int n,int m){

        // in every step , I can go down or go right

        // If it is able to reach the last element, then add 1 as it is a way 
        if(i ==n-1 && j == m-1){
            return 1;
        }
        if(i== n || j == m){
            return 0;
        }
        int right = gridWays(i, j+1, n, m);
        int down = gridWays(i+1, j, n, m);

        return right+down;
    }
    public static void main(String[] args) {
        int n = 3,m=3;
        System.out.println("Grid ways = " + gridWays(0, 0, n, m));
    }
    
}
