public class CountCollisionsOnRoad {
    public static void main(String[] args) {
        String directions = "LLRR";
        int result = countCollisions(directions);
        System.out.println(result);
    }

    public static int countCollisions(String directions){
        final int n = directions.length();
        if(n == 1){
            return 0;
        }
        int left = 0;
        int right = n - 1;
        while(left < right && directions.charAt(left) == 'L'){
            left++;
        }
        while(left < right && directions.charAt(right) == 'R'){
            right--;
        }
        if(left >= right){
            return 0;
        }
        int count = 0;
        for( ; left <= right; left++){
            count += (directions.charAt(left) != 'S' ? 1 : 0);
        }
        return count;
    }
}
