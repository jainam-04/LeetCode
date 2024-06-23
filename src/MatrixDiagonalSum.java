public class MatrixDiagonalSum {
    public static int diagonalSum(int[][] matrix){
        int sumOfDiagonal1 = 0;
        int sumOfDiagonal2 = 0;
        for(int i = 0, j = 0; i < matrix.length; i++, j++){
            sumOfDiagonal1 += matrix[i][j];
        }
        for(int i = 0, j = matrix.length - 1; i < matrix.length; i++, j--){
            sumOfDiagonal2 += matrix[i][j];
        }
        int sum = sumOfDiagonal1 + sumOfDiagonal2;
        if(matrix.length % 2 != 0){
            sum -= matrix[matrix.length / 2][matrix[0].length / 2];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5}
        };
        System.out.println(diagonalSum(matrix));
    }
}
