/*
 * @Date: 2023-05-01 18:48:34
 * @LastEditors: mianmianguo2020
 * @LastEditTime: 2023-05-01 19:11:17
 * @Description: 
 */

 import java.util.Map;
 import java.util.HashMap;


 class _2295ReplaceElementsinanArray {
    public int[] arrayReplace(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] operation : operations) {
            int idx = map.get(operation[0]);
            nums[idx] = operation[1];
            map.remove(operation[0]);
            map.put(operation[1], idx);
        }
        return nums;
    }
}
