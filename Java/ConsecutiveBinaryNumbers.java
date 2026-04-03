package Java;
class Solution {
    public int concatenatedBinary(int n) {
        long modulo = (long) Math.pow(10,9) + 7;
        String s = "";
        for (int i = 1; i <= n; i++) {
            s += Integer.toBinaryString(i);
            long val = Long.parseLong(s, 2);
            val = val%modulo;
            s = Long.toBinaryString(val);
        }

        return (int)Long.parseLong(s,2);
    }
}