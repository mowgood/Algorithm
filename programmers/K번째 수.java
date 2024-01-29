import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // 풀이 1
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                list.add(array[j-1]);
            }
            Collections.sort(list);
            answer[i] = list.get(commands[i][2]-1);
            list.clear();
        }
        
        // 풀이 2
        // for (int i = 0; i < commands.length; i++) {
        //     int[] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        //     Arrays.sort(arr);
        //     answer[i] = arr[commands[i][2]-1];
        // }
        
        return answer;  
    }
}
