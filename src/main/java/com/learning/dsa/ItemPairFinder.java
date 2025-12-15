package com.learning.dsa;

import java.util.HashSet;

/*
In a shop, there are n items with different prices for each item.
You have a total of N currency units and need to purchase a pair of items with that exact amount.
The function should return true if there exists a pair of items in the shop whose sum equals N, else return false.
The items are not necessarily in sorted order.
 */
public class ItemPairFinder {

    public static boolean canBuyPair(int[] prices, int N) {
        HashSet<Integer> set = new HashSet<>();

        for (int price : prices) {
            int complement = N - price;

            if (set.contains(complement)) {
                return true;  // Found a pair that sums to N
            }

            set.add(price);
        }

        return false;  // No pair found
    }

    public static void main(String[] args) {
        int[] prices = {10, 5, 2, 7, 11, 15};
        int N = 9;

        System.out.println(canBuyPair(prices, N));  // Output: true (pair: 7 + 2)
    }
}
