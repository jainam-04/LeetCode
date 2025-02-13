public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxPrice(prices));
    }

    public static int maxPrice(int[] prices){
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int price : prices) {
            if (price < min_price) {
                min_price = price;
            }
            max_profit = Math.max(max_profit, price - min_price);
        }
        return max_profit;
    }
}
