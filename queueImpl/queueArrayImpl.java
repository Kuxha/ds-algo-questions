package queueImpl;

public class queueArrayImpl {

    // NAIVE QUEUE IMPLEMENTAION
    public static class Queue{

        static int queue[];
        static int front;

         public  Queue(int n){
            queue = new int[n];
            front = -1;
        }

        public boolean isEmpty(){
            return front == -1;
        }

    
        public void add(int data) {

            if(front == queue.length -1){
                // means full
                System.out.println("queue is full - no more");
                return;
            }
            front++;
            queue[front]= data;


        }


        public int remove() {
            int removedElement = queue[0];


            for (int i = 0; i < queue.length-1; i++) {
                queue[i] = queue[i+1];
            }

            front--;

            return removedElement;
        }


        public int peek() {
            return queue[0];
        }
        
    }



    public static class CircularQueue{

        static int queue[];
        static int front;

         public  CircularQueue(int n){
            queue = new int[n];
            front = -1;
        }

        public boolean isEmpty(){
            return front == -1;
        }

    
        public void add(int data) {

            if(front == queue.length -1){
                // means full
                System.out.println("queue is full - no more");
                return;
            }
            front++;
            queue[front]= data;


        }


        public int remove() {
            int removedElement = queue[0];


            for (int i = 0; i < queue.length-1; i++) {
                queue[i] = queue[i+1];
            }

            front--;

            return removedElement;
        }


        public int peek() {
            return queue[0];
        }
        
    }

    public static void main(String[] args) {

        Queue q = new Queue(10);

        q.add(0);
        q.add(2);
        q.add(4);


        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
        
    }


    
}
