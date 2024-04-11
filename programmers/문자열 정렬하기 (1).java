import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        return Arrays.stream(my_string.replaceAll("[a-z]", "").split(""))
            .sorted()
            .mapToInt(Integer::parseInt)
            .toArray();
    }
}
