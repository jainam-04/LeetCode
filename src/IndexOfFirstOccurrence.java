public class IndexOfFirstOccurrence {
    public static int strStr(String hayStack, String needle){
        if(hayStack.length() < needle.length()){
            return -1;
        }
        for(int i = 0; i <= hayStack.length() - needle.length(); i++){
            if(hayStack.startsWith(needle, i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String hayStack = "leetcode";
        String needle = "leeto";
        System.out.println(strStr(hayStack, needle));
    }
}
