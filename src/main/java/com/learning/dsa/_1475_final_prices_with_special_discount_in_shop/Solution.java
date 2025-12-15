package com.learning.dsa._1475_final_prices_with_special_discount_in_shop;

class Solution {
    public int[] finalPrices(int[] prices) {
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<=prices[i]){
                    prices[i]=prices[i]-prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.finalPrices(new int[]{8,4,6,2,3}); // [4,2,4,2,3]
        System.out.print("[");
        for (int i=0;i<res.length;i++){
            System.out.print(res[i]);
            if(i<res.length-1) System.out.print(",");
        }
        System.out.println("]");
    }
}