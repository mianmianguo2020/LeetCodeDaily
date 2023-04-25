package Graph;

import java.util.*;

/**
 * @author Christy Guo
 * @create 2023-04-10 4:14 PM
 */

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class _133CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node cloneNode = new Node(node.val);
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, cloneNode);

//        extracted(visited);

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!visited.containsKey(neighbor)) { 
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));
               }
            }
        extracted(visited);
        return cloneNode;
    }

    private void extracted(Map<Node, Node> visited) {
        visited.forEach((originalNode, clonedNode) -> {
            System.out.println("Original node: " + originalNode.val);
            System.out.print("Original node neighbors: ");
            originalNode.neighbors.forEach(neighbor -> System.out.print(neighbor.val + " "));
            System.out.println();
            System.out.println("Cloned node: " + clonedNode.val);
            System.out.print("Cloned node neighbors: ");
            clonedNode.neighbors.forEach(neighbor -> System.out.print(neighbor.val + " "));
            System.out.println();
        });
    }

}
