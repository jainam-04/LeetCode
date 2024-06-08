public class PalindromeNumber {
    public static boolean isPalindrome(int x){
        int reverse = 0;
        int copy = x;
        if(x < 0){
            return false;
        }
        else{
            while(x > 0){
                reverse = (reverse * 10) + (x % 10);
                x = x / 10;
            }
        }
        return reverse == copy;
    }

    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }
}
