package BinarySearch;

/*
 * @Author: mianmiantea2019
 * @Date: 2023-05-03 11:44:38
 * @LastEditors: mianmiantea2019
 * @Description:
 */

 class _704BinarySearch {
    public int search(int[] nums, int target) {
       if (nums == null || nums.length == 0) {
          return -1;
        }
        int start = 0;
        int end = nums.length;
        //[)
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > target) {
                end = mid;  
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
