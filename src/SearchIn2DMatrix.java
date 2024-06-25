public class SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target){
        int r = matrix.length;
        int c = matrix[0].length;
        int start = 0;
        int end = r * c - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int row = mid / c;
            int col = mid % c;
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
