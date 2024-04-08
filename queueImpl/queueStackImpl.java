package queueImpl;

import java.util.Stack;

public class queueStackImpl {


    public static class Queue{

         static Stack<Integer> s1 = new Stack<>();
         static Stack<Integer> s2 = new Stack<>();

  

        public boolean isEmpty(){
            return s1.isEmpty();
        }
        
        public void add(int data){

            // first check if s1 is empty

            if(s1.empty()){
                // if empty , directly add to s1 and return
                s1.push(data);
                return;
            }


            // else if s1 is not empty
            // first take all elements from s1 and push to s2

            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }

            return;
        }
    

        public  int remove(){
            if(this.isEmpty()){
                System.out.println("empty queue");
                return -1;
            }

            return s1.pop();
        }

        public  int peek(){
            return s1.peek();
        }
    

    
    }

    
        public static void main(String[] args) {

            Queue q = new Queue();

            q.add(0);
            q.add(2);
            q.add(4);


            while(!q.isEmpty()){
                System.out.println(q.remove());
            }
            
        }
    
}
    

