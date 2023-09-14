package recursion;

public class Strings {


    public String RemoveDuplicates(String str,int index,StringBuilder res,boolean []map){

        if(index == str.length() -1){
            return res.toString();
        }

        char curr = str.charAt(index);

        if(map[curr-'a']){
                // if the character already exists , we do not have to append it to our ans - just call remove duplicated for next index
                return RemoveDuplicates(str, index+1, res, map);
        }else{
            // if the character does not exist - we first put map = true, and then also append it to our results
                map[curr-'a'] = true;
                res.insert(0,curr);
                return RemoveDuplicates(str, index+1, res, map);
        }



    }

    public static void main(String[] args) {
    //    String s = "LABA KUMAR DEKA";

    //    int res = lengthOfString(s,0);

    //    System.out.println("length of string " + s + " is  " + res);



       int res2 = 0;
       String s2 = "abcab";
       int ans = countSameStringThingy(s2,0,s2.charAt(0),res2);

       System.out.println("answer " +( ans ));

        }


    public static int countSameStringThingy(String s,int index,char c,int res){


       

            if(s.length()== index){
                return res;
            }


            System.out.println("index = " + index + " char is " + s.charAt(index) + " , checked with  " + c);

            System.out.println(res);
            if(s.charAt(index) == c){
                System.out.println("matches so res ko bahra do");
                res = res + 1;
            }

            System.out.println(res);

            return 1+ countSameStringThingy(s, index+1, s.charAt(index), res);

        }
    public static int lengthOfString(String s,int i){

        try {
            char c= s.charAt(i);
            System.out.println("char = " + c);
            return lengthOfString(s, i+1);
        } catch (Exception e) {
            return i;
          
        }

    }
    public static String convertNumtoString(int n,StringBuilder s){

        if(n == 0){
            return s.toString();
        }
        int digit = n%10;
        
        s.insert(0," ");
        switch (digit) {
            case 0:
                s.insert(0,"zero");
                break;
        
            case 1:
                s.insert(0,"one");
                break;
            case 2:
                s.insert(0,"two");
                break;
            case 3:
                s.insert(0,"three");
                break;
            case 4:
                s.insert(0,"four");
                break;
            case 5:
                s.insert(0,"five");
                break;
            case 6:
                s.insert(0,"six");
                break;
            case 7:
                s.insert(0,"seven");
                break;
            case 8:
                s.insert(0,"eight");
                break;
            case 9:
                s.insert(0,"nine");
                break;
        
        }

        return convertNumtoString(n/10, s);


    }

    
}
