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
     swap(data, start, pivotIndex);
     int low = start + 1;
     int high = end;
     Random r = new Random();//use for optimization. will have either 1 or 0 to choose which side you add to if you're looking at num equal to pivot
     while(low <= high){//while still within bounds
       if(data[low] > pivot || (data[low] == pivot && r.nextInt() % 2 == 0)){//if greater than the pivot, and use rand to optimize
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
     int lo = 0;//start at 0
     int hi = data.length - 1;//end at end of data array
     quicksort(data, lo, hi);//call helper method
   }

   public static void quicksort(int[] data, int lo, int hi){
     if(lo >= hi){
       return;
     }
     int pivot = partition(data, lo, hi);
     quicksort(data, lo, pivot - 1);
     quicksort(data, pivot + 1, hi);
   }

   public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}


}
