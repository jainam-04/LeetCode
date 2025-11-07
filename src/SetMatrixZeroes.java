import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1}
        };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void setZeroes(int[][] matrix){
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int[] arr = new int[2];
                if(matrix[i][j] == 0){
                    arr[0] = i;
                    arr[1] = j;
                    list.add(arr);
                }
            }
        }
        int i = 0;
        while(i < list.size()){
            int[] arr = list.get(i);
            for(int j = 0; j < matrix.length; j++){
                matrix[j][arr[1]] = 0;
            }
            for(int j = 0; j < matrix[i].length; j++){
                matrix[arr[0]][j] = 0;
            }
            i++;
        }
    }
}
