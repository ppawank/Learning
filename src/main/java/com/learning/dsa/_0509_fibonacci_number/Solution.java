package com.learning.dsa._0509_fibonacci_number;

class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int a=0,b=1;
        for(int i=2;i<=n;i++){
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for(int i=0;i<=10;i++){
            System.out.println(i + " -> " + solution.fib(i));
        }
    }
}