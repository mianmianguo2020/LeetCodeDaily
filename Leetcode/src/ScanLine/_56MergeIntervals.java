package ScanLine;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * @author Christy Guo
 * @create 2023-04-25 11:50 PM
 */
public class _56MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[] currentInterval = intervals[0];
        for(int[] cur: intervals){
            if(cur[0] <= currentInterval[1]){
                currentInterval[1] = Math.max(currentInterval[1], cur[1]);
            } else{
                result.add(currentInterval);
                currentInterval = cur;
            }

        }
        result.add(currentInterval);
        return result.toArray(new int[result.size()][]);
    }

}
