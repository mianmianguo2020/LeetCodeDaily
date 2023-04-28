package HashTable;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @author Christy Guo
 * @create 2023-04-27 8:18 PM
 */
public class _49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if (strs == null || strs.length == 0) {
            return ans;
        }

        for (String string : strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(string);
        }
        ans.addAll(map.values());
        return ans;
    }
}
