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
    //System.out.println ("Initial: " + toString (data));
    Random rng = new Random ();
    int pivIndex = Math.abs (rng.nextInt () % data.length);
    int pivot = data [pivIndex];
    //System.out.println ("Pivot: " + pivot);
    int temp = data[start];
    data [pivIndex] = temp; //switching beginning and pivot
    data [start] = pivot;

    int i = start + 1; //new variable to keep track of lo end

    while (i != end) {
      int s = data[i]; //start
      int e = data[end]; //end
      if (s > pivot) {
        data[i] = e; // if bigger than pivot bring it to the end
        data[end] = s;
        end --;
      }
      else {
        i ++;
      }
    }

    if (data [i] > pivot) {
      int x = data[i - 1];
      data[i - 1] = pivot;
      data[start] = x;
      return i - 1;
    }
    else {
      int x = data[i];
      data [i] = pivot;
      data[start] = x;
      return i;
    }
    //System.out.println ("Final: " + toString (data));
  }

  private static void deBugPartition (int [] data, int start, int end) { //working on it before
    System.out.println ("Initial: " + toString (data));
    Random rng = new Random ();
    int pivIndex = Math.abs (rng.nextInt () % data.length);
    int pivot = data [pivIndex];
    System.out.println ("Pivot: " + pivot);
    int temp = data[start];
    data [pivIndex] = temp;
    data [start] = pivot;

    int i = start + 1;

    while (i != end) {
      int s = data[i];
      int e = data[end];
      if (s > pivot) {
        data[i] = e;
        data[end] = s;
        end --;
      }
      else {
        i ++;
      }
    }

    if (data [i] > pivot) {
      int x = data[i - 1];
      data[i - 1] = pivot;
      data[start] = x;
      System.out.println ("Answer: " + (i - 1));
    }
    else {
      int x = data[i];
      data [i] = pivot;
      data[start] = x;
      System.out.println ("Answer: " + i);
    }
    System.out.println ("Final: " + toString (data));
  }


  private boolean checkPivot (int[] data, int ans) {
    int pivot = data[ans];
    for (int i = 0; i < data.length; i ++) {
      if (i < ans){
        if (pivot > data[i]) {
          return false;
        }
      }
      else {
        if (pivot < data[i]) {
          return false;
        }
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

    for (int i = 0; i < 10; i ++) {
      deBugPartition(test, 0, 6);
      System.out.println ("--------------------------------------------------------");
    }

    /*
    System.out.println (toString (a));
    for (int i = 0; i < a.length; i ++) {
      System.out.println (quickselect (a, i + 1));
    }
    */

  }
}
