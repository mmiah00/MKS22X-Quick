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

  public static void deBugPartition (int [] data, int start, int end) {
     Random rng = new Random ();
     int r = Math.abs (rng.nextInt () % data.length);
     int pivot = data [r];
     System.out.println("Pivot Value: " + pivot);
     while (start != end) {
       int now = data [start];
       if (now < pivot) {
         start ++;
       }
       if (now > pivot) {
         int e = data [end];
         data [end] = now;
         data [start] = e;
         end --;
       }
       if (start == end) {
         data [start] = pivot;
         data [r] = now;
         System.out.println (start);
         //return start;
       }
     }
     System.out.println (toString (data));
  }

  public static String toString (int[] data) {
    String ans = "[ ";
    for (int i =0 ; i < data.length; i ++) {
      ans += data[i] + " ";
    }
    return ans + " ]";
  }

  public static void main (String [] args) {
    int[] test = {8, 6, 7, 5, 3, 0, 9};
    deBugPartition (test, 0, 6);
  }
}
