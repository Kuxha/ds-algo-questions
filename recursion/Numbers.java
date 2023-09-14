package recursion;

public class Numbers {


    public void getNumbersInDecreasingOrder(int n){

        if(n == 1){  
                    System.out.println(1);  
            return;
        }
        System.out.println(n);
         getNumbersInDecreasingOrder(n-1);
    }

    public void getNumbersInIncreasingOrder(int n){
    
        if(n == 1){  
            System.out.println(1);  
            return;
        }

         getNumbersInIncreasingOrder(n-1);
             System.out.println(n);
    }

    public long getSumOfNNaturalNumbers(int n){
  
        if(n == 1){
            return 1;
        }

        return n + getSumOfNNaturalNumbers(n-1);

    }


     public static boolean isSorted(int a[],int i){
  
       if(a.length-1 == i || a.length == 0) return true;
       if(a[i]>a[i+1]) return false;

       return isSorted(a, i+1);


    }


    public int FirstOcuurence(int a[],int i,int key){
      
        if(a.length == i){
            return -1;
        }
        System.out.println("num at index = "+ i + " is = " + a[i]);
        if(a[i] == key){
            System.out.println("Found key at index = " + i);
            return i;
        }
     

        return FirstOcuurence(a, i+1, key);
       


    }

    public int LastOcuurence(int a[],int i,int key){
      
        if(i == -1){
            return -1;
        }
        System.out.println("num at index = "+ i + " is = " + a[i]);
        if(a[i] == key){
            System.out.println("Found key at index = " + i);
            return i;
        }
     

        return LastOcuurence(a, i-1, key);
       


    }

    // Initial index should start at 0 
    public int AllOccurences(int a[],int i,int key,int res){
      
        if(a.length == i){
            return res;
        }
        System.out.println("num at index = "+ i + " is = " + a[i]);
        if(a[i] == key){
            res ++;
        }
     

        return AllOccurences(a, i+1, key, res);
       


    }

    public static void main(Strings[] args) {

        int a[] = {};
        System.out.println(isSorted(a,0));
    }
    
}
