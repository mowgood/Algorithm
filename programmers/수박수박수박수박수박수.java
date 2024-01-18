class Solution {
    public String solution(int n) {
        String answer = "수";
        
        for (int i=0; i<n-1; i++) {
            if (i % 2 == 0) {
                answer += "박";
                continue;
            }
            answer += "수";
        }
        return answer;
    }
}
