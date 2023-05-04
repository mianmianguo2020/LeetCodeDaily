package BinarySearch;

/**
 * @Author: mianmiantea2019
 * @Date: 2023-05-03 10:57 PM
 * @LastEditors: mianmiantea2019
 * @Description:
 */

import java.util.HashMap;
import java.util.Map;


public class _930BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            count += map.getOrDefault(sum - goal, 0);
        }
        return count;
    }
}
