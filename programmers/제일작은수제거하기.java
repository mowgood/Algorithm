class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[arr.length-1];
        
        int min = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(min > arr[i]) min = arr[i];
        }
        
        int idx = 0;
        for(int i=0; i<arr.length; i++) {
            if(min == arr[i]) continue;
            answer[idx++] = arr[i];
        }

        return answer;
    }
}
