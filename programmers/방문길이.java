import java.util.*;

class Solution {
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
        String move;
        
        int nowX = 0;
        int nowY = 0;
        int nextX = 0;
        int nextY = 0;
        
        for(int i=0; i<dirs.length(); i++) {
            move = "";
            nextX = nowX;
            nextY = nowY;
            
            if(dirs.charAt(i) == 'U') {
                nextY++;
                move += nowX;
                move += nowY;
                move += nextX;
                move += nextY;
            }
            else if(dirs.charAt(i) == 'D') {
                nextY--;
                move += nextX;
                move += nextY;
                move += nowX;
                move += nowY;
            }
            else if(dirs.charAt(i) == 'R') {
                nextX++;
                move += nowX;
                move += nowY;
                move += nextX;
                move += nextY;
            }
            else if(dirs.charAt(i) == 'L') {
                nextX--;
                move += nextX;
                move += nextY;
                move += nowX;
                move += nowY;
            }
            
            if(nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5) continue;
            
            set.add(move);
            nowX = nextX;
            nowY = nextY;
        }
        
        return set.size();
    }
}
