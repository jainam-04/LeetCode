public class OperationsToMakeIntegerZero {
    public static void main(String[] args) {
        int n = 6;
        int result = minimumOneBitOperations(n);
        System.out.println(result);
    }

    public static int minimumOneBitOperations(int n){
        int result = 0;
        while(n > 0){
            result ^= n;
            n >>= 1;
        }
        return result;
    }
}
