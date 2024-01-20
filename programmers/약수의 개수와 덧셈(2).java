class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            if (i % Math.sqrt(i) == 0) {
                // 약수의 개수는 홀수
                answer -= i;
                continue;
            }
            // 약수의 개수는 짝수
            answer += i;
        }
        
        return answer;
    }
}
