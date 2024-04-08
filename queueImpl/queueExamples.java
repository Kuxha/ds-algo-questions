
package queueImpl;
import java.util.*;
public class queueExamples {
    


    // interleave queue


    public static void interleaveTwoHalvesofQueue(Queue<Integer> q){
        System.out.println("OLD QUEUE");
        System.out.println(q);

        Queue<Integer> newQueue = new ArrayDeque<>(1000); // to have the first half
        int size = q.size();

        for (int i = 0; i < size/2; i++) {
            newQueue.add(q.remove());
        }

        // now new queue has first half of the queue
        // old queue has the 2nd half


        while(!newQueue.isEmpty()){
            q.add(newQueue.remove());
            q.add(q.remove());
        }


        System.out.println("NEW QUEUE");
        System.out.println(q);

    }



    //First non repeating letter

    public static void firstNonRepeating(String s){

        // aabccxb
        // answer is a -1 b b b b x 

        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26]; // for frequency
        // why queue , because we need to check first of something
        for (int i = 0; i < s.length(); i++) {

            // System.out.println("checking for char at index + " + i + " = " + s.charAt(i));
            // System.out.println(s.charAt(i) - 'a');
            q.add(s.charAt(i));
            freq[s.charAt(i)-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }


            // if queue is empty
            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }else{
                // if queue is not empty , and we find a element on top of queue which has frequency == 1
                System.out.print(q.peek() +" ");
            }


        }
    }


    public static void testing(){
        
        String s = "aabccxb";
        firstNonRepeating(s);
    }
    public static void main(String[] args) {


        Queue<Integer> q = new ArrayDeque<>(1000);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        // input - 1,2,3,4,5,6
        // output- 1,4,2,5,3,6


        interleaveTwoHalvesofQueue(q);
    }
}
