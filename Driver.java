public class Driver{
  public static void main(String[] args){
    int[] data1 = {10, 80, 30, 90, 40, 50, 70};
    System.out.println(Quick.printArray(data1));
    System.out.println(Quick.partition(data1, 0, 6));
    System.out.println(Quick.printArray(data1));
    System.out.println(Quick.checkPartition(data1));
  }
}
