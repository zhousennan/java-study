package org.example.completableFuture;

public class StockProfitCalculator {

    /**
     * 计算最大股票利润
     *
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        StockProfitCalculator calculator = new StockProfitCalculator();
        int[] prices = {7, 2, 5, 3, 6, 4,1 };
        System.out.println("最大利润: " + calculator.maxProfit(prices));
    }
}
