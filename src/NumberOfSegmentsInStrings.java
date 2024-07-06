public class NumberOfSegmentsInStrings {
    public static int countSegments(String s){
        String[] words = s.split(" ");
        int count = 0;
        for(String word : words){
            if(!word.isEmpty()){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "Hello, my name is John";
        System.out.println(countSegments(s));
    }
}
