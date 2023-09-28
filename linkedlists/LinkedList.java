package linkedlists;

public class LinkedList {
    
    private Node head;
    private Node tail;
    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    public void addFirst(int data){

        // First create the node

        Node newNode = new Node(data);
        if(head ==null){

            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

    }

    public void addLast(int data){

        // First create the node

        Node newNode = new Node(data);
        if(head ==null){

            head = tail = newNode;
            return;
        }

        tail.next = newNode; // current jo tail he, point its next to the new node
        tail = newNode; // make new node as the new tail

    }


    public void print(){
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.print("null");
        System.out.println();
    }

    public void search(int data, Node node,int i){
        if(node == null){
            System.out.println("not found");
            return;
        }

        if(node.data == data){
            System.out.println(data + " found at index : " + i);
            return;
        }

        // If not found , and not last node

        search(data, node.next, i+1);

    }


    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }



    public void deleteNthNodeFromEnd(int n){

        // calculate size

        Node temp = head;
        int sizeOfLL = 0;

        while(temp!=null){
            temp = temp.next;
            sizeOfLL++;
        }

        if(n>sizeOfLL){
            System.out.println("n greater than size of ll");
            return;
        }
        System.out.println("size = " + sizeOfLL);

        int nthNodeFromStart = sizeOfLL - n ; // we need to get to n-1th node , because that will be used to delete 
        System.out.println("nth node from start = " + nthNodeFromStart);
        Node prev = head;
        int i = 1;
        while(i <nthNodeFromStart ){
            prev = prev.next;
            i++;
        }


       if(prev == head){
        head = head.next;
       }
   
        if(  prev== null ||  prev.next == null){
            System.out.println("Nth node is the end");
            return;
        }
        prev.next = prev.next.next;

    }

    public Node findMid(Node headNode){
        Node slow = headNode;
        Node fast = headNode.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("The mid Node value = " + slow.data);
        return slow;
    }


    public boolean isPalindrome(){


        if(head == null || head.next==null){
            return true;
        }
        // Step 1: find mid point brother
        Node mid = findMid(head);

        // Reverse from mid as head

        Node prev = null;
        Node curr = mid;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }


        // whats the head now?


        Node right = prev;
        Node left = head;

        while(right!=null){
            if(right.data != left.data){

                System.out.println(right.data +" of right, and left ka data " + left.data + " do not match");
                return false;
            }

            right = right.next;
            left = left.next;
        }


         


        return true;
    }


    public Node mergeSort(Node headNode){
        // First we find mid

        // base case
        if(headNode==null ||headNode.next == null){
            return headNode;
        }
        Node mid = findMid(headNode);
        Node rightHead = mid.next;
        mid.next =null;

        Node leftHead = headNode;
        Node leftLL = mergeSort(leftHead);
        Node rightLL = mergeSort(rightHead);

        return merge(leftLL,rightLL);
    }


    public Node merge(Node left,Node right){
        Node mergedLL = new Node(Integer.MIN_VALUE);
        Node temp = mergedLL;
        while(left!=null && right!=null){
            if(left.data<right.data){
                temp.next = left;
                left = left.next;
               temp = temp.next;
            }else{
                temp.next = right;
                right =  right.next;
                temp = temp.next;
            }
        }

        while(left!=null){
                   temp.next = left;
                left = left.next;
               temp = temp.next;
        }

        while(right!=null){
              temp.next = right;
                right =  right.next;
                temp = temp.next;
        }




        return mergedLL.next;
    }



    public void ZigZag(Node headNode){
        
        //Mid 
        Node mid = findMid(headNode);

        //Reverse the second half

        Node prev = null;
        Node curr = mid;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 
        Node rightHead = prev;
        Node leftHead = headNode;
        Node nextLeft;
        Node nextRight;


        // Do not memoerize this. Think logically with pen and paper , it will become obvious
        while(rightHead!=null && leftHead!=null){

            // For Ziz Zagging
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            rightHead.next = nextLeft;

            // For preparing next nodes
            leftHead = nextLeft;
            rightHead = nextRight;

        }

        
    }
    public static void main(String[] args) {
        


        
        LinkedList ll = new LinkedList();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        // ll.addLast(6);
        ll.print();

        ll.ZigZag(ll.head);
        // ll.head= ll.mergeSort(ll.head);
        ll.print();

        // System.out.println("linked list is plaindrome = "  + ll.isPalindrome());
     


        // 1 2 3 4 5 6
        // 1 6 2 5 3 4





        // System.out.println("searching for 4");
        // ll.search(4, ll.head, 0);
        // System.out.println("searching for 11");
        // ll.search(11, ll.head, 0);

        // ll.reverse();
        // ll.print();
        
        // System.out.println("searching for 4");
        // ll.search(4, ll.head, 0);
        // System.out.println("searching for 11");
        // ll.search(11, ll.head, 0);


        // System.out.println("\n\n Nodes at present are \n\n");
        // ll.print();
        // System.out.println("Deleting node at index 4th from end");
        // ll.deleteNthNodeFromEnd(4);
        // System.out.println("deleted 4th node from end");
        // ll.print();

    }
}
