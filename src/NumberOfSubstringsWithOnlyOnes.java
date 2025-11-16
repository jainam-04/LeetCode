public class NumberOfSubstringsWithOnlyOnes {
    public static void main(String[] args) {
        String s = "111111";
        int result = numSub(s);
        System.out.println(result);
    }

    public static int numSub(String s){
        long count = 0;
        long total = 0;
        long mod = 1000000007;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            }
            else{
                count = 0;
            }
            total = (total + count) % mod;
        }
        return (int) total;
    }
}
