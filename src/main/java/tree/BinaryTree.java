package tree;

/**
 * Source: https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
 *
 * About Trees:
 *       1. Topmost node -> root
 *       2. Elements directly under -> children
 *       3. Elements directly above -> parents
 *       4. Elements with no children -> leaves
 *
 *      Why Tree?
 *          1. Some information needs to be stored in hierarchy. Like File system in computer.
 *          2. Trees (with some specific order like BST) gives faster access/search than LL but slower than Array which is O(1).
 *          3. Trees provide moderate insertion/deletion - faster than Array but slower than unordered LL.
 *
 *      Properties of Binary Tree:
 *          1. Maximum no. of elements at any level l -> 2^l. e.g -> at level 0 -> 2^0 = 1 , at level 1 -> 2^1 = 2.
 *          2. Maximum no. of nodes in a binary tree of height h = 2^h - 1. so, binary tree with height 2 ->
 *              maximum nodes can be 2^2 -1 = 3. for h=3, 2^3-1 = 7
 *          3. In a Binary Tree with N nodes, minimum possible height or minimum number of levels is ? Log2(N+1)
 *          4. In Binary tree where every node has 0 or 2 children, number of leaf nodes is always one more than nodes with two children.
 *                  L = T + 1
 *                  Where L = Number of leaf nodes
 *                        T = Number of internal nodes with two children
 *
 *      Source: https://www.geeksforgeeks.org/binary-tree-set-3-types-of-binary-tree/
 *      Types of Binary Tree:
 *          1. Full Binary Tree :
 *          2. Complete Binary Tree :
 *          3. Perfect Binary Tree :
 *          4. Balanced Binary Tree :
 *          5. Degenerate (or pathological) tree :
 *
 */
public class BinaryTree {

    Node root;

    BinaryTree(int key){
        root = new Node(key);
    }

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree(1);

        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
    }
}

class Node{

    int data;
    Node left,right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
}
