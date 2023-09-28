package linkedlists;

import java.util.*;
public class DoublyLinkedList{

    public static Node head;
    public static Node tail;
    public static int size;

    public class Node{
        Node next;
        Node prev;
        int data;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head=tail = newNode; 
            return;
        }

        newNode.next =head;
        head.prev = newNode;
        head = newNode;

    }

    public void printDLL(Node headNode){

        // Node temp = head;
        System.out.println("The Doubly Linked List is \n");
        while( headNode !=null){
            System.out.print( headNode.data  + " ->");
          headNode=  headNode .next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(1);
        dll.addFirst(5);
        dll.addFirst(3);
        dll.printDLL(head);
        
    }


}