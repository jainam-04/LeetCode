import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        String[] sChar = s.split("");
        Arrays.sort(sChar);
        String[] tChar = t.split("");
        Arrays.sort(tChar);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String value : sChar) {
            sb1.append(value);
        }
        for (String value : tChar) {
            sb2.append(value);
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
