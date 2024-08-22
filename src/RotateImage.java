import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        for(int row = 0; row < n / 2; row++){
            for(int col = row; col < n - row - 1; col++){
                swap(matrix, row, col, col, n - 1- row); // swaps top-left and top-right
                swap(matrix, row, col, n - 1 - row, n - 1 - col); // swaps top-left and bottom-right
                swap(matrix, row, col, n - 1 - col, row); // swaps top-left and bottom-left
            }
        }
    }

    public static void swap(int[][] matrix, int first, int second, int third, int fourth){
        int temp = matrix[first][second];
        matrix[first][second] = matrix[third][fourth];
        matrix[third][fourth] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
