class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                answer += ' ';
                continue;
            }
            
            if ((Character.isLowerCase(ch) && ch+n > 'z')
                    || Character.isUpperCase(ch) && ch+n > 'Z') {
                answer += (char)(ch+n-26);
            }
            else {
                answer += (char)(ch+n);
            }
        }
        return answer;
    }
}
