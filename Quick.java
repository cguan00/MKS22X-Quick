import java.util.*;

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
     //choosing median value of the lo, hi, and middle elements
     int loNum = data[start];
     int hiNum = data[end];
     int medNum = data[data.length / 2];
     int[] tempArray = {loNum, hiNum, medNum};
     Arrays.sort(tempArray);
     int pivot = tempArray[1];

     //only have pivot value, so must figure out pivot index
     int pivotIndex;
     if(data[start] == pivot){
       pivotIndex = start;//see if pivot was located at start
     } else if(data[end] == pivot){
       pivotIndex = end;//see if pivot was located at end
     } else{
       pivotIndex = data.length / 2;//wasn't at start or end, so it was at middle element
     }

     //same as non-optimized version, with the addition of the random number chooser when number is same as pivot
     int low = start + 1;
     int high = end;
     swap(data, start, pivotIndex);
     while(low <= high){//while still within bounds
       int rand = (int)(Math.random() * 2);//use for optimization. either 1 or 0 to choose which side you add to if you're looking at num equal to pivot
       if(data[low] > pivot || (data[low] == pivot && rand == 0)){//if greater than the pivot, and use rand to optimize
         swap(data, low, high);
         high--;
       }else{
         low++;//start moves over by one
       }
     }
     swap(data, start, high);
     return high;


     // ******NON OPTIMIZED VERSION******

     // int pivotIndex = (int) (Math.random()*(end - start) + start);
     // int pivot = data[pivotIndex];
     // int low = start + 1;
     // int high = end;
     // swap(data, start, pivotIndex);
     // while(low <= high){//while still within bounds
     //   if(data[low] > pivot){//if greater than the pivot, and use rand to optimize
     //     swap(data, low, high);
     //     high--;
     //   }else{
     //     low++;//start moves over by one
     //   }
     // }
     // swap(data, start, high);
     // return high;
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
     quicksort(data, 0 , 0);
   }

   public static void quicksort(int[] data, int lo, int hi){
     if(lo <= hi){
       return;
     }
     int pivot = partition(data, lo, hi);
     quicksort(data, lo, pivot - 1);
     quicksort(data, pivot + 1, hi);
   }


}
