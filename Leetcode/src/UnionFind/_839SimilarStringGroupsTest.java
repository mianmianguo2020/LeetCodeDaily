package UnionFind;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Christy Guo
 * @create 2023-04-27 11:09 PM
 */



public class _839SimilarStringGroupsTest {

    @Test
    public void testUnionFind() {
        DSU dsu = new DSU(10);
        assertEquals(10, dsu.regions());

        dsu.union(1, 2);
        assertEquals(9, dsu.regions());

        dsu.union(2, 3);
        assertEquals(8, dsu.regions());

    }
}