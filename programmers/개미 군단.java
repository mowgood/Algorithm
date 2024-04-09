class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] attack = {5, 3, 1};
        
        for (int i = 0; i < attack.length; i++) {
            answer += hp / attack[i];
            hp %= attack[i];
        }
        
        return answer;
    }
}
