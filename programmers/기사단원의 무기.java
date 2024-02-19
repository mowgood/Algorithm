class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int w = cal(i);
            if (w > limit) {
                answer += power;
            } else {
                answer += w;
            }
        }
        return answer;
    }
    
    public static int cal(int num) {
        int cnt = 0;
        
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (i * i == num) cnt++;
            else if (num % i == 0) cnt += 2;
        }
        return cnt;
    }
}
