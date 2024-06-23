import java.util.HashSet;

public class RowAndColumnContainsAllNumbers {
    public static boolean checkValid(int[][] matrix){
        for (int[] ints : matrix) {
            HashSet<Integer> set = new HashSet<>();
            for (int anInt : ints) {
                if (set.contains(anInt)) {
                    return false;
                }
                set.add(anInt);
            }
        }
        for(int i = 0; i < matrix.length; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < matrix[i].length; j++){
                if(set.contains(matrix[j][i])){
                    return false;
                }
                set.add(matrix[j][i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        };
        System.out.println(checkValid(matrix));
    }
}
