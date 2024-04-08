package trees;

import java.util.*;

import javax.swing.tree.TreeNode;
public class treesImpl {

    public static class Node {
        int data;
        Node left;
        Node right;


        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;

        }
    }



    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){

        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    public static void levelOrder(Node root){

        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();

        q.add(root);


        while(!q.isEmpty()){
            Node node = q.remove();

            System.out.print(node.data +" ");

            if(node.left!=null){
                q.add(node.left);
            }

            if(node.right!=null){
                q.add(node.right);
            }
        }

    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);


        return Math.max(leftHeight, rightHeight)+1;
    }

    public static int countNumberOfNodes(Node root){
        if(root == null){
            return 0;
        }


        int leftCount = countNumberOfNodes(root.left);
        int rightCount = countNumberOfNodes(root.right);
        
        return leftCount + rightCount + 1;

    }

    public static int sumOfNodes(Node root){

        if(root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }



    // Time complexity = O(n^2)
    public static int diameter(Node root){


        if(root == null) {
            return 0;
        }
        // Diameter of a tree is longest route from a leaf to a leaf

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);


        int selfDiameter = height(root.left) + height(root.right) + 1;

        return Math.max(rightDiameter, Math.max(leftDiameter, selfDiameter));
    }




    public static class NodeInfo {
        int height;
        int diameter;

        public NodeInfo(int h,int d){
            this.height = h;
            this.diameter = d;
        }
    }

    public static NodeInfo diameterOfATreeOptimized(Node root){


        if(root == null){
            return  new NodeInfo(0,0);
        }

        // First get Diameter

        NodeInfo leftInfo = diameterOfATreeOptimized(root.left);
        NodeInfo rightInfo = diameterOfATreeOptimized(root.right);

        
        int selfDiameter = leftInfo.height + rightInfo.height + 1;

        // visualize this well. There are two cases - one where diameter is going through root (in which case selfDiamter is the diameter)
        // in the other case the diamter is in either left or right 
        // we take maximum of the three cases
        int diameter = Math.max(selfDiameter, Math.max(leftInfo.diameter,rightInfo.diameter));
        int height =  Math.max(leftInfo.height, rightInfo.height) + 1;

        return new NodeInfo(height, diameter);
    }



        public static boolean isIdentical(Node root, Node subRoot) {
        
        if(root == null && subRoot == null){
            return true;
        }

        if(root == null || subRoot == null || root.data != subRoot.data){
            return false;
        }


        // here both vals are equal
        if(!isIdentical(root.left,subRoot.left)){
            return false;
        }

        if(!isIdentical(root.right,subRoot.right)){
            return false;
        }

        return true;



    }
    
    public boolean isSubtree(Node root, Node subRoot) {
        
        if(root == null && subRoot == null) {
            return true;
        }

        if(root == null || subRoot == null){
            return false;
        }

        // First we try to find ma
        if(root.data ==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
                // if not identical we go to left and right
            }
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);


    }


    public static class HDInfo {

        int  horizontalDistance;
        Node node;

        HDInfo(Node n,int h){
            this.horizontalDistance = h;
            this.node = n;
        }
    }

    public static void TopViewOfTree(Node root){

        // First we need queue boi - for level order traversing
        // Horizontal distance  - for first node its 0 - then its children will have  -1 and +1 each 



        if(root == null){
            System.out.println("Tree is empty mate");
            return;
        }

        // Now here we take take a queue

        Queue<HDInfo> q = new LinkedList<>();
        q.add(new HDInfo(root,0)); // first root node ka HD  = 0

        HashMap<Integer,Node> map = new HashMap<>();
        map.put(0, root);

        int min = 0;
        int max = 0;

        q.add(null); // why ? super important- to know when you have reached a level


        while(!q.isEmpty()){
            HDInfo curr = q.poll();
            // first we get the current node

            if(curr == null){
                // means next node tak jao
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null); //insert again for next level lol
                }
            }

            // if curr !=null

            if(!map.containsKey(curr.horizontalDistance)){
                map.put(curr.horizontalDistance, curr.node);
                min = Math.min(min, curr.horizontalDistance);
                max = Math.max(max, curr.horizontalDistance);
            }
        }




    }
    public static void main(String[] args) {
        // making a binary tree

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);


        // testing preorder
        System.out.println("\nPreorder Traversal");
        preOrder(root);

        // testing inorder
        System.out.println("\nInorder Traversal");
        inOrder(root);

        // testing postorder
        System.out.println("\nPostorder Traversal");
        postOrder(root);


        // testing level order
        System.out.println("\nLevel order Traversal");
        levelOrder(root);

        // testing height
        System.out.print("\nheight of tree = " + height(root));
       

        // testing number of nodes
        System.out.print("\ncount of nodes = " + countNumberOfNodes(root));

        System.out.println("\nsum of nodes = " + sumOfNodes(root));

        System.out.println("\ndiameter = " + diameterOfATreeOptimized(root).diameter);
    }


    
    
}
