class Solution {
    public int[] finalPrices(int[] prices) {
        int size=prices.length;
        int[] res = new int[size];

        for(int i=0;i<size;i++){
            int discount=0;
            for(int j=i+1;j<size;j++){
                if(prices[j]<=prices[i]){
                    discount=prices[j];
                    break;
                }
            }
            res[i]=prices[i]-discount;

        }
        return res;
    }
}