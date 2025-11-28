class Solution {
    public boolean isHappy(int n) { 
        Set<Integer> seen = new HashSet<>();
        return isHappyHelper(n,seen);
    }



    private boolean isHappyHelper(int n, Set<Integer> seen) {
        // Base case: if n == 1, it's happy
        if (n == 1) return true;
 
        // If we have already seen this number, cycle detected → not happy
        if (seen.contains(n)) return false;
 
        // Add current number to the set
        seen.add(n);
 
        // Recursive call with the sum of squares of digits
        return isHappyHelper(sumOfSquares(n), seen);
    }
 
    // Helper method to compute sum of squares of digits
    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}