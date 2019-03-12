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
         data[end] = start;
         data [start] = end;
         end --;
       }
     }
     return 0;
  }
  public static void main (String [] args) {
    int[] test = {8, 6, 7, 5, 3, 0, 9};
    System.out.println (partition (test, 0, 6));
  }
}
