package Array.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {

    }

    int[][] merge(int[][] arr) {
        ArrayList<int[]> li = new ArrayList<>();
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int start = arr[0][0]; // initialize start and end by the interval of the first row
        int end = arr[0][1];
        for (int i = 0; i < arr.length; i++) {
            int s = arr[i][0]; // now store the intervals to compare with the previous one
            int e = arr[i][1];
            if (s <= end) { // Now compare if the start (s) interval is less than the previous end interval
                            // then
                end = Math.max(end, e); // merge them, means update our end by the greater value of the end interval
            } else { // if not means that interval is not overlapping in the current interval
                li.add(new int[] { start, end }); // add that previous merged interval into list and update start &
                                                  // end by the current intervals
                start = s;
                end = e;
            }

        }

        li.add(new int[] { start, end });
        return li.toArray(new int[li.size()][2]); 
    }
}
