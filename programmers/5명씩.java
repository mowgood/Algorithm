import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        String[] answer = new String[names.length % 5 == 0 ? names.length / 5: names.length / 5 + 1];
        List<String> answer2 = new ArrayList<>();
        
        int idx = 0;
        for (int i = 0 ; i < names.length; i += 5) {
            answer[idx++] = names[i];
            answer2.add(names[i]);
        }
        
        return answer;
        // return answer2.toArray(new String[answer2.size()]);
    }
}
