public class LengthOfLastWord {
    public static int lengthOfLastWord(String s){
        s = s.trim();
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        String s = "Luffy         is       still         joyboy        ";
        System.out.println(lengthOfLastWord(s));
    }
}
