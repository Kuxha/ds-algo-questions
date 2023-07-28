



public class Sort{

public static void BubbbleSort(int a[]){

    int n = a.length;
    int temp = 0;
    for (int i = 0; i < n - 1; i++) {
        // n - 1 because we will use (i+1) to swap
        for (int j = 0; j < n- 1 - i; j++) {
            // n - 1 - i because we will be putting largest value at end once

            if(a[j+1]<a[j]){
                temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }  
        }
    }
    return;
}


public static void SelectionSort(int a[]){

    int n = a.length;

    int temp = 0;
    int index = 0; // for minimum index
    for (int i = 0; i < n-1 ; i++) {
  
        index = i;
  
        for (int j = i+1; j < n ; j++) {


            if(a[j]<a[index]){
                index = j;
            }

        
        }

        // swapping the number at minimum index , with i
            temp = a[index];
            a[index] = a[i];
            a[i] = temp;
      
    }
    return;
}


public static void InsertionSort(int a[]){

    int n = a.length;
    int temp = 0;
    for (int i = 0; i < n - 1; i++) {
        // n - 1 because we will use (i+1) to swap
        for (int j = 0; j < n- 1 - i; j++) {
            // n - 1 - i because we will be putting largest value at end once

            if(a[j+1]<a[j]){
                temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }  
        }
    }
    return;
}

}