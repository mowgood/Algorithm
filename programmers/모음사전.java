class Solution {
    public int solution(String word) {
      
        // 풀이 2
        int answer = word.length();
        String str = "AEIOU";
        int[] increase = {781, 156, 31, 6, 1};
        
        for (int i = 0; i < word.length(); i++) {
            answer += (increase[i] * str.indexOf(word.charAt(i)));
        }
        
        return answer;
    }
}
