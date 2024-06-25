public class SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;
        if(rows == 1){
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }
        while(rStart <= (rEnd - 1)){
            int mid = rStart + (rEnd - rStart) / 2;
            if(matrix[mid][cMid] == target){
                return true;
            }
            if(matrix[mid][cMid] > target){
                rEnd = mid;
            }
            else{
                rStart = mid;
            }
        }
        if(matrix[rStart][cMid] == target){
            return true;
        }
        if(matrix[rStart + 1][cMid] == target){
            return true;
        }
        if(target <= matrix[rStart][cMid - 1]){
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }
        if((target >= matrix[rStart][cMid + 1]) && (target <= matrix[rStart][cols - 1])){
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }
        if(target <= matrix[rStart + 1][cMid - 1]){
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        }
        else{
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
    }

    public static boolean binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd - cStart) / 2;
            if(matrix[row][mid] == target){
                return true;
            }
            if(matrix[row][mid] > target){
                cEnd = mid - 1;
            }
            else{
                cStart = mid + 1;
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
