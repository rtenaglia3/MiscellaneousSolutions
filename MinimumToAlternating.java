/// Return the minimum number of operations required to swap individual letters until the sstring is alternating binary.
/// The string is a binary string.

class Solution {
    public int minOperations(String s) {
        int operations = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i+1)) continue;

            s = changeCharacter(s,i+1);
            operations++;
        }

        return Math.min(operations, s.length() - operations); // It could be the ones we didn't swap
    }

    private String changeCharacter(String s, int index) {
        String before = s.substring(0,index);
        Character target = s.charAt(index);
        String after = s.substring(index+1, s.length());

        if (target == '1') {
            return before + '0' + after;
        }

        return before + '1' + after;
    }
}