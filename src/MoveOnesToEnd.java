public class MoveOnesToEnd {
    public static void main(String[] args) {
        String str = "00111";
        int result = maxOperations(str);
        System.out.println(result);
    }

    public static int maxOperations(String str){
        int ones = 0;
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                ones++;
            }
            else if(i > 0 && str.charAt(i - 1) == '1'){
                count += ones;
            }
        }
        return count;
    }
}
