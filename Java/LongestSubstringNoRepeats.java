package Java;
/// Given a string s, find the length of the longest without duplicate characters.
/// 0 <= s.length <= 5 * 104
/// s consists of English letters, digits, symbols and spaces.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        String subs = "";

        for (int i = 0; i < s.length(); i++) {
            String nextChar = Character.toString(s.charAt(i));
            if (subs.contains(nextChar)) {
                int index = subs.indexOf(nextChar);
                if (subs.length() > index) {
                    subs = subs.substring(index+1);
                    subs += nextChar;
                } else {
                    subs = nextChar;
                }
            } else {
                subs += nextChar;
            }

            if (subs.length() > longest) {
                longest = subs.length();
            }
        }

        return longest;
    }
}