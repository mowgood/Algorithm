class Solution {
    public int solution(int n) {
        // 풀이 1
        double n2 = (double) n;
        return (int) Math.ceil(n2/7);
        
        // 풀이 2
        // return (n + 6) / 7;
        
        // 풀이 3
        // return (n%7 == 0) ? n/7 : n/7 + 1;
    }
}
