import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> hm = new HashMap<>();
        int[] res = new int[targets.length];
        
        for(int i=0; i<keymap.length; i++) {
            for(int j=0; j<keymap[i].length(); j++) {
                char ch = keymap[i].charAt(j);
                if(!hm.containsKey(ch) || hm.get(ch) > j) {
                    hm.put(ch, j+1);
                } 
            }
        }
        
        for(int i=0; i<targets.length; i++) {
            int cnt = 0;
            for(int j=0; j<targets[i].length(); j++) {
                char ch = targets[i].charAt(j);
                if(!hm.containsKey(ch))  {
                    cnt = 0;
                    break;
                }
                else {
                    cnt += hm.get(ch);
                }
            }
            res[i] = cnt == 0 ? -1 : cnt;
        }
        return res;
    }
}
