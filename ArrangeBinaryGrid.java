/// Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.
/// A grid is said to be valid if all the cells above the main diagonal are zeros.
/// Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.
/// The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).

class Solution {
    public int minSwaps(int[][] grid) {
        int steps = 0;
        int[] flags = new int[grid.length];

        // Move the grid
        for (int k = grid.length-1; k > 0; k--) {
            int indexOfRow = getIndexOfFirstRowWithNeededZeroes(grid, k, grid.length-k-1);
            if (indexOfRow == -1) return -1; // Return -1 if the grid can't be diagonalized
            
            int[] row = grid[indexOfRow];


            for (int i = indexOfRow; i>grid.length-1-k; i--) {
                swapRowWithPrevious(grid, i);
                steps++;
            }
        }

        return steps;
    }

    private int countZeroes(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[row.length-1-i] != 0) {
                return i;
            }
        }

        return row.length;
    }

    private int getIndexOfFirstRowWithNeededZeroes(int[][] grid, int k, int startIndex) {
        for (int i = startIndex; i < grid.length; i++) {
            int[] row = grid[i];
            int zeroesInRow = countZeroes(row);

            if (zeroesInRow >= k) return i;
        }

        return -1;
    }

    private void swapRowWithPrevious(int[][] grid, int index) {
        int[] temp = grid[index];
        grid[index] = grid[index-1];
        grid[index-1] = temp;
    }
}