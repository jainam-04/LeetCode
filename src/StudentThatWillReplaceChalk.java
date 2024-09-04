public class StudentThatWillReplaceChalk {
    public static int chalkReplacer(int[] chalk, int n){
        long sum = 0;
        for(int i : chalk){
            sum += i;
        }
        int remaining = (int) (n % sum);
        for(int i = 0; i < chalk.length; i++){
            if(remaining < chalk[i]){
                return i;
            }
            remaining -= chalk[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] chalk = {3, 4, 1, 2};
        int n = 25;
        System.out.println(chalkReplacer(chalk, n));
    }
}
