import java.util.*;
import java.util.Arrays;

public class OldQuick {

  public static void quicksort(int[] data) {
    quicksort (data, 0, data.length  - 1);
  }

  private static void insertionSort (int[] ary) {
    int sortedindex = 0; //divider between assorted and not
    while (sortedindex < ary.length) {
      int beingsorted = ary [sortedindex];
      for (int x = sortedindex; x >= 0; x --) { //going backwards to find the smallest
        int now = ary [x];
        if (now > beingsorted) {
          ary [x + 1] = now;
          ary [x] = beingsorted;
        }
      }
      sortedindex ++;
      //System.out.println (toString (ary));
    }
  }

  /*private static void insertionSort (int[] data, int lo, int hi) {
    int sortedindex = lo;
    int len = hi - lo + 1;
    while (sortedindex <= hi) {
      int beingsorted = data[sortedindex];
      for (int x = sortedindex; x >= lo; x --) {
        int now = data[x];
        if (now < beingsorted) {
          data[x + 1] = now;
          data[x] = beingsorted;
        }
      }
      sortedindex ++;
    }
  }
  */

  private static void insertionSort(int[] data, int lo, int hi){
    int i = lo + 1;
    while (i <= hi){
      int now = data[i];
      int before = i - 1;
      int x = 0;
      while (before >= 0 && now < data[before]) {
        data[i -x ] = data[before];
        before--;
        x ++;
      }
      data[before + 1] = now;
    }
  }

  private static void quicksort (int[] data, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    int len = hi - lo;
    if (len < 50) {
      insertionSort (data,lo,hi);
    }
    /*if (len < 15) {
      insertionSort (data, lo, hi);
    }*/
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

  private static int partition(int[] data, int start, int end) {
    Random rng = new Random();
    int pivot = Math.abs (rng.nextInt(end-start+1)) + start;
    int og = start; //keeping track of the start
    int piv = data[pivot]; //pivot value
    int s = data[og];
    data[og] = piv; //swapping first value and pivot value
    data[pivot] = s;

    start++;

    while(start < end){
      if(data[start] == piv ) { //if equal swap start and end values and move end up
        int e = data[end];
        data[end] = data[start];
        data[start] = e;
        end--;
      }
      if(data[start] > piv ) { //if start is bigger than pivot, swap start and end values and move end up
        int e = data[end];
        data[end] = data[start];
        data[start] = e;
        end--;
      }
      else start++; //if smaller move start down
    }

    //once start reaches end check if the value there is greater or less than pivot
    if (piv < data[end]){ //if greater, put it in front
      data[og] = data[end - 1];
      data[end -1] = piv;
      return end-1;
    }
    else { //if less than pivot, swap places
      data[og] = data[end];
      data[end] = piv;
      return end;
    }
  }

  private static void deBugPartition (int [] data, int start, int end) {
    System.out.println ("Initial: " + toString (data));
    Random rng = new Random();
    int pivot = Math.abs (rng.nextInt(end-start+1)) + start;
    int og = start; //keeping track of the start
    int piv = data[pivot]; //pivot value
    System.out.println ("Pivot: " + piv);
    int s = data[og];
    data[og] = piv; //swapping first value and pivot value
    data[pivot] = s;

    start++;

    while(start < end){
      if(data[start] == piv ) { //if equal swap start and end values and move end up
        int e = data[end];
        data[end] = data[start];
        data[start] = e;
        end--;
      }
      if(data[start] > piv ) { //if start is bigger than pivot, swap start and end values and move end up
        int e = data[end];
        data[end] = data[start];
        data[start] = e;
        end--;
      }
      else start++; //if smaller move start down
    }

    //once start reaches end check if the value there is greater or less than pivot
    if (piv < data[end]){ //if greater, put it in front
      data[og] = data[end - 1];
      data[end -1] = piv;
      System.out.println ("Answer: " + (end -1));
    }
    else { //if less than pivot, swap places
      data[og] = data[end];
      data[end] = piv;
      System.out.println ("Answer: " + end);
    }
  }


  private static boolean checkPivot (int[] data, int ans) {
    int pivot = data[ans];
    for (int i = 0; i < data.length; i ++) {
      if (i < ans){
        if (pivot > data[i]) {
          return false;
        }
      }
      if (i > ans) {
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

  private static boolean check (int[] testing) {
    int[] og = testing;
    quicksort (og);
    Arrays.sort (testing);
    return testing == og ;
  }

  /*
  public static void main (String [] args) {
    int[] test = {8, 6, 7, 5, 3, 0, 9};
    int [] a = {2,4,7,1,3,6,12};
    int [] b = {40,3,25,24,30};
    int [] c = {1,3,8,5,7,2};


    for (int i = 0; i < 10; i ++) {
      deBugPartition(c, 0, c.length -1 );
      System.out.println ("--------------------------------------------------------");
    }

    quicksort (test);
    System.out.println (toString (test));
    System.out.println ("--------------------------------------------------------");
    quicksort (a);
    System.out.println (toString  (a));
    System.out.println ("--------------------------------------------------------");
    quicksort (b);
    System.out.println (toString  (b));
    System.out.println ("--------------------------------------------------------");
    quicksort (c);
    System.out.println (toString  (c));
    System.out.println ("--------------------------------------------------------");


    System.out.println (toString (a));
    for (int i = 0; i < a.length; i ++) {
      System.out.println (quickselect (a, i + 1));
    }


  }
  */

}
