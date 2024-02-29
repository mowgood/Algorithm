import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> hm1 = new HashMap<>();
        Map<String, Integer> hm2 = new HashMap<>();

        for (String x : X.split("")) {
            hm1.put(x, hm1.getOrDefault(x, 0) + 1);
        }
        
        for (String y : Y.split("")) {
            hm2.put(y, hm2.getOrDefault(y, 0) + 1);
        }
        
        for (int i = 9; i >= 0; i--) {
            String num = String.valueOf(i);
            if (hm1.containsKey(num) && hm2.containsKey(num)) {
                int repeatSize = Math.min(hm1.get(num), hm2.get(num));
                sb.append(num.repeat(repeatSize));
            }
        }
        
        if (sb.length() == 0) return "-1";
        if (sb.toString().charAt(0) == '0') return "0";
        return sb.toString();
    }
}
