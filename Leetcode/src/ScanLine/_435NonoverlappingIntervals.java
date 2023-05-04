package scanLine;

import java.util.Arrays;

/**
 * @Author: mianmiantea2019
 * @Date: 2023-05-03 7:15 PM
 * @LastEditors: mianmiantea2019
 * @Description:
 */

public class _435NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals,(a1, a2)->{
            return a1[1] - a2[1];
        });

        int end = Integer.MIN_VALUE;
        int count = 0;
        for(int[] cur: intervals){
            if(cur[0] >= end){
                end = cur[1];
            }else{
                count++;
            }
        }

        return count;
    }
}
