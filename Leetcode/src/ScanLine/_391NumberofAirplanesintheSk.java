package ScanLine;

import java.util.*;
import java.util.List;

/**
 * @author Christy Guo
 * @create 2023-04-26 9:35 AM
 */

  class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }

public class _391NumberofAirplanesintheSk {
    public int countOfAirplanes(List<Interval> airplanes) {

        airplanes.sort((a, b) -> a.start - b.start);

        int maxAirplanes = 0;
        int currAirplanes = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval interval : airplanes) {
            // Check if any airplane has landed before the start of this interval
            while (!pq.isEmpty() && pq.peek() <= interval.start) {
                pq.poll();
                currAirplanes--;
            }
            // Add the current airplane to the priority queue
            pq.offer(interval.end);
            currAirplanes++;
            // Update the maximum number of airplanes seen so far
            maxAirplanes = Math.max(maxAirplanes, currAirplanes);
        }

        return maxAirplanes;
    }
}
