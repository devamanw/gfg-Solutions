class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
       
        int[] counts = new int[rows + cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[Math.abs(r - rCenter) + Math.abs(c - cCenter)]++;
            }
        }

     
        int[] partitions = new int[counts.length + 1];
        for (int i = 1; i < counts.length; i++) {
            partitions[i] += partitions[i - 1] + counts[i - 1];
        }

        
        int[][] result = new int[rows * cols][];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int dist = Math.abs(r - rCenter) + Math.abs(c - cCenter);
                result[partitions[dist]++] = new int[] { r, c };
            }
        }
        return result;
    }
}
