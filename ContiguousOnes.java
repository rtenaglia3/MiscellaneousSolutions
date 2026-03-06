/// Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.

class Solution {
    public boolean checkOnesSegment(String s) {
        boolean contiguousSegmentFound = false;

        int firstOne = s.indexOf('1');

        if (firstOne == -1) return true;

        int nextZero = s.indexOf('0', firstOne);

        if (nextZero == -1) return true;

        String afterOnes = s.substring(nextZero, s.length());

        if (afterOnes.indexOf('1') != -1) return false;

        return true;
    }
}