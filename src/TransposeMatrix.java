import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix){
        int[][] transposeMatrix = new int[matrix[0].length][matrix.length];
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                transposeMatrix[col][row] = matrix[row][col];
            }
        }
        return transposeMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }
}
