public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums){
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for(int num : nums){
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if((max1 > num) && (num > max2)){
                max3 = max2;
                max2 = num;
            }
            else if((max2 > num) && (num > max3)){
                max3 = num;
            }
        }
        if(max3 != Long.MIN_VALUE){
            return (int) max3;
        }
        else{
            return (int) max1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5, 3, 5};
        System.out.println(thirdMax(nums));
    }
}
