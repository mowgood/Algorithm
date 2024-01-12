import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (student1[i%5] == answers[i]) score[0]++;
            if (student2[i%8] == answers[i]) score[1]++;
            if (student3[i%10] == answers[i]) score[2]++;
        }
        
        int max = score[0];
        for (int i = 0; i < score.length; i++) {
            if (max < score[i]) {
                list.clear();
                max = score[i];
            }
            if (score[i] == max) {
                list.add(i+1);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
