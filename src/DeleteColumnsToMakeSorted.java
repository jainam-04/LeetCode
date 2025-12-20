public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        String[] str = {"cba", "daf", "ghi"};
        int result = minDeletionSize(str);
        System.out.println(result);
    }

    public static int minDeletionSize(String[] str){
        int count = 0;
        for(int i = 0; i < str[0].length(); i++){
            count += isUnsorted(str, i);
        }
        return count;
    }

    public static int isUnsorted(String[] str, int j){
        for(int i = 1; i < str.length; i++){
            if(str[i].charAt(j) < str[i - 1].charAt(j)){
                return 1;
            }
        }
        return 0;
    }
}
