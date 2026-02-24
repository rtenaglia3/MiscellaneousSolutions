/* Two Sum:
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Constraints:
    2 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
    -10^9 <= target <= 10^9
*/

public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.Length; i++) {
            for (int j = i + 1; j < nums.Length; j++) {
                if (nums[i] + nums[j] == target) {
                    return [i,j];
                }
            }
        }
        return [0,0];
    }

    /// Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
    public int[] TwoSumButFast(int[] nums, int target) {
        List<int> numList = nums.ToList();
        for (int i = 0; i < nums.Length; i++) {
            int j = numList.FindIndex(value => value == target - numList[i]);
            if (j != -1 && j != i) {
                return [i,j];
            }
        }
        return [0,0];
    }
}