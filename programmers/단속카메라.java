import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 진출 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
       
        // 첫 번째 차량의 진출 지점에 카메라 설치
        int current = routes[0][1]; 
        int answer = 1;
        
        // 이전 차량의 진출 지점(카메라 설치 지점) 보다, 다음 차량의 진입 지점이 더 크면 카메라 설치
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > current) {
                answer++;
                current = routes[i][1];
            }
        }
        
        return answer;
    }
}
