import java.util.*;

class Point {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int[][] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        
        Point start = new Point(0, 0);
        Point end = new Point(maps.length-1, maps[0].length-1);
        
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        
        int[][] dist = new int[maps.length][maps[0].length];
        dist[0][0] = 1;
        visit[0][0] = true;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            if(now.x == end.x && now.y == end.y) {
                return dist[now.x][now.y];
            }
            
            for(int i=0; i<dx.length; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if((nextX >= 0 && nextX < maps.length) && (nextY >= 0 && nextY < maps[0].length) 
                   && !visit[nextX][nextY] && maps[nextX][nextY] == 1) {
                    visit[nextX][nextY] = true;
                    dist[nextX][nextY] = dist[now.x][now.y] + 1;
                    q.offer(new Point(nextX, nextY));
                }
            }
        }
        return -1; 
    }
}
