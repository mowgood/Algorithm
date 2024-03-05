import java.util.*;

class Solution {
    public int[] solution(String[] strlist) {
        // 1
        /*
        int[] answer = new int[strlist.length];
        for (int i = 0; i < strlist.length; i++) {
            answer[i] = strlist[i].length();
        }
        return answer;
        */
        
        // 2
        return Arrays.stream(strlist).mapToInt(String::length).toArray();
    }
}
