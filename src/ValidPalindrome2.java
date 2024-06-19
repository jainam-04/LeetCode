public class ValidPalindrome2 {
    public static boolean validPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            char currentStart = s.charAt(start);
            char currentEnd = s.charAt(end);
            if(currentStart != currentEnd){
                return compare(s, start + 1, end) || compare(s, start, end - 1);
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }

    public static boolean compare(String s, int start, int end){
        while(start < end){
            char currentStart = s.charAt(start);
            char currentEnd = s.charAt(end);
            if(currentStart != currentEnd){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "deeee";
        System.out.println(validPalindrome(s));
    }
}
