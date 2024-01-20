class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        if (right == 1) return -1; // 1부터 1일 경우 answer에서 1을 뺀 수 리턴 (1의 약수는 홀수)
        
        if (left == 1) { // 1부터 시작할 경우 1을 뺀 후 시작 (1의 약수는 홀수)
            answer -= 1;
            left += 1;
        }
        
        for (int number = left; number <= right; number++) {
            if(isEven(number)) {
                answer += number;
                continue;
            }
            answer -= number;
        }
        return answer;
    }
    
    public static boolean isEven(int number) {
        int count = 2; //1, ..., number
        
        for (int i = 2; i < number; i++) {
            if (number % i == 0) count++;
        }
        
        if (count % 2 != 0) return false;
        return true;
    }
}
