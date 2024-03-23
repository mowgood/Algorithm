class Solution {
    public int solution(int n) {
        // 1
        if (Math.pow((int) Math.sqrt(n), 2) == n) return 1;
        return 2;
        
        // 2
        // if (n % Math.sqrt(n) == 0) return 1;
        // return 2;
    }
}
