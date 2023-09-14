package bitmask;


public class BitMask{
    public static String isOddorEven(int a){
        int bitmask = 1;

        if((a&bitmask)==1){
                 return "odd";
        }
        return "even";
    }

}
 