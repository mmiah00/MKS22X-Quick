import java.util.*;
import java.util.Arrays;

public class Quick {

  public static void quicksort(int[] data) {
    quicksort (data, 0, data.length - 1);
  }

  private static void quicksort (int[] data, int hi, int lo) {
    if (lo >= hi) {
      return;
    }
    int pivot = partition (data,lo, hi);
    quicksort (data, lo, pivot - 1);
    quicksort (data, pivot + 1, hi);
  }

  public static int quickselect(int[] data, int k) {
    k -= 1;
    int div = partition (data, 0, data.length - 1); //first division
    while (div != k ) {
      if (div > k) { //if k is to the right only look at the right side
        div = partition (data, 0, div - 1); //divide only to the right
      }
      else {
        div = partition (data, div + 1, data.length - 1); //else only divide values to the left
      }
    }
    return data[div]; //once div == k, that kth value is in the right spot
  }

  private static int partition (int [] data, int start, int end) {
    Random rng = new Random ();
    int pivIndex = Math.abs (rng.nextInt () % data.length);
    int pivot = data [pivIndex];
    int temp = data[start];
    data [pivIndex] = temp;
    data [start] = pivot;
    start ++;

    while (start < data.length && end >= 0) {
      if (start == end) {
        int now = data[start];
        data[0] = now;
        data[start] = pivot;
        return start;
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
    return 0;
  }

  /*
  private static void deBugPartition (int [] data, int start, int end) { //working on it before
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
  */

  private static void deBugPartition (int[] data, int start, int end) {
    System.out.println ("Initial: " + toString (data));
    Random rng = new Random ();
    int pivIndex = Math.abs (rng.nextInt () % data.length);
    int pivot = data [pivIndex];
    System.out.println ("Pivot: " + pivot);
    int temp = data[start];
    data [pivIndex] = temp;
    data [start] = pivot;
    start ++;
    boolean right = false;
    while (start != end) {
      if (data[start] == pivot) {
        if (!right) {
          start ++;
          right = true;
        }
        else {
          int s = data[start];
          int e = data[end];
          data[start] = e;
          right = false;
          System.out.println ("ans: " + start) ;
          break;
        }
      }
      else {
        if (data[start] > pivot) {
          int s = data[start];
          int e = data[end];
          data[start] = e;
          end --;

        }
        else {
          start ++;
        }
      }
    }
    System.out.println ("Final: " + toString (data));

  }


  private boolean checkPivot (int[] data, int ans) {
    int pivot = data[ans];
    for (int i = 0; i < ans; i ++) {
      if (data [i] > ans) {
        return false;
      }
    }
    return true;
  }


  private static String toString (int[] data) {
    String ans = "[";
    for (int i =0 ; i < data.length; i ++) {
      ans += data[i];
      if (i != data.length - 1) {
        ans += " ";
      }
    }
    return ans + "]";
  }

  private static String toString (int[][] data) {
    String ans = "[ ";
    for (int i =0 ; i < data.length; i ++) {
      ans += toString (data[i]);
      ans += "\n";
    }
    ans += "]";
    return ans;
  }

  private boolean check (int[] testing) {
    int[] og = testing;
    quicksort (og);
    Arrays.sort (testing);
    return testing == og ;
  }

  public static void main (String [] args) {
    int[] test = {8, 6, 7, 5, 3, 0, 9};
    int [] a = {2,4,7,1,3,6,12};
    int [] b = {40,3,25,24,30};
    int [] c = {1,3,8,5,7,2};

    /*
    for (int i = 0; i < 5; i ++) {
      partition(test, 0, 6);
      System.out.println ("--------------------------------------------------------");
    }
    */

    System.out.println (toString (a));
    for (int i = 0; i < a.length; i ++) {
      System.out.println (quickselect (a, i + 1));
    }

  }
}
