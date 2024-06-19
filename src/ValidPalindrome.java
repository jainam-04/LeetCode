public class ValidPalindrome {
    public static boolean isPalindrome(String s){
        if(s.isEmpty()){
            return true;
        }
        else{
            int start = 0;
            int end = s.length() - 1;
            while(start <= end){
                char currentStart = s.charAt(start);
                char currentEnd = s.charAt(end);
                if(!Character.isLetterOrDigit(currentStart)){
                    start++;
                }
                else if(!Character.isLetterOrDigit(currentEnd)){
                    end--;
                }
                else{
                    if(Character.toLowerCase(currentStart) != Character.toLowerCase(currentEnd)){
                        return false;
                    }
                    start++;
                    end--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
