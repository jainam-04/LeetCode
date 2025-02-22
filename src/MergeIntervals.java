import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 16}
        };
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int[] previous = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(interval[0] <= previous[1]){
                previous[1] = Math.max(previous[1], interval[1]);
            }
            else{
                merged.add(previous);
                previous = interval;
            }
        }
        merged.add(previous);
        return merged.toArray(new int[merged.size()][]);
    }
}
