public class Quick{

  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
   public static int partition(int[] data, int start, int end) {
    int pivotIndex = (int) (Math.random()*(end - start) + start);
    int pivot = data[pivotIndex];
    // System.out.println(pivot);
    int low = start + 1;
    int high = end;
    swap(data, start, pivotIndex);
    while(low <= high){//while still within bounds
      if(data[low] > pivot){//if greater than the pivot
        swap(data, low, high);
        high--;
      }else{
        low++;//start moves over by one
      }
    }
    swap(data, start, high);
    return high;
  }


  public static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  public static String printArray(int[] data){
    String output = "";
    for(int i = 0; i < data.length; i++){
      output += data[i] + " ";
    }
    return output;
  }

  /*return the value that is the kth smallest value of the array. k = 0 is the smallest
 */
  public static int quickselect(int[] data, int k){
    int start = 0;//start from beginning of array
    int end = data.length - 1;//end at end of array
    int pivot = partition(data, start, end);//partition it once
    while(pivot != k){//keep going if you haven't reached target value
      if(pivot > k){//if pivot index is greater than target
        end = pivot - 1;
      }else{//if pivot index is less than target
        start = pivot + 1;
      }
      pivot = partition(data, start, end);
    }
    return data[pivot];//return value at the pivot index
  }

  /*Modify the array to be in increasing order.
   */
   public static void quicksort(int[] data){
     // quicksort(data, 0 , 0);
   }

   public static void quicksort(int[] data, int lo, int hi){
     // if(lo <= hi){
     //   return;
     // }
     // int pivot = partition(data, lo, hi);
     // quicksort(data, lo, pivot - 1);
     // quicksort(data, pivot + 1, hi);
   }


}
