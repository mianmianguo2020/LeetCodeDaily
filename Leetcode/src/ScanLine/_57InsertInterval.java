package ScanLine;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Christy Guo
 * @create 2023-04-26 12:15 AM
 */
public class _57InsertInterval {
    List<int[]> result = new ArrayList<>();
    public int[][] insert(int[][] intervals, int[] newInterval) {
        for (int[] current: intervals) {
            newInterval = getInts(newInterval, current);
        }
        if (newInterval!=null) {
            result.add(newInterval);
        }
        return result.toArray(new int[0][]);
    }

    private int[] getInts(int[] newInterval, int[] current) {
        if (newInterval == null || current[1] < newInterval[0]) {
            result.add(current);
        } else if(current[0] > newInterval[1]){
            result.addAll(List.of(newInterval, current));
            newInterval = null;
        } else{
            newInterval[0] = Math.min(newInterval[0], current[0]);
            newInterval[1] = Math.max(newInterval[1], current[1]);
        }
        return newInterval;
    }

}
