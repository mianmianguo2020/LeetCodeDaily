package ScanLine;

import java.util.Arrays;

/**
 * @author Christy Guo
 * @create 2023-04-26 12:35 AM
 */
public class _252MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        //Sort the intervals array in ascending order based on the start time of each interval
        Arrays.sort(intervals, (int[] a1, int[] a2) -> {
            return a1[0] - a2[0];
        });

        // If there is any overlap between the end time of the current interval and the start time of the next interval,
        // then the meeting rooms cannot be attended by the same person, and we return false.
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] - intervals[i + 1][0] > 0)
                return false;
        }
        return true;
    }
}
