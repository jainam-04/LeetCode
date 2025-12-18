public class BestTimeToBuyAndSellStockUsingStrategy {
    public static void main(String[] args) {
        int[] prices = {4, 2, 8};
        int[] strategy = {-1, 0, 1};
        int k = 2;
        long result = maxProfit(prices, strategy, k);
        System.out.println(result);
    }

    public static long maxProfit(int[] prices, int[] strategy, int k){
        final int n = prices.length;
        final int k2 = k / 2;
        long[] sum = new long[n + 1];
        long modify = 0;
        long sum_ = 0;
        for(int i = 0; i < n; i++){
            final int x = prices[i];
            sum[i + 1] = sum_ += (long) strategy[i] * x;
            modify += ((i >= k2 & i < k) ? x : 0);
        }
        long profit = Math.max(sum[n], modify + sum[n] - sum[k]);
        for (int i = 1; i + k <= n; i++) {
            modify += prices[i + k - 1] - prices[i + k2 - 1];
            profit = Math.max(profit, modify + sum[n] - sum[i + k] + sum[i]);
        }
        return profit;
    }
}
