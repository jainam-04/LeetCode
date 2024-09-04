import java.util.Arrays;

public class Convert1DTo2D {
    public static int[][] construct2DArray(int[] original, int m, int n){
        int[][] original2D = new int[m][n];
        if(m * n == original.length){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    original2D[i][j] = original[i * n + j];
                }
            }
            return original2D;
        }
        else{
            return new int[][]{};
        }
    }
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4};
        int m = 2;
        int n = 2;
        System.out.println(Arrays.deepToString(construct2DArray(original, m, n)));
    }
}
