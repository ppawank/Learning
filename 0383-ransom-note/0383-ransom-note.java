class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magMap = new HashMap<>();
        char[] magChar = magazine.toCharArray();
        char[] ransomChar = ransomNote.toCharArray();

        for (char ch : magChar) {
            if (magMap.containsKey(ch)) {
                int counter = magMap.get(ch);
                magMap.put(ch, ++counter);
            } else {
                magMap.put(ch, 1);
            }
        }

        for (char c : ransomChar) {
            if (magMap.get(c) == null || magMap.get(c) <= 0) {
                return false;
            } else {
                int counter = magMap.get(c);
                magMap.put(c,--counter);
            }
        }
        return true;

    }
}