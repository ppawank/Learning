class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] patternChar = pattern.toCharArray();
        String[] stringArr = s.split(" ");
        HashMap<Character, String> mapping = new HashMap<>();
        int i = 0;
        for (char c : patternChar) {
            if (i < stringArr.length && !mapping.containsKey(c) && !mapping.containsValue(stringArr[i])) {
                // System.out.println(String.format("Array String:{%s} {%d}", stringArr[i], i));
                mapping.put(c, stringArr[i]);
            }
            i++;
        }

        StringBuilder str = new StringBuilder();
        for (char c : patternChar) {
            str.append(mapping.get(c)).append(" ");
        }

        // System.out.println("String:" + s);
        // System.out.print("Building str:" + str.toString());
        return s.equals(str.toString().trim());

    }
}