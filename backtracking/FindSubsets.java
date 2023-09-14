package backtracking;

public class FindSubsets {
    

    public void FindSubsets(String s, int i , String ans){

        // BASE CASE
        if(i == s.length()){
            System.out.println(ans);
            return;
        }

        FindSubsets(s, i+1, ans + s.charAt(i)); // Here we consider the character at ith index in our answer // YES
        // (basically all YES wala answers will come first )
        FindSubsets(s, i+1, ans); // Here we do not take the character at ith index // NO

    }
}
