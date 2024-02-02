import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        // 풀이 1
//         String[] answer = new String[strings.length];
        
//         Map<String, String> hm = new HashMap<>();
        
//         for (int i = 0; i < strings.length; i++) {
//             String s = String.valueOf(strings[i].charAt(n)); 
//             hm.put(strings[i], s);
//         }
        
//         List<String> list = new ArrayList<>(hm.keySet());
        
//         Collections.sort(list, new Comparator<String>() {
//             public int compare(String s1, String s2) {
//                 if (hm.get(s1).equals(hm.get(s2))) {
//                     return s1.compareTo(s2);
//                 }
//                 else {
//                     return hm.get(s1).compareTo(hm.get(s2));
//                 }
//             }
//         });
        
//         for (int i = 0; i < answer.length; i++) {
//             answer[i] = list.get(i);
//         }
        
//         return answer;
        
        // 풀이 2
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) > s2.charAt(n)) return 1;
                else if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else if (s1.charAt(n) < s2.charAt(n)) return -1;
                else return 0;
            }
        });
        
        return strings;
    }
}
