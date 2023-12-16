package com.linlif.leecode;

/**
 * 121 买股票最佳时机
 */
class code121 {

    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }


    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
//        int result = 0;
//        int min = prices[0];
//        for (int value : prices) {
//            result = Math.max(result, value - min);
//            min = Math.min(min, value);
//        }
//        return Math.max(result, 0);

        int max = 0;
        int[] results = new int[prices.length];
        results[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            results[i] = Math.min(results[i - 1], prices[i]);
            max = Math.max(max, prices[i] - results[i]);
        }
        return max;
    }
}
