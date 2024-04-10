class Solution {
    static boolean[] visit;
    static int answer = 55;
    static boolean isPossible = false;
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        if (!isPossible) return 0;
        return answer;
    }
    
    public static void dfs(String current, String target, String[] words, int cnt) {
        if (current.equals(target)) {
            isPossible = true;
            answer = Math.min(answer, cnt);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visit[i] || !usado(current, words[i])) continue;
            visit[i] = true;
            dfs(words[i], target, words, cnt+1);
            visit[i] = false;
        }
    }
    
    public static boolean usado(String current, String next) {
        int cnt = 0;
        for (int i = 0; i < current.length(); i++) {
            if (cnt > 1) return false;
            if (current.charAt(i) != next.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
}
