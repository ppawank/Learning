class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int[] hash = new int[256];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        while (right < s.length()) {
            char rChar = s.charAt(right);

            if (hash[rChar] > 0) {
                count++;
            }
            hash[rChar]--;
            right++;

            while (count == t.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }

                char lChar = s.charAt(left);
                hash[lChar]++;
                if (hash[lChar] > 0) {
                    count--;
                }
                left++;
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}