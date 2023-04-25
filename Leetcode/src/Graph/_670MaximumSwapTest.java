package Graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Christy Guo
 * @create 2023-04-10 9:36 AM
 */
class _670MaximumSwapTest {

    @Test
    void maximumSwap() {
        _670MaximumSwap solution = new _670MaximumSwap();
        int expected = 99253;
        int result = solution.maximumSwap(93259);
        assertEquals(expected, result);
    }
}