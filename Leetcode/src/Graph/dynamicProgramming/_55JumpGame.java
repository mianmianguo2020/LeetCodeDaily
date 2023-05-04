package dynamicProgramming;

/**
 * @Author: mianmiantea2019
 * @Date: 2023-05-03 7:15 PM
 * @LastEditors: mianmiantea2019
 * @Description:
 */
public class _55JumpGame {

  public boolean canJump1(int[] nums) {
        int len = nums.length;
        int last = len-1;
        for(int i = len-1; i >= 0; i--){
            if(last - i <= nums[i]){
                last = i;
            }
        }

        return last == 0;
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] f = new boolean[len];

        f[0] = true;
        for(int j = 1; j < len; j++){
            f[j] = false;
            for(int i = 0; i < j; i++){
                if(f[i] && j-i <= nums[i]){
                    f[j] = true;
                    break;
                }
            }
        }
        return f[len-1];
    }
}
