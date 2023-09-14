package testcases;

import java.math.BigInteger;
import java.util.Scanner;

import recursion.Power;
import recursion.Factorial;
import recursion.Fibonacci;
import recursion.Numbers;
import recursion.Strings;

public class Recursion {


    // 1 and 2
    public void TestPrintInOrder(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to be printed");
        int n = sc.nextInt();

        System.out.println(" ---- Numbers in Decreasing Order ----- ");
        new Numbers().getNumbersInDecreasingOrder(n);
        
        System.out.println(" ---- Numbers in Increasing Order ----- ");
        new Numbers().getNumbersInIncreasingOrder(n);
        sc.close();
    }

    // 3
    public void TestFactorial(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to get Factorial for");
        int n = sc.nextInt();
        long ans = new Factorial().getFactorial(n);

        System.out.println(" ---- Factorial----- ");
        System.out.println(ans);
        sc.close();
    }
    // 4
    public void TestSumOfNNaturalNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to get sum for");
        int n = sc.nextInt();
        long ans = new Numbers().getSumOfNNaturalNumbers(n);

        System.out.println(" ---- Sum----- ");
        System.out.println(ans);
        sc.close();
    }

    // 5
    public void TestFibonacci(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to get Fibonacci for");
        int n = sc.nextInt();
        long ans = new Fibonacci().getFibonacci(n);

        System.out.println(" ---- Fibonacci---- ");
        System.out.println(ans);
        sc.close();
    }
    // 7
    public void TestFirstOccurence(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to get First Occurence for");
        int key = sc.nextInt();
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];

        System.out.println("key = " + key);
        System.out.println("size of array = " + n + "\n");
        for (int i = 0; i < n; i++) {
        
            a[i] = sc.nextInt();
            System.out.println("value at index " + i + " is = " + a[i]);
        }

        System.out.println("-------");


        // always start from first index
        int ans = new Numbers().FirstOcuurence(a, 0, key);

        System.out.println(ans);

        sc.close();
    }
    // 8
    public void TestLastOccurence(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to get Last Occurence for");
        int key = sc.nextInt();
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];

        System.out.println("key = " + key);
        System.out.println("size of array = " + n + "\n");
        for (int i = 0; i < n; i++) {
        
            a[i] = sc.nextInt();
            System.out.println("value at index " + i + " is = " + a[i]);
        }
        System.out.println("-------");

        // always start from first index
        int ans = new Numbers().LastOcuurence(a, n-1, key);
        System.out.println(ans);
        sc.close();
    }
    // 9 - 10
    public void TestPower(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to be powered");
        int a = sc.nextInt();
        System.out.println("Enter power");
        int power = sc.nextInt();

        long start = System.currentTimeMillis();
        BigInteger nonOptimized = new Power().getPower(a, power);
        System.out.println("The answer by non optimized version is" + nonOptimized);
        long end = System.currentTimeMillis();
        System.out.println("Time taken for non optimized version : " + (end - start) + " milliseconds");



         start = System.currentTimeMillis();
        BigInteger optimized = new Power().getPowerOptimized(a, power);
          System.out.println("The answer by optimized version is" + (optimized));
          end = System.currentTimeMillis();
        System.out.println("Time taken for  optimized version : " + (end - start) + " milliseconds");

        System.out.println("Answer  matches = " + optimized.equals(nonOptimized));

        sc.close(); 
    }







    public void TestIsSorted(){

    }



    // Q and A

   public void TestAllOccurence(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to get all Occurence for");
        int key = sc.nextInt();
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int a[] = new int[n];

        System.out.println("key = " + key);
        System.out.println("size of array = " + n + "\n");
        for (int i = 0; i < n; i++) {
        
            a[i] = sc.nextInt();
            System.out.println("value at index " + i + " is = " + a[i]);
        }
        System.out.println("-------");

        // always start from first index
        int res = 0;
        int ans = new Numbers().AllOccurences(a, 0, key,res);
        System.out.println("res = " + res);
        System.out.println("ans = " + ans);
        sc.close();
    }

    public void TestRemovingDuplicates(){


        System.out.println("Enter String");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();


        StringBuilder sb = new StringBuilder("");
        boolean map[] = new boolean[26];
        
        String ans = new Strings().RemoveDuplicates(s, 0, sb, map);
        System.out.println(ans);

        sc.close();
    }

    public Recursion(){


        

      
    }
    
}
