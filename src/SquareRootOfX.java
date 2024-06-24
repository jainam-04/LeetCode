public class SquareRootOfX {
    public static int sqrt(int x){
        if(x == 0){
            return 0;
        }
        int start = 1;
        int end = x;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid == x / mid){
                return mid;
            }
            if(mid > x / mid){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int x = 2;
        System.out.println(sqrt(x));
    }
}
