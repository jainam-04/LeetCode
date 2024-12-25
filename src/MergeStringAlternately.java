public class MergeStringAlternately {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2){
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while((i < word1.length()) && (j < word2.length())){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        while(i < word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j < word2.length()){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}
