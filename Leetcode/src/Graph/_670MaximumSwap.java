package Graph;

import java.util.Arrays;

/**
 * @author Christy Guo
 * @create 2023-04-09 1:18 PM
 *         https://leetcode.com/problems/maximum-swap/
 *         redo
 *
 */
public class _670MaximumSwap {
    public int maximumSwap(int num) {
        char[] n = Integer.toString(num).toCharArray();
        int idx;
        char temp;

        for (int i = 0; i < n.length - 1; i++) {
            idx = i + 1;
            for (int j = i + 1; j < n.length; j++) {
                if (n[idx] < n[j]) {
                    idx = j;
                }
            }
            if (n[i] < n[idx]) {
                temp = n[i];
                n[i] = n[idx];
                n[idx] = temp;
                return Integer.parseInt((String.valueOf(n)));
            }
        }
        return num;
    }

    public void swap(int i, int j, char[] charArray) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}
