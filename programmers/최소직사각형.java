class Solution {
    public int solution(int[][] sizes) {
        int maxRow = 0;
        int maxCol = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int row = Math.max(sizes[i][0], sizes[i][1]);
            int col = Math.min(sizes[i][0], sizes[i][1]);
            
            maxRow = Math.max(maxRow, row);
            maxCol = Math.max(maxCol, col);
        }
        
        return maxRow * maxCol;
    }
}
