package HashTable;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Christy Guo
 * @create 2023-04-27 8:20 PM
 */
public class _49GroupAnagramsTest {
    @Test
    public void testGroupAnagrams() {
        _49GroupAnagrams solution = new _49GroupAnagrams();

        // Input
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Expected output
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );

        // Test the method
        List<List<String>> actual = solution.groupAnagrams(strs);

        // Assert that the actual output matches the expected output
        assertEquals(expected, actual);
    }
}
