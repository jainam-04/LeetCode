public class Power {
    public static double pow(double x, int n){
        return Math.pow(x, n);
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        System.out.println(pow(x, n));
    }
}
