/* 
    You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.
    For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
    For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.
    The test cases are generated so that the answer fits in a 32-bits integer.
*/

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> binaryNumbers = new ArrayList<>();

        // Fill the list
        parseNextLayerOfTree(root, binaryNumbers, "");

        // Add them up
        int theAnswer = 0;
        for (int value : binaryNumbers) {
            theAnswer += value;
        }

        return binaryNumbers.size();
    }

    public void parseNextLayerOfTree(TreeNode root, List<Integer> binaryNumbers, String currentNumberString) {
        String newCurrentNumberString = currentNumberString;
        newCurrentNumberString += Integer.toString(root.val);
        
        if (root.left == null && root.right == null) {
            int newCurrentNumber = Integer.parseInt(newCurrentNumberString, 2);
            binaryNumbers.add(newCurrentNumber);
        } else if (root.left != null) {
            parseNextLayerOfTree(root.left, binaryNumbers, newCurrentNumberString);
        } else {
            parseNextLayerOfTree(root.right, binaryNumbers, newCurrentNumberString);
        }
    }
}