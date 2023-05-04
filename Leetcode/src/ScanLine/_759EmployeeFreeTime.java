package ScanLine;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: mianmiantea2019
 * @Date: 2023-05-03 7:15 PM
 * @LastEditors: mianmiantea2019
 * @Description:
 */

public class _759EmployeeFreeTime {
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> {
            return a.start - b.start;
        });
        for(List<Interval> i: schedule){
            for(Interval j: i){
                pq.add(j);
            }
        }

        Interval last = pq.poll();
        while(!pq.isEmpty()){
            Interval cur = pq.poll();
            if(last.end < cur.start){
                res.add(new Interval(last.end, cur.start));
            }
            last.end = Math.max(last.end, cur.end);
        }
        return res;
    }
}
