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
        data [0] = now;
        data[start] = pivot;
        System.out.println ("Ans: " + start);
        break;
      }
      if (data[start] > pivot) {
        int now = data[start];
        int endVal = data[end];
        data [start] = endVal; //swapping end and beginning
        data [end] = now;
        end --;
      }
      if (data[start] < pivot) {
        start ++;
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
    return ans + " ]";
  }

  public static void main (String [] args) {
    int[] test = {8, 6, 7, 5, 3, 0, 9};
    deBugPartition (test, 0, 6);
  }
}

/*
Random rng = new Random ();
int r = Math.abs (rng.nextInt () % data.length);
int pivot = data [r];
System.out.println("Pivot Value: " + pivot);
int temp = data[start];
data[r] = temp;
data[0] = pivot;
start ++;
while (start < data.length && start != end ) {
  if (start == end) {
    int s = data [start];
    data [start] = pivot;
    data [r] = s;
    System.out.println ("Answer: " + start);
    //return r;
  }
  if (data[start] < pivot) {
    start ++;
  }
  else {
    int e = data [end];
    int now = data[start];
    data[end] = now;
    data [start] = e;
    end --;
  }
}
*/
