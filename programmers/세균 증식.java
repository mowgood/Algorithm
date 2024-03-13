class Solution {
    public int solution(int n, int t) {
        // 1
        int answer = n;
        for (int i = 0; i < t; i++) {
            answer *= 2;
        }
        
        // 2
        // int answer = n << t;
        
        return answer;
    }
}
