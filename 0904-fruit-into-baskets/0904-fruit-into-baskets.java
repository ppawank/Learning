class Solution {
    public int totalFruit(int[] fruits) {

        int i=0,j=0;
        int n=fruits.length;
        int longest=0;
        Map<Integer,Integer> basket = new HashMap<>(); 
        for(j=0;j<n;j++){
            // if(!basket.containsKey(fruits[j])){
            //     basket.put();
            // }

            basket.merge(fruits[j],1,Integer::sum);
         
            while(basket.size()>2){
                basket.put(fruits[i],basket.get(fruits[i])-1);
                if(basket.get(fruits[i])==0){
                    basket.remove(fruits[i]);
                }
                i++;
            }
            longest=Math.max(longest,j-i+1);
        }
        
        return longest;
    }
}