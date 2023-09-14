package recursion;

import java.math.BigInteger;

public class Power {

    // Time complexity : O(n)
    // Space complexity : O(1)
    // Input Parameters :  a = integer , b = power
    // Result : a double having the result of a to the power of b

    public BigInteger  getPower(int a,int n){

      BigInteger  res = new BigInteger("" + a + "");
      if(n == 0){
        return BigInteger.ONE;
      }

       return res.multiply(getPower(a, n-1));
    }


    public BigInteger  getPowerOptimized(int a,int n){

      System.out.println("original n = " + n);
      BigInteger  res = new BigInteger("" + a + "");
      if(n == 0){

        System.out.println(" n = " + n  + " , and returning 1 ");

        return BigInteger.ONE;
      }


      BigInteger halfRes = getPowerOptimized(a, n/2);
      BigInteger halfSquared = halfRes.multiply(halfRes);

      if(n %2 ==0){
         System.out.println(" n = " + n  + " , and returning " + halfSquared);
        return halfSquared ;
      }

      BigInteger oddRes = res.multiply(halfSquared );
      System.out.println(" n = " + n  + " , and returning " +  oddRes);
      return  oddRes;
     

    }
}