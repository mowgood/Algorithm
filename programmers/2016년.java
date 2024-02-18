// import java.time.*;

class Solution {
    public String solution(int a, int b) {
        
        // 풀이 1
        String answer = "";
        String[] answers = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int day = 0;
        for (int i = 0; i < a-1; i++) {
            day += days[i];
        }
        
        day += (b-1);
        answer = answers[day % 7];
        
        return answer;
        
        // 풀이 2
        // return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
    }
}
