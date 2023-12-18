import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Map<Integer, Double> hm = new HashMap<>();
        int[] user = new int[N+2]; // 각 스테이지별 현재 유저 수
        int[] user2 = new int[N+1]; // 각 스테이지에 도달한 총 유저 수
        
        for(int stage : stages) {
            user[stage]++;
        }
        
        user2[N] = user[N] + user[N+1];
        for(int i=N-1; i>=1; i--) {
            user2[i] = user[i] + user2[i+1];
        }
        
        for(int i=1; i<user2.length; i++) {
            if(user[i] == 0 || user2[i] == 0) {
                hm.put(i, 0.0);
            }
            else {
                hm.put(i, (double) user[i] / user2[i]);
            }
        }
        
        // 처음 실패한 코드
        // for(int i=1; i<=N; i++) {
        //     double sum = 0.0;
        //     for(int j=N+1; j>=i; j--) {
        //         sum += user[j];
        //     }
        //     if(sum == 0) {
        //         hm.put(i, 0.0);
        //         break;
        //     }
        //     hm.put(i, user[i] / sum);
        // }
        
        List<Integer> keyList = new ArrayList<>(hm.keySet());
        Collections.sort(keyList, (o1, o2)->(hm.get(o2).compareTo(hm.get(o1))));
        // Collections.sort(keyList, (o1, o2) -> Double.compare(hm.get(o2), hm.get(o1)));
        
        for(int i=0; i<keyList.size(); i++) {
            answer[i] = keyList.get(i);
        }
        
        return answer;
    }
}
