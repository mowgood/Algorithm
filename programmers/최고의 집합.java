class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[] {-1};
        
        int[] answer = new int[n];
        
        int num = s/n;
        for (int i = 0; i < n; i++) {
            answer[i] = num;
        }
        
        int need = s % n;
        for (int i = n - 1; i >= n - need; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}
