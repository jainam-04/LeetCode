public class CountNoOfComputerUnlockingPermutations {
    public static void main(String[] args) {
        int[] complexity = {3, 3, 3, 4, 4, 4};
        int result = countPermutations(complexity);
        System.out.println(result);
    }

    public static int countPermutations(int[] complexity){
        final int MOD = 1000000007;
        int n = complexity.length;
        int first = complexity[0];
        for(int i = 1; i < n; i++){
            if(complexity[i] <= first){
                return 0;
            }
        }
        long factorial = 1;
        for(int i = 2; i < n; i++){
            factorial = (factorial * i) % MOD;
        }
        return (int) factorial;
    }
}
