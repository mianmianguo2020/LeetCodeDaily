/*
 * @Author: mianmiantea2019
 * @Date: 2023-05-01 22:03:18
 * @LastEditors: mianmiantea2019
 * @LastEditTime: 2023-05-01 22:25:07
 * @Description:
 */

class _1099TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int ans = -1;
      
        while (i < j) {
            int temp = nums[i] + nums[j];
            if (temp < k) {  
                ans = Math.max(ans, temp); 
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
