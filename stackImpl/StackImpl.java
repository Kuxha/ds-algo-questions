
package stackImpl;
import java.util.*;
public class StackImpl {




    public static void reverseString(String s){
        Stack<Character> st = new Stack<>();
   

        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){

            sb.append(st.pop());
        }

     
        System.out.println("AFTER REVERSE");
        System.out.println(   sb.toString());
         
    }


    public static void pushAtBottom(Stack<Integer> st,int x){

        if(st.isEmpty()){
            st.push(x);
            return;
        }


            int top =      st.pop();
       
            pushAtBottom(st, x);
            st.push(top);
     }

    public static void reverseStack(Stack<Integer> st){

        if(st.isEmpty()){
            return;
        }

        int x = st.pop();
        reverseStack(st);
        pushAtBottom(st,x);
        
    }


    public static void test(){


        System.out.println("TESTING REVERSE");
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println("Original Stack");
        System.out.println(st.toString());
        reverseStack(st);
        System.out.println("REVERSED STACK");
        System.out.println(st.toString());



        System.out.println("STOCK SPAN TEST");

        int a[] = {10, 4, 5 ,90, 120, 80};
        stockSpan(a);


        System.out.println("NEXT GREATER ELEMENT");

        int b[] = {10, 4, 5 ,90, 120, 80};
        nextGreaterElement(b);


        System.out.println("TESTING VALID PARENTHESIS");

        String s0 = "[]";
        System.out.println(s0 + " has valid parenthesis  = " + validParenthesis(s0));
        String s01 = "[]}";
        System.out.println(s01 + " has valid parenthesis  = " +validParenthesis(s01));
        String s02 = "[]{}";
        System.out.println(s0 + " has valid parenthesis  = " +validParenthesis(s02));


        System.out.println("TESTING Duplicate PARENTHESIS");
        String s1 = "(a+b){}";
        System.out.println(s1  + "  has duplicates  = " + duplicateParenthesis(s1));
        String s11 = "(a+b)";
        System.out.println(s11  + "  has duplicates  = " + duplicateParenthesis(s11));
    }

    public static void stockSpan(int a[]){


        // till how many days was the span less than whats now
        // [100 80 60 70 60 75 85]
        int res[] = new int[a.length];
        System.out.println("Array");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // First ka answer would always be zero na
        res[0] = 1;
        Stack<Integer> st = new Stack<>();

        st.push(0);

        // jab tak stack mein elements he, which are less than this. keep popppin

        for (int i = 1; i < res.length; i++) {


                while(!st.isEmpty() && a[st.peek()]<a[i]){
                    st.pop();
                 }
                 if(st.isEmpty()){
                    // means there are literally no prices more than this
                    res[i]  = i+1;
                 }else{
                    res[i] = i-st.peek();
                 }

                 st.push(i);
        }

        System.out.println("ANS");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

    


    }

    public static boolean validParenthesis(String s){

        Stack<Character> st = new Stack<>();

        for (int i=0;i<s.length();i++) {
            
            Character character = s.charAt(i);
            System.out.println(character);
            if(character =='(' || character == '{' || character == '['){
                // if character is opening
              
                st.push(character);
            }else{

                if(st.isEmpty()){
                    return false;
                } 
               switch (character) {
                case '}':{
                 
                    if(st.peek() != '{'){
                        return false;
                    }

               
                    break;
                }
                case ']':{
                     if(st.peek() != '['){
                        return false;
                    }
                
                    break;
                }
                case ')':{
                    if(st.peek() != '('){
                        return false;
                    }
                 
                    break;
                }               
                default:
                    break;
               }

                st.pop();
            }

            System.out.println(st);
            
        }


        if(!st.isEmpty()){
            return false;
        }
        return true;

    }

    // assumption is that the string will have valid parenthesis lol
    public static boolean duplicateParenthesis(String s){

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            
            if(character =='}' || character == ']' || character == ')'){
                // if character is a closing bracket 
              int count = 0;
              switch (character) {
                case '}':{

                    while(st.peek()!='{'){
                        st.pop(); // pop out all the operators and operands
                        count++;
                    }
                 
                    if(count == 0){
                        // means this bracket is a duplicate
                        return true;
                    }

                    // now we also pop the opening bracket
                    st.pop();
               
                    break;
                }
                case ']':{
                    while(st.peek()!='['){
                        st.pop(); // pop out all the operators and operands
                        count++;
                    }
                 
                    if(count == 0){
                        // means this bracket is a duplicate
                        return true;
                    }

                    // now we also pop the opening bracket
                    st.pop();
               
                    break;
                }
                case ')':{
                    while(st.peek()!='('){
                        st.pop(); // pop out all the operators and operands
                        count++;
                    }
                 
                    if(count == 0){
                        // means this bracket is a duplicate
                        return true;
                    }

                    // now we also pop the opening bracket
                    st.pop();
               
                    break;
                }               
                default:
                    break;
               }
 
            }else{

 
               st.push(character);


            }

        }

        return false;
        
    }



     public static void nextGreaterElement(int a[]){

    
        int n = a.length;
        if(n==0) return;
        int res[] = new int[n];
        System.out.println("Array");
        for (int i = 0; i <n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        Stack<Integer> st = new Stack<>();

        // The last number will have no next greater , so it's answer will be -1 always
        res[n-1] = -1;
        st.push(a[n-1]); // push last index to stack


        // For next greater element , we traverse backwards
        for (int i = n-2; i>=0; i--) {
            while(!st.isEmpty() && st.peek()<=a[i] ){
                // Until the stack is empty , and until we encounter a value in the stack which is larger than the current value - keep poppin
                st.pop();
            }

            // in case we came out of loop because stack is empty , it means there are no greater elements on the right
            if(st.isEmpty()){
                res[i] = -1;
            }else{
                // else what it means is the element at top of stack is greater than current , so add that to result for curr
                res[i] = st.peek();
            }

            // once we have figured out next greater element for a number , add it to stack
            st.push(a[i]);


        }

        System.out.println("RES");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

    }



    public static void nextSmallerElement(int a[]){

    
        int n = a.length;
        if(n==0) return;
        int res[] = new int[n];
        System.out.println("Array");
        for (int i = 0; i <n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        Stack<Integer> st = new Stack<>();

        // The last number will have no next greater , so it's answer will be -1 always
        res[n-1] = -1;
        st.push(a[n-1]); // push last index to stack


        // For next greater element , we traverse backwards
        for (int i = n-2; i>=0; i--) {
            while(!st.isEmpty() && st.peek()>=a[i] ){
                // Until the stack is empty , and until we encounter a value in the stack which is larger than the current value - keep poppin
                st.pop();
            }

            // in case we came out of loop because stack is empty , it means there are no greater elements on the right
            if(st.isEmpty()){
                res[i] = -1;
            }else{
                // else what it means is the element at top of stack is greater than current , so add that to result for curr
                res[i] = st.peek();
            }

            // once we have figured out next greater element for a number , add it to stack
            st.push(a[i]);


        }

        System.out.println("RES");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

    }


    public static int[] nextSmallerElementIndex(int a[]){

    
        int n = a.length;
        if(n==0){
            return new int[]{};
        }
        int res[] = new int[n];
        System.out.println("Array");
        for (int i = 0; i <n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        Stack<Integer> st = new Stack<>();

        // The last index will be = n , since next smaller element does't exist
        res[n-1] = n;
        st.push(n-1); // push last index to stack


        // For next greater element , we traverse backwards
        for (int i = n-2; i>=0; i--) {
            while(!st.isEmpty() && a[st.peek()]>=a[i] ){
                // Until the stack is empty , and until we encounter a value in the stack which is larger than the current value - keep poppin
                st.pop();
            }

            // in case we came out of loop because stack is empty , it means there are no greater elements on the right
            if(st.isEmpty()){
                res[i] = n;
            }else{
                // else what it means is the element at top of stack is greater than current , so add that to result for curr
                res[i] = st.peek();
            }

            // once we have figured out next greater element for a number , add it to stack
            st.push(i);


        }

        System.out.println("RES");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        return res;

    }


    public static int[] previousSmallerElementIndex(int a[]){

    
        int n = a.length;
        if(n==0) {
            return new int[]{};
        }
        int res[] = new int[n];
        System.out.println("Array");
        for (int i = 0; i <n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        Stack<Integer> st = new Stack<>();

        // The first index wont have a previous smaller, so anser always -1
        res[0] = -1;
        st.push(n-1); // push last index to stack


        // For next greater element , we traverse backwards
        for (int i = 1; i<n; i++) {
            while(!st.isEmpty() && a[st.peek()]>=a[i] ){
                // Until the stack is empty , and until we encounter a value in the stack which is larger than the current value - keep poppin
                st.pop();
            }

            // in case we came out of loop because stack is empty , it means there are no greater elements on the right
            if(st.isEmpty()){
                res[i] = -1;
            }else{
                // else what it means is the element at top of stack is greater than current , so add that to result for curr
                res[i] = st.peek();
            }

            // once we have figured out next greater element for a number , add it to stack
            st.push(i);


        }

        System.out.println("RES");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        return res;
    }



    public static int maximumHistogramArea(int a[]){

        // First Find Next Smaller element array
        int[] prevSmallerIndex = previousSmallerElementIndex(a);
        int[] nextSmallerIndex = nextSmallerElementIndex(a);

        // We need to find maximum area possible for each bar

        int area=0,height=0,width = 0,maximumArea = 0;


        System.out.println("Maximum Histogram Area - for the following array");
        for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {

            height = a[i];
            width = nextSmallerIndex[i] - prevSmallerIndex[i] -1;
            area = height * width;
            System.out.print(area +" ");
            maximumArea = Math.max(maximumArea, area);
            
        }
        System.out.println();

        return maximumArea;

    }
    public static void main(String[] args) {

       System.out.println("NEXT GREATER ELEMENT");

        int b[] = {6, 2, 5, 4, 5, 1, 6};
        // answer is 2,6,10,6,8,3
        System.out.println("maximum area is " + maximumHistogramArea(b));
    }
    
}
