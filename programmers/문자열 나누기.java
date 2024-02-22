class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0);
        int cnt = 1;
        
        int idx = 1;
        while(idx < s.length()) { 
            if (s.charAt(idx) == first) cnt++;
            else cnt--;
            
            if (cnt == 0) {
                answer++;
                if (idx + 1 < s.length()) {
                    first = s.charAt(++idx);
                    cnt = 1;
                }
            }
            idx++;
        }
        
        if(cnt != 0) answer++;
        
        return answer;
    }
}
