/// Given a string s, find the length of the longest without duplicate characters.
/// 0 <= s.length <= 5 * 104
/// s consists of English letters, digits, symbols and spaces.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        String subs = "";
        char nextChar;
        int longestSubstringLength = 0;
        for (int i = 0; i < s.length(); i++) {
            nextChar = s.charAt(i);
            longestSubstringLength = subs.length();
            if (subs.contains(Character.toString(nextChar))) {
                if (subs.length() > longestSubstringLength) {
                    longestSubstringLength = subs.length();
                }
                int lastIndexOfRepeat = subs.lastIndexOf(nextChar);
                subs = subs.substring(lastIndexOfRepeat);
            }

            subs.concat(Character.toString(nextChar));
        }

        return longestSubstringLength;
    }
}