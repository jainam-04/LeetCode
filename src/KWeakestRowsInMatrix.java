import java.util.Arrays;

public class KWeakestRowsInMatrix {
    public static int[] kWeakestRows(int[][] matrix, int k){
        int count_soldiers = 0;
        int[] arr = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    count_soldiers++;
                }
            }
            arr[i] = count_soldiers;
            count_soldiers = 0;
        }
        int[] new_arr = new int[arr.length];
        System.arraycopy(arr, 0, new_arr, 0, new_arr.length);
        Arrays.sort(new_arr);
        int[] ans = new int[k];
        int min;
        for(int i = 0; i < k; i++){
            min = i;
            for(int j = 0; j < arr.length; j++){
                if((arr[j] == new_arr[min]) && (arr[j] != -1)){
                    min = j;
                    arr[j] = -1;
                    break;
                }
            }
            ans[i] = min;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows(matrix, k)));
    }
}
