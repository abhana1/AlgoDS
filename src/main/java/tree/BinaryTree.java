package tree;

import java.util.*;

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
 *      Storing trees:
 *          1. Arrays -> start from the root as index 1 and keep allocation index for all the nodes even if its empty assign an index.
 *                         how to find the left and right side of a node:
 *                         - left = 2*i
 *                         - right = 2*i + 1
 *          2. Using nodes
 *
 *
 *      Note: Recursion is very important for binary tree. And binary tree questions can be easily solved by using recursion.
 *
 *      Types of Traversal: (Each traversal has a different use.)
 *          1. InOrder - LNR
 *          2. PreOrder - NLR
 *          3. PostOrder - LRN
 *          4. Many a times the interviewer asks to print tree from other directions as well like print from the left side or from below to above.
 *
 */
public class BinaryTree {

    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Node root = createTree();

        System.out.println("inorder");
        inOrder(root);

        System.out.println("preorder");
        preOrder(root);

        System.out.println("postorder");
        postOrder(root);

        System.out.println("");
        System.out.println("Left view is - ");
        leftView(root);

        bottomView(root);

    }

    static Node createTree(){
        Node root = null;

        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if(data == -1) return null;

        root = new Node(data);

        System.out.println("Enter left of "+data);
        root.left = createTree();

        System.out.println("Enter right of "+data);
        root.right = createTree();

        return root;
    }

    // bottom view of the binary tree
    static void bottomView(Node root){

        if(root==null) return;

        int hd = 0;

        root.horizontalDistance = hd;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node temp = queue.remove();
            hd = temp.horizontalDistance;

            map.put(hd,temp.data);

            if(temp.left!= null){
                temp.left.horizontalDistance = hd-1;
                queue.add(temp.left);
            }

            if(temp.right!= null){
                temp.right.horizontalDistance=hd+1;
                queue.add(temp.right);
            }

        }

        System.out.println(map.values());

        // to convert to arraylist
        ArrayList<Integer> list = new ArrayList<Integer>(map.values());

        System.out.println(list.toString());


    }


    // gfg - isBST - is Binary Search Tree
    /*
    Properties of a BST:
    1. Left node contains value lesser than root node.
    2. Right node contains value greater than root node.
    3. Both left and right nodes should internally also use binary tree.

    Note: In BST, each node has a distinct key.
     */
    static boolean isBST(Node root){
        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node root, int min, int max) {
        // a empty node is BST.
        if(root==null) return true;

        if (root.data<min || root.data>max) return false;

        return isBSTUtil(root.left,min,root.data-1) && isBSTUtil(root.right,root.data+1, max);

    }

    // isBST other method:
    static Node prev;

    static boolean isBSTUtil(Node root)
    {
        // traverse the tree in inorder fashion and
        // keep track of prev node
        if (root != null)
        {
            if (!isBSTUtil(root.left)) return false;

            // Allows only distinct valued nodes
            if (prev != null && root.data <= prev.data) return false;

            prev = root;

            return isBSTUtil(root.right);
        }
        return true;
    }

    // gfg - left view question
    static void leftView(Node root){
        if(root == null) return;

        System.out.print(root.data+" ");
        if(root.left == null) {
            leftView(root.right);
        } else {
            leftView(root.left);
        }
    }

    // isBinarySearchTree on my own
    static boolean isBinarySearchTree(Node root){
        return isBinarySearchTreeUtils(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static boolean isBinarySearchTreeUtils(Node root, int min, int max){
        if(root==null) return true;

        if(root.data < min || root.data < max) return false;

        return isBinarySearchTreeUtils(root.left,min,root.data-1)&&isBinarySearchTreeUtils(root.right,root.data+1,max);
    }

    // type of traversals
    static void inOrder(Node root){
        if(root == null) return;

        // LNR

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    static void preOrder(Node root){
        if(root == null) return;

        // NLR

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null) return;

        // LRN

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
}

class Node{

    int data;
    Node left,right;
    int horizontalDistance;


    public Node(int data){
        this.data = data;
        horizontalDistance=Integer.MAX_VALUE;
        left = right = null;
    }
}
