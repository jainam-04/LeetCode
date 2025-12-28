public class CountNegativeNoInSortedMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        int result = countNegatives(grid);
        System.out.println(result);
    }

    public static int countNegatives(int[][] grid){
        int count = 0;
        for(int[] rows : grid){
            for(int col : rows){
                if(col < 0){
                    count++;
                }
            }
        }
        return count;
    }
}
