public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {3, 1, 2, 4, 5};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int h = Math.min(height[left], height[right]);
            int b = right - left;
            int area = b * h;
            maxArea = Math.max(maxArea, area);
            if(height[left] <= height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
