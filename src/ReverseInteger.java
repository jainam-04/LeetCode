public class ReverseInteger {
    public static void main(String[] args) {
        int n = -123;
        System.out.println(reverseNumber(n));
    }

    public static int reverseNumber(int n){
        boolean flag = false;
        if(n < 0){
            n = n * -1;
            flag = true;
        }
        int rev = 0;
        while(n > 0){
            int rem = n % 10;
            n /= 10;
            if(rev > (Integer.MAX_VALUE - rem) / 10){
                return 0;
            }
            rev = rev * 10 + rem;
        }
        if(flag){
            rev = rev * -1;
        }
        return rev;
    }
}
