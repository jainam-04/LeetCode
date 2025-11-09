public class CountOperationsToObtainZero {
    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 3;
        int result = countOperations(num1, num2);
        System.out.println(result);
    }

    public static int countOperations(int num1, int num2){
        int count = 0;
        while(num1 != 0 && num2 != 0){
            if(num1 >= num2){
                num1 -= num2;
            }
            else{
                num2 -= num1;
            }
            count++;
        }
        return count;
    }
}
