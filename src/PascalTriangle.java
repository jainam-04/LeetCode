import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            ans.add(generateRows(i));
        }
        return ans;
    }

    public static List<Integer> generateRows(int rows){
        int ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col = 1; col < rows; col++){
            ans = ans * (rows - col);
            ans = ans / col;
            ansRow.add(ans);
        }
        return ansRow;
    }

    public static void main(String[] args) {
        int n = 10;
        List<List<Integer>> list = generate(n);
        System.out.println(list);
    }
}
