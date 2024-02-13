import java.util.*;

class Solution {
    static Set<Integer> hs;
    public int solution(int[] elements) {
        int answer = 0;
        hs = new HashSet<>();
        
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                dfs(j, 0, 0, i, elements);
            }
        }
        
        return hs.size();
    }
    
    public static void dfs(int current, int cnt, int sum, int totalCnt, int[] elements) {
        if (cnt == totalCnt) {
            hs.add(sum);
            return;
        }
        
        if (current == elements.length-1) {
            dfs(0, cnt+1, sum+elements[0], totalCnt, elements);
        }
        else {
            dfs(current+1, cnt+1, sum+elements[current+1], totalCnt, elements);
        }
    }
}
