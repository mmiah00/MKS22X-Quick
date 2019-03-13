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
    System.out.println (toString (data));
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

     /*
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
     */
     System.out.println (toString (data));
  }

  public static String toString (int[] data) {
    String ans = "[ ";
    for (int i =0 ; i < data.length; i ++) {
      ans += data[i] + " ";
    }
    return ans + "]";
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
