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
    int low = start + 1;
    int high = end;
    data[pivotIndex] = data[0];//swap pivot and index
    data[0] = pivot;//swap pivot and index
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

  public static void swap(int[] data, int start, int end) {
      int temp = data[end];
      data[end] = data[start];
      data[start] = temp;
  }


  //method to check if parition is working properly
  //all values on left will be less than partition, all values on right will be greater
  public boolean checkPartition(int[] data){
    return true;
  }

  public static String printArray(int[] data){
    String output = "";
    for(int i = 0; i < data.length; i++){
      output += data[i] + " ";
    }
    return output;
  }

  /*return the value that is the kth smallest value of the array. k=0 is the smallest
 */
  public static int quickselect(int[] data, int k){
    return 0;
  }

/*Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data){

 }


}
