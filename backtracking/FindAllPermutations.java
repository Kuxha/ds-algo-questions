package backtracking;

public class FindAllPermutations {
    

    public void FindAllPermutations(String s,String ans){


        if(s.length() == 0){
            System.out.println(ans);
            return;
        }


        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);
            String newString = s.substring(0, i) + s.substring(i +1);
            FindAllPermutations(newString, ans+curr);
            
        }
    }
}
