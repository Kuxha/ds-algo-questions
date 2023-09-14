



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



public void MergeSort(int a[],int start,int end){
   System.out.println("\n before sorting \n");
    for (int i = 0; i < a.length; i++) {
        System.out.print(a[i]+ " ");
    }

    if(start>=end){
        return;
    }
    // kaam

    int mid = start + (end - start)/2;

    MergeSort(a, start, mid);
    MergeSort(a, mid+1, end);


    Merge(a, start, mid, end);

    System.out.println("\n after sorting \n");
    for (int i = 0; i < a.length; i++) {
        System.out.print(a[i]+ " ");
    }

}

public static void Merge(int a[],int start,int mid,int end){

    int temp[] = new int[end-start +1];
    int i = start; // for tracking left array
    int j = mid+1; // for traking right array
    int k = 0; // For tracking temporary array


    while(i<=mid && j<=end){

        if(a[i]<a[j]){
            temp[k] = a[i];
            i++;
        }else{
            temp[k] = a[j];
            j++;
        }

        k++;
    }

    while(i<=mid){
        temp[k++] = a[i++];
    }
    while(j<=end){
        temp[k++] = a[j++];
    }


    // Here we put the merged values in the original array .
    // For original array , it will start from start obviously. and it goes to the length of temporary array
    for (int k2 = 0, k3 = start; k2 < temp.length;k3++, k2++) {
        a[k3] = temp[k2];
        
    }

}


public void QuickSort(int a[],int start,int end){

    if(start>= end){
         return;
        }

    int pivotindex = Partition(a,start,end);
    // HERE - first we sort all elements in pivot.
    // left side mein sabko humne small kar dia
    // right mein sabko humne jyada kar dia

    QuickSort(a,0,pivotindex-1);
    QuickSort(a, pivotindex +1, end);


}

public int Partition(int a[],int start,int end){


    int pivot = a[end];
    int i = start-1; // to make place for all elements smaller than the pivot
    int temp = 0;

    for (int j = start; j < end; j++) {

        if(a[j]<=pivot){
            i++;

            temp = a[j];
            a[j] = a[i];
            a[i] = temp;

        }
        
    }

    // Putting PIVOT in the correct place

    i++;

    temp = a[end];
    a[end] = a[i];
    a[i] = temp;

    


    return i++;
}

}