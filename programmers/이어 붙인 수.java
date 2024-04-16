import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] num_list) {
        String odd = Arrays.stream(num_list)
            .filter(i -> i % 2 != 0)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining());
        
        String even = Arrays.stream(num_list)
            .filter(i -> i % 2 == 0)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining());
        
        return Integer.parseInt(odd) + Integer.parseInt(even);
    }
}
