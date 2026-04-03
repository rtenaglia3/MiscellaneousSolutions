package Java;
/// A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
/// Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.

class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        for (int i=0; i < n.length(); i++) {
            int currDigit = Integer.parseInt(n.substring(i,i+1));
            if (currDigit > maxDigit) maxDigit = currDigit;
        }

        return maxDigit;
    }
}