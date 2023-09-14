package recursion;

public class Misc {

    // 2 * n 
    public static int TilingProblem(int n){

        if(n == 0 || n == 1) {
            return 1;
        }


        int vertical  = TilingProblem(n-1);
        int horizontal = TilingProblem(n-2);

        return vertical + horizontal;

    }

    // 
    // public static void FriendsPairingProblem(int n){

    //     if(n == 0 || n == 1) {
    //         return 1;
    //     }


    //     int vertical  = TilingProblem(n-1);
    //     int horizontal = TilingProblem(n-2);

    //     return vertical + horizontal;


    // }
    
}
