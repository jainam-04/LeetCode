import java.util.Arrays;

public class IncrementSubMatricesByOne {
    public static void main(String[] args) {
        int[][] queries = {
                {0, 0, 1, 1}
        };
        int n = 2;
        int[][] result = rangeAddQueries(n, queries);
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] rangeAddQueries(int n, int[][] queries){
        int[][] difference = new int[n + 1][n + 1];
        for(int[] query : queries){
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];
            difference[r1][c1]++;
            difference[r1][c2 + 1]--;
            difference[r2 + 1][c1]--;
            difference[r2 + 1][c2 + 1]++;
        }
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int above = i > 0 ? matrix[i - 1][j] : 0;
                int left = j > 0 ? matrix[i][j - 1] : 0;
                int diagonal = i > 0 && j > 0 ? matrix[i - 1][j - 1] : 0;
                matrix[i][j] = difference[i][j] + above + left - diagonal;
            }
        }
        return matrix;
    }
}
