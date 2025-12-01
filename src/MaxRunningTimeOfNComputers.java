import java.util.Arrays;

public class MaxRunningTimeOfNComputers {
    public static void main(String[] args) {
        int n = 2;
        int[] batteries = {1, 1, 1, 1};
        long result = maxRunTime(n, batteries);
        System.out.println(result);
    }

    public static long maxRunTime(int n, int[] batteries){
        long totalEnergy = 0;
        for(int battery : batteries){
            totalEnergy += battery;
        }
        Arrays.sort(batteries);
        for(int i = batteries.length - 1; i >= 0; i--){
            if(batteries[i] > totalEnergy / n){
                totalEnergy -= batteries[i];
                n--;
            }
            else{
                break;
            }
        }
        return totalEnergy / n;
    }
}
