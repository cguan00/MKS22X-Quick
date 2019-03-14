public class Driver{
  public static void main(String[] args){
    int[] data1 = {10, 80, 30, 90, 40, 50, 70};
    System.out.println(Quick.printArray(data1));
    // System.out.println(Quick.partition(data1, 0, 6));
    // System.out.println(Quick.printArray(data1));

    //testing quickselect
    System.out.println(Quick.quickselect(data1, 0));//10
    System.out.println(Quick.quickselect(data1, 1));//30
    System.out.println(Quick.quickselect(data1, 2));//40
    System.out.println(Quick.quickselect(data1, 3));//50
    System.out.println(Quick.quickselect(data1, 4));//70
    System.out.println(Quick.quickselect(data1, 5));//80
    System.out.println(Quick.quickselect(data1, 6));//90

    //try quick sort
    Quick.quicksort(data1);
    System.out.println(Quick.printArray(data1));
  }
}
