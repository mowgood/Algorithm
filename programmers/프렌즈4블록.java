import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] game = new char[m][n];
        
        for(int i=0; i<m; i++) {
            game[i] = board[m-i-1].toCharArray();
        }
        
        while(true) {
            boolean flag = false;
            boolean[][] visit = new boolean[m][n];
            
            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    if(game[i][j] == ' ') 
                        continue;
                    char animal = game[i][j];
                    if(game[i][j+1] == animal && game[i+1][j] == animal &&
                        game[i+1][j+1] == animal) {
                        visit[i][j] = true;
                        visit[i][j+1] = true;
                        visit[i+1][j] = true;
                        visit[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            
            if(!flag) {
                break;
            }
            
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(visit[i][j]) {
                        game[i][j] = ' ';
                        answer++;
                    }
                }
            }
            
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(game[i][j] == ' ') {
                        for(int k=i; k<m; k++) {
                            if(game[k][j] == ' ') {
                                continue;  
                            }
                            game[i][j] = game[k][j];
                            game[k][j] = ' ';
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
