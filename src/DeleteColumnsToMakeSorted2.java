public class DeleteColumnsToMakeSorted2 {
    public static void main(String[] args) {
        String[] str = {"ca", "bb", "ac"};
        int result = minDeletionSize(str);
        System.out.println(result);
    }

    public static int minDeletionSize(String[] str){
        int n = str.length;
        int m = str[0].length();
        char[][] a = new char[n][];
        for(int i = 0; i < n; i++){
            a[i] = str[i].toCharArray();
        }
        boolean[] resolved = new boolean[n - 1];
        int unresolved = n - 1;
        int deletions = 0;
        for(int col = 0; col < m && unresolved > 0; col++){
            boolean needDelete = false;
            for(int row = 0; row < n - 1; row++){
                if(!resolved[row] && a[row][col] > a[row + 1][col]){
                    needDelete = true;
                    break;
                }
            }
            if(needDelete){
                deletions++;
                continue;
            }
            for(int row = 0; row < n - 1; row++){
                if(!resolved[row] && a[row][col] < a[row + 1][col]){
                    resolved[row] = true;
                    unresolved--;
                }
            }
        }
        return deletions;
    }
}
