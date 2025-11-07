public class MaximizeTheMinimum {
    public static void main(String[] args) {
        int[] stations = {4, 4, 4, 4};
        int r = 0;
        int k = 3;
        long result = maxPower(stations, r, k);
        System.out.println(result);
    }

    public static long maxPower(int[] stations, int r, int k){
        long low = 0;
        long high = 0;
        for(int s : stations){
            high += s;
        }
        high += k;
        long ans = 0;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(canAchieve(stations, r, k, mid)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public static boolean canAchieve(int[] stations, int r, long k, long target){
        int n = stations.length;
        long[] add = new long[n];
        long used = 0;
        long windowSum = 0;
        for(int i = 0; i <= r; i++){
            windowSum += stations[i];
        }
        for(int i = 0; i < n; i++){
            if(i - r - 1 >= 0){
                windowSum -= stations[i - r - 1] + add[i - r - 1];
            }
            if(i + r < n && i != 0){
                windowSum += stations[i + r] + add[i + r];
            }
            if(windowSum < target){
                long need = target - windowSum;
                if(used + need > k){
                    return false;
                }
                used += need;
                add[Math.min(n - 1, i + r)] += need;
                windowSum += need;
            }
        }
        return true;
    }
}
