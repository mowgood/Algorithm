class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(0, 0, numbers, target);
        return answer;
    }
    
    private int dfs(int current, int sum, int[] numbers, int target) {
        if (current == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(current+1, sum + numbers[current], numbers, target) +
            dfs(current+1, sum - numbers[current], numbers, target);
    }
}
