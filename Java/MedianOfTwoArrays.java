package Java;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Merge the arrays
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);

        // Sort the arrays
        Arrays.sort(merged);

        // Find the middle
        if (merged.length % 2 == 1) {
            // Case 1: Odd number of elements
            return merged[merged.length / 2];
        } else {
            //Case 2: Even number of elements
            return (double) (merged[merged.length / 2 - 1] + merged[merged.length / 2]) / 2;
        }
    }
}