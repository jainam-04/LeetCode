public class PalindromeInMinimumNumberOfSwaps {
    public static void minimumNumberOfSwaps(String s){
        char[] ch = s.toCharArray();
        int count = 0;
        if(checkIsPalindrome(ch)){
            System.out.println(count);
            return;
        }
        for(int i = 2; i < ch.length; i++){
            if(ch[i - 1] != ch[i]){
                swap(ch, i - 1, i);
                count++;
            }
            if(checkIsPalindrome(ch)){
                break;
            }
            if(ch[ch.length - i + 1] != ch[ch.length - i]){
                swap(ch, ch.length - i + 1, ch.length - i);
                count++;
            }
            if(checkIsPalindrome(ch)){
                break;
            }
        }
        System.out.println(count);
    }

    public static void swap(char[] ch, int first, int second){
        char temp = ch[first];
        ch[first] = ch[second];
        ch[second] = temp;
    }

    public static boolean checkIsPalindrome(char[] ch){
        int start = 0;
        int end = ch.length - 1;
        while(start <= end){
            if(ch[start] != ch[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "racecar";
        minimumNumberOfSwaps(s);
    }
}
