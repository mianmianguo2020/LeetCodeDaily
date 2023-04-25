package Graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Christy Guo
 * @create 2023-04-10 5:18 PM
 */
class _133CloneGraphTest {

    @Test
    void cloneGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // clone the graph
        _133CloneGraph solution = new _133CloneGraph();
        Node cloned = solution.cloneGraph(node1);

        // check that the cloned graph is equal to the original graph
        assertEquals(node1.val, cloned.val);
        assertEquals(node1.neighbors.size(), cloned.neighbors.size());
        for (int i = 0; i < node1.neighbors.size(); i++) {
            assertEquals(node1.neighbors.get(i).val, cloned.neighbors.get(i).val);
            assertEquals(node1.neighbors.get(i).neighbors.size(), cloned.neighbors.get(i).neighbors.size());
            for (int j = 0; j < node1.neighbors.get(i).neighbors.size(); j++) {
                assertEquals(node1.neighbors.get(i).neighbors.get(j).val, cloned.neighbors.get(i).neighbors.get(j).val);
            }
        }
    }
}