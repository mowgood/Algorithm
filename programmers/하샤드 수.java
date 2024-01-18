class Solution {
    public boolean solution(int x) {
        // 풀이 1
        int number = x;
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        } 
   
        // 풀이 2
        // int sum = String.valueOf(x).chars().map(ch -> ch - '0').sum();
        
        return x % sum == 0; 
    }
}
