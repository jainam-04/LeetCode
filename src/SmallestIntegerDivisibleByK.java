public class SmallestIntegerDivisibleByK {
    public static void main(String[] args) {
        int k = 17;
        int result = smallestRepUnitDivByK(k);
        System.out.println(result);
    }

    public static int smallestRepUnitDivByK(int k){
        if(k == 1){
            return 1;
        }
        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        int rem = 0;
        for(int i = 1; i <= k; i++){
            rem = ((rem * 10) + 1) % k;
            if(rem == 0){
                return i;
            }
        }
        return -1;
    }
}
