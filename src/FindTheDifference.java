public class FindTheDifference {
    public static char findTheDifference(String s, String t){
        int x = 0;
        for(char i : s.toCharArray()){
            x = x ^ i;
        }
        for(char i : t.toCharArray()){
            x = x ^ i;
        }
        return (char) x;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }
}
