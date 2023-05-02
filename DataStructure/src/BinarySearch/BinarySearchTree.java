/*
 * @Author: mianmianguo2020
 * @Date: 2023-05-01 23:08:29
 * @LastEditors: mianmianguo2020
 * @LastEditTime: 2023-05-02 00:25:33
 * @Description: 
 */

package BinarySearch;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    //  10
//   5     13
// 2  7  11  16
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(13);
        tree.insert(11);
        tree.insert(2);
        tree.insert(16);
        tree.insert(7);
        tree.printInOrder(tree.root);
    }

    public BinarySearchTree insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
            return this;
        }
        Node current = this.root;
        while (true) {
            if (value == current.value) return null;
            if (value < current.value) {
                if (current.left == null) {
                    current.left = newNode;
                    return this;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return this;
                }
                current = current.right;
            }
        }
    }

    public Node find(int value) {
        if (this.root == null) return null;
        Node current = this.root;
        boolean found = false;
        while (current != null && !found) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                found = true;
            }
        }
        if (!found) return null;
        return current;
    }

    public boolean contains(int value) {
        if (this.root == null) return false;
        Node current = this.root;
        boolean found = false;
        while (current != null && !found) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }

}
