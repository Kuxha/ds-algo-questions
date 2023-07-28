

public class Reverse{
  
    public static void ReverseArray(int a[]){

        int n = a.length;
        int temp = 0;
        for (int i = 0,j=n-1;  i<j; i++,j--) {
            
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;

        }
        
    }
}