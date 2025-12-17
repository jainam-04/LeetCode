public class BestTimeToBuyAndSellStocks5 {
    class State{
        long maxProfit;
        long buyHold;
        long sellHold;
        State(long p, long b, long s){
            maxProfit = p;
            buyHold = b;
            sellHold = s;
        }
    }

    public static void main(String[] args) {
        int[] prices = {1, 7, 9, 8, 2};
        int k = 2;
        BestTimeToBuyAndSellStocks5 bestTimeToBuyAndSellStocks5 = new BestTimeToBuyAndSellStocks5();
        long result = bestTimeToBuyAndSellStocks5.maximumProfit(prices, k);
        System.out.println(result);
    }

    public long maximumProfit(int[] prices, int k){
        int firstPrice = prices[0];
        State[] dp = new State[k + 1];
        for(int index = 0; index <= k; index++){
            dp[index] = new State(0, -firstPrice, firstPrice);
        }
        int n = prices.length;
        for(int day = 1; day < n; day++){
            int currentPrice = prices[day];
            for(int transaction = k; transaction > 0; transaction--){
                long previousProfit = dp[transaction - 1].maxProfit;
                dp[transaction].maxProfit = Math.max(dp[transaction].maxProfit, Math.max(dp[transaction].buyHold + currentPrice, dp[transaction].sellHold - currentPrice));
                dp[transaction].buyHold = Math.max(dp[transaction].buyHold, previousProfit - currentPrice);
                dp[transaction].sellHold = Math.max(dp[transaction].sellHold, previousProfit + currentPrice);
            }
        }
        return dp[k].maxProfit;
    }
}
