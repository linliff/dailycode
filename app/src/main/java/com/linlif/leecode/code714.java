package com.linlif.leecode;

public class code714 {

    //714. 买卖股票的最佳时机含手续费
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;//买入的时候就付手续费
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {//买入价比之前小就更新买入
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {//有利润就进行卖出
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices, int fee) {
        int result = 0;
        int subProfit = 0;
        int min = prices[0] + fee;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee > min && prices[i] > prices[i - 1]) {
                subProfit = Math.max(subProfit, prices[i] - min);
                if (i == prices.length - 1) {
                    result = result + subProfit;
                }
            } else {
                min = prices[i] + fee;
                result = result + subProfit;
                subProfit = 0;
            }
        }
        return result;
    }

}
