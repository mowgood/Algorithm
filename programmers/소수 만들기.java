class Solution {
    static int[] arr = new int[3];
    static int answer = 0;
    public int solution(int[] nums) {
        dfs(0, 0, nums);
        return answer;
    }
    
    public static void dfs(int current, int cnt, int[] nums) {
        if (cnt == 3) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            if (isPrime(sum)) answer++;
            return;
        }
        
        for (int i = current; i < nums.length; i++) {
            arr[cnt] = nums[i];
            dfs(i+1, cnt+1, nums);
        }
    }
    
    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
