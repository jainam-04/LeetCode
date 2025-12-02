import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNoOfTrapezoids1 {
    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {1, 0},
                {0, 1},
                {2, 1}
        };
        int result = countTrapezoids(points);
        System.out.println(result);
    }

    public static int countTrapezoids(int[][] points){
        long MOD = 1000000007L;
        Map<Integer, Long> map = new HashMap<>();
        for(int[] point : points){
            map.put(point[1], map.getOrDefault(point[1], 0L) + 1);
        }
        List<Long> segment = new ArrayList<>();
        for(long key : map.values()){
            if(key >= 2){
                segment.add((key * (key - 1) / 2) % MOD);
            }
        }
        long sum = 0;
        long ans = 0;
        for(long value : segment){
            ans = (ans + value * sum) % MOD;
            sum = (sum + value) % MOD;
        }
        return (int) ans;
    }
}
