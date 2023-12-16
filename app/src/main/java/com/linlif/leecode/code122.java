package com.linlif.leecode;

//122. 买卖股票的最佳时机 II
public class code122 {


    //[7,1,5,3,6,4]
    //解题思路：最大利润可以拆解为每个子数组最大利润之和，
    // 既：遍历数组(入手)，当遇到卖出利润最大时进行出手，记录当前利润，
    // 再从下一个元素开始遍历(重新入手)，最终累加利润之和进行返回。
    public int maxProfit(int[] prices) {
        int result = 0;
        int subProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //只要当前股价大于前面的最小股价，且利润没有变小，就更新最大利润
            if (prices[i] > min && prices[i] > prices[i - 1]) {
                subProfit = Math.max(subProfit, prices[i] - min);
                if (i == prices.length - 1) {//注意遍历到最后一位时需要更新，把最后的利润进行累加
                    result = result + subProfit;
                }
            } else {//此时子利润达到最大，出手，并更新新的入手股价和利润总和
                min = prices[i];
                result = result + subProfit;
                subProfit = 0;
            }
        }
        return result;
    }

}
