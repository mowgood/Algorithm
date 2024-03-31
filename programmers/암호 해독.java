import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String cipher, int code) {
        
        // 풀이 1
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < cipher.length(); i++) {
            if ((i + 1) % code != 0) continue;
            sb.append(cipher.charAt(i));
        }
        
        return sb.toString();
        
        // 풀이 2
        // return IntStream.range(0, cipher.length())
        //     .filter(idx -> idx % code == code - 1)
        //     .mapToObj(idx -> String.valueOf(cipher.charAt(idx)))
        //     .collect(Collectors.joining());
    }
}
