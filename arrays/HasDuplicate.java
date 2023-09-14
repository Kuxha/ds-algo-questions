package arrays;
import java.util.HashSet;
import java.util.Set;

public class HasDuplicate {
    public static boolean HasDuplicateinArray(int a[]){

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            if(set.contains(a[i])) return false;

            set.add(a[i]);
        }
        return true;
    }

}
