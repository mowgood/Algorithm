import java.util.*;

class Solution {
    public int solution(int[] box, int n) {
        // 1
        /*
        int a = box[0]/n;
        int b = box[1]/n;
        int c = box[2]/n;
        return a*b*c;
        */
        
        // 2
        return Arrays.stream(box)
            .map(i -> i / n)
            .reduce(1, (x, y) -> x * y);
    }
}
