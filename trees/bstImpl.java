package trees;

import java.util.*;

public class bstImpl {

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

    public static Node insertNode(Node n,Node root){

        if(root == null){

            System.out.println("node being inserted = "  + n.data);
           root = n;
           return root;
        }
        if(n.data <root.data){
            root.left = insertNode(n,root.left);
        }else{

        root.right = insertNode(n,root.right);
        }

        return root;
    }

    public static Node createBST(int a[]){
        Node root = null;
        for (int i = 0; i < a.length; i++) {

            System.out.println("Value being inserted  = " + a[i]);
            Node n = new Node(a[i]);
            if(i== 0 ){
                root = n;
            }else{
                insertNode(n, root);
            }
   
        }

        return root;
    }

    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }



    public static boolean search(Node root , int key){

        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data <key){
            // look in right subtree
            return search(root.right,key);
        }else{
           // look in left subtree
           return  search(root.left,key); 
        }





    }


    public static void delete(Node n){
        // n is the node to be deleted

        // If node has  0 child
        if(n.left == null && n.right == null){
            // if it contains no children simply make it null
            n = null;
        }

        // If node has 1 left child
        if(n.left !=null && n.right == null){
            n = n.left;
        }

        // If node has 1 right child
        if(n.right !=null && n.left == null){
            n = n.right;
        }


        // If node has both children

        // Find inorder successsor
        Node inorderSuccessor = n.right;

        while(inorderSuccessor.left!=null){
            inorderSuccessor = inorderSuccessor.left;
        }


        n = inorderSuccessor;
        inorderSuccessor = null;


        return;

    }



    
    public static void main(String[] args) {
        // making a binary tree
        int a[] = {7,8,9,10,1,2,3,4,5,6};
        Node root = createBST(a);

        inorderTraversal(root);
        System.out.println("\nKey 10 is in BST " + search(root, 10));


 
    }


    
    
}
