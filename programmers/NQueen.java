class Solution {
    int answer;
    int[] chess;
    
    public int solution(int n) {
        answer = 0;
        chess = new int[n];
        isQueen(0, n);
        return answer;
    }
    
    private void isQueen(int idx, int n) {
        if(idx == n) {
            answer++;
            return;
        }
        for(int i=0; i<n; i++) {
            chess[idx] = i;
            if(isPossible(idx)) {
                isQueen(idx+1, n);
            }
        }
    }
    
    private boolean isPossible(int idx) {
        for(int i=0; i<idx; i++) {
            // 상하 공격
            if(chess[idx] == chess[i]) {
                return false;
            }
            // 대각선 공격
            if(Math.abs(chess[idx] - chess[i]) == Math.abs(idx - i)) {
                return false;
            }
        }
        return true;
    }
}
