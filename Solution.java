import backtracking.FindAllPermutations;
import backtracking.FindSubsets;
import testcases.Recursion;

public class Solution{

   
    public static void main(String[] args) {

    
        // int a[] = {1,2,3,4,5,6,7,1,2,2,3,-5};
        // new Sort().QuickSort(a, 0, a.length-1);



        // System.out.println("\n\n\nFINAL RESULTS\n\n\n");
        // for (int i = 0; i < a.length; i++) {
        //     System.out.print(a[i] + " ");
        // }


        String s  = "abc";
        new FindSubsets().FindSubsets(s, 0, "");
        new FindAllPermutations().FindAllPermutations(s, "");
    }

}