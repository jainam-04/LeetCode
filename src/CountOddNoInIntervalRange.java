public class CountOddNoInIntervalRange {
    public static void main(String[] args) {
        int low = 8;
        int high = 10;
        int result = countOdds(low, high);
        System.out.println(result);
    }

    public static int countOdds(int low, int high){
        return (high + 1) / 2 - (low / 2);
    }
}
