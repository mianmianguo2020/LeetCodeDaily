package scanLine;

import java.util.*;

/**
 * @Author: mianmiantea2019
 * @Date: 2023-05-03 7:15 PM
 * @LastEditors: mianmiantea2019
 * @Description:
 */
public class _352DataStreamasDisjointIntervals {
    TreeSet<int[]> set = new TreeSet<>((a, b)->{
        if(a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
    });
    public _352_DataStreamasDisjointIntervals() {

    }

    public void addNum(int val) {
        int[] intervals = {val, val};
        if(set.contains(intervals)) return;

        int[] low = set.lower(intervals);
        int[] high = set.higher(intervals);

        if(high != null && high[0] == val) return;
        if(low != null && low[1] + 1 == val && high != null && high[0] - 1 == val){
            low[1] = high[1];
            set.remove(high);
        }else if(low != null && low[1] + 1>= val) low[1] = Math.max(low[1], val);
        else if(high != null && val + 1 == high[0]){
            high[0] = val;
        }else{
            set.add(intervals);
        }

    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        for(int[] intervals: set) res.add(intervals);
        return res.toArray(new int[0][]);
    }
}
