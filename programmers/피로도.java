class Solution {
    private static int answer;
    private static boolean[] visit;
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    private void dfs(int k, int[][] dungeons, int n) {
        for (int i=0; i<dungeons.length; i++) {
            if(visit[i] || k < dungeons[i][0]) {
                continue;
            }
            visit[i] = true;
            dfs(k - dungeons[i][1], dungeons, n + 1);
            visit[i] = false;
        }
        answer = Math.max(n, answer);
    }
}
