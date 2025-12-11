import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CountCoveredBuildings {
    public static void main(String[] args) {
        int n = 5;
        int[][] buildings = {
                {1, 3},
                {3, 2},
                {3, 3},
                {3, 5},
                {5, 3}
        };
        int result = countCoveredBuildings(n, buildings);
        System.out.println(result);
    }

    public static int countCoveredBuildings(int n, int[][] buildings){
        Map<Integer, TreeSet<Integer>> rowToCol = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colToRow = new HashMap<>();
        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];
            rowToCol.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            colToRow.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }
        int count = 0;
        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];
            TreeSet<Integer> rows = rowToCol.get(x);
            TreeSet<Integer> cols = colToRow.get(y);
            Integer left = cols.lower(y);
            Integer right = cols.higher(y);
            Integer up = rows.lower(x);
            Integer down = rows.higher(x);
            if((left != null) && (right != null) && (up != null) && (down != null)){
                count++;
            }
        }
        return count;
    }
}
