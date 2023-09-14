package recursion;

public class Factorial {


    
    public long getFactorial(int n){

        // Base case
        if(n == 1){
            return 1;
        }

        // Calling inner function
        return n*getFactorial(n-1);
    }
    
}
