class Solution {
    public boolean isPalindrome(String s) {
        String str = String.valueOf(cleanString(s));
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }
    public String cleanString(String x) {
        char[] charArray = x.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('a' + c - 'A'));
            }else if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}