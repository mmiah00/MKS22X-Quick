import java.util.*;

public class Quick {

  public static int partition (int [] data, int start, int end) {
     Random rng = new Random ();
     int r = Math.abs (rng.nextInt () % data.length);
     int pivot = data [r];
     while (start < data.length && end >= 0) {
       if (start == end) {
         int s = data [start];
         data [start] = pivot;
         data [r] = s;
         return r;
       }
       if (data[start] < pivot) {
         start ++;
       }
       else {
         int e = data [end];
         int now = data[start];
         data[end] = now ;
         data [start] = e;
         end --;
       }
     }
     return 0;
  }

  public static void deBugPartition (int [] data, int start, int end) {
    System.out.println ("Initial: " + toString (data));
    Random rng = new Random ();
    int pivIndex = Math.abs (rng.nextInt () % data.length);
    int pivot = data [pivIndex];
    System.out.println ("Pivot: " + pivot);
    int temp = data[start];
    data [pivIndex] = temp;
    data [start] = pivot;
    start ++;

    while (start < data.length && end >= 0) {
      if (start == end) {
        int now = data[start];
        data[0] = now;
        data[start] = pivot;
        System.out.println ("Answer: " + start);
        break;
      }
      if (data[start] < pivot) {
        start ++;
      }
      else {
        //if (data[start] > pivot) {
        int e = data[end];
        int s = data[start];
        data [end] = s;
        data[start] = e;
        end --;
      }
    }
     System.out.println ("Final: " + toString (data));
  }

  public static int[][] viv (int [] data, int start, int end) {
    Random rng = new Random();
    int pivot = rng.nextInt(end-start+1) + start;
    int index = start;

    int num = data[pivot];
    data[pivot] = data[start];
    data[start] = num;
    start++;
    boolean moveLeft = true;

    while (start < end) {
      int temp = data[start];
      if (data[start] == num) {
        if (moveLeft) {
          start++;
          moveLeft = false;
        }
        else {
          data[start] = data[end];
          data[end] = temp;
          end--;
          moveLeft = true;
        }
      }
      else if (data[start] > num) {
        data[start] = data[end];
        data[end] = temp;
        end--;
      }
      else {
        start++;
      }
    }

    while (index < data.length-1 && data[index+1] <= num) {
      index++;
    }

    data[0] = data[index];
    data[index] = num;
    int[][] newData = new int[2][];
    newData[0] = data;
    newData[1] = new int[] {index};

    return newData;
  }

  public static String toString (int[] data) {
    String ans = "[";
    for (int i =0 ; i < data.length; i ++) {
      ans += data[i];
      if (i != data.length - 1) {
        ans += " ";
      }
    }
    return ans + "]";
  }

  public static String toString (int[][] data) {
    String ans = "[ ";
    for (int i =0 ; i < data.length; i ++) {
      ans += toString (data[i]);
      ans += "\n";
    }
    ans += "]";
    return ans;
  }

  public static void main (String [] args) {
    int[] test = {8, 6, 7, 5, 3, 0, 9};
    int [] a = {2,4,7,1,3,6,12};
    int [] b = {40,3,25,24,30};
    int [] c = {1,3,8,5,7,2};
    deBugPartition (test, 0, 6);
    System.out.println ();
    deBugPartition (a, 0, a.length - 1);
    System.out.println ();
    deBugPartition (b, 0, b.length - 1);
    System.out.println ();
    deBugPartition (c, 0, c.length - 1);
  }
}
