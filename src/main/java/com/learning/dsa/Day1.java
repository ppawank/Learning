package com.learning.dsa;

public class Day1 {
    public static void main(String[] args) {
        Day1.sumOfOddNumbers();
        Day1.sumOfAllDigits(123);

    }

    private static void sumOfOddNumbers() {
        int sum=0;
        for(int i=1; i<50; i++){
            if(i%2 != 0){
                sum+=i;
            }
        }
        System.out.println("Sum of first 50 odd numbers: "+sum);
    }

    private static void sumOfAllDigits(int n){
        int sum=0;
        int evenCount=0;
        int oddCount=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
            int digit=n%10;
            if(digit%2==0){
                evenCount++;
            }else {
                oddCount++;
            }
        }
        System.out.println("Even count: "+evenCount);
        System.out.println("Odd count: "+oddCount);
        System.out.println("Sum of all digits: "+sum);
    }
}

