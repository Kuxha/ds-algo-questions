package recursion;

public class Fibonacci {
    public long getFibonacci(int n){

        // Base case
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }

        // Calling inner function
        return getFibonacci(n-1) + getFibonacci(n-2);
    }
}
